import React, { Component } from 'react'
import { Route, HashRouter, Switch } from 'react-router-dom'
import Login from './shared/Login'
import TopBar from './shared/topBar/TopBar'
import NavBar from './shared/navBar/NavBar'
import Dashboard from './pages/dashboard/Dashboard'
import ClienteForm from './pages/clientes/ClienteForm'

class App extends Component {
  render() {
    const token = localStorage.getItem('user')

    if (token) {
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
                  <Route path="/dashboard" exact component={Dashboard}/>
                  <Route path="/cadastro-cliente" component={ClienteForm}/>
                </div>
              </div>
            )} />
          </Switch>
        </HashRouter>
      </div>
    );
  }
}

export default App;