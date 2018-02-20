import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux'
import Routes from './routes';

import 'bootstrap/dist/css/bootstrap.css'

import configureStore from './store/configureStrore';

export const store = configureStore();

ReactDOM.render(
    <Provider store={store}>
        <Routes/>
    </Provider>,
    document.getElementById('root')
);