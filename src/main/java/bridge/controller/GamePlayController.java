package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GamePlayController {
    private final BridgeGame bridgeGame;
    private final BridgeGameResult bridgeGameResult;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

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
        outputView.printMap(bridgeGameResult.getCurrentResult(index));
    }

    private void progressPlayerMove(int moveIndex) {
        boolean isPossibleMove = bridgeGame.move(moveIndex++, inputView.readMoving(), bridgeGameResult);
        showCurrentResult(moveIndex);
        if (!isPossibleMove) {
            askReplay();
        }
    }

    private void askReplay() {
        String gameCommand = inputView.readGameCommand();
        if (bridgeGame.retry(gameCommand)) {
            startGame();
            return;
        }
        gameProgress = false;
    }

    private void showFinalResult(StringBuffer result) {
        outputView.printResult(result);
    }
}