package com.google.android.gms.dynamic;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes2.dex */
public final class zaa implements OnDelegateCreatedListener {
    public final /* synthetic */ DeferredLifecycleHelper zaa;

    public zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        this.zaa.zaa = lifecycleDelegate;
        Iterator it = this.zaa.zac.iterator();
        while (it.hasNext()) {
            ((zah) it.next()).zab(this.zaa.zaa);
        }
        this.zaa.zac.clear();
        this.zaa.zab = null;
    }
}
