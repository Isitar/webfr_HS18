import React from 'react';
import Header from './Header';
import Footer from './Footer';
import {Container} from 'reactstrap';
import QuestionnaireContainer from '../questionnaire/QuestionnaireContainer';

export default class App extends React.Component {

    rightMessage;

    constructor(props) {
        super(props);
        this.state = {rightMessage: ''};
    }


    render() {
        return (
            <Container fluid>
                <Header
                    title="Flashcard Client with React"
                    subtitle="Version 1"/>
                <QuestionnaireContainer onNumberOfQuestionnairesChanged={this.NumberOfQuestionnairesChanged}/>
                <Footer leftMessage="The FHNW Team" rightMessage={this.state.rightMessage}/>
            </Container>
        )
    }

    NumberOfQuestionnairesChanged = (numberOfQuestionnaires) => this.setState({rightMessage: numberOfQuestionnaires + ' Questionnaires'});

}
