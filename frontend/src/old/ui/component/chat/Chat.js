import React, {Component} from 'react';
import './Chat.css';
import $ from 'jquery';

class Chat extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isOpened: true
        };
        this.toogleState = this.toogleState.bind(this);
    }

    toogleState() {
        this.setState({isOpened: !this.state.isOpened});
        if(this.state.isOpened) {
            this.$chatBody.hide("slow");
        }else{
            this.$chatBody.show("slow");
        }
    }

    componentDidMount() {
        this.$chatBody=$(this.refs.chatBody);
    }

    render() {
        return (
            <div className="chat-container">
                <div>
                    <div>
                        <button className="btn pull-right" onClick={this.toogleState}>_(min)</button>
                    </div>
                    <div ref="chatBody" className="chat-body">
                        <div>
                            <label>Chat name</label>
                        </div>
                        <div>
                        <textarea className="chat-dialog" readOnly="true" value="User1: some msg">
                        </textarea>
                        </div>
                        <div>
                            <div className="input-group">
                                <input className="form-control" type="text"/>
                                <span className="input-group-btn">
                                <button className="btn btn-info">Send</button></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Chat;