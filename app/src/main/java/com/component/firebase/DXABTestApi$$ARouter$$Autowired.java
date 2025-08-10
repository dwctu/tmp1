package com.component.firebase;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.component.firebase.listener.IDXABTestProvider;
import dc.pd;

/* loaded from: classes.dex */
public class DXABTestApi$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) pd.c().g(SerializationService.class);
        DXABTestApi.abTestProvider = (IDXABTestProvider) pd.c().g(IDXABTestProvider.class);
    }
}
