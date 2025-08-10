package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public class ReplicationRule {
    public void a(ReplicationDestinationConfig replicationDestinationConfig) {
        if (replicationDestinationConfig == null) {
            throw new IllegalArgumentException("Destination cannot be null in the replication rule");
        }
    }

    public void b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix cannot be null for a replication rule");
        }
    }

    public void c(String str) {
    }
}
