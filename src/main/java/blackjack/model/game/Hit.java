package blackjack.model.game;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import java.util.List;

public class Hit {
    private final Cards cards;

    public Hit(Cards cards) {
        this.cards = cards;
    }

    void draw(Card card) {
        final var newHand = cards.add(card);
        if (newHand.isBust()) {
            return new Bust(newHand);
        }
        return new Hit(newHand);
    }

    Object stand() {
        return new Stand(cards);
    }

    List<Card> cards() {
        return cards.getCards();
    }

    void calculateProfit() {

    }
}

