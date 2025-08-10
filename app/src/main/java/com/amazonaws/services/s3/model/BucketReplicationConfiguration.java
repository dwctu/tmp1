package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BucketReplicationConfiguration implements Serializable {
    private String roleARN;
    private Map<String, ReplicationRule> rules = new HashMap();

    public BucketReplicationConfiguration a(String str, ReplicationRule replicationRule) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("Rule id cannot be null or empty.");
        }
        if (replicationRule == null) {
            throw new IllegalArgumentException("Replication rule cannot be null");
        }
        this.rules.put(str, replicationRule);
        return this;
    }

    public void b(String str) {
        this.roleARN = str;
    }
}
