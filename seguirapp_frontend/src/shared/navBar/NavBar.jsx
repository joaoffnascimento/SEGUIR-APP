import React, { Component } from 'react'
import { Menu } from 'semantic-ui-react'
import './NavBar.css'

class NavBar extends Component {

    state = {
        itemAtivo: ''
    }

    handleItemClick = (e, { name }) => {
        this.setState({ itemAtivo: name })
    }

    render() {
        const { itemAtivo } = this.state

        return (
            <div className="nav-bar">
                <Menu vertical pointing inverted color='grey'>
                    <Menu.Item className="text-inicio"
                        name='Inicio'
                        active={itemAtivo === 'Inicio'}
                        href="#/"
                        onClick={this.handleItemClick}/>
                    <Menu.Item className="text-white"> <strong>Cadastros</strong> </Menu.Item>
                    <Menu.Menu className="text-white">
                        <Menu.Item
                            name='Cliente'
                            active={itemAtivo === 'Cliente'}
                            href="#/cadastro-cliente"
                            onClick={this.handleItemClick}
                        />
                        <Menu.Item
                            name='Dispositivo'
                            active={itemAtivo === 'Dispositivo'}
                            href="#/cadastro-dispositivo"
                            onClick={this.handleItemClick}
                        />
                    </Menu.Menu>
                </Menu>
            </div>
        )
    }
}

export default NavBar