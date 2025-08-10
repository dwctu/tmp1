package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.bouncycastle.pqc.crypto.gmss.GMSSParameters;

/* loaded from: classes5.dex */
public class GMSSKeySpec implements KeySpec {
    private GMSSParameters gmssParameterSet;

    public GMSSKeySpec(GMSSParameters gMSSParameters) {
        this.gmssParameterSet = gMSSParameters;
    }

    public GMSSParameters getParameters() {
        return this.gmssParameterSet;
    }
}
