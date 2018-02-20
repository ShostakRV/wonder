import React, {Component} from 'react';
import {connect} from "react-redux";
import {bindActionCreators} from "redux";

class Home extends Component {
    render() {
        return (
            <div>
                <div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address exsample(super)</label>
                        <input type="text" name="username" class="form-control" id="exampleInputEmail1"
                               placeholder="super"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1"
                               placeholder="super"/>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"/> Check me out
                        </label>
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
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