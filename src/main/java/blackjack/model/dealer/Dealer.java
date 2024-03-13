package blackjack.model.dealer;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import blackjack.model.card.InitialCardPair;
import blackjack.model.cardgenerator.CardGenerator;
import java.util.List;

public class Dealer {
    private static final int MAX_DRAWABLE_SCORE = 16;
    private static final int NON_DRAW_COUNT = 2;

    private final Cards cards;

    public Dealer() {
        this.cards = new Cards();
    }

    public void dealCards(final InitialCardPair initialCardPair) {
        this.cards.addCards(initialCardPair.getCards());
    }

    public void drawCards(final CardGenerator cardGenerator) {
        while (canDrawCard()) {
            cards.addCard(cardGenerator.pick());
        }
    }

    private boolean canDrawCard() {
        return cards.canAddCardWithinScoreLimit(MAX_DRAWABLE_SCORE);
    }

    public int calculateCardsTotalScore() {
        return cards.calculateScore();
    }

    public boolean isBlackJack() {
        return cards.isBlackJack();
    }

    public boolean isBust() {
        return cards.isBust();
    }

    public int getDrawCount() {
        return cards.size() - NON_DRAW_COUNT;
    }

    public Card getFirstCard() {
        return cards.get(0);
    }

    public List<Card> getCards() {
        return cards.getCards();
    }
}
