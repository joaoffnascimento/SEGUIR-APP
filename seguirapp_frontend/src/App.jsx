import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Route, HashRouter, Switch } from 'react-router-dom'
import Login from './shared/Login'
import TopBar from './shared/topBar/TopBar'
import NavBar from './shared/navBar/NavBar'
import Dashboard from './pages/dashboard/Dashboard'
import ClienteForm from './pages/clientes/ClienteForm'
import DispositivoForm from './pages/dispositivos/DispositivoForm'
import ClienteList from './pages/clientes/ClienteList'
import GrupoForm from './pages/grupos/GrupoForm'
import VeiculoForm from './pages/veiculos/VeiculoForm'
import VeiculoList from './pages/veiculos/VeiculosList'

class App extends Component {

  render() {
    const user = localStorage.getItem('user')

    if (!user) {
      return <Login />
    }

    return (
      <div>
        <HashRouter>
          <Switch>
            <Route path="/" render={() => (
              <div>
                <TopBar />
                <NavBar />
                <div className='container'>
                  <Route path="/" exact component={Dashboard} />
                  <Route path="/cliente" exact component={ClienteList} />
                  <Route path="/cliente/novo" exact component={ClienteForm} />
                  <Route path="/dispositivo" exact component={DispositivoForm} />
                  <Route path="/grupo" exact component={GrupoForm} />
                  <Route path="/veiculo" exact component={VeiculoList} />
                  <Route path="/veiculo/novo" exact component={VeiculoForm} />
                </div>
              </div>
            )} />
          </Switch>
        </HashRouter>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  user: state.system.user
});

export default connect(mapStateToProps)(App);