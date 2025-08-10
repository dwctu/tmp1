package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

/* loaded from: classes5.dex */
public final class SipHash {

    public static class Mac extends BaseMac {
        public Mac() {
            super(new org.bouncycastle.crypto.macs.SipHash());
        }
    }

    public static class Mac48 extends BaseMac {
        public Mac48() {
            super(new org.bouncycastle.crypto.macs.SipHash(4, 8));
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = SipHash.class.getName();

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            sb.append(str);
            sb.append("$Mac");
            configurableProvider.addAlgorithm("Mac.SIPHASH", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.Mac.SIPHASH-2-4", "SIPHASH");
            configurableProvider.addAlgorithm("Mac.SIPHASH-4-8", str + "$Mac48");
        }
    }

    private SipHash() {
    }
}
