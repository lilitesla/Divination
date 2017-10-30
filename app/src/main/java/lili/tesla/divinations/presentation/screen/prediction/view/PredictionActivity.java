package lili.tesla.divinations.presentation.screen.prediction.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lili.tesla.divinations.R;
import lili.tesla.divinations.data.Prediction;
import lili.tesla.divinations.presentation.screen.base.BaseActivity;
import lili.tesla.divinations.presentation.screen.divination.view.DivinationActivity;
import lili.tesla.divinations.presentation.screen.main.view.MainActivity;
import lili.tesla.divinations.presentation.screen.prediction.presenter.PredictionPresenter;

public class PredictionActivity extends BaseActivity implements PredictionView {

    public static final String EXTRA_KEY_INDEX = "KEY_INDEX";
    PredictionPresenter mPresenter;
    private String mPredictionIndex;

    @BindView(R.id.textview_prediction_caption)
    TextView mTextViewPredictionCaption;

    @BindView(R.id.textview_prediction_slogan)
    TextView mTextViewPredictionSlogan;

    @BindView(R.id.textview_prediction_description)
    TextView mTextViewPredictionDescription;

    public static void start(Context context, String indexPrediction) {
        Intent intent = new Intent(context, PredictionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString( EXTRA_KEY_INDEX, indexPrediction);
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

        mPredictionIndex = getIntent().getStringExtra(EXTRA_KEY_INDEX);

        mPresenter.showPrediction(mPredictionIndex);
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

    @Override
    public void showPrediction(Prediction prediction) {
        mTextViewPredictionCaption.setText(prediction.getChina_caption() + ". " + prediction.getCaption());
        mTextViewPredictionSlogan.setText(prediction.getSlogan());
        mTextViewPredictionDescription.setText(prediction.getDescription());
    }



}
