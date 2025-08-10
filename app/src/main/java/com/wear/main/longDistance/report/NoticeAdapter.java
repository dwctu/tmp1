package com.wear.main.longDistance.report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class NoticeAdapter extends RecyclerView.Adapter<NoticeViewHolder> {
    public String[] a;

    public static class NoticeViewHolder extends RecyclerView.ViewHolder {
        public TextView a;

        public NoticeViewHolder(@NonNull View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.text);
        }
    }

    public NoticeAdapter(Context context, int i) {
        this.a = context.getResources().getStringArray(i == 1 ? R.array.report_group_notice_content : R.array.report_notice_content);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull NoticeViewHolder noticeViewHolder, int i) {
        noticeViewHolder.a.setText(this.a[i]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NoticeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notice_item_text, viewGroup, false));
    }
}
