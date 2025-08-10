package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class DeleteObjectsResult$DeletedObject implements Serializable {
    private boolean deleteMarker;
    private String deleteMarkerVersionId;
    private String key;
    private String versionId;

    public void a(boolean z) {
        this.deleteMarker = z;
    }

    public void b(String str) {
        this.deleteMarkerVersionId = str;
    }

    public void c(String str) {
        this.key = str;
    }

    public void d(String str) {
        this.versionId = str;
    }
}
