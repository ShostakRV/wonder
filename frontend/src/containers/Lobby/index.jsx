import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";

class App extends Component {
    render() {
        return (
            <div>
                Loby
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

export default connect(mapStateToProps, actionsStateToProps)(App);