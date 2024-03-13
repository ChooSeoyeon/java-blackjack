package blackjack.model.player;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import blackjack.model.card.InitialCardPair;
import blackjack.model.cardgenerator.CardGenerator;
import java.util.List;

public class Player {
    private static final int MAX_DRAWABLE_SCORE = 21;
    private static final String INVALID_NAME_LENGTH = "참여자 이름은 한 글자 이상이다";

    private final String name;
    private final Cards cards;

    public Player(final String name) {
        validateName(name);
        this.name = name;
        this.cards = new Cards();
    }

    private void validateName(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public void dealCards(final InitialCardPair initialCardPair) {
        this.cards.addCards(initialCardPair.getCards());
    }

    public void drawCard(final CardGenerator cardGenerator) {
        cards.addCard(cardGenerator.pick());
    }

    public boolean canDrawCard() {
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

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards.getCards();
    }
}
