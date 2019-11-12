import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form } from 'semantic-ui-react';
import { TextField } from '../../shared/form/TextField'

class dispositivoForm extends Component {
  render() {
    return (
      <Container className='semi-fluid'>
        <Header>Cadastrar Dispositivo</Header>
        <Form>
          <Form.Group widths='equal'>
            <Field
              name='nome'
              label='Nome'
              placeholder='Informe o nome do dispositivo'
              component={TextField} />
          </Form.Group>
          <Form.Group widths='equal'>
            <Field
              name='identificador'
              label='Identificador'
              placeholder='Informe o identificado do dispositivo'
              component={TextField} />
          </Form.Group>
        </Form>
      </Container>
    )
  }
}

const DispositivoForm = reduxForm({
  form: 'dispositivoForm'
})(dispositivoForm)

export default DispositivoForm
