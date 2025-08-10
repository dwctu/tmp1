package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BucketLifecycleConfiguration implements Serializable {
    private List<Rule> rules;

    public static class NoncurrentVersionTransition implements Serializable {
        private int days = -1;
        private String storageClass;

        public void a(int i) {
            this.days = i;
        }

        public void b(String str) {
            this.storageClass = str;
        }
    }

    public static class Rule implements Serializable {
        private AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
        private Date expirationDate;
        private LifecycleFilter filter;
        private String id;
        private List<NoncurrentVersionTransition> noncurrentVersionTransitions;
        private String prefix;
        private String status;
        private List<Transition> transitions;
        private int expirationInDays = -1;
        private boolean expiredObjectDeleteMarker = false;
        private int noncurrentVersionExpirationInDays = -1;

        public Rule a(NoncurrentVersionTransition noncurrentVersionTransition) {
            if (noncurrentVersionTransition == null) {
                throw new IllegalArgumentException("NoncurrentVersionTransition cannot be null.");
            }
            if (this.noncurrentVersionTransitions == null) {
                this.noncurrentVersionTransitions = new ArrayList();
            }
            this.noncurrentVersionTransitions.add(noncurrentVersionTransition);
            return this;
        }

        public Rule b(Transition transition) {
            if (transition == null) {
                throw new IllegalArgumentException("Transition cannot be null.");
            }
            if (this.transitions == null) {
                this.transitions = new ArrayList();
            }
            this.transitions.add(transition);
            return this;
        }

        public void c(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload) {
            this.abortIncompleteMultipartUpload = abortIncompleteMultipartUpload;
        }

        public void d(Date date) {
            this.expirationDate = date;
        }

        public void e(int i) {
            this.expirationInDays = i;
        }

        public void f(boolean z) {
            this.expiredObjectDeleteMarker = z;
        }

        public void g(LifecycleFilter lifecycleFilter) {
            this.filter = lifecycleFilter;
        }

        public void h(String str) {
            this.id = str;
        }

        public void i(int i) {
            this.noncurrentVersionExpirationInDays = i;
        }

        @Deprecated
        public void j(String str) {
            this.prefix = str;
        }

        public void k(String str) {
            this.status = str;
        }
    }

    public static class Transition implements Serializable {
        private Date date;
        private int days = -1;
        private String storageClass;

        public void a(Date date) {
            this.date = date;
        }

        public void b(int i) {
            this.days = i;
        }

        public void c(String str) {
            this.storageClass = str;
        }
    }

    public BucketLifecycleConfiguration(List<Rule> list) {
        this.rules = list;
    }

    public List<Rule> a() {
        return this.rules;
    }

    public BucketLifecycleConfiguration() {
    }
}
