package bridge.controller;

import bridge.constant.ExceptionMessage;
import bridge.model.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GamePlayController {
    private final BridgeGame bridgeGame;
    private final int bridgeSize;

    private boolean gameProgress = true;
    private boolean isAllAnswer = false;
    private int gameTryCount = 0;

    public GamePlayController(BridgeGame bridgeGame, int bridgeSize) {
        this.bridgeGame = bridgeGame;
        this.bridgeSize = bridgeSize;
    }

    public void startGame() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult(bridgeSize);
        gameTryCount++;
        int moveIndex = 0;
        while (gameProgress && !isAllAnswer) {
            progressPlayerMove(moveIndex++, bridgeGameResult);
            isAllAnswer = bridgeGameResult.isGameSuccess();
        }
        showFinalResult(bridgeGameResult.getFinalResult(isAllAnswer, gameTryCount));
    }

    private void showCurrentResult(BridgeGameResult bridgeGameResult) {
        OutputView.getOutputView().printMap(bridgeGameResult.getCurrentResult());
    }

    private void progressPlayerMove(int moveIndex, BridgeGameResult bridgeGameResult) {
        boolean isPossibleMove = bridgeGame.move(moveIndex, inputPlayerMove(InputView.getInputView()), bridgeGameResult);
        showCurrentResult(bridgeGameResult);
        if (!isPossibleMove) {
            askReplay();
        }
    }

    private void askReplay() {
        String gameCommand = inputRetryCommand(InputView.getInputView());
        if (bridgeGame.retry(gameCommand)) {
            startGame();
            return;
        }
        gameProgress = false;
    }

    private void showFinalResult(StringBuffer result) {
        OutputView.getOutputView().printResult(result);
    }

    private String inputPlayerMove(InputView inputView) {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException exception) {
                OutputView.getOutputView().printErrorMessage(ExceptionMessage.MOVE.getMessage());
            }
        }
    }

    private String inputRetryCommand(InputView inputView) {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException exception) {
                OutputView.getOutputView().printErrorMessage(ExceptionMessage.RETRY_INPUT.getMessage());
            }
        }
    }
}