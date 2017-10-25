package lili.tesla.divinations.presentation.screen.divination.presenter;

import lili.tesla.divinations.presentation.screen.base.BasePresenter;
import lili.tesla.divinations.presentation.screen.divination.view.DivinationView;

/**
 * Created by Лилия on 25.10.2017.
 */

public class DivinationPresenter extends BasePresenter<DivinationView> {

    public void showPredictionScreen(){
        mView.showPredictionScreen();
    }
}
