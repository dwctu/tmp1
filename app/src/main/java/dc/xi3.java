package dc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import java.io.File;
import java.util.ArrayList;

/* compiled from: Mp4Movie.java */
@TargetApi(16)
/* loaded from: classes4.dex */
public class xi3 {
    public h51 a = h51.j;
    public ArrayList<bj3> b = new ArrayList<>();
    public File c;

    public void a(int i, long j, MediaCodec.BufferInfo bufferInfo) throws Exception {
        if (i < 0 || i >= this.b.size()) {
            return;
        }
        this.b.get(i).a(j, bufferInfo);
    }

    public int b(MediaFormat mediaFormat, boolean z) throws Exception {
        this.b.add(new bj3(this.b.size(), mediaFormat, z));
        return this.b.size() - 1;
    }

    public File c() {
        return this.c;
    }

    public h51 d() {
        return this.a;
    }

    public ArrayList<bj3> e() {
        return this.b;
    }

    public void f(File file) {
        this.c = file;
    }

    public void g(int i) {
        if (i == 0) {
            this.a = h51.j;
            return;
        }
        if (i == 90) {
            this.a = h51.k;
        } else if (i == 180) {
            this.a = h51.l;
        } else if (i == 270) {
            this.a = h51.m;
        }
    }

    public void h(int i, int i2) {
    }
}
