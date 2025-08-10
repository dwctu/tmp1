package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class BucketCrossOriginConfiguration implements Serializable {
    private List<CORSRule> rules;

    public BucketCrossOriginConfiguration(List<CORSRule> list) {
        this.rules = list;
    }

    public List<CORSRule> a() {
        return this.rules;
    }

    public BucketCrossOriginConfiguration() {
    }
}
