package lili.tesla.divinations.presentation.screen.prediction.presenter;

import lili.tesla.divinations.data.Prediction;
import lili.tesla.divinations.data.database.DatabaseAccess;
import lili.tesla.divinations.presentation.application.App;
import lili.tesla.divinations.presentation.screen.base.BasePresenter;
import lili.tesla.divinations.presentation.screen.prediction.view.PredictionView;

/**
 * Created by Лилия on 25.10.2017.
 */

public class PredictionPresenter extends BasePresenter<PredictionView> {

    public void startGameScreenAgain(){
        mView.startGameScreenAgain();
    }

    public void backToMainScreen(){
        mView.backToMainScreen();
    }

    public void showPrediction(String predictionIndex) {

        String[] str = new String[1];
        str[0] = predictionIndex;
        Prediction prediction = App.databaseAccess.getPrediction(str);

        mView.showPrediction(prediction);
    }

}
