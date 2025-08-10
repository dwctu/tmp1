package org.jivesoftware.smack.util.dns;

/* loaded from: classes5.dex */
public class SRVRecord extends HostAddress implements Comparable<SRVRecord> {
    private int priority;
    private int weight;

    public SRVRecord(String str, int i, int i2, int i3) {
        super(str, i);
        if (i3 < 0 || i3 > 65535) {
            throw new IllegalArgumentException("DNS SRV records weight must be a 16-bit unsiged integer (i.e. between 0-65535. Weight was: " + i3);
        }
        if (i2 >= 0 && i2 <= 65535) {
            this.priority = i2;
            this.weight = i3;
        } else {
            throw new IllegalArgumentException("DNS SRV records priority must be a 16-bit unsiged integer (i.e. between 0-65535. Priority was: " + i2);
        }
    }

    public int getPriority() {
        return this.priority;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override // org.jivesoftware.smack.util.dns.HostAddress
    public String toString() {
        return super.toString() + " prio:" + this.priority + ":w:" + this.weight;
    }

    @Override // java.lang.Comparable
    public int compareTo(SRVRecord sRVRecord) {
        int i = sRVRecord.priority - this.priority;
        return i == 0 ? this.weight - sRVRecord.weight : i;
    }
}
