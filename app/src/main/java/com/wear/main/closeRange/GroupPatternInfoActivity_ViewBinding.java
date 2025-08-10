package com.wear.main.closeRange;

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
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.widget.control.NewCurveLineView;

/* loaded from: classes3.dex */
public class GroupPatternInfoActivity_ViewBinding implements Unbinder {
    public GroupPatternInfoActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GroupPatternInfoActivity a;

        public a(GroupPatternInfoActivity_ViewBinding groupPatternInfoActivity_ViewBinding, GroupPatternInfoActivity groupPatternInfoActivity) {
            this.a = groupPatternInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Throwable {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ GroupPatternInfoActivity a;

        public b(GroupPatternInfoActivity_ViewBinding groupPatternInfoActivity_ViewBinding, GroupPatternInfoActivity groupPatternInfoActivity) {
            this.a = groupPatternInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Throwable {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public GroupPatternInfoActivity_ViewBinding(GroupPatternInfoActivity groupPatternInfoActivity, View view) {
        this.a = groupPatternInfoActivity;
        groupPatternInfoActivity.ivUserImg = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'ivUserImg'", RoundedImageView.class);
        groupPatternInfoActivity.pattern_line = (NewCurveLineView) Utils.findRequiredViewAsType(view, R.id.pattern_line, "field 'pattern_line'", NewCurveLineView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_play, "field 'ivPlay' and method 'onViewClicked'");
        groupPatternInfoActivity.ivPlay = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_play, "field 'ivPlay'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, groupPatternInfoActivity));
        groupPatternInfoActivity.tvPlay = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_play, "field 'tvPlay'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_save, "field 'ivSave' and method 'onViewClicked'");
        groupPatternInfoActivity.ivSave = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_save, "field 'ivSave'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, groupPatternInfoActivity));
        groupPatternInfoActivity.tvSave = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_save, "field 'tvSave'", TextView.class);
        groupPatternInfoActivity.rvMemberAccept = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_member_accept, "field 'rvMemberAccept'", RecyclerView.class);
        groupPatternInfoActivity.tvPatternName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pattern_name, "field 'tvPatternName'", TextView.class);
        groupPatternInfoActivity.tvSaveMember = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_save_member, "field 'tvSaveMember'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GroupPatternInfoActivity groupPatternInfoActivity = this.a;
        if (groupPatternInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        groupPatternInfoActivity.ivUserImg = null;
        groupPatternInfoActivity.pattern_line = null;
        groupPatternInfoActivity.ivPlay = null;
        groupPatternInfoActivity.tvPlay = null;
        groupPatternInfoActivity.ivSave = null;
        groupPatternInfoActivity.tvSave = null;
        groupPatternInfoActivity.rvMemberAccept = null;
        groupPatternInfoActivity.tvPatternName = null;
        groupPatternInfoActivity.tvSaveMember = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
