import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Dashboard from './pages/dashboard/Dashboard'

import {Provider} from 'react-redux'
import {createStore, applyMiddleware, compose} from 'redux'
import thunk from 'redux-thunk'
import multi from 'redux-multi'
import promise from 'redux-promise'
import reducers from './reducers'

import 'semantic-ui-react'

import './styles/style.css'

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose
const middleware = [thunk,multi,promise]

const store = createStore(reducers,composeEnhancers(
    applyMiddleware(...middleware)
))

ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>
    ,document.getElementById('root')
);
