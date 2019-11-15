import React, { Component } from 'react';
import Requests from '../../shared/Requests'
import { Link } from 'react-router-dom'
import { Header, Container, Table, Segment, Button } from 'semantic-ui-react'

class ClienteList extends Component {

  state = {
    clientes: []
  }

  componentDidMount() {
    this.getClientes()
  }

  getClientes() {
    Requests.getClientes().then(data => {
      this.setState({ clientes: data })
    })
  }

  renderClientes(cliente) {
    return (
      <Table.Row key={cliente.idPessoa}>
        <Table.Cell>
            {cliente.nome}
        </Table.Cell>
        <Table.Cell>
          {cliente.telefone}
        </Table.Cell>
        <Table.Cell>
          {cliente.email}
        </Table.Cell>
        <Table.Cell>
          {cliente.cidade}
        </Table.Cell>
        <Table.Cell>
          {cliente.grupo}
        </Table.Cell>
        <Table.Cell>
          {cliente.dispositivo}
        </Table.Cell>
        <Table.Cell>
          {cliente.tipo}
        </Table.Cell>
      </Table.Row>
    )
  }

  render() {
    const { clientes } = this.state

    clientes.map(cliente => (
      console.log(cliente)
    ))

    console.log(localStorage.getItem('user'))

    return (

      <Container className='semi-fluid'>
        <Header>Clientes</Header>

        <Segment>
          <Link to={'/cliente/novo'}>
            <Button>Novo Cliente</Button>
          </Link>
        </Segment>

        <Table>
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>NOME</Table.HeaderCell>
              <Table.HeaderCell>TELEFONE</Table.HeaderCell>
              <Table.HeaderCell>EMAIL</Table.HeaderCell>
              <Table.HeaderCell>CIDADE - UF</Table.HeaderCell>
              <Table.HeaderCell>GRUPO</Table.HeaderCell>
              <Table.HeaderCell>DISPOSITIVO</Table.HeaderCell>
              <Table.HeaderCell>TIPO</Table.HeaderCell>
            </Table.Row>
          </Table.Header>

          <Table.Body>
            {clientes.map(cliente => this.renderClientes(cliente))}
          </Table.Body>

        </Table>
      </Container>
    );
  }
}

export default ClienteList