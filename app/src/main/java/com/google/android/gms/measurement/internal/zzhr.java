package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzhr implements zzlg {
    public final /* synthetic */ zzid zza;

    public zzhr(zzid zzidVar) {
        this.zza = zzidVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlg
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzD(TtmlNode.TEXT_EMPHASIS_AUTO, "_err", bundle);
        } else {
            this.zza.zzF(TtmlNode.TEXT_EMPHASIS_AUTO, "_err", bundle, str);
        }
    }
}
