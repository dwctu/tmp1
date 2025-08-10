package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible
/* loaded from: classes2.dex */
public interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}
