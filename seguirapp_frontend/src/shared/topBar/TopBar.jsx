import React, { Component } from 'react'
import './TopBar.css'

class TopBar extends Component {
    render() {
        return (
            <div className="top-bar">
                <div >
                    <a href="#/" className="text-bar">
                        Segui<strong>App</strong>
                    </a>
                </div>
                <a href="#/" className="btn-sair">
                    Sair
                </a>
            </div>
        )
    }
}

export default TopBar