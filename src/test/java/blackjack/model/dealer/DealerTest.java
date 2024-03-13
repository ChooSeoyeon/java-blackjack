package blackjack.model.dealer;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.model.card.Card;
import blackjack.model.card.Denomination;
import blackjack.model.card.InitialCardPair;
import blackjack.model.card.Suit;
import blackjack.model.cardgenerator.SequentialCardGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {
    @Test
    @DisplayName("딜러는 카드의 합이 17점 이상이 될 때까지 카드를 받는다")
    void canDrawTest() {
        // given
        Card firstDealCard = new Card(Suit.HEART, Denomination.TWO);
        Card secondDealCard = new Card(Suit.HEART, Denomination.TWO);
        InitialCardPair initialCardPair = InitialCardPair.of(new SequentialCardGenerator(
                List.of(firstDealCard, secondDealCard)
        ));
        Dealer dealer = new Dealer();
        dealer.dealCards(initialCardPair);

        // when
        Card firstDrawCard = new Card(Suit.HEART, Denomination.TEN);
        Card secondDrawCard = new Card(Suit.HEART, Denomination.FOUR);
        dealer.drawCards(new SequentialCardGenerator(List.of(firstDrawCard, secondDrawCard)));

        // then
        int cardsTotal = dealer.calculateCardsTotalScore();
        assertThat(cardsTotal).isGreaterThan(17);
    }
}
