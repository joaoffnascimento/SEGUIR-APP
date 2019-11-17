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
    const cidade = cliente.cidade ? cliente.cidade.nome : 'Não encontrada'
    const dispositivo = cliente.dispositivo ? cliente.dispositivo.nome : 'Não encontrado'
    const grupo = cliente.grupo ? cliente.grupo.empresa : 'Não encontrado'

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
          {cidade}
        </Table.Cell>
        <Table.Cell>
          {grupo}
        </Table.Cell>
        <Table.Cell>
          {dispositivo}
        </Table.Cell>
        <Table.Cell>
          {cliente.tipo}
        </Table.Cell>
      </Table.Row>
    )
  }

  render() {
    const { clientes } = this.state


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