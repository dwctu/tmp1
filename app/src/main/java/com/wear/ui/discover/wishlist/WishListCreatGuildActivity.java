package com.wear.ui.discover.wishlist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import dc.me3;
import dc.pj3;
import dc.r13;
import dc.s13;
import dc.sg3;
import dc.ye3;

/* loaded from: classes3.dex */
public class WishListCreatGuildActivity extends BaseActivity<r13> implements s13 {
    public r13 a;

    @BindView(R.id.create_wish_list_btn)
    public Button create_btn;

    @BindView(R.id.nav_back)
    public ImageView navBack;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v4(View view) {
        this.a.j();
        ye3.d("M0006", "");
    }

    @Override // dc.s13
    public void B2(String str) {
        pj3.w(this, str);
        finish();
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.i(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_wishlist_guild_layout);
        me3.c(me3.c.WISH_LIST_UI_ENTER);
        ye3.c("wish list", "into page", null);
        ButterKnife.bind(this);
        this.navBack.setOnClickListener(new View.OnClickListener() { // from class: dc.h13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t4(view);
            }
        });
        this.create_btn.setOnClickListener(new View.OnClickListener() { // from class: dc.i13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v4(view);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.WISH_LIST_UI_EXIT);
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        super.showErrorMsg(str, z);
        sg3.l(str);
    }
}
