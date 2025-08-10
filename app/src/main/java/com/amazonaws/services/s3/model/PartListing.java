package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PartListing implements S3RequesterChargedResult {
    public List<PartSummary> a;

    public List<PartSummary> a() {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        return this.a;
    }

    public void b(String str) {
    }

    public void c(String str) {
    }

    public void d(Owner owner) {
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void e(boolean z) {
    }

    public void f(String str) {
    }

    public void g(int i) {
    }

    public void h(int i) {
    }

    public void i(Owner owner) {
    }

    public void j(int i) {
    }

    public void k(String str) {
    }

    public void l(boolean z) {
    }

    public void m(String str) {
    }
}
