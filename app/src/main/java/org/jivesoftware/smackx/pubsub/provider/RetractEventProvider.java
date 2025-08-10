package org.jivesoftware.smackx.pubsub.provider;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.pubsub.RetractItem;

/* loaded from: classes5.dex */
public class RetractEventProvider extends EmbeddedExtensionProvider<RetractItem> {
    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    public /* bridge */ /* synthetic */ ExtensionElement createReturnExtension(String str, String str2, Map map, List list) {
        return createReturnExtension(str, str2, (Map<String, String>) map, (List<? extends ExtensionElement>) list);
    }

    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    public RetractItem createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return new RetractItem(map.get(TtmlNode.ATTR_ID));
    }
}
