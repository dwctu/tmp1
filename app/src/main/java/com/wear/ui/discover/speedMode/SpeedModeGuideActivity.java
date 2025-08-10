package com.wear.ui.discover.speedMode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import com.wear.widget.iwatcher.ImageWatcher;
import com.wear.widget.llong.DSGuideViewpager;
import dc.gg3;
import dc.kg3;
import dc.ns3;
import dc.pj3;
import java.util.ArrayList;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class SpeedModeGuideActivity extends BaseActivity {

    @BindView(R.id.ac_main_dsguide_dsvp)
    public DSGuideViewpager dsGuideViewpager;

    @BindView(R.id.ac_main_dsguide_rl)
    public RelativeLayout rlDSGuide;

    @BindView(R.id.ac_main_dsguide_check)
    public TextView tvGuideCheck;

    @BindView(R.id.ac_main_guide_msg)
    public TextView tvGuideMsg;

    @BindView(R.id.ac_main_guide_title)
    public TextView tvGuideTitle;

    @BindView(R.id.v_image_watcher)
    public ImageWatcher vImageWatcher;

    public class a implements ImageWatcher.i {
        public a(SpeedModeGuideActivity speedModeGuideActivity) {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.i
        public void a(Context context, String str, ImageWatcher.g gVar) {
            if (WearUtils.e1(str)) {
                return;
            }
            gVar.b(BitmapFactory.decodeResource(context.getResources(), Integer.valueOf(str).intValue()));
        }
    }

    public class b implements DSGuideViewpager.b {
        public b() {
        }

        @Override // com.wear.widget.llong.DSGuideViewpager.b
        public void a(Integer num) throws Resources.NotFoundException {
            SpeedModeGuideActivity.this.u4();
        }
    }

    public class c implements ImageWatcher.h {
        public c(SpeedModeGuideActivity speedModeGuideActivity) {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.h
        public void a(int i) {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.h
        public void b(int i, GifImageView gifImageView, Object obj) {
        }
    }

    @OnClick({R.id.ac_main_dsguide_close, R.id.ac_main_dsguide_check})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_main_dsguide_check /* 2131361863 */:
            case R.id.ac_main_dsguide_close /* 2131361864 */:
                pj3.f(this, SpeedModeActivity.class);
                finish();
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.discover_speed_mode_guide_activity);
        ButterKnife.bind(this);
        t4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        kg3.b(this.activity, true);
    }

    public final void t4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.drawable.guide_speed_mode));
        this.dsGuideViewpager.setListImgs(arrayList);
        this.dsGuideViewpager.e(false);
        this.vImageWatcher.setTranslucentStatus(gg3.g(this));
        this.vImageWatcher.setErrorImageRes(R.drawable.avatar_default_fullview_fail);
        this.vImageWatcher.setLoader(new a(this));
        this.dsGuideViewpager.setiPageClickListener(new b());
    }

    public final void u4() throws Resources.NotFoundException {
        List<GifImageView> views = this.dsGuideViewpager.getViews();
        GifImageView gifImageView = views.get(this.dsGuideViewpager.getCurrentIndex());
        ArrayList arrayList = new ArrayList();
        for (GifImageView gifImageView2 : views) {
            gifImageView2.getLocationOnScreen(new int[2]);
            arrayList.add(new ns3(gifImageView2.getWidth(), gifImageView2.getHeight(), r2[0], r2[1]));
        }
        this.vImageWatcher.E(gifImageView, this.dsGuideViewpager.getViews(), this.dsGuideViewpager.getListImgUri(), arrayList, false, new c(this));
    }
}
