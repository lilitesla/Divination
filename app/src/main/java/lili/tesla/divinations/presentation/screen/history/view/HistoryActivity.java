package lili.tesla.divinations.presentation.screen.history.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import lili.tesla.divinations.presentation.application.App;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import lili.tesla.divinations.R;
import lili.tesla.divinations.data.AuditItem;
import lili.tesla.divinations.presentation.screen.base.BaseActivity;
import lili.tesla.divinations.presentation.screen.history.presenter.HistoryPresenter;
import lili.tesla.divinations.presentation.screen.prediction.view.ItemClickListener;
import lili.tesla.divinations.presentation.screen.prediction.view.PredictionActivity;

public class HistoryActivity extends BaseActivity implements HistoryView {

    private HistoryPresenter mPresenter;
    private Context context;

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
        context = this;
        ButterKnife.bind(this);
        mPresenter = new HistoryPresenter();
        mPresenter.setView(this);

        List<AuditItem> auditList = new ArrayList<>();

        auditList = App.databaseAccess.getAuditItems();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        HistoryRecyclerViewAdapter adapter = new HistoryRecyclerViewAdapter(auditList);
        adapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void clicked(String index) {
                PredictionActivity.start(context, index);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true); // необязательно
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // необязательно
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(itemAnimator);



    }


}
