package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.component.dxbilog.lib._BILogProviderImpl;
import java.util.Map;

/* loaded from: classes.dex */
public class ARouter$$Group$$dxRouter implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/dxRouter/BILogProviderImpl", RouteMeta.build(RouteType.PROVIDER, _BILogProviderImpl.class, "/dxrouter/bilogproviderimpl", "dxrouter", null, -1, Integer.MIN_VALUE));
    }
}
