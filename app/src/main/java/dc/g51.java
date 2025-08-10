package dc;

/* compiled from: Logger.java */
/* loaded from: classes2.dex */
public abstract class g51 {
    public static g51 a(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new b51(cls.getSimpleName()) : new e51(cls.getSimpleName());
    }

    public abstract void b(String str);
}
