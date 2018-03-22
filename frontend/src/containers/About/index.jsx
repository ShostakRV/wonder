import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";

class App extends Component {
    render() {
        return (
            <div>
                This game created by:
                <ul>
                    <li>Shostak Roma</li>
                    <li>Pavlenko Bohdan</li>
                    <li>Misurenko Bohdan</li>
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

export default connect(mapStateToProps, actionsStateToProps)(App);