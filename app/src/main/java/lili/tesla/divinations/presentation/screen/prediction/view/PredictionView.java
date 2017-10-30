package lili.tesla.divinations.presentation.screen.prediction.view;

import lili.tesla.divinations.data.Prediction;

/**
 * Created by Лилия on 25.10.2017.
 */

public interface PredictionView {
    void startGameScreenAgain();
    void backToMainScreen();
    void showPrediction(Prediction prediction);
}
