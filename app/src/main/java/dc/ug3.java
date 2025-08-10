package dc;

import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import dc.nf3;
import java.io.IOException;
import java.util.List;

/* compiled from: TestUtil.java */
/* loaded from: classes4.dex */
public class ug3 {

    /* compiled from: TestUtil.java */
    public class a implements Runnable {
        public final /* synthetic */ List a;

        /* compiled from: TestUtil.java */
        /* renamed from: dc.ug3$a$a, reason: collision with other inner class name */
        public class C0222a implements nf3.d {
            public final /* synthetic */ String a;
            public final /* synthetic */ Pattern b;

            public C0222a(a aVar, String str, Pattern pattern) {
                this.a = str;
                this.b = pattern;
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) throws IOException {
                if (WearUtils.e1(str) || str.contains("result")) {
                    return;
                }
                if (rf3.o(str)) {
                    str = rf3.r(str);
                }
                WearUtils.m2(str, this.a);
                Pattern pattern = new Pattern(this.a);
                pattern.setName(this.b.getName());
                pattern.setData(str);
                pattern.setCreator(this.b.getEmail());
                pattern.setEmail(WearUtils.y.r());
                pattern.setAuthor(this.b.getAuthor());
                pattern.setTimer(this.b.getTimer());
                pattern.setToyFunc(this.b.getToyTag());
                if (pattern.getHead() != null && !WearUtils.e1(pattern.getHead().getToys()) && pattern.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                    pattern.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
                }
                pattern.setStatus(Pattern.DOWNLOAD);
                xe2.L0().t(pattern, false);
                xe3.a(xe2.r, "添加成功" + this.a);
            }
        }

        public a(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Pattern pattern : this.a) {
                if (!xe2.L0().O(ch3.n().r(), pattern.getId())) {
                    String id = pattern.getId();
                    if (WearUtils.x0(pattern.getId()).exists()) {
                        Pattern pattern2 = new Pattern(id);
                        pattern2.setName(pattern.getName());
                        pattern2.setCreator(pattern.getEmail());
                        pattern2.setEmail(WearUtils.y.r());
                        pattern2.setAuthor(pattern.getAuthor());
                        pattern2.setTimer(pattern.getTimer());
                        pattern2.setToyFunc(pattern.getToyTag());
                        pattern2.setStatus(Pattern.DOWNLOAD);
                        xe2.L0().t(pattern2, false);
                        xe3.a(xe2.r, "添加成功" + id);
                    } else {
                        nf3.b(pattern.getCdnPath(), new C0222a(this, id, pattern));
                    }
                }
            }
        }
    }

    public static void a(List<Pattern> list) {
        xe3.a(xe2.r, "测试批量添加:" + list.size());
        vg3.b().a(new a(list));
    }
}
