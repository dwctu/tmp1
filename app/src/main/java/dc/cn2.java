package dc;

import com.google.gson.Gson;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHiddenShowSuccBean;
import com.wear.bean.PatternsHiddenBean;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* compiled from: PatternsHiddenPresenterImpl.java */
/* loaded from: classes3.dex */
public class cn2 extends tl2<jp2, Object> implements wn2<Object> {
    public bn2 c;

    public cn2(bn2 bn2Var) {
        this.c = bn2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        if (obj instanceof PatternsHiddenBean) {
            ArrayList arrayList = new ArrayList();
            List<Map> data = ((PatternsHiddenBean) obj).getData();
            if (data != null && !data.isEmpty()) {
                for (Map map : data) {
                    Gson gson = WearUtils.A;
                    Pattern pattern = (Pattern) gson.fromJson(gson.toJson(map), Pattern.class);
                    String str = (String) map.get("isAnony");
                    pattern.setCreated(new Date(((Double) map.get("createdTime")).longValue()));
                    if (pattern.getName() != null) {
                        pattern.setName(WearUtils.u(pattern.getName()));
                    }
                    if ("1".equals(str)) {
                        pattern.setAnony(true);
                        pattern.setAuthor(null);
                    }
                    arrayList.add(pattern);
                }
            }
            if (g()) {
                ((jp2) this.b.get()).P3(z, arrayList);
            }
        }
        if (obj instanceof PatternHiddenShowSuccBean) {
            PatternHiddenShowSuccBean patternHiddenShowSuccBean = (PatternHiddenShowSuccBean) obj;
            if (g()) {
                ((jp2) this.b.get()).L2(z, patternHiddenShowSuccBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }

    public void i(boolean z, Map<String, Object> map, String str) {
        this.a = this.c.b(z, map, this, str);
    }
}
