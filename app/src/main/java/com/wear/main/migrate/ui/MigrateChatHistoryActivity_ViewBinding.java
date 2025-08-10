package com.wear.main.migrate.ui;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class MigrateChatHistoryActivity_ViewBinding implements Unbinder {
    public MigrateChatHistoryActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MigrateChatHistoryActivity a;

        public a(MigrateChatHistoryActivity_ViewBinding migrateChatHistoryActivity_ViewBinding, MigrateChatHistoryActivity migrateChatHistoryActivity) {
            this.a = migrateChatHistoryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public MigrateChatHistoryActivity_ViewBinding(MigrateChatHistoryActivity migrateChatHistoryActivity, View view) {
        this.a = migrateChatHistoryActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_chat_migrate, "method 'onViewClicked'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, migrateChatHistoryActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
