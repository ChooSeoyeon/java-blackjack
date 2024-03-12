package blackjack;

import blackjack.controller.BlackjackGame;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame(new InputView(), new OutputView());
        game.play();
    }
}
