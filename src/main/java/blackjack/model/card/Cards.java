package blackjack.model.card;

import blackjack.model.cardgenerator.CardGenerator;
import java.util.ArrayList;
import java.util.List;

public class Cards {
    //    private static final Map<String, Card> pool = Suit.stream()
//            .flatMap(suit -> Denomination.stream().map(denomination -> new Card(suit, denomination)))
//            .collect(toMap(it -> toKey(it.suit, it.denomination), Function.identity()));

    // public static Card of (final Suit suit, final De de) { return pool.get(toKey(s, d)); }
    // private static
    private static final int BLACK_JACK_CONDITION = 21;
    private static final int BURST_CONDITION = 21;
    private static final int ACE_ADJUSTMENT = 10;

    private final List<Card> cards;

    public Cards(final List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public Cards(final CardGenerator cardGenerator) {
        this.cards = new ArrayList<>(deal(cardGenerator));
    }

    private List<Card> deal(final CardGenerator cardGenerator) {
        return List.of(cardGenerator.pick(), cardGenerator.pick());
    }

    public Cards add(final Card card) {
        final var newCards = new ArrayList<>(this.cards);

        newCards.add(card);
        return new Cards(newCards);
    }

    public void addCard(final CardGenerator cardGenerator) {
        cards.add(cardGenerator.pick());
    }

    public int calculateCardsTotal() {
        int total = cards.stream()
                .map(Card::getDenomination)
                .mapToInt(Denomination::getScore)
                .sum(); // totalScore 메서드 분리

        // map(Card::score).reduce(Score.defaults(), Score::add);

        if (hasAce() && canBeAdjusted(total)) { // score 비교하고 더하는 걸 score 객체로 빼자. -> addAceScoreIfNotBust()
            return adjustTotalForAce(total); // BlackJackScore
        }
        // if (hasAce()) {return score.addAceScoreIfNotBust().toInt();
        return total;
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(card -> card.getDenomination().isAce());
    }

    private boolean canBeAdjusted(int total) { // 21을 초과했는지의 여부 담기 위해
        return total + ACE_ADJUSTMENT <= BLACK_JACK_CONDITION; // BLACKJACK_SCORE = 21, ACE_ADDITIONAL_SCORE = 10;
    } // aceScore = add(ACE_ADDITIONAL_SCORE); if(aceScore.notBust()) { return aceScore; } return this;
    // notBust() { return this.valeu <= BLACKJACK_SCORE; }

    // assertThat\(hand.score\(\)\).isEqualTo\(([0-9]*)\);
    //assertThat\(hand.score\(\)\).isEqualTo\(new Score\($1\)\);

    // public Score add(final int other) { return new Score(this.value + other);]
    // public Score add(final Score other) { return add(other.value)};

    private int adjustTotalForAce(int total) {
        return total + ACE_ADJUSTMENT;
    }

    public boolean isBlackJack() {
        return calculateCardsTotal() == BLACK_JACK_CONDITION;
    }

    public boolean isBurst() {
        return calculateCardsTotal() > BURST_CONDITION;
    }

    public int size() {
        return cards.size();
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public List<Card> getCards() {
        return cards; // Collections.unmodifidableList(cards)로 변경하기
    }
}
