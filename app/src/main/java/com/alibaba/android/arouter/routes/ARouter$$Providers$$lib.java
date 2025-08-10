package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.component.dxbilog.lib._BILogProviderImpl;
import java.util.Map;

/* loaded from: classes.dex */
public class ARouter$$Providers$$lib implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.component.dxbilog.lib.IBILogProvider", RouteMeta.build(RouteType.PROVIDER, _BILogProviderImpl.class, "/dxRouter/BILogProviderImpl", "dxRouter", null, -1, Integer.MIN_VALUE));
    }
}
