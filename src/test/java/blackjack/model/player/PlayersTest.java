package blackjack.model.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import blackjack.model.card.Card;
import blackjack.model.card.Denomination;
import blackjack.model.card.InitialCardPair;
import blackjack.model.card.Suit;
import blackjack.model.cardgenerator.SequentialCardGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class PlayersTest {
    @Test
    @DisplayName("참여자 수는 1명 이상이 아니면 예외가 발생한다")
    void validatePlayersCountTest() {
        // when & then
        assertThatThrownBy(() -> Players.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideDuplicatedNames")
    @DisplayName("참여자 이름은 중복되면 예외가 발생한다")
    void validateDuplicatedNamesTest(List<String> names) {
        // when & then
        assertThatThrownBy(() -> Players.from(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> provideDuplicatedNames() {
        return Stream.of(
                List.of("mia", "mia", "dora"),
                List.of("dora", "dora", "dora")
        );
    }

    @Test
    @DisplayName("모든 참여자가 블랙잭이면 true를 반환한다")
    void isAllBlackJackTest() {
        // given
        Card firstDealCard = new Card(Suit.HEART, Denomination.ACE);
        Card secondDealCard = new Card(Suit.HEART, Denomination.JACK);
        InitialCardPair initialCardPair = InitialCardPair.of(
                new SequentialCardGenerator(List.of(firstDealCard, secondDealCard)));

        Players players = Players.from(List.of("mia", "dora"));
        players.getPlayers()
                .forEach(player -> player.dealCards(initialCardPair));

        // when
        boolean actual = players.isAllBlackJack();

        // then
        assertThat(actual).isTrue();
    }
}
