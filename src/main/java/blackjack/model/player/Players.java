package blackjack.model.player;

import blackjack.model.cardgenerator.CardGenerator;
import blackjack.view.dto.PlayerFinalCardsOutcome;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {
    private static final String INVALID_NAMES_COUNT = "참여자 수는 1명 이상이다";
    private static final String DUPLICATED_NAMES = "참여자 이름은 중복될 수 없다";

    private final List<Player> players;

    public Players(final List<String> playerNames) {
        validate(playerNames);
        this.players = playerNames.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(final List<String> playerNames) {
        validatePlayerNamesCount(playerNames);
        validateDuplicatedPlayerNames(playerNames);
    }

    private void validatePlayerNamesCount(final List<String> playerNames) {
        if (playerNames.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAMES_COUNT);
        }
    }

    private void validateDuplicatedPlayerNames(final List<String> playerNames) {
        Set<String> uniquePlayerNames = new HashSet<>(playerNames);
        if (uniquePlayerNames.size() != playerNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAMES);
        }
    }

    public void dealCards(final CardGenerator cardGenerator) {
        players.forEach(player -> player.dealCards(cardGenerator));
    }

    public boolean isAllBlackJack() {
        return players.stream()
                .allMatch(Player::isBlackjack);
    }

    public List<PlayerFinalCardsOutcome> captureFinalCardsOutcomes() {
        return players.stream()
                .map(PlayerFinalCardsOutcome::of)
                .toList();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
