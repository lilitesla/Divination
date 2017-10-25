package lili.tesla.divinations.presentation.screen.main.presenter;

import lili.tesla.divinations.presentation.screen.base.BasePresenter;
import lili.tesla.divinations.presentation.screen.main.view.MainView;

/**
 * Created by Лилия on 25.10.2017.
 */

public class MainPresenter extends BasePresenter<MainView>{

    public void startGameScreen() {
        mView.startGameScreen();
    }

    public void showHistoryScreen() {
        mView.showHistoryScreen();
    }
}
