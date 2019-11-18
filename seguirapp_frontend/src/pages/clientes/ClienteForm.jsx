import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form, Button, Message } from 'semantic-ui-react';
import { cpfLabel, validateCpf, requiredValidate, celularLabel, validatePhoneBr } from '../../helpers/FnUtils'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { createCliente } from '../../actions/formActions'
import { TextField } from '../../shared/form/TextField'
import { SelectField } from '../../shared/form/SelectField'
import Requests from '../../shared/Requests'

class ClienteForm extends Component {

  state = {
    nome: null,
    cpf: null,
    dtNascimento: null,
    dispositivo: null,
    loading: false,


    errors: [],
    optionsTipo: [{ key: 'adm', text: 'Administrador', value: 'administrador' }, { key: 'cli', text: 'Cliente', value: 'cliente' }],
    optionsDispositivos: [],
    optionsEstados: [],
    optionsCidades: [],
    optionsGrupos: [],
    estado: ''
  }

  componentDidMount() {
    this.getDispositivos()
    this.getEstados()
    // this.getCidades()
    this.getGrupos()
  }


  getDispositivos() {

    this.setState({ loading: true })

    Requests.getClientes().then(pessoas => {

      let identificador = []
      let dispositivoValid = []

      const dispPessoa = pessoas.filter(pessoa => {
        return pessoa.dispositivo
      })

      dispPessoa.map(id => {
        identificador.push(id.dispositivo.identificador)
      })

      Requests.getDispositivos().then(dispositivos => {
        
        for (let index = 0; index < dispositivos.length; index++) {

          const dispositivo = dispositivos[index]

          const identificadorPessoa = identificador[index]

          dispositivoValid.push(dispositivo.identificador !== identificadorPessoa ?
            dispositivos[index] : null)
        }

        const disps = dispositivoValid.map(disp => (
          disp ?
            { key: disp.idDispositivo, text: disp.nome, value: { idDispositivo: String(disp.idDispositivo) } }
            : {}
        ))

        this.setState({ optionsDispositivos: disps, loading: false })
      })
    })
  }

  // { key: disp.idDispositivo, text: disp.nome, value: { idDispositivo: String(disp.idDispositivo) } }

  getEstados() {
    Requests.getEstados().then(estados => {
      const estado = estados.map(uf => ({ key: uf.idEstado, text: uf.nome, value: uf.idEstado }))

      this.setState({
        optionsEstados: estado,
        loading: false
      })
    })
  }

  // getCidades() {
  //   this.setState({ loading: true })

  //   Requests.getCidades().then(cidade => {
  //     const cidades = cidade.map(cid => ({ key: cid.idCidade, text: cid.nome, value: { idCidade: Number(cid.idCidade) } }))

  //     this.setState({
  //       optionsCidades: cidades,
  //       loading: false
  //     })
  //   })
  // }

  getCidades = (value) => {
    let cidadesEsts = []

    Requests.getCidades().then((cidades) => {
      cidades.map(cidade => {
        if (value === cidade.estado) {

          cidadesEsts.push(cidade)
          // let cidadesEsts = []
          const cids = cidadesEsts.map(cid => ({
            key: cid.idCidade,
            text: cid.nome,
            value: { idCidade: cid.idCidade, nome: cid.nome, estado: { idEstado: value } }
          }))

          this.setState({ optionsCidades: cids })
        }
      })
    })
  }

  getGrupos() {
    this.setState({ loading: true })

    Requests.getGrupos().then(grupo => {
      const grupos = grupo.map(gr => ({ key: gr.idGrupo, text: gr.empresa, value: { idGrupo: String(gr.idGrupo) } }))

      this.setState({
        optionsGrupos: grupos,
        loading: false
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
    const { errors, optionsDispositivos, loading } = this.state

    const dispositivosOpts = optionsDispositivos.filter(item => {
      if (item.key) {
        return item
      }
    });

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
            <Form.Select
              search
              selection
              options={this.state.optionsEstados}
              placeholder='Selecione o estado'
              value={this.state.estado}
              label='Estado'
              onChange={(event, { value }) => this.setState({ estado: value }, this.getCidades(value))} />
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
              normalize={celularLabel}
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
              options={dispositivosOpts}
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
          <Button positive loading={loading} type='submit' >Cadastrar</Button>
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

  const dispositivo = requiredValidate(values.dispositivo)

  const errors = {
    nome,
    cpfCnpj,
    dtNascimento,
    logradouro,
    telefone,
    tipo,
    email,
    senha,
    dispositivo
  }
  return errors
}

const clienteForm = reduxForm({
  form: 'clienteForm',
  validate
})(ClienteForm)

const mapDispatchToProps = dispatch => bindActionCreators({ createCliente }, dispatch)

export default connect(null, mapDispatchToProps)(clienteForm)