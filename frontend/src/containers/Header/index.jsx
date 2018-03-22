import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";

import './style.css';

class Header extends Component {
    render() {
        return (
            <div className="game-name">
                7 Wonders
            </div>
        );
    }
};

function mapStateToProps(state) {
    return {
        globalState: state.globalState
    }
}

function actionsStateToProps(dispatch) {
    return {}
}

export default connect(mapStateToProps, actionsStateToProps)(Header);