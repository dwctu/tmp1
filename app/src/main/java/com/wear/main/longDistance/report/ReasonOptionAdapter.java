package com.wear.main.longDistance.report;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.pj3;

/* loaded from: classes3.dex */
public class ReasonOptionAdapter extends RecyclerView.Adapter<ReasonOptionHolder> {
    public String[] a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public static class ReasonOptionHolder extends RecyclerView.ViewHolder {
        public View a;
        public TextView b;
        public ImageView c;

        public ReasonOptionHolder(@NonNull View view) {
            super(view);
            this.a = view;
            this.b = (TextView) view.findViewById(R.id.text_view);
            this.c = (ImageView) view.findViewById(R.id.item_line);
        }
    }

    public ReasonOptionAdapter(@NonNull Context context, String str, String str2, String str3, String str4, String str5) {
        if ((TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) && !WearUtils.e1(str5)) {
            this.a = context.getResources().getStringArray(R.array.report_reason_option);
        } else {
            this.a = context.getResources().getStringArray(R.array.report_reason_option_no_img);
        }
        this.b = str2;
        this.c = str;
        this.d = str3;
        this.e = str4;
        this.f = str5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(int i, ReasonOptionHolder reasonOptionHolder, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("user_id", this.c);
        bundle.putString(FirebaseAnalytics.Param.GROUP_ID, this.b);
        bundle.putString("group_name", this.d);
        bundle.putString("group_owner", this.e);
        String[] strArr = this.a;
        if (i == strArr.length - 1) {
            pj3.g(reasonOptionHolder.a.getContext(), OtherReason.class, bundle);
            return;
        }
        String[] strArr2 = {"t1", "t2", "t3", "t5", "t4"};
        if (strArr.length == 4) {
            strArr2 = new String[]{"t1", "t2", "t3", "t4"};
        }
        String str = strArr2[i];
        String str2 = "举报的reason==" + str;
        bundle.putString("reason_key", str);
        if (i == 3) {
            bundle.putString("user_img", this.f);
        }
        pj3.g(reasonOptionHolder.a.getContext(), ReportActivity.class, bundle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull final ReasonOptionHolder reasonOptionHolder, final int i) {
        reasonOptionHolder.b.setText(this.a[i]);
        reasonOptionHolder.a.setOnClickListener(new View.OnClickListener() { // from class: dc.jc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.m(i, reasonOptionHolder, view);
            }
        });
        reasonOptionHolder.c.setVisibility(i != this.a.length + (-1) ? 0 : 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public ReasonOptionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ReasonOptionHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.report_reason_option_items, viewGroup, false));
    }
}
