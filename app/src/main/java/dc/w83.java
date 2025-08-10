package dc;

import android.net.Uri;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.util.MyApplication;

/* compiled from: GlideLoader.java */
/* loaded from: classes4.dex */
public class w83 implements l93 {
    private qo mOptions = new qo().c().m(tg.PREFER_RGB_565).X(R.drawable.pattern_like_loading).h(R.drawable.avatar_default_fullview_fail);
    private qo mPreOptions = new qo().h0(true).h(R.drawable.avatar_default_fullview_fail);

    @Override // dc.l93
    public void I(ImageView imageView, String str) {
        kf.w(imageView.getContext()).v(str).a(this.mPreOptions).A0(imageView);
    }

    @Override // dc.l93
    public void O(ImageView imageView, Uri uri) {
        kf.w(imageView.getContext()).r(uri).a(this.mOptions).A0(imageView);
    }

    @Override // dc.l93
    public void V() {
        kf.c(MyApplication.N()).b();
    }

    @Override // dc.l93
    public void y(ImageView imageView, String str) {
        kf.w(imageView.getContext()).v(str).a(this.mOptions).A0(imageView);
    }
}
