package lili.tesla.divinations.presentation.screen.history.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lili.tesla.divinations.R;
import lili.tesla.divinations.data.AuditItem;

/**
 * Created by Лилия on 30.10.2017.
 */

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.HistoryViewHolder> {

    private List<AuditItem> mAuditItemsList;

    public HistoryRecyclerViewAdapter(List<AuditItem> auditItemList) {
        this.mAuditItemsList = auditItemList;
    }

    @Override
    public HistoryRecyclerViewAdapter.HistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item, viewGroup, false);
        return new HistoryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(HistoryRecyclerViewAdapter.HistoryViewHolder holder, int position) {
        AuditItem auditItem = mAuditItemsList.get(position);

        holder.mCaptionTextView.setText(auditItem.getPredictionCaption());
        holder.mDateTextView.setText(auditItem.getDate());

    }

    @Override
    public int getItemCount() {
        return mAuditItemsList.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {

        private TextView mCaptionTextView;
        private TextView mDateTextView;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            mCaptionTextView = (TextView) itemView.findViewById(R.id.textview_item_caption);
            mDateTextView = (TextView) itemView.findViewById(R.id.textview_item_date);
        }
    }
}
