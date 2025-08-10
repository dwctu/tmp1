package org.jivesoftware.smackx.pubsub.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.pubsub.ConfigurationEvent;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* loaded from: classes5.dex */
public class ConfigEventProvider extends EmbeddedExtensionProvider<ConfigurationEvent> {
    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    public /* bridge */ /* synthetic */ ExtensionElement createReturnExtension(String str, String str2, Map map, List list) {
        return createReturnExtension(str, str2, (Map<String, String>) map, (List<? extends ExtensionElement>) list);
    }

    @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
    public ConfigurationEvent createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return list.size() == 0 ? new ConfigurationEvent(map.get("node")) : new ConfigurationEvent(map.get("node"), new ConfigureForm((DataForm) list.iterator().next()));
    }
}
