import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import {createStore, applyMiddleware} from 'redux';
import {composeWithDevTools} from 'redux-devtools-extension';
import thunk from 'redux-thunk';
import {Router, Route, HashRouter} from 'react-router-dom';

import App from './App';
import './index.css';
import reducer from './redusers/index';
import About from './About';
import Menu from "./Menu";

const store = createStore(reducer, composeWithDevTools(applyMiddleware(thunk)));

ReactDOM.render(
    <Provider store={store}>
        <HashRouter>
            <div>
                <Route path="/" component={Menu}/>
                <Route path="/" component={App}/>
                <Route path="/traks" component={App}/>
                <Route path="/about" component={About}/>
            </div>
        </HashRouter>
    </Provider>,
    document.getElementById('root')
);