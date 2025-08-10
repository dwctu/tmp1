package com.koushikdutta.async.callback;

/* loaded from: classes3.dex */
public interface CompletedCallback {

    public static class NullCompletedCallback implements CompletedCallback {
        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
        }
    }

    void onCompleted(Exception exc);
}
