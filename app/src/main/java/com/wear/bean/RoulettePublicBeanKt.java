package com.wear.bean;

import dc.bu1;
import dc.ch3;
import dc.eg3;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: RoulettePublicBean.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"generateRoulettePublicBean", "Lcom/wear/bean/RoulettePublicBean;", "algorithm", "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RoulettePublicBeanKt {
    @Nullable
    public static final RoulettePublicBean generateRoulettePublicBean(@Nullable String str) {
        String appAccountCode = ch3.n().o().getAppAccountCode();
        if (appAccountCode == null) {
            return null;
        }
        String strH = eg3.h(bu1.a(), appAccountCode + "_toyRoulettePublic", null);
        if (strH == null) {
            return null;
        }
        return new RoulettePublicBean(strH, str);
    }

    public static /* synthetic */ RoulettePublicBean generateRoulettePublicBean$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "DH";
        }
        return generateRoulettePublicBean(str);
    }
}
