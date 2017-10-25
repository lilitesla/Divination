package lili.tesla.divinations.presentation.screen.divination.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.divinations.R;
import lili.tesla.divinations.presentation.screen.base.BaseActivity;
import lili.tesla.divinations.presentation.screen.divination.presenter.DivinationPresenter;
import lili.tesla.divinations.presentation.screen.prediction.view.PredictionActivity;

public class DivinationActivity extends BaseActivity implements DivinationView {

    DivinationPresenter mPresenter;

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
    }

    @OnClick(R.id.button_show_prediction)
    void showPredictionClicked(View view){
        mPresenter.showPredictionScreen();
    }

    @Override
    public void showPredictionScreen() {
        PredictionActivity.start(this);
    }
}
