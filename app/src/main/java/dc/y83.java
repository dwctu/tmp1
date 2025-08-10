package dc;

import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import java.util.ArrayList;

/* compiled from: MediaFolder.java */
/* loaded from: classes4.dex */
public class y83 {
    public String a;
    public String b;
    public long c;
    public ArrayList<MediaFile> d;

    public y83(int i, String str, String str2, long j, ArrayList<MediaFile> arrayList) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = arrayList;
    }

    public String a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public ArrayList<MediaFile> d() {
        return this.d;
    }

    public void e(ArrayList<MediaFile> arrayList) {
        this.d = arrayList;
    }
}
