package org.jivesoftware.smackx.pubsub.listener;

import org.jivesoftware.smackx.pubsub.ItemDeleteEvent;

/* loaded from: classes5.dex */
public interface ItemDeleteListener {
    void handleDeletedItems(ItemDeleteEvent itemDeleteEvent);

    void handlePurge();
}
