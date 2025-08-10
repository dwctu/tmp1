package dc;

import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: AutoAttr.java */
/* loaded from: classes4.dex */
public abstract class ev3 {
    public int a;
    public int b;
    public int c;

    public ev3(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public void a(View view) {
        int iG;
        boolean z = view.getTag() != null && view.getTag().toString().equals(TtmlNode.TEXT_EMPHASIS_AUTO);
        if (z) {
            aw3.a(" pxVal = " + this.a + " ," + getClass().getSimpleName());
        }
        if (i()) {
            iG = e() ? h() : g();
            if (z) {
                aw3.a(" useDefault val= " + iG);
            }
        } else if (c()) {
            iG = h();
            if (z) {
                aw3.a(" baseWidth val= " + iG);
            }
        } else {
            iG = g();
            if (z) {
                aw3.a(" baseHeight val= " + iG);
            }
        }
        if (iG > 0) {
            iG = Math.max(iG, 1);
        }
        f(view, iG);
    }

    public abstract int b();

    public boolean c() {
        return d(this.b, b());
    }

    public boolean d(int i, int i2) {
        return (i & i2) != 0;
    }

    public abstract boolean e();

    public abstract void f(View view, int i);

    public int g() {
        return yv3.g(this.a);
    }

    public int h() {
        return yv3.h(this.a);
    }

    public boolean i() {
        return (d(this.c, b()) || d(this.b, b())) ? false : true;
    }

    public String toString() {
        return "AutoAttr{pxVal=" + this.a + ", baseWidth=" + c() + ", defaultBaseWidth=" + e() + MessageFormatter.DELIM_STOP;
    }
}
