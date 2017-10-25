package lili.tesla.divinations.presentation.screen.main.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import lili.tesla.divinations.R;
import butterknife.ButterKnife;
import lili.tesla.divinations.presentation.screen.base.BaseActivity;
import lili.tesla.divinations.presentation.screen.divination.view.DivinationActivity;
import lili.tesla.divinations.presentation.screen.history.view.HistoryActivity;
import lili.tesla.divinations.presentation.screen.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mPresenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mPresenter = new MainPresenter();
        mPresenter.setView(this);
    }

    @OnClick(R.id.button_start)
    void startGameClicked(View view) {
        mPresenter.startGameScreen();
    }

    @OnClick(R.id.button_history)
    void showHistoryClicked(View view) {
        mPresenter.showHistoryScreen();
    }

    @Override
    public void startGameScreen(){
        DivinationActivity.start(this);
    }

    @Override
    public void showHistoryScreen() {
       HistoryActivity.start(this);
    }


}
