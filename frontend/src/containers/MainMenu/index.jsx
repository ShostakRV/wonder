import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {Link} from 'react-router-dom';
import {PAGE_PATH} from '../../pathCons';

class MainMenu extends Component {
    render() {
        return (
            <div>
                <ul>
                    <li>
                        <Link to={PAGE_PATH.home}>
                            <button className="btn">Home</button>
                        </Link>
                    </li>
                    <li>
                        <Link to={PAGE_PATH.about}>
                            <button className="btn">About</button>
                        </Link>
                    </li>
                    <li>
                        <Link to={PAGE_PATH.login}>
                            <button className="btn">Login</button>
                        </Link>
                    </li>
                </ul>
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