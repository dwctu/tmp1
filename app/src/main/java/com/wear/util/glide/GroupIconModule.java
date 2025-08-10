package com.wear.util.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Registry;
import dc.jj3;
import dc.kf;
import dc.lf;
import dc.xn;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes4.dex */
public class GroupIconModule extends xn {
    @Override // dc.xn, dc.yn
    public void a(Context context, lf lfVar) {
    }

    @Override // dc.ao, dc.co
    public void b(@NonNull Context context, @NonNull kf kfVar, @NonNull Registry registry) {
        kfVar.l().d(List.class, InputStream.class, new jj3.a(context));
    }
}
