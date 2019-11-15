import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form, Button } from 'semantic-ui-react';
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { createCliente } from '../../actions/clienteActions'
import { TextField } from '../../shared/form/TextField'

class ClienteForm extends Component {

  render() {
    const { handleSubmit } = this.props

    return (
      <Container className='semi-fluid'>
        <Header>Cadastrar Cliente</Header>
        <Form onSubmit={handleSubmit(this.props.createCliente)}>
          <Form.Group widths='equal'>
            <Field
              name='nome'
              label='Nome'
              placeholder='Informe o nome completo'
              required={true}
              component={TextField} />
            <Field
              name='cpfCnpj'
              label='CPF ou CNPJ'
              placeholder='Informe o cpf'
              required={true}
              component={TextField} />
            <Field
              name='dtNascimento'
              type='date'
              required={false}
              label='Data de Nascimento'
              component={TextField} />
          </Form.Group>
          <Form.Group widths='equal'>
            <Field
              name='logradouro'
              label='Logradouro'
              required={true}
              placeholder='Informe seu endereço'
              component={TextField} />
            <Field
              name='cidade'
              required={false}
              label='Cidade'
              component={TextField} />
            <Field
              name='telefone'
              required={true}
              label='Telefone'
              component={TextField} />
          </Form.Group>
          <Form.Group widths='equal'>
            <Field
              name='grupo'
              placeholder='Informe o e-mail'
              label='Grupo'
              component={TextField} />
            <Field
              name='dispositivo'
              label='Dispositivo'
              component={TextField} />
            <Field
              name='tipo'
              label='Tipo de Usuario'
              component={TextField} />
          </Form.Group>
          <Form.Group widths='equal'>
            <Field
              name='email'
              type='email'
              required={true}
              placeholder='Informe o e-mail'
              label='E-mail'
              component={TextField} />
            <Field
              name='senha'
              type='password'
              required={true}
              label='Senha'
              component={TextField} />
          </Form.Group>

          <Button type='button' onClick={() => this.props.history.goBack()}> Cancelar </Button>
          <Button positive type='submit' >Cadastrar</Button>
        </Form>
      </Container>
    );
  }
}

const clienteForm = reduxForm({
  form: 'clienteForm'
})(ClienteForm)

const mapDispatchToProps = dispatch => bindActionCreators({createCliente}, dispatch)

export default connect(null, mapDispatchToProps)(clienteForm)