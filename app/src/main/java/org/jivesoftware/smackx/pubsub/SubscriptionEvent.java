package org.jivesoftware.smackx.pubsub;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class SubscriptionEvent extends NodeEvent {
    private List<String> subIds;

    public SubscriptionEvent(String str) {
        super(str);
        this.subIds = Collections.emptyList();
    }

    public List<String> getSubscriptions() {
        return Collections.unmodifiableList(this.subIds);
    }

    public void setSubscriptions(List<String> list) {
        if (list != null) {
            this.subIds = list;
        }
    }

    public SubscriptionEvent(String str, List<String> list) {
        super(str);
        this.subIds = Collections.emptyList();
        if (list != null) {
            this.subIds = list;
        }
    }
}
