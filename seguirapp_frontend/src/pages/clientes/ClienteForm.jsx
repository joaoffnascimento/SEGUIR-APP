import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form, Button, Message } from 'semantic-ui-react';
import { cpfLabel, validateCpf, requiredValidate, celularLabel, validatePhoneBr } from '../../helpers/FnUtils'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { createCliente } from '../../actions/clienteActions'
import { TextField } from '../../shared/form/TextField'
import { SelectField } from '../../shared/form/SelectField'
import Requests from '../../shared/Requests'

class ClienteForm extends Component {

  state = {
    nome: null,
    cpf: null,
    dtNascimento: null,
    dispositivo: null,


    errors: [],
    optionsTipo: [{ key: 'adm', text: 'Administrador', value: 'administrador' }, { key: 'cli', text: 'Cliente', value: 'cliente' }],
    optionsDispositivos: [],
    optionsCidades: [],
    optionsGrupos: []
  }

  componentDidMount() {
    this.getDispositivos()
    this.getCidades()
    this.getGrupos()
  }

  getDispositivos() {
    Requests.getDispositivos().then(dispositivo => {
      const dispositivos = dispositivo.map(disp => ({ key: disp.idDispositivo, text: disp.nome, value: {idDispositivo: String(disp.idDispositivo)} }))

      this.setState({
        optionsDispositivos: dispositivos
      })
    })
  }

  getCidades() {
    Requests.getCidades().then(cidade => {
      const cidades = cidade.map(cid => ({ key: cid.idCidade, text: cid.nome, value: cid.nome }))

      this.setState({
        optionsCidades: cidades
      })
    })
  }

  getGrupos() {
    Requests.getGrupos().then(grupo => {
      const grupos = grupo.map(gr => ({ key: gr.idGrupo, text: gr.empresa, value: {idGrupo: String(gr.idGrupo)} }))

      this.setState({
        optionsGrupos: grupos
      })
    })
  }

//   render() {
//     const { errors } = this.state

//     return (
//       <Container className='semi-fluid'>
//         <Header>Cadastrar Cliente</Header>

//         <Message
//           error
//           hidden={errors.length === 0}
//           list={errors}>
//         </Message>

//         <Form>

//           <Form.Group widths='equal'>
//             <Form.Input
//               name='nome'
//               label='Nome'
//               placeholder='Informe o nome completo'
//               value={this.state.nome}
//               onChange={(event, {value}) => this.setState({ nome: value })} />

//             <Form.Input
//               name='cpfCnpj'
//               label='CPF'
//               placeholder='Informe o cpf'
//               value={this.state.cpf}
//               onChange={(event, {value}) => this.setState({ cpf: cpfLabel(value) })} />

//             <Form.Input
//               name='dtNascimento'
//               type='date'
//               label='Data de Nascimento'
//               value={this.state.dtNascimento}
//               onChange={(event, {value}) => this.setState({ dtNascimento: value})}
//             />
//           </Form.Group>

//           <Form.Group widths='equal'>
//             <Form.Input
//               name='logradouro'
//               label='Logradouro'
//               placeholder='Informe seu endereço'
//               value={this.state.logradouro}
//               onChange={(event, {value}) => this.setState({ logradouro: value})}/>
//             <Field
//               name='cidade'
//               search={true}
//               options={this.state.optionsCidades}
//               label='Cidade'
//               component={SelectField} />
//             <Field
//               name='telefone'
//               label='Telefone'
//               value={this.state.telefone}
//               onChange={(event, {value}) => this.setState({ telefone: celularLabel(value)})}/>
//           </Form.Group>
//           <Form.Group widths='equal'>
//             <Form.Select
//               name='grupo'
//               options={this.state.optionsGrupos}
//               label='Grupo'
//               value={this.state.dispositivo}
//               onChange={(event, {value}) => this.setState({dispositivo: value})}/>
//             <Form.Select
//               name='dispositivo'
//               options={this.state.optionsDispositivos}
//               placeholder='Selecione um dispositivo'
//               label='Dispositivo'
//               value={this.state.dispositivo}
//               onChange={(event, {value}) => this.setState({dispositivo: value})}/>
//             <Form.Select
//               required
//               name='tipo'
//               options={this.state.optionsTipo}
//               label='Tipo de Usuario'
//               value={this.state.tipo}
//               onChange={(event, {value}) => this.setState({tipo: value})} />
//           </Form.Group>
//           <Form.Group widths='equal'>
//             <Form.Input
//               name='email'
//               required
//               type='email'
//               placeholder='Informe o e-mail'
//               label='E-mail'
//               value={this.state.email}
//               onChange={(event, {value}) => this.setState({ email: value })}/>
//             <Form.Input
//               name='senha'
//               required
//               type='password'
//               label='Senha'
//               value={this.state.senha}
//               onChange={(event, {value}) => this.setState({ senha: value })}/>
//           </Form.Group>

//           <Button type='button' onClick={() => this.props.history.goBack()}> Cancelar </Button>
//           <Button positive type='submit' >Cadastrar</Button>
//         </Form>
//       </Container>
//     )
//   }
// }

// export default ClienteForm
  render() {
    const { handleSubmit } = this.props
    const { errors } = this.state

    return (
      <Container className='semi-fluid'>
        <Header>Cadastrar Cliente</Header>

        <Message
          error
          hidden={errors.length === 0}
          list={errors}>
        </Message>

        <Form onSubmit={handleSubmit(this.props.createCliente)}>

          <Form.Group widths='equal'>
            <Field
              name='nome'
              label='Nome'
              placeholder='Informe o nome completo'
              component={TextField} />

            <Field
              name='cpfCnpj'
              label='CPF'
              placeholder='Informe o cpf'
              normalize={cpfLabel}
              component={TextField} />

            <Field
              name='dtNascimento'
              type='date'
              label='Data de Nascimento'
              component={TextField} />
          </Form.Group>

          <Form.Group widths='equal'>
            <Field
              name='logradouro'
              label='Logradouro'
              placeholder='Informe seu endereço'
              component={TextField} />
            <Field
              name='cidade'
              options={this.state.optionsCidades}
              placeholder='Selecione a cidade'
              label='Cidade'
              component={SelectField} />
            <Field
              name='telefone'
              label='Telefone'
              placeholder='Informe seu número'
              component={TextField} />
          </Form.Group>
          <Form.Group widths='equal'>
            <Field
              name='grupo'
              options={this.state.optionsGrupos}
              label='Grupo'
              placeholder='Selecione um grupo'
              component={SelectField} />
            <Field
              name='dispositivo'
              options={this.state.optionsDispositivos}
              placeholder='Selecione um dispositivo'
              label='Dispositivo'
              component={SelectField} />
            <Field
              name='tipo'
              options={this.state.optionsTipo}
              placeholder='Selecione um tipo'
              label='Tipo de Usuario'
              component={SelectField} />
          </Form.Group>
          <Form.Group widths='equal'>
            <Field
              name='email'
              type='email'
              placeholder='Informe o e-mail'
              label='E-mail'
              component={TextField} />
            <Field
              name='senha'
              type='password'
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

const validate = (values, props) => {
  const nome = requiredValidate(values.nome)

  let cpfCnpj = requiredValidate(values.cpfCnpj)
  if (!cpfCnpj) cpfCnpj = validateCpf(values.cpfCnpj)

  const dtNascimento = requiredValidate(values.dtNascimento)

  const logradouro = requiredValidate(values.logradouro)

  const telefone = requiredValidate(values.telefone)

  const tipo = requiredValidate(values.tipo)

  const email = requiredValidate(values.email)

  const senha = requiredValidate(values.senha)

  const errors = {
    nome,
    cpfCnpj,
    dtNascimento,
    logradouro,
    telefone,
    tipo,
    email,
    senha
  }
  return errors
}

const clienteForm = reduxForm({
  form: 'clienteForm',
  validate
})(ClienteForm)

const mapDispatchToProps = dispatch => bindActionCreators({ createCliente }, dispatch)

export default connect(null, mapDispatchToProps)(clienteForm)