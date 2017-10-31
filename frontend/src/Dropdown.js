import React, {Component} from 'react';

class Dropdown extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpened: false}
    }

    toogleState() {
        this.setState({isOpened: !this.state.isOpened})
    }

    render() {
        console.log('isOpened ' + this.state.isOpened);
        let dropdownText;
        if (this.state.isOpened) {
            dropdownText = <div>Here is what is showin in dropdown</div>;
        }
        return (
            <div onClick={this.toogleState.bind(this)}>
                Hello dropdown
                {dropdownText}
            </div>
        );
    }
}

export default Dropdown