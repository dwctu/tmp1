package com.huawei.hms.feature.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class d implements DynamicModule.VersionPolicy {
    private static final String a = "d";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = a;
        Logger.i(str2, "The version of remote module " + str + SignatureImpl.INNER_SEP + remoteModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.j));
        Logger.i(str2, "The version of local module " + str + SignatureImpl.INNER_SEP + localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.k));
        if (remoteModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.j) >= localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.k)) {
            Logger.i(str2, "Choose remote module info.");
            return remoteModuleInfo;
        }
        Logger.i(str2, "Choose local module info.");
        return localModuleInfo;
    }
}
