import React from 'react';
import {Button} from 'reactstrap';
import {MdAddBox, MdRefresh} from "react-icons/md";


export default class Counter extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            counter: 0
        };
    }

    componentDidMount() {
        this.incrInOneSecond();
    }

    incrInOneSecond() {
        setInterval(() => {
            this.increment();
        }, 1000)
    }

    increment = () => this.setState({counter: this.state.counter + 1});

    reset = () =>
        this.setState({counter: 0});

    render() {
        const nrStyle = {
            textAlign: 'center',
            fontSize: '320px',
            margin: '10px'
        };
        return (
            <div>
                <p style={nrStyle}>{this.state.counter}</p>
                <Button type="button" color="danger" onClick={this.reset}>
                    <MdRefresh/>
                </Button>&nbsp;
                {this.props.message}
            </div>
        )
    };
}