import React, { Component } from 'react';
import Requests from '../../shared/Requests'
import { Header, Container } from 'semantic-ui-react'

class ClienteList extends Component {

  state = {
    clientes: []
  }

  componentDidMount(){
    this.getClientes()
  }

  getClientes() {
    Requests.getClientes().then(data => {
      this.setState({clientes: data})
    })
  }

  render() {
    const { clientes } = this.state

    clientes.map(cliente => (
      console.log(cliente)
    ))
    
    return (
      <Container className='semi-fluid'>
        <Header>Clientes</Header>
      </Container>
    );
  }
}

export default ClienteList