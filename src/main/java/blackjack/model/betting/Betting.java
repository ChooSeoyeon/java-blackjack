package blackjack.model.betting;

import blackjack.model.player.MatchResult;
import java.util.HashMap;
import java.util.Map;

public class Betting {
    private static final String NOT_FOUND_BETTING_PLAYER = "배팅 정보가 없는 플레이어입니다.";

    private final Map<String, BettingMoney> playerBettingMoney;

    public Betting() {
        this.playerBettingMoney = new HashMap<>();
    }

    public void addPlayerBettingMoney(final String playerName, final BettingMoney bettingMoney) {
        playerBettingMoney.put(playerName, bettingMoney);
    }

    public int calculatePlayerBettingProfit(final String playerName, final MatchResult matchResult) {
        BettingMoney bettingMoney = findBettingMoneyByPlayerName(playerName);
        return matchResult.calculateProfit(bettingMoney);
    }

    private BettingMoney findBettingMoneyByPlayerName(final String playerName) {
        if (!playerBettingMoney.containsKey(playerName)) {
            throw new IllegalArgumentException(NOT_FOUND_BETTING_PLAYER);
        }
        return playerBettingMoney.get(playerName);
    }
}
