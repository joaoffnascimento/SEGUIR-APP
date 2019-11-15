import React, { Component } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { setUsuario } from '../actions/systemActions'
import Requests from './Requests'
import { Form, Button, Header, Message } from 'semantic-ui-react'
import Cookie from 'cookiejs'
import './Login.css'

class Login extends Component {

    state = {
        email: '',
        senha: '',

        users: [],

        userError: false
    }

    componentDidMount() {
        this.getUsers()
    }

    getUsers() {
        Requests.getClientes().then(data => {
            this.setState({ users: data })
        })
    }

    handleSubmit = () => {

        const { email, senha, users } = this.state
        const { setUsuario } = this.props

        users.map(user => {
            console.log(user)
            if (user.email === email && user.senha === senha) {
                const usuario = {
                    idUser: user.idPessoa,
                    tipoUser: user.tipo
                }
                setUsuario(usuario)

                window.localStorage.setItem('user', usuario.idUser)
                Cookie.set('tipo', usuario.tipoUser)
                this.setState({ email: '', senha: '', emailError: false, senhaError: false })
            } else {
                this.setState({ userError: true })
            }
        })
    }

    render() {

        const { email, senha, userError } = this.state

        return (
            <div className='container-login'>

                {userError &&
                    <Message color='red'> E-mail ou senha inválida, tente novamente! </Message>}

                <Form className='login' onSubmit={this.handleSubmit}>

                    <Header className='text-white' size='large' textAlign="center">SeguiApp</Header>

                    <strong className='text-white' >E-Mail</strong>
                    <Form.Input
                        required
                        type='email'
                        placeholder='Informe seu email'
                        value={email}
                        onChange={event => this.setState({ email: event.target.value })}
                    />
                    <strong className='text-white' >Senha</strong>
                    <Form.Input
                        required
                        type='password'
                        value={senha}
                        onChange={event => this.setState({ senha: event.target.value })}
                    />
                    <Button positive className="btn" type="submit">Entrar</Button>
                </Form>
            </div>
        )
    }
}

const mapDispatchToProps = dispatch =>
    bindActionCreators({ setUsuario }, dispatch);

export default connect(null, mapDispatchToProps)(Login)