package lili.tesla.divinations.presentation.screen.main.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import lili.tesla.divinations.R;
import butterknife.ButterKnife;
import lili.tesla.divinations.presentation.screen.base.BaseActivity;
import lili.tesla.divinations.presentation.screen.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mPresenter = new MainPresenter();
    }

    @OnClick(R.id.button_start)
    void startGameClicked(View view) {
        mPresenter.startGameScreen();
    }

    @OnClick(R.id.button_history)
    void showHistoryClicked(View view) {
        mPresenter.showHistory();
    }

    @Override
    public void startGameScreen(){
        Toast.makeText(this, "startGameScreen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showHistory() {
       Toast.makeText(this, "showHistoryScreen", Toast.LENGTH_SHORT).show();
    }


}
