import React, { Component } from 'react';
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { createDispositivo } from '../../actions/clienteActions'
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form, Button, Table } from 'semantic-ui-react';
import { TextField } from '../../shared/form/TextField'
import Requests from '../../shared/Requests'
import { toastr } from 'react-redux-toastr'

class DispositivoForm extends Component {
  state = {
    dispositivos: [],
    nomeDispositivo: ''
  }

  componentDidMount() {
    this.getDispositivos()
  }

  getDispositivos() {
    Requests.getDispositivos().then(dispositivo => {
      this.setState({ dispositivos: dispositivo })
    })
  }

  handleSubmit = () => {
    const { nomeDispositivo } = this.state
    const dispositivo = {
      nome: nomeDispositivo
    }

    Requests.createDispositivo(dispositivo).then(resp => {
      toastr.success('Sucesso', 'Dispositivo cadastrado com sucesso!')
      this.setState({nomeDispositivo: ''})

      this.getDispositivos()
    }).catch(err =>{
      toastr.error(err)
  })
  }

  renderDispositivos(dispositivo) {
    return (
      <Table.Row key={dispositivo.idDispositivo}>
        <Table.Cell>{dispositivo.idDispositivo}</Table.Cell>
        <Table.Cell>{dispositivo.nome}</Table.Cell>
        <Table.Cell>{dispositivo.identificador}</Table.Cell>
      </Table.Row>
    )
  }

  render() {
    const { dispositivos, nomeDispositivo } = this.state

    return (
      <Container className='semi-fluid'>
        <Header>Cadastrar Dispositivo</Header>
        <Form onSubmit={this.handleSubmit}>
          <Form.Group widths='equal'>
            <Form.Input
              label='Nome'
              value={nomeDispositivo}
              placeholder='Informe o nome do dispositivo'
              required
              onChange={(event) => this.setState({nomeDispositivo: event.target.value})}
              />
          </Form.Group>

          <Button positive type='submit'>Cadastrar</Button>
        </Form>

        <Header>Lista Dipositivos</Header>
        <Table>
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>ID</Table.HeaderCell>
              <Table.HeaderCell>NOME</Table.HeaderCell>
              <Table.HeaderCell>IDENTIFICADOR</Table.HeaderCell>
            </Table.Row>
          </Table.Header>

          <Table.Body>
            {dispositivos.map(dispositivo => this.renderDispositivos(dispositivo))}
          </Table.Body>
        </Table>
      </Container>
    )
  }

}

export default DispositivoForm

// class dispositivoForm extends Component {

//   state = {
//     dispositivos: []
//   }

//   componentDidMount() {
//     this.getDispositivos()
//   }

//   getDispositivos() {
//     Requests.getDispositivos().then(dispositivo => {
//       this.setState({ dispositivos: dispositivo })
//     })
//   }

//   renderDispositivos(dispositivo) {
//     return(
//       <Table.Row key={dispositivo.idDispositivo}>
//         <Table.Cell>{dispositivo.idDispositivo}</Table.Cell>
//         <Table.Cell>{dispositivo.nome}</Table.Cell>
//         <Table.Cell>{dispositivo.identificador}</Table.Cell>
//       </Table.Row>
//     )
//   }

//   render() {
//     const { handleSubmit } = this.props
//     const { dispositivos } = this.state

//     return (
//       <Container className='semi-fluid'>
//         <Header>Cadastrar Dispositivo</Header>
//         <Form onSubmit={handleSubmit(this.props.createDispositivo)}>
//           <Form.Group widths='equal'>
//             <Field
//               name='nome'
//               label='Nome'
//               placeholder='Informe o nome do dispositivo'
//               component={TextField} />
//           </Form.Group>

//           <Button positive type='submit' >Cadastrar</Button>
//         </Form>

//         <Header>Lista Dipositivos</Header>
//         <Table>
//           <Table.Header>
//             <Table.Row>
//               <Table.HeaderCell>ID</Table.HeaderCell>
//               <Table.HeaderCell>NOME</Table.HeaderCell>
//               <Table.HeaderCell>IDENTIFICADOR</Table.HeaderCell>
//             </Table.Row>
//           </Table.Header>

//           <Table.Body>
//             {dispositivos.map(dispositivo => this.renderDispositivos(dispositivo))}
//           </Table.Body>
//         </Table>
//       </Container>
//     )
//   }
// }

// const DispositivoForm = reduxForm({
//   form: 'dispositivoForm'
// })(dispositivoForm)

// const mapDispatchToProps = dispatch => bindActionCreators({ createDispositivo }, dispatch)

// export default connect(null, mapDispatchToProps)(DispositivoForm)
