package com.wear.main.migrate.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ChatMigrateSelectActivity_ViewBinding implements Unbinder {
    public ChatMigrateSelectActivity a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigrateSelectActivity a;

        public a(ChatMigrateSelectActivity_ViewBinding chatMigrateSelectActivity_ViewBinding, ChatMigrateSelectActivity chatMigrateSelectActivity) {
            this.a = chatMigrateSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigrateSelectActivity a;

        public b(ChatMigrateSelectActivity_ViewBinding chatMigrateSelectActivity_ViewBinding, ChatMigrateSelectActivity chatMigrateSelectActivity) {
            this.a = chatMigrateSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigrateSelectActivity a;

        public c(ChatMigrateSelectActivity_ViewBinding chatMigrateSelectActivity_ViewBinding, ChatMigrateSelectActivity chatMigrateSelectActivity) {
            this.a = chatMigrateSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ChatMigrateSelectActivity_ViewBinding(ChatMigrateSelectActivity chatMigrateSelectActivity, View view) {
        this.a = chatMigrateSelectActivity;
        chatMigrateSelectActivity.myActionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'myActionBar'", MyActionBar.class);
        chatMigrateSelectActivity.recyclerViewUsers = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_select_rcv, "field 'recyclerViewUsers'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ac_migrate_select_iv_all, "field 'ivAll' and method 'onClick'");
        chatMigrateSelectActivity.ivAll = (ImageView) Utils.castView(viewFindRequiredView, R.id.ac_migrate_select_iv_all, "field 'ivAll'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatMigrateSelectActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ac_migrate_select_tv_next, "field 'tvNext' and method 'onClick'");
        chatMigrateSelectActivity.tvNext = (TextView) Utils.castView(viewFindRequiredView2, R.id.ac_migrate_select_tv_next, "field 'tvNext'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatMigrateSelectActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ac_migrate_select_tv_all, "method 'onClick'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, chatMigrateSelectActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMigrateSelectActivity chatMigrateSelectActivity = this.a;
        if (chatMigrateSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMigrateSelectActivity.myActionBar = null;
        chatMigrateSelectActivity.recyclerViewUsers = null;
        chatMigrateSelectActivity.ivAll = null;
        chatMigrateSelectActivity.tvNext = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
