import React, {Component} from 'react';
import {Button, Col, Container, Navbar, Row} from "react-bootstrap";
import MainGameService from "../services/MainGameService";

class MainGameBoardComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            player_1_score: 0,
            player_2_score: 0,
            draw_score: 0
        }

        this.onClick_Func = this.onClick_Func.bind(this);
    }

    onClick_Func(player1_move) {
        MainGameService.openYourHand(player1_move).then(response => {
            let moveResult = response.data;

            if (moveResult.result === "WIN") {
                this.setState({player_1_score: this.state.player_1_score + 1});
            } else if (moveResult.result === "LOSE") {
                this.setState({player_2_score: this.state.player_2_score + 1});
            } else if (moveResult.result === "DRAW") {
                this.setState({draw_score: this.state.draw_score + 1});
            }

            if (moveResult.player2_Move === "ROCK") {
                document.getElementById("player2_rock_id").style.backgroundColor = 'red';
                setTimeout(() => {
                    document.getElementById("player2_rock_id").style.backgroundColor = 'white';
                }, 1000);
            } else if (moveResult.player2_Move === "PAPER") {
                document.getElementById("player2_paper_id").style.backgroundColor = 'red';
                setTimeout(() => {
                    document.getElementById("player2_paper_id").style.backgroundColor = 'white';
                }, 1000);
            } else if (moveResult.player2_Move === "SCISSORS") {
                document.getElementById("player2_scissors_id").style.backgroundColor = 'red';
                setTimeout(() => {
                    document.getElementById("player2_scissors_id").style.backgroundColor = 'white';
                }, 1000);
            }
        });
    }

    render() {
        return (
            <div>
                <Navbar.Toggle/>
                <Container fluid>
                    <Row>
                        <Col className="text-center">
                            <h1>PLAYER 1</h1>
                        </Col>
                        <Col className="text-center">
                            <h1>DRAW</h1>
                        </Col>
                        <Col className="text-center">
                            <h1>COMPUTER</h1>
                        </Col>
                    </Row>
                    <Row className="my-xxl-3">
                        <Col className="text-center">
                            <h1>{this.state.player_1_score}</h1>
                        </Col>
                        <Col className="text-center">
                            <h1>{this.state.draw_score}</h1>
                        </Col>
                        <Col className="text-center">
                            <h1>{this.state.player_2_score}</h1>
                        </Col>
                    </Row>
                    &nbsp;
                    <Row>
                        <Col>
                            <Row md={2}>
                                <Button variant="info" active
                                        onClick={() => this.onClick_Func('ROCK')}>
                                    <img src="https://image.pngaaa.com/783/3313783-small.png" alt="rock" width="200px"/>
                                </Button>
                            </Row>
                            &nbsp;
                            <Row md={2}>
                                <Button variant="info" active
                                        onClick={() => this.onClick_Func('PAPER')}>
                                    <img
                                        src="https://www.vhv.rs/dpng/d/535-5351099_rock-paper-scissors-rock-paper-scissors-icons-png.png"
                                        alt="paper" width="200px"/>
                                </Button>
                            </Row>
                            &nbsp;
                            <Row md={2}>
                                <Button variant="info" active
                                        onClick={() => this.onClick_Func('SCISSORS')}>
                                    <img
                                        src="https://www.clipartmax.com/png/small/428-4288836_your-hand-hand-clipart-png-rock-paper-scissors.png"
                                        alt="scissors" width="200px"/>
                                </Button>
                            </Row>
                        </Col>
                        <Col>
                            <Row md={2}>
                                <Button variant="outline-warning" disabled id="player2_rock_id">
                                    <img src="https://image.pngaaa.com/783/3313783-small.png" alt="rock" width="200px"/>
                                </Button>
                            </Row>
                            &nbsp;
                            <Row md={2}>
                                <Button variant="outline-warning" disabled id="player2_paper_id">
                                    <img
                                        src="https://www.vhv.rs/dpng/d/535-5351099_rock-paper-scissors-rock-paper-scissors-icons-png.png"
                                        alt="paper" width="200px"/>
                                </Button>
                            </Row>
                            &nbsp;
                            <Row md={2}>
                                <Button variant="outline-warning" disabled id="player2_scissors_id">
                                    <img
                                        src="https://www.clipartmax.com/png/small/428-4288836_your-hand-hand-clipart-png-rock-paper-scissors.png"
                                        alt="scissors" width="200px"/>
                                </Button>
                            </Row>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default MainGameBoardComponent;