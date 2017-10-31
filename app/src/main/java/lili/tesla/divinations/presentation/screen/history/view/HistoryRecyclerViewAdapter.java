package lili.tesla.divinations.presentation.screen.history.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import lili.tesla.divinations.R;
import lili.tesla.divinations.data.AuditItem;
import lili.tesla.divinations.presentation.screen.prediction.view.ItemClickListener;

/**
 * Created by Лилия on 30.10.2017.
 */

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.HistoryViewHolder> {

    private List<AuditItem> mAuditItemsList;
    private ItemClickListener itemClickListener;

    public HistoryRecyclerViewAdapter(List<AuditItem> auditItemList) {
        this.mAuditItemsList = auditItemList;
    }

    @Override
    public HistoryRecyclerViewAdapter.HistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item, viewGroup, false);
        return new HistoryViewHolder(view);
    }

    public void setOnItemClickListener(ItemClickListener onItemClickListener) {
        itemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(HistoryRecyclerViewAdapter.HistoryViewHolder holder, int position) {
        AuditItem auditItem = mAuditItemsList.get(position);

        holder.mCaptionTextView.setText(auditItem.getPredictionCaption());
        holder.mDateTextView.setText(auditItem.getDate());

        final int clickPos = position;
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.clicked(mAuditItemsList.get(clickPos).getPredictionIndex());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAuditItemsList.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {

        private TextView mCaptionTextView;
        private TextView mDateTextView;
        private LinearLayout mLinearLayout;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            mCaptionTextView = (TextView) itemView.findViewById(R.id.textview_item_caption);
            mDateTextView = (TextView) itemView.findViewById(R.id.textview_item_date);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout_recyclerView);
        }
    }
}
