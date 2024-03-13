package blackjack.controller;

import blackjack.model.card.InitialCardPair;
import blackjack.model.cardgenerator.CardGenerator;
import blackjack.model.cardgenerator.RandomCardGenerator;
import blackjack.model.dealer.Dealer;
import blackjack.model.player.Player;
import blackjack.model.player.Players;
import blackjack.model.referee.Referee;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import blackjack.view.dto.DealerFinalCardsOutcome;
import blackjack.view.dto.PlayerFinalCardsOutcome;
import blackjack.view.dto.PlayerMatchResult;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class BlackjackGame {
    private final InputView inputView;
    private final OutputView outputView;

    public BlackjackGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        CardGenerator cardGenerator = new RandomCardGenerator();
        Players players = retryOnException(this::preparePlayers);
        Dealer dealer = new Dealer();

        dealCards(players, dealer, cardGenerator);
        drawCards(players, dealer, cardGenerator);
        showResult(players, dealer);
    }

    private Players preparePlayers() {
        List<String> playerNames = inputView.askPlayerNames();
        return Players.from(playerNames);
    }

    private void dealCards(final Players players, final Dealer dealer, final CardGenerator cardGenerator) {
        outputView.printDealCardsIntro(players.getNames());
        dealCardsToPlayers(players, cardGenerator);
        dealCardsToDealer(dealer, cardGenerator);
    }

    private void dealCardsToPlayers(final Players players, final CardGenerator cardGenerator) {
        for (Player player : players.getPlayers()) {
            player.dealCards(InitialCardPair.of(cardGenerator));
            outputView.printPlayerCards(player.getName(), player.getCards());
        }
    }

    private void dealCardsToDealer(final Dealer dealer, CardGenerator cardGenerator) {
        dealer.dealCards(InitialCardPair.of(cardGenerator));
        outputView.printDealerFirstCard(dealer.getFirstCard());
    }

    private void drawCards(final Players players, final Dealer dealer, final CardGenerator cardGenerator) {
        if (isGameEnd(dealer, players)) {
            return;
        }
        drawCardsToPlayers(players, cardGenerator);
        drawCardsToDealer(dealer, cardGenerator);
    }

    private boolean isGameEnd(final Dealer dealer, final Players players) {
        return dealer.isBlackJack() || players.isAllBlackJack();
    }

    private void drawCardsToPlayers(final Players players, final CardGenerator cardGenerator) {
        for (Player player : players.getPlayers()) {
            drawCardsToPlayer(player, cardGenerator);
        }
    }

    private void drawCardsToPlayer(final Player player, final CardGenerator cardGenerator) {
        boolean isContinue = player.canDrawCard();
        while (isContinue) {
            isContinue = drawCardToPlayer(player, cardGenerator);
        }
    }

    private boolean drawCardToPlayer(final Player player, final CardGenerator cardGenerator) {
        Command command = retryOnException(() -> inputView.askPlayerDrawOrStandCommand(player.getName()));
        if (command.isDraw()) {
            player.drawCard(cardGenerator);
            outputView.printPlayerCards(player.getName(), player.getCards());
        }
        return player.canDrawCard() && command.isDraw();
    }

    private void drawCardsToDealer(final Dealer dealer, final CardGenerator cardGenerator) {
        dealer.drawCards(cardGenerator);
        outputView.printDealerDrawCount(dealer.getDrawCount());
    }

    private void showResult(final Players players, final Dealer dealer) {
        showFinalCardsOutcome(players, dealer);
        showMatchResult(players, dealer);
    }

    private void showFinalCardsOutcome(final Players players, final Dealer dealer) {
        DealerFinalCardsOutcome dealerFinalCardsOutcome = DealerFinalCardsOutcome.of(dealer);
        List<PlayerFinalCardsOutcome> playerFinalCardsOutcomes = players.captureFinalCardsOutcomes();
        outputView.printDealerFinalCards(dealerFinalCardsOutcome);
        outputView.printPlayersFinalCards(playerFinalCardsOutcomes);
    }

    private void showMatchResult(final Players players, final Dealer dealer) {
        Referee referee = new Referee(players, dealer);
        List<PlayerMatchResult> playerMatchResults = referee.determinePlayersMatchResult();
        outputView.printMatchResult(playerMatchResults);
    }

    public <T> T retryOnException(final Supplier<T> retryOperation) {
        Optional<T> result = Optional.empty();
        while (result.isEmpty()) {
            result = tryOperation(retryOperation);
        }
        return result.get();
    }

    private <T> Optional<T> tryOperation(final Supplier<T> operation) {
        try {
            return Optional.of(operation.get());
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return Optional.empty();
        }
    }
}
