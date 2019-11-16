import React, { Component } from 'react'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { setUsuario } from '../../actions/systemActions'
import Cookie from 'cookiejs'
import './TopBar.css'

class TopBar extends Component {

    handleSair = () => {
        const { setUsuario } = this.props

        const usuario = {
            idUser: '',
            tipoUser: ''
        }

        setUsuario(usuario)
        window.localStorage.removeItem('user')
        Cookie.remove('tipo')
    }

    render() {
        return (
            <div className="top-bar">
                <div >
                    <a href="#/" className="text-bar">
                        Segui<strong>App</strong>
                    </a>
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