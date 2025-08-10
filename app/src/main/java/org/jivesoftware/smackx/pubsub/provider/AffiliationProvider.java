package org.jivesoftware.smackx.pubsub.provider;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.pubsub.Affiliation;

/* loaded from: classes5.dex */
public class AffiliationProvider extends EmbeddedExtensionProvider<Affiliation> {
    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    public /* bridge */ /* synthetic */ ExtensionElement createReturnExtension(String str, String str2, Map map, List list) {
        return createReturnExtension(str, str2, (Map<String, String>) map, (List<? extends ExtensionElement>) list);
    }

    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    public Affiliation createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return new Affiliation(map.get("node"), Affiliation.Type.valueOf(map.get(FirebaseAnalytics.Param.AFFILIATION)));
    }
}
