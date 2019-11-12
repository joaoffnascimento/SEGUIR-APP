import React, { Component } from 'react'
import { Form, Button, Header } from 'semantic-ui-react'
import './Login.css'

class Login extends Component {

    state = {
        email: ''
    }

    handleSubmit = async (event) => {
        event.preventDefault()

        localStorage.setItem('user', 1)
    }

    render() {
        return (
            <div className='container-login'>
                <Form className='login' onSubmit={this.handleSubmit}>

                    <Header className='text-white' size='large' textAlign="center">SeguiApp</Header>

                    <strong className='text-white' >E-Mail</strong>
                    <Form.Input
                        type='email'
                        placeholder='Informe seu email'
                        required
                    />
                    <strong className='text-white' >Senha</strong>
                    <Form.Input
                        type='password'
                        required
                    />
                        <Button className="btn" type="submit">Entrar</Button>
                </Form>
            </div>
        )
    }
}

export default Login