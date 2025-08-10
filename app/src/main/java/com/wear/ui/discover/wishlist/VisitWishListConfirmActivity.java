package com.wear.ui.discover.wishlist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ii;
import dc.kf;
import dc.pj3;
import dc.pl;
import dc.qo;
import dc.ye3;

/* loaded from: classes3.dex */
public class VisitWishListConfirmActivity extends BaseActivity {

    @BindView(R.id.continue_btn)
    public Button continueBtn;

    @BindView(R.id.nav_back)
    public ImageView navBack;

    @BindView(R.id.profile_icon_view)
    public ImageView profileView;

    @BindView(R.id.wishlist_name_view)
    public TextView wishListName;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v4(String str, View view) {
        pj3.w(this, str + (!WearUtils.v ? "?_utm_pro=2112141049" : "?_utm_pro=2201181285"));
        ye3.d("M0010", "");
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.visit_wishlist_confirm_activity);
        ButterKnife.bind(this);
        final String stringExtra = getIntent().getStringExtra(ImagesContract.URL);
        String stringExtra2 = getIntent().getStringExtra("wishlist_name");
        String stringExtra3 = getIntent().getStringExtra("image_url");
        this.navBack.setOnClickListener(new View.OnClickListener() { // from class: dc.f13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t4(view);
            }
        });
        this.wishListName.setText(String.format(ah4.e(R.string.wish_list_titile), stringExtra2));
        kf.x(this.profileView).v(stringExtra3).f(ii.e).X(R.drawable.default_avatar_wish_list).a(qo.p0(new pl())).A0(this.profileView);
        this.continueBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.g13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v4(stringExtra, view);
            }
        });
    }
}
