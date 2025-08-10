package com.component.dxbilog.lib;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import dc.pd;

/* loaded from: classes.dex */
public class BILogApi$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) pd.c().g(SerializationService.class);
        BILogApi.biLogProvider = (IBILogProvider) pd.c().g(IBILogProvider.class);
    }
}
