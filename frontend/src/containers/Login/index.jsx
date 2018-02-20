import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";

class Home extends Component {
    render() {
        return (
            <div>
                Login
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

export default connect(mapStateToProps, actionsStateToProps)(Home);