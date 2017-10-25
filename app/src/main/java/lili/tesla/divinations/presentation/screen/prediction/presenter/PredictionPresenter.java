package lili.tesla.divinations.presentation.screen.prediction.presenter;

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

}
