package bridge.controller;

import bridge.factory.ViewFactory;
import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;

public class GamePlayController {
    private final BridgeGame bridgeGame;
    private final BridgeGameResult bridgeGameResult;
    private boolean gameProgress = true;

    public GamePlayController(BridgeGame bridgeGame, BridgeGameResult bridgeGameResult) {
        this.bridgeGame = bridgeGame;
        this.bridgeGameResult = bridgeGameResult;
    }

    public void startGame() {
        bridgeGameResult.resetResult();
        int moveIndex = 0;
        while (gameProgress) {
            progressPlayerMove(moveIndex);
            moveIndex++;
            isGameClear(moveIndex);
        }
        showFinalResult(bridgeGameResult.getFinalResult(moveIndex, "성공"));
    }

    private void showCurrentResult(int index) {
        ViewFactory.getOutputView().printMap(bridgeGameResult.getCurrentResult(index));
    }

    private void progressPlayerMove(int moveIndex) {
        boolean isPossibleMove = bridgeGame.move(moveIndex++, ViewFactory.getInputView().readMoving(), bridgeGameResult);
        showCurrentResult(moveIndex);
        if (!isPossibleMove) {
            askReplay(moveIndex);
        }
    }

    private void askReplay(int moveIndex) {
        String gameCommand = ViewFactory.getInputView().readGameCommand();
        if (bridgeGame.retry(gameCommand)) {
            startGame();
            return;
        }
        showFinalResult(bridgeGameResult.getFinalResult(moveIndex, "실패"));
        gameProgress = false;
    }

    private void isGameClear(int moveIndex) {
        if (bridgeGame.isAllStep(moveIndex)) {
            gameProgress = false;
        }
    }

    private void showFinalResult(StringBuffer result) {
        ViewFactory.getOutputView().printResult(result);
    }
}
