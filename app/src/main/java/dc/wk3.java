package dc;

import android.webkit.JavascriptInterface;
import com.wear.bean.vb.JsPatternUrlBean;
import com.wear.util.WearUtils;
import org.greenrobot.eventbus.EventBus;

/* compiled from: InJavaScriptLocalObj.java */
/* loaded from: classes4.dex */
public class wk3 {
    public final dl3 a;

    public wk3(dl3 dl3Var) {
        this.a = dl3Var;
    }

    @JavascriptInterface
    public void androidGetCurUrlAllMediaIds(String str) {
        String str2 = "" + str;
    }

    @JavascriptInterface
    public void getMediaPatternCallback(String str) {
        String str2 = "getMediaPatternCallback result:" + str;
        if (WearUtils.e1(str)) {
            return;
        }
        JsPatternUrlBean jsPatternUrlBean = (JsPatternUrlBean) WearUtils.A.fromJson(str, JsPatternUrlBean.class);
        if (jsPatternUrlBean == null) {
            jsPatternUrlBean = new JsPatternUrlBean(Boolean.FALSE, "");
        }
        EventBus.getDefault().post(jsPatternUrlBean);
    }

    @JavascriptInterface
    public void mediaStatus(String str) {
        dl3 dl3Var = this.a;
        if (dl3Var != null) {
            dl3Var.K1(str);
        }
    }
}
