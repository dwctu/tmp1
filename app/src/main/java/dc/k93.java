package dc;

import com.wear.protocol.CommunMessage;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DataUtil.java */
/* loaded from: classes4.dex */
public class k93 {
    public static volatile k93 c;
    public List<MediaFile> a;
    public List<CommunMessage> b;

    public k93() {
        new ArrayList();
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public static k93 a() {
        if (c == null) {
            synchronized (k93.class) {
                if (c == null) {
                    c = new k93();
                }
            }
        }
        return c;
    }

    public List<CommunMessage> b() {
        return this.b;
    }

    public List<MediaFile> c() {
        return this.a;
    }

    public void d(List<CommunMessage> list) {
        this.b.clear();
        this.b.addAll(list);
    }

    public void e(List<MediaFile> list) {
        this.a = list;
    }
}
