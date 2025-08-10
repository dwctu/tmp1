package dc;

import com.wear.bean.PatternFilterToyBean;
import java.util.Comparator;

/* compiled from: PatternFilterToyCompare.java */
/* loaded from: classes3.dex */
public class s12 implements Comparator<PatternFilterToyBean> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(PatternFilterToyBean patternFilterToyBean, PatternFilterToyBean patternFilterToyBean2) {
        return patternFilterToyBean.getToyName().compareTo(patternFilterToyBean2.getToyName());
    }
}
