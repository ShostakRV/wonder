import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {Link} from 'react-router-dom';
import {PAGE_PATH} from '../../pathCons';

class MainMenu extends Component {
    render() {
        return (
            <div>
                <Link to={PAGE_PATH.home}>
                    <button className="btn">Home</button>
                </Link>
                <Link to={PAGE_PATH.about}>
                    <button className="btn">About</button>
                </Link>
                <Link to={PAGE_PATH.login}>
                    <button className="btn">Login</button>
                </Link>
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

export default connect(mapStateToProps, actionsStateToProps)(MainMenu);