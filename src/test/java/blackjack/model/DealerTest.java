package blackjack.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    @DisplayName("딜러는 카드의 합이 17점 이상이 될 때까지 카드를 받는다")
    void canHitTest() {
        // given
        Card cardCreatedByDeal = new Card(Suit.HEART, Denomination.TWO);
        Dealer dealer = new Dealer(new SequentialCardGenerator(List.of(cardCreatedByDeal, cardCreatedByDeal)));

        // when
        Card firstCardCreatedByAction = new Card(Suit.HEART, Denomination.TEN);
        Card secondCardCreatedByAction = new Card(Suit.HEART, Denomination.FOUR);
        dealer.doAction(new SequentialCardGenerator(List.of(firstCardCreatedByAction, secondCardCreatedByAction)));

        // then
        int cardsTotal = dealer.getHand().calculateCardsTotal();
        assertThat(cardsTotal).isGreaterThan(17);
    }
}
