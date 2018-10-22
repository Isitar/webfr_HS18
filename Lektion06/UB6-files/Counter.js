import React from 'react';

export default class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    }
    this.increment = this.increment.bind(this);
    this.reset = this.reset.bind(this);
  }
  increment() {
    this.setState({ counter: this.state.counter + 1 });
  }
  reset() {
    this.setState({ counter: 0 });
  }
  render() {
    const nrStyle = {
      textAlign: 'center',
      fontSize: '320px',
      margin: '10px'
    };
    return (
      <div>
        <p style={nrStyle}>{this.state.counter}</p>
        <button type="button" onClick={this.increment}>
          INCR
        </button>&nbsp;
          <button type="button" onClick={this.reset}>
          REFRESH
        </button>&nbsp;
          {this.props.message}
      </div>
    )
  }
}