package lili.tesla.divinations.presentation.screen.divination.presenter;

import android.widget.Toast;

import java.util.Random;

import lili.tesla.divinations.presentation.screen.base.BasePresenter;
import lili.tesla.divinations.presentation.screen.divination.view.DivinationView;

/**
 * Created by Лилия on 25.10.2017.
 */

public class DivinationPresenter extends BasePresenter<DivinationView> {

    private String indexPrediction;
    private int tossCounts;
    private final Random random = new Random();

    public void showPredictionScreen(){
        mView.showPredictionScreen();
    }

    public void tossCoin(){
        tossCounts ++;

        int mRandomNum = random.nextInt(2) + 1;

        indexPrediction = indexPrediction + mRandomNum;
        mView.showLine(mRandomNum, tossCounts);

        if (tossCounts == 6) {
            mView.showButtonTossCount(false);
            mView.showButtonPredictionScreen(true);


        }
    }

    public void countsNull(){
        tossCounts = 0;
        indexPrediction = "";
        mView.showButtonTossCount(true);
        mView.showButtonPredictionScreen(false);

    }

    public String getPredictionIndex() {
        return indexPrediction;
    }


}
