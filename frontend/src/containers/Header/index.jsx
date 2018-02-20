import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";

class Header extends Component {
    render() {
        return (
            <div>
                header
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