package com.wear.main.longDistance;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SearchButton;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class CreateChatRoomActivity_ViewBinding implements Unbinder {
    public CreateChatRoomActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ CreateChatRoomActivity a;

        public a(CreateChatRoomActivity_ViewBinding createChatRoomActivity_ViewBinding, CreateChatRoomActivity createChatRoomActivity) {
            this.a = createChatRoomActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ CreateChatRoomActivity a;

        public b(CreateChatRoomActivity_ViewBinding createChatRoomActivity_ViewBinding, CreateChatRoomActivity createChatRoomActivity) {
            this.a = createChatRoomActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.a.onClick(view);
        }
    }

    @UiThread
    public CreateChatRoomActivity_ViewBinding(CreateChatRoomActivity createChatRoomActivity, View view) {
        this.a = createChatRoomActivity;
        createChatRoomActivity.abTitle = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.ab_title, "field 'abTitle'", MyActionBar.class);
        createChatRoomActivity.rvSelectFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_select_friend, "field 'rvSelectFriend'", RecyclerView.class);
        createChatRoomActivity.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
        createChatRoomActivity.llTop = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_top, "field 'llTop'", LinearLayout.class);
        createChatRoomActivity.sbSearch = (SearchButton) Utils.findRequiredViewAsType(view, R.id.sb_search, "field 'sbSearch'", SearchButton.class);
        createChatRoomActivity.ivAll = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_all, "field 'ivAll'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_all, "field 'llAll' and method 'onClick'");
        createChatRoomActivity.llAll = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.ll_all, "field 'llAll'", RelativeLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, createChatRoomActivity));
        createChatRoomActivity.tvCreate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_create, "field 'tvCreate'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_single_group_create, "field 'rl_single_group_create' and method 'onClick'");
        createChatRoomActivity.rl_single_group_create = (RelativeLayout) Utils.castView(viewFindRequiredView2, R.id.rl_single_group_create, "field 'rl_single_group_create'", RelativeLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, createChatRoomActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CreateChatRoomActivity createChatRoomActivity = this.a;
        if (createChatRoomActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        createChatRoomActivity.abTitle = null;
        createChatRoomActivity.rvSelectFriend = null;
        createChatRoomActivity.rvFriend = null;
        createChatRoomActivity.llTop = null;
        createChatRoomActivity.sbSearch = null;
        createChatRoomActivity.ivAll = null;
        createChatRoomActivity.llAll = null;
        createChatRoomActivity.tvCreate = null;
        createChatRoomActivity.rl_single_group_create = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
