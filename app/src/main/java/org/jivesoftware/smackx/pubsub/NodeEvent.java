package org.jivesoftware.smackx.pubsub;

/* loaded from: classes5.dex */
public abstract class NodeEvent {
    private String nodeId;

    public NodeEvent(String str) {
        this.nodeId = str;
    }

    public String getNodeId() {
        return this.nodeId;
    }
}
