package dc;

import androidx.annotation.NonNull;
import dc.mj;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* loaded from: classes.dex */
public class di<DataType> implements mj.b {
    public final vg<DataType> a;
    public final DataType b;
    public final ah c;

    public di(vg<DataType> vgVar, DataType datatype, ah ahVar) {
        this.a = vgVar;
        this.b = datatype;
        this.c = ahVar;
    }

    @Override // dc.mj.b
    public boolean a(@NonNull File file) {
        return this.a.a(this.b, file, this.c);
    }
}
