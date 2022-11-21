package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.view.InputView;

public class GamePlayController {
    InputView inputView = new InputView();
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
        System.out.println(bridgeGameResult.showFinalResult(moveIndex, "성공"));
    }

    private void showCurrentResult(int index) {
        System.out.println(bridgeGameResult.getCurrentResult(index));
    }

    private void progressPlayerMove(int moveIndex) {
        boolean isPossibleMove = bridgeGame.move(moveIndex++, inputView.readMoving(), bridgeGameResult);
        showCurrentResult(moveIndex);
        if (!isPossibleMove) {
            askReplay(moveIndex);
        }
    }


    private void askReplay(int moveIndex) {
        String gameCommand = inputView.readGameCommand();
        if (bridgeGame.retry(gameCommand)) {
            startGame();
            return;
        }
        System.out.println(bridgeGameResult.showFinalResult(moveIndex, "실패"));
        gameProgress = false;
    }

    private void isGameClear(int moveIndex) {
        if (bridgeGame.isAllStep(moveIndex)) {
            gameProgress = false;
        }
    }
}
