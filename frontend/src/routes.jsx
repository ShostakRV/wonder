import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import Header from './containers/Header/index';
import Footer from './containers/Footer/index';
import MainMenu from './containers/MainMenu';

import Home from './containers/Home/';
import About from './containers/About/';
import Login from './containers/Login/';

import {PAGE_PATH} from './pathCons';


export default () => (
    <div>
        <BrowserRouter>
            <div>
                <div className="container-fluid">
                    <div className="header">
                        <Header/>
                    </div>
                    <div className="row main-content">
                        <div className="col-md-2 menu-bar">
                            <MainMenu/>
                        </div>
                        <div className="col-md-10 content-container">
                            <Switch>
                                <Route exact path={PAGE_PATH.home} component={Home}/>
                                <Route path={PAGE_PATH.about} component={About}/>
                                <Route path={PAGE_PATH.login} component={Login}/>
                            </Switch>
                        </div>
                    </div>
                    <div className="footer">
                        <Footer/>
                    </div>
                </div>
            </div>
        </BrowserRouter>
    </div>
);
