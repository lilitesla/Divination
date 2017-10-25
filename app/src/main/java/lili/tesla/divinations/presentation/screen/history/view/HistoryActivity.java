package lili.tesla.divinations.presentation.screen.history.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.ButterKnife;
import lili.tesla.divinations.R;
import lili.tesla.divinations.presentation.screen.base.BaseActivity;
import lili.tesla.divinations.presentation.screen.history.presenter.HistoryPresenter;

public class HistoryActivity extends BaseActivity implements HistoryView {

    private HistoryPresenter mPresenter;

    public static void start(Context context) {
        Intent intent = new Intent(context, HistoryActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        mPresenter = new HistoryPresenter();
        mPresenter.setView(this);
    }
}
