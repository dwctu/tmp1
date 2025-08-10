package dc;

import java.util.Date;

/* compiled from: DateHelper.java */
/* loaded from: classes2.dex */
public class d51 {
    public static long a(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }

    public static Date b(long j) {
        return new Date((j - 2082844800) * 1000);
    }
}
