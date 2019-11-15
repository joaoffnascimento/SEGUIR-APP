import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Menu } from 'semantic-ui-react'
import Cookie from 'cookiejs'
import './NavBar.css'

class NavBar extends Component {

    state = {
        itemAtivo: ''
    }

    handleItemClick = (e, { name }) => {
        this.setState({ itemAtivo: name })
    }

    renderAdmin() {
        const { itemAtivo } = this.state

        return (
            <Menu vertical pointing inverted color='grey'>
                <Menu.Item className="text-inicio"
                    name='Inicio'
                    active={itemAtivo === 'Inicio'}
                    href="#/"
                    onClick={this.handleItemClick} />
                <Menu.Item
                    name='Clientes'
                    active={itemAtivo === 'Clientes'}
                    href="#/cliente"
                    onClick={this.handleItemClick}
                />
                <Menu.Item
                    name='Dispositivos'
                    active={itemAtivo === 'Dispositivos'}
                    href="#/dispositivo"
                    onClick={this.handleItemClick}
                />
            </Menu>
        )
    }

    renderCliente() {
        const { itemAtivo } = this.state

        return(
            <Menu vertical pointing inverted color='grey'>
                    <Menu.Item className="text-inicio"
                        name='Inicio'
                        active={itemAtivo === 'Inicio'}
                        href="#/"
                        onClick={this.handleItemClick} />
                    <Menu.Item
                        name='Localizar Dispositivo'
                        active={itemAtivo === 'Localizar Dispositivo'}
                        href="#/"
                        onClick={this.handleItemClick}
                    />
                </Menu>
        )
    }

    render() {
        const tipo = Cookie.get('tipo')

        return (
            <div className="nav-bar">
                {tipo === 'administrador' ? this.renderAdmin() : this.renderCliente()}
            </div>
        )
    }
}

const mapStateToProps = state => ({
  user: state.system.user
});

export default connect(mapStateToProps)(NavBar)