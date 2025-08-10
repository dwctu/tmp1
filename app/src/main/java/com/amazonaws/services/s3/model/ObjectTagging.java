package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ObjectTagging implements Serializable {
    private List<Tag> tagSet;

    public ObjectTagging(List<Tag> list) {
        this.tagSet = list;
    }

    public List<Tag> a() {
        return this.tagSet;
    }
}
