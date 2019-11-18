import React, { Component } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { setUsuario } from '../../actions/systemActions'
import Cookie from 'cookiejs'
import './TopBar.css'

import Requests from '../Requests'

class TopBar extends Component {

    state ={ 
        pessoa: null
    }

    componentDidMount(){
        Requests.getClientes().then(clientes => {
            clientes.map(cliente => {
                if(cliente.idPessoa == localStorage.getItem('user')){
                    this.setState({pessoa: cliente.nome})
                }
            })
        })
    }

    handleSair = () => {
        const { setUsuario } = this.props

        const usuario = {
            idUser: '',
            tipoUser: ''
        }

        const {
            protocol,
            host
        } = window.location;
        

        setUsuario(usuario)
        window.location.replace(`${protocol}//${host}`);
        localStorage.removeItem('user')
        localStorage.removeItem('tipo')
    }

    render() {
        return (
            <div className="top-bar">
                <div >
                    <a href="#/" className="text-bar">
                        Segui<strong>App</strong>
                    </a>
                </div>
                <div>
                    {this.state.pessoa}
                </div>
                <a onClick={this.handleSair} className="btn-sair">
                    Sair
                </a>
            </div>
        )
    }
}

const mapDispatchToProps = dispatch =>
  bindActionCreators({setUsuario}, dispatch);

export default connect(null,mapDispatchToProps)(TopBar)