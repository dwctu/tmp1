package com.wear.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.bean.FaqResponeItems;
import com.wear.main.account.FAQActivity;
import java.util.List;

/* loaded from: classes3.dex */
public class FAQAdapter extends android.widget.BaseAdapter {
    public FAQActivity a;
    public LayoutInflater b;
    public int c = -1;

    public static class ViewHolder {

        @BindView(R.id.faq_answer)
        public TextView faqAnswer;

        @BindView(R.id.faq_answer_fg)
        public View faqAnswerFg;

        @BindView(R.id.faq_details_action)
        public LinearLayout faqDetailsAction;

        @BindView(R.id.faq_title)
        public TextView faqTitle;

        @BindView(R.id.iv_details_action)
        public ImageView iv_details_action;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.faqTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.faq_title, "field 'faqTitle'", TextView.class);
            viewHolder.faqDetailsAction = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.faq_details_action, "field 'faqDetailsAction'", LinearLayout.class);
            viewHolder.iv_details_action = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_details_action, "field 'iv_details_action'", ImageView.class);
            viewHolder.faqAnswer = (TextView) Utils.findRequiredViewAsType(view, R.id.faq_answer, "field 'faqAnswer'", TextView.class);
            viewHolder.faqAnswerFg = Utils.findRequiredView(view, R.id.faq_answer_fg, "field 'faqAnswerFg'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.faqTitle = null;
            viewHolder.faqDetailsAction = null;
            viewHolder.iv_details_action = null;
            viewHolder.faqAnswer = null;
            viewHolder.faqAnswerFg = null;
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a == FAQAdapter.this.c) {
                FAQAdapter.this.c = -1;
            } else {
                FAQAdapter.this.c = this.a;
            }
            FAQAdapter.this.notifyDataSetChanged();
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ ViewHolder a;
        public final /* synthetic */ FaqResponeItems b;
        public final /* synthetic */ int c;

        public b(ViewHolder viewHolder, FaqResponeItems faqResponeItems, int i) {
            this.a = viewHolder;
            this.b = faqResponeItems;
            this.c = i;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.faqAnswer.getViewTreeObserver().removeOnPreDrawListener(this);
            int lineCount = this.a.faqAnswer.getLineCount();
            this.b.setLineCount(lineCount);
            if (lineCount > 3) {
                this.a.faqDetailsAction.setVisibility(0);
                this.a.faqAnswerFg.setVisibility(0);
            } else {
                this.a.faqDetailsAction.setVisibility(4);
                this.a.faqAnswerFg.setVisibility(4);
            }
            if (this.c == FAQAdapter.this.c) {
                this.a.iv_details_action.setBackgroundResource(R.drawable.content_icon_faq_pullup);
                this.a.faqAnswerFg.setVisibility(4);
                this.a.faqAnswer.setEllipsize(null);
                this.a.faqAnswer.setLines(lineCount + 1);
            } else if (lineCount > 3) {
                this.a.faqAnswerFg.setVisibility(0);
                this.a.faqAnswer.setEllipsize(TextUtils.TruncateAt.END);
                this.a.faqAnswer.setLines(3);
            }
            return false;
        }
    }

    public class c implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ TextView a;

        public c(FAQAdapter fAQAdapter, TextView textView) {
            this.a = textView;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.a.getLineCount() >= 2) {
                this.a.setEllipsize(TextUtils.TruncateAt.END);
                this.a.setLines(2);
                return false;
            }
            this.a.setEllipsize(null);
            this.a.setLines(1);
            return false;
        }
    }

    public FAQAdapter(FAQActivity fAQActivity) {
        this.b = null;
        this.a = fAQActivity;
        this.b = LayoutInflater.from(fAQActivity);
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public FaqResponeItems getItem(int i) {
        return this.a.d.get(i);
    }

    public void d() {
        this.c = -1;
    }

    public final void e(TextView textView, String str) {
        textView.getViewTreeObserver().addOnPreDrawListener(new c(this, textView));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FaqResponeItems> list = this.a.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        FaqResponeItems item = getItem(i);
        if (view == null) {
            view = this.b.inflate(R.layout.faq_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.faqTitle.setText(item.getTitle());
        viewHolder.faqAnswer.setText(item.getContent());
        e(viewHolder.faqTitle, item.getTitle());
        viewHolder.faqDetailsAction.setOnClickListener(new a(i));
        viewHolder.faqDetailsAction.setVisibility(4);
        viewHolder.faqAnswerFg.setVisibility(4);
        if (item.getLineCount() == 0) {
            viewHolder.faqAnswer.setMaxLines(Integer.MAX_VALUE);
            viewHolder.faqAnswer.setMinLines(0);
            viewHolder.faqAnswer.getViewTreeObserver().addOnPreDrawListener(new b(viewHolder, item, i));
        } else {
            if (item.getLineCount() > 3) {
                viewHolder.faqDetailsAction.setVisibility(0);
                viewHolder.faqAnswerFg.setVisibility(0);
            } else {
                viewHolder.faqDetailsAction.setVisibility(4);
                viewHolder.faqAnswerFg.setVisibility(4);
            }
            if (i == this.c) {
                viewHolder.iv_details_action.setBackgroundResource(R.drawable.content_icon_faq_pullup);
                viewHolder.faqAnswerFg.setVisibility(4);
                viewHolder.faqAnswer.setEllipsize(null);
                viewHolder.faqAnswer.setLines(item.getLineCount());
            } else {
                viewHolder.iv_details_action.setBackgroundResource(R.drawable.content_icon_faq_dropdown);
                if (item.getLineCount() > 3) {
                    viewHolder.faqAnswerFg.setVisibility(0);
                    viewHolder.faqAnswer.setEllipsize(TextUtils.TruncateAt.END);
                    viewHolder.faqAnswer.setLines(3);
                }
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }
}
