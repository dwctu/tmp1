package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.DeleteObjectsResult$DeletedObject;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DeleteObjectsResponse implements S3RequesterChargedResult {
    public List<DeleteObjectsResult$DeletedObject> a;
    public List<MultiObjectDeleteException.DeleteError> b;

    public DeleteObjectsResponse() {
        this(new ArrayList(), new ArrayList());
    }

    public List<DeleteObjectsResult$DeletedObject> a() {
        return this.a;
    }

    public List<MultiObjectDeleteException.DeleteError> b() {
        return this.b;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void e(boolean z) {
    }

    public DeleteObjectsResponse(List<DeleteObjectsResult$DeletedObject> list, List<MultiObjectDeleteException.DeleteError> list2) {
        this.a = list;
        this.b = list2;
    }
}
