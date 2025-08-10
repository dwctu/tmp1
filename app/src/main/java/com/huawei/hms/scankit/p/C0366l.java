package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashSet;
import java.util.Set;

/* compiled from: CameraFocusManager.java */
/* renamed from: com.huawei.hms.scankit.p.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0366l implements Camera.AutoFocusCallback {
    private static final Set<String> a;

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add(TtmlNode.TEXT_EMPHASIS_AUTO);
        hashSet.add("macro");
    }

    public final synchronized void a() {
        throw null;
    }
}
