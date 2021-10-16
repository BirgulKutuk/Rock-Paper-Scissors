import axios from 'axios';

const ROCK_PAPER_SCISSORS_GAME_API_BASE_URL = "http://localhost:8080/api/rockpaperscissors";

class MainGameService {

    openYourHand(move) {
        return axios.post(ROCK_PAPER_SCISSORS_GAME_API_BASE_URL + "/openYourHand/" + move);
    }
}

export default new MainGameService()