package org.jivesoftware.smackx.pubsub;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;

/* loaded from: classes5.dex */
public class ConfigurationEvent extends NodeExtension implements EmbeddedPacketExtension {
    private ConfigureForm form;

    public ConfigurationEvent(String str) {
        super(PubSubElementType.CONFIGURATION, str);
    }

    public ConfigureForm getConfiguration() {
        return this.form;
    }

    @Override // org.jivesoftware.smackx.pubsub.EmbeddedPacketExtension
    public List<ExtensionElement> getExtensions() {
        return getConfiguration() == null ? Collections.emptyList() : Arrays.asList(getConfiguration().getDataFormToSend());
    }

    public ConfigurationEvent(String str, ConfigureForm configureForm) {
        super(PubSubElementType.CONFIGURATION, str);
        this.form = configureForm;
    }
}
