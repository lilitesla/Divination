package lili.tesla.divinations.presentation.screen.divination.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.divinations.R;
import lili.tesla.divinations.presentation.screen.base.BaseActivity;
import lili.tesla.divinations.presentation.screen.divination.presenter.DivinationPresenter;
import lili.tesla.divinations.presentation.screen.prediction.view.PredictionActivity;

public class DivinationActivity extends BaseActivity implements DivinationView {

    DivinationPresenter mPresenter;

    @BindView(R.id.button_show_prediction) Button mButtonShowPrediction;
    @BindView(R.id.button_toss_a_coin) Button mButtonTossCoin;


    public static void start(Context context) {
        Intent intent = new Intent(context, DivinationActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divination);

        ButterKnife.bind(this);
        mPresenter = new DivinationPresenter();
        mPresenter.setView(this);

        mPresenter.countsNull();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.countsNull();
    }

    @OnClick(R.id.button_show_prediction)
    void showPredictionClicked(View view){
        mPresenter.showPredictionScreen();
    }

    @OnClick(R.id.button_toss_a_coin)
    void tossCoinClicked(View view) {mPresenter.tossCoin();}

    @Override
    public void showPredictionScreen() {
        PredictionActivity.start(this, mPresenter.getPredictionIndex());

    }

    @Override
    public void showButtonTossCount(boolean flag) {
        if (flag) {
            mButtonTossCoin.setVisibility(View.VISIBLE);
        } else {
            mButtonTossCoin.setVisibility(View.GONE);
        }
    }

    @Override
    public void showButtonPredictionScreen(boolean flag) {
        if (flag) {
            mButtonShowPrediction.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Индекс: " + mPresenter.getPredictionIndex(), Toast.LENGTH_SHORT).show();
        } else {
            mButtonShowPrediction.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLine(int randomNum, int orderNum) {
        Toast.makeText(this, "Получили " + orderNum + " число: " + randomNum, Toast.LENGTH_SHORT).show();
        // TODO: 30.10.2017 show line
    }


}
