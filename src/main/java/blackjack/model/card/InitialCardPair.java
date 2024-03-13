package blackjack.model.card;

import blackjack.model.cardgenerator.CardGenerator;
import java.util.List;

public class InitialCardPair {
    private final Card firstCard;
    private final Card secondCard;

    public InitialCardPair(final Card firstCard, final Card secondCard) {
        this.firstCard = firstCard;
        this.secondCard = secondCard;
    }

    public static InitialCardPair of(CardGenerator cardGenerator) {
        return new InitialCardPair(cardGenerator.pick(), cardGenerator.pick());
    }

    public List<Card> getCards() {
        return List.of(firstCard, secondCard);
    }
}
