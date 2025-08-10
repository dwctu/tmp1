package com.component.firebase;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.component.firebase.listener.IDXABTestProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sun.jna.Callback;
import dc.pd;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DXABTestApi.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tH\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\b\u0010\f\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011J$\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tH\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/component/firebase/DXABTestApi;", "", "()V", "abTestProvider", "Lcom/component/firebase/listener/IDXABTestProvider;", "getCurABTestContent", "Ljava/util/HashMap;", "", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfigValue;", "Lkotlin/collections/HashMap;", "getCurABTestValue", "key", "getFirebaseDeviceToken", "", Callback.METHOD_NAME, "Lcom/component/firebase/listener/DXFirebaseDeviceTokenCallback;", "getFirebaseInstallId", "Lcom/component/firebase/listener/DXFirebaseInstallIdCallback;", "getPreABTestContent", "getPreABTestValue", "init", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/firebase/listener/DXABTestListener;", "setConfig", "config", "Lcom/component/firebase/bean/DXFirebaseConfigBean;", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DXABTestApi {

    @NotNull
    public static final DXABTestApi a;

    @Autowired
    @JvmField
    @Nullable
    public static IDXABTestProvider abTestProvider;

    static {
        DXABTestApi dXABTestApi = new DXABTestApi();
        a = dXABTestApi;
        pd.c().e(dXABTestApi);
    }
}
