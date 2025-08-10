package dc;

/* loaded from: classes.dex */
public /* synthetic */ class c {
    public static /* synthetic */ int a(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
