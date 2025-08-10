package dc;

import android.webkit.JavascriptInterface;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.bean.vb.PatternEditVideoInfo;
import com.wear.bean.vb.PatternEditVideoStatusBean;
import com.wear.bean.vb.VideoCancelMuteBean;
import com.wear.util.WearUtils;
import org.greenrobot.eventbus.EventBus;

/* compiled from: JsApi.java */
/* loaded from: classes4.dex */
public class al3 {
    @JavascriptInterface
    public void androidAdBarClick(Object obj, fj4<String> fj4Var) {
        ll3.E().e0("syncBar", "click", "ad", null, null);
    }

    @JavascriptInterface
    public void androidConnectToyClick(Object obj, fj4<String> fj4Var) {
        EventBus.getDefault().post(new qk3());
    }

    @JavascriptInterface
    public void androidMediaClickMedia(Object obj, fj4<String> fj4Var) {
        VideoCancelMuteBean videoCancelMuteBean;
        if (obj != null) {
            try {
                String strValueOf = String.valueOf(obj);
                if (WearUtils.e1(strValueOf) || (videoCancelMuteBean = (VideoCancelMuteBean) WearUtils.A.fromJson(strValueOf, VideoCancelMuteBean.class)) == null) {
                    return;
                }
                EventBus.getDefault().post(videoCancelMuteBean);
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("模拟点击取消视频静音：", e));
            }
        }
    }

    @JavascriptInterface
    public void androidSTMMediaInfo(Object obj, fj4<String> fj4Var) {
        PatternEditVideoInfo patternEditVideoInfo = null;
        if (obj != null) {
            try {
                String strValueOf = String.valueOf(obj);
                if (!WearUtils.e1(strValueOf)) {
                    String str = "androidSTMMediaInfo: " + strValueOf;
                    patternEditVideoInfo = (PatternEditVideoInfo) WearUtils.A.fromJson(strValueOf, PatternEditVideoInfo.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("获取视频信息：", e));
            }
        }
        if (patternEditVideoInfo == null) {
            patternEditVideoInfo = new PatternEditVideoInfo();
        }
        ll3.E().G(patternEditVideoInfo);
    }

    @JavascriptInterface
    public void androidSTMMediaStatus(Object obj, fj4<String> fj4Var) {
        PatternEditVideoStatusBean patternEditVideoStatusBean;
        if (obj != null) {
            try {
                String strValueOf = String.valueOf(obj);
                if (WearUtils.e1(strValueOf) || (patternEditVideoStatusBean = (PatternEditVideoStatusBean) WearUtils.A.fromJson(strValueOf, PatternEditVideoStatusBean.class)) == null) {
                    return;
                }
                ll3.E().p(patternEditVideoStatusBean);
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("监听视频播放状态：", e));
            }
        }
    }
}
