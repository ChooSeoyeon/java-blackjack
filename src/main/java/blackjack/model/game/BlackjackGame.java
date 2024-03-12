package blackjack.model.game;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import java.util.List;

public class BlackjackGame {
    static Object start(final List<Card> cards) {
        final Cards hand = new Cards(cards);
        if (hand.isBlackJack()) {
            return new Blackjack(hand);
        }
        return new Hit(hand);
    }
}
