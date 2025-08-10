package com.google.firebase.database.core;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes2.dex */
public final class Tag {
    private final long tagNumber;

    public Tag(long j) {
        this.tagNumber = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Tag.class == obj.getClass() && this.tagNumber == ((Tag) obj).tagNumber;
    }

    public long getTagNumber() {
        return this.tagNumber;
    }

    public int hashCode() {
        long j = this.tagNumber;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.tagNumber + MessageFormatter.DELIM_STOP;
    }
}
