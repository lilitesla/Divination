package lili.tesla.divinations.presentation.screen.prediction.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.divinations.R;
import lili.tesla.divinations.presentation.screen.base.BaseActivity;
import lili.tesla.divinations.presentation.screen.divination.view.DivinationActivity;
import lili.tesla.divinations.presentation.screen.main.view.MainActivity;
import lili.tesla.divinations.presentation.screen.prediction.presenter.PredictionPresenter;

public class PredictionActivity extends BaseActivity implements PredictionView {

    PredictionPresenter mPresenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, PredictionActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        ButterKnife.bind(this);
        mPresenter = new PredictionPresenter();
        mPresenter.setView(this);
    }

    @OnClick(R.id.button_start_again)
    void startGameAgainClicked(View view){
        mPresenter.startGameScreenAgain();
    }

    @OnClick(R.id.button_back_to_main)
    void backToMainClicked(View view){
        mPresenter.backToMainScreen();
    }

    @Override
    public void startGameScreenAgain(){
        DivinationActivity.start(this);
    }

    @Override
    public void backToMainScreen() {
        MainActivity.start(this);
    }



}
