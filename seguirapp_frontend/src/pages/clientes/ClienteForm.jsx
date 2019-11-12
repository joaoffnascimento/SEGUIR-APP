import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form, Button } from 'semantic-ui-react';
import { TextField } from '../../shared/form/TextField'

class clienteForm extends Component {
  render() {
    return (
      <Container className='semi-fluid'>
        <Header>Cadastrar Cliente</Header>
        <Form>
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
              required={true}
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
              required={true}
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

          <Button positive >Cadastrar</Button>
        </Form>
      </Container>
    );
  }
}


const ClienteForm = reduxForm({
  form: 'clienteForm'
})(clienteForm)

export default ClienteForm