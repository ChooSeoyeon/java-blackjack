package blackjack.model.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private static final int BLACKJACK_SCORE = 21;
    private static final int BLACKJACK_CARD_SIZE = 2;
    private static final int ACE_ADDITIONAL_SCORE = 10;

    private final List<Card> cards;

    Cards(final List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void addCards(final List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void addCard(final Card card) {
        cards.add(card);
    }

    public boolean canAddCardWithinScoreLimit(int maxScoreThreshold) {
        return calculateScore() <= maxScoreThreshold;
    }

    public int calculateScore() {
        int total = cards.stream()
                .map(Card::getDenomination)
                .mapToInt(Denomination::getScore)
                .sum();

        if (hasAce()) {
            return addAceScoreIfNotBust(total);
        }
        return total;
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(card -> card.getDenomination().isAce());
    }

    private int addAceScoreIfNotBust(int total) {
        if (total + ACE_ADDITIONAL_SCORE <= BLACKJACK_SCORE) {
            return total + ACE_ADDITIONAL_SCORE;
        }
        return total;
    }

    public boolean isBlackJack() {
        return calculateScore() == BLACKJACK_SCORE && cards.size() == BLACKJACK_CARD_SIZE;
    }

    public boolean isBust() {
        return calculateScore() > BLACKJACK_SCORE;
    }

    public int size() {
        return cards.size();
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public List<Card> getCards() {
        return cards;
    }
}
