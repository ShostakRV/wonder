import React, {Component} from 'react';
import './Chat.css';

class Chat extends Component {
    render() {
        return (
            <div className="chat-container">
                <div>
                    <textarea className="chat-dialog" readOnly="true">
                        User1: some msg
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
        )
    }
}

export default Chat;