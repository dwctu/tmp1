package dc;

import java.io.Serializable;

/* compiled from: PhotoModel.java */
/* loaded from: classes4.dex */
public class rj3 implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean isChecked;
    private String originalPath;

    public rj3(String str) {
        this.originalPath = str;
    }

    public String a() {
        return this.originalPath;
    }

    public boolean b() {
        return this.isChecked;
    }

    public void c(String str) {
        this.originalPath = str;
    }

    public rj3() {
    }
}
