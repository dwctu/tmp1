package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class d extends AsyncTask<Context, Integer, Boolean> {
    private static final String a = d.class.getSimpleName();

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) throws IOException {
        InputStream bksFromTss;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            bksFromTss = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            g.b(a, "doInBackground: exception : " + e.getMessage());
            bksFromTss = null;
        }
        g.a(a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        if (bksFromTss == null) {
            return Boolean.FALSE;
        }
        f.a(bksFromTss);
        return Boolean.TRUE;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        g.a(a, "onPreExecute");
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            g.c(a, "onPostExecute: upate done");
        } else {
            g.b(a, "onPostExecute: upate failed");
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        g.c(a, "onProgressUpdate");
    }
}
