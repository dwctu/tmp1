package com.wear.ui.me;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.net.MailTo;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class BirthDayConditionsAdapter extends RecyclerView.Adapter<b> {
    public String[] a;
    public Context b;

    public class a extends ClickableSpan {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent;
            if (BirthDayConditionsAdapter.this.n()) {
                intent = new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME + this.a));
            } else {
                intent = new Intent("android.intent.action.VIEW", Uri.parse("https://mail.google.com/mail/u/0/?view=cm&fs=1&tf=1&to=" + this.a));
            }
            BirthDayConditionsAdapter.this.b.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(true);
        }
    }

    public static class b extends RecyclerView.ViewHolder {
        public View a;

        public b(@NonNull View view) {
            super(view);
            this.a = view;
        }
    }

    public BirthDayConditionsAdapter(String[] strArr) {
        this.a = strArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.length;
    }

    public final boolean n() {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
        return this.b.getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        TextView textView = (TextView) bVar.a.findViewById(R.id.text_view);
        String str = this.a[i];
        if (!str.contains("#1#") || i != 4) {
            textView.setText(str);
            return;
        }
        int iIndexOf = str.indexOf("#1#");
        String string = this.b.getString(R.string.contact_email);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str.replace("#1#", string));
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(new a(string), iIndexOf, string.length() + iIndexOf, 33);
        }
        textView.setMovementMethod(new LinkMovementMethod());
        textView.setText(spannableStringBuilder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.b = recyclerView.getContext();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.birthday_conditions_text_items, viewGroup, false));
    }
}
