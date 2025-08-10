package com.amazonaws.services.s3.model;

import java.util.List;

/* loaded from: classes.dex */
public class MultiObjectDeleteException extends AmazonS3Exception {
    private static final long serialVersionUID = -2004213552302446866L;
    private final List<DeleteObjectsResult$DeletedObject> deletedObjects;
    private final List<DeleteError> errors;

    public static class DeleteError {
        public void a(String str) {
        }

        public void b(String str) {
        }

        public void c(String str) {
        }

        public void d(String str) {
        }
    }

    @Override // com.amazonaws.AmazonServiceException
    public String a() {
        return super.a();
    }
}
