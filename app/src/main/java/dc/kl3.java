package dc;

import com.wear.bean.vb.PatternEditVideoInfo;
import com.wear.bean.vb.PatternEditVideoStatusBean;
import com.wear.util.WearUtils;
import java.util.HashMap;

/* compiled from: PatternCreateController.java */
/* loaded from: classes4.dex */
public abstract class kl3 {
    public HashMap<String, PatternEditVideoInfo> a;
    public String b;

    public void p(PatternEditVideoStatusBean patternEditVideoStatusBean) {
        if (WearUtils.e1(patternEditVideoStatusBean.getWebPageId())) {
            return;
        }
        q(patternEditVideoStatusBean);
        r(patternEditVideoStatusBean, this.b);
    }

    public abstract void q(PatternEditVideoStatusBean patternEditVideoStatusBean);

    public final void r(PatternEditVideoStatusBean patternEditVideoStatusBean, String str) {
        PatternEditVideoInfo patternEditVideoInfo = this.a.get(str);
        if (patternEditVideoInfo == null) {
            patternEditVideoInfo = new PatternEditVideoInfo();
            patternEditVideoInfo.setUrl(str);
        }
        patternEditVideoInfo.setPlaying(patternEditVideoStatusBean.getVideoStatus() == 1);
        patternEditVideoInfo.setCurrentTime(patternEditVideoStatusBean.getCurrentTime());
        if (patternEditVideoStatusBean.getDuration() != 0) {
            patternEditVideoInfo.setDuration(patternEditVideoStatusBean.getDuration());
        }
        patternEditVideoInfo.setPlaybackRate(patternEditVideoStatusBean.getPlaybackRate());
        this.a.put(str, patternEditVideoInfo);
    }
}
