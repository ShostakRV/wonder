import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import {createStore, applyMiddleware} from 'redux';
import {composeWithDevTools} from 'redux-devtools-extension';
import thunk from 'redux-thunk';
import {Route, BrowserRouter} from 'react-router-dom';

import App from './ui/container/app/App';
import './index.css';
import reducer from './redusers/index';
import About from './ui/container/about/About';
import Menu from "./ui/component/Menu";

const store = createStore(reducer, composeWithDevTools(applyMiddleware(thunk)));

ReactDOM.render(
    <Provider store={store}>
        <BrowserRouter>
            <div>
                <Route path="/" component={Menu}/>
                <Route path="/loby" component={App}/>
                <Route path="/about" component={About}/>
            </div>
        </BrowserRouter>
    </Provider>,
    document.getElementById('root')
);