import React from 'react';
import {Col, Row} from "reactstrap";

export default class Footer extends React.Component {
    rightMessage;
    leftMessage;
    render() {
        return <Row>
            <Col xs={4}>&copy; {this.props.leftMessage}</Col>
            <Col xs={4} xsOffset={4} className="text-right">{this.props.rightMessage}</Col>
        </Row>
    }
}