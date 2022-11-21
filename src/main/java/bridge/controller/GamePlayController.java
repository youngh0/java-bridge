package bridge.controller;

import bridge.factory.ViewFactory;
import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.utils.input.PlayerMovingInput;
import bridge.utils.input.RetryInput;

public class GamePlayController {
    private final BridgeGame bridgeGame;
    private final BridgeGameResult bridgeGameResult;
    private boolean gameProgress = true;
    private boolean isAllAnswer = false;

    public GamePlayController(BridgeGame bridgeGame, BridgeGameResult bridgeGameResult) {
        this.bridgeGame = bridgeGame;
        this.bridgeGameResult = bridgeGameResult;
    }

    public void startGame() {
        bridgeGameResult.resetResult();
        int moveIndex = 0;
        while (gameProgress && !isAllAnswer) {
            progressPlayerMove(moveIndex);
            moveIndex++;
            isAllAnswer = bridgeGameResult.isGameSuccess();
        }
        showFinalResult(bridgeGameResult.getFinalResult(moveIndex, isAllAnswer));
    }

    private void showCurrentResult(int index) {
        ViewFactory.getOutputView().printMap(bridgeGameResult.getCurrentResult(index));
    }

    private void progressPlayerMove(int moveIndex) {
        boolean isPossibleMove = bridgeGame.move(moveIndex++, PlayerMovingInput.inputPlayerMoving(), bridgeGameResult);
        showCurrentResult(moveIndex);
        if (!isPossibleMove) {
            askReplay();
        }
    }

    private void askReplay() {
        String gameCommand = RetryInput.inputRetry();
        if (bridgeGame.retry(gameCommand)) {
            startGame();
            return;
        }
        gameProgress = false;
    }

    private void showFinalResult(StringBuffer result) {
        ViewFactory.getOutputView().printResult(result);
    }
}