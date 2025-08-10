package com.wear.main.migrate.ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class ChatMigratePtoActivity_ViewBinding implements Unbinder {
    public ChatMigratePtoActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigratePtoActivity a;

        public a(ChatMigratePtoActivity_ViewBinding chatMigratePtoActivity_ViewBinding, ChatMigratePtoActivity chatMigratePtoActivity) {
            this.a = chatMigratePtoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigratePtoActivity a;

        public b(ChatMigratePtoActivity_ViewBinding chatMigratePtoActivity_ViewBinding, ChatMigratePtoActivity chatMigratePtoActivity) {
            this.a = chatMigratePtoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ChatMigratePtoActivity_ViewBinding(ChatMigratePtoActivity chatMigratePtoActivity, View view) {
        this.a = chatMigratePtoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ac_migrate_receive_tv_entire, "field 'tvEntire' and method 'onClick'");
        chatMigratePtoActivity.tvEntire = (TextView) Utils.castView(viewFindRequiredView, R.id.ac_migrate_receive_tv_entire, "field 'tvEntire'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatMigratePtoActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ac_migrate_receive_tv_partical, "field 'tvPartical' and method 'onClick'");
        chatMigratePtoActivity.tvPartical = (TextView) Utils.castView(viewFindRequiredView2, R.id.ac_migrate_receive_tv_partical, "field 'tvPartical'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatMigratePtoActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMigratePtoActivity chatMigratePtoActivity = this.a;
        if (chatMigratePtoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMigratePtoActivity.tvEntire = null;
        chatMigratePtoActivity.tvPartical = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
