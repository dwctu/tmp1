package dc;

import com.google.gson.Gson;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHiddenSuccBean;
import com.wear.bean.PatternHiddenSuccDataBean;
import com.wear.bean.PatternSearchBean;
import com.wear.bean.PatternUserBean;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* compiled from: PatternSearchPresenterImpl.java */
/* loaded from: classes3.dex */
public class an2 extends tl2<hp2, Object> implements wn2<Object> {
    public zm2 c;

    public an2(zm2 zm2Var) {
        this.c = zm2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        super.a(z, obj);
        if (obj instanceof PatternUserBean) {
            f().N3(z, ((PatternUserBean) obj).getData());
        }
        if (obj instanceof PatternSearchBean) {
            ArrayList arrayList = new ArrayList();
            List<Map> data = ((PatternSearchBean) obj).getData();
            if (data != null && !data.isEmpty()) {
                for (Map map : data) {
                    Gson gson = WearUtils.A;
                    Pattern pattern = (Pattern) gson.fromJson(gson.toJson(map), Pattern.class);
                    long jLongValue = ((Double) map.get("createdTime")).longValue();
                    String str = (String) map.get("isAnony");
                    pattern.setCreated(new Date(jLongValue));
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
            f().B0(z, arrayList);
            f().o1(z, arrayList);
        }
        if (obj instanceof PatternHiddenSuccBean) {
            Gson gson2 = WearUtils.A;
            PatternHiddenSuccDataBean patternHiddenSuccDataBean = (PatternHiddenSuccDataBean) gson2.fromJson(gson2.toJson(((PatternHiddenSuccBean) obj).getData()), PatternHiddenSuccDataBean.class);
            if (g()) {
                ((hp2) this.b.get()).k3(z, patternHiddenSuccDataBean);
            }
        }
    }

    public void h(boolean z, Map<String, Object> map) {
        this.a = this.c.a(z, map, this);
    }

    public void i(boolean z, Map<String, Object> map) {
        this.a = this.c.b(z, map, this);
    }

    public void j(boolean z, Map<String, Object> map) {
        this.a = this.c.c(z, map, this);
    }

    public void k(boolean z, Map<String, Object> map) {
        this.a = this.c.d(z, map, this);
    }
}
