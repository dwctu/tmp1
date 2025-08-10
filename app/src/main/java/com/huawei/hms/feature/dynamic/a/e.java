package com.huawei.hms.feature.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class e implements DynamicModule.VersionPolicy {
    private static final String a = "e";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        if (remoteModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.j) > 0) {
            Logger.i(a, "Prefer remote: The version of remote module " + str + SignatureImpl.INNER_SEP + remoteModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.j));
            return remoteModuleInfo;
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        if (localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.k) <= 0) {
            Logger.i(a, "Cannot get module info in remote or local.");
            return new Bundle();
        }
        Logger.i(a, "Choose local: The version of local module " + str + SignatureImpl.INNER_SEP + localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.k));
        return localModuleInfo;
    }
}
