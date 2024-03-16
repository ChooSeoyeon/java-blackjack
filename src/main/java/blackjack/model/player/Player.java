package blackjack.model.player;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import blackjack.model.cardgenerator.CardGenerator;
import blackjack.model.dealer.Dealer;
import java.util.List;

public class Player {
    private static final int MAX_DRAWABLE_SCORE = 21;
    private static final String INVALID_NAME_LENGTH = "참여자 이름은 한 글자 이상이어야 합니다.";

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

    public void dealCards(final CardGenerator cardGenerator) {
        List<Card> receivedCards = List.of(cardGenerator.pick(), cardGenerator.pick());
        cards.addCards(receivedCards);
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

    public MatchResult determineMatchResult(final Dealer dealer) {
        return MatchResult.determine(dealer, this);
    }

    public boolean isBlackjack() {
        return cards.isBlackjack();
    }

    public boolean isBust() {
        return cards.isBust();
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

    public String getName() {
        return name;
    }
}
