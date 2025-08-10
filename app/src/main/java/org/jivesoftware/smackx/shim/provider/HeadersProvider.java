package org.jivesoftware.smackx.shim.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

/* loaded from: classes5.dex */
public class HeadersProvider extends EmbeddedExtensionProvider<HeadersExtension> {
    public static final HeadersProvider INSTANCE = new HeadersProvider();

    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    public /* bridge */ /* synthetic */ ExtensionElement createReturnExtension(String str, String str2, Map map, List list) {
        return createReturnExtension(str, str2, (Map<String, String>) map, (List<? extends ExtensionElement>) list);
    }

    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    public HeadersExtension createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return new HeadersExtension(list);
    }
}
