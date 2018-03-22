import React, {Component} from 'react';
import {Link} from 'react-router-dom';

import Chat from "./chat/Chat";

class Menu extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-default">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <a className="navbar-brand" href="#">WebSiteName</a>
                        </div>
                        <ul className="nav navbar-nav">
                            <li className="nav-item">
                                <Link to="/">Main</Link>
                            </li>
                            <li className="nav-item">
                                <Link to="/loby">Loby</Link>
                            </li>
                            <li className="nav-item">
                                <Link to="/about">About</Link>
                            </li>
                        </ul>
                    </div>
                </nav>
                <Chat/>
            </div>
        );
    }
}

export default Menu;