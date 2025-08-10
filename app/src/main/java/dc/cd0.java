package dc;

import android.content.Context;
import android.os.Process;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: HookCollector.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/component/dxutilcode/lib/collector/HookCollector;", "Lcom/component/dxutilcode/lib/collector/HookInterface;", "()V", "checkClass", "", "checkFile", "checkInstalled", "checkStack", "detectHook", "context", "Landroid/content/Context;", "setXposedFalse", "", "hytto-apps.android.components.base.dxutilcode"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class cd0 {
    public final boolean a() throws ClassNotFoundException {
        Iterator it = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"de.robv.android.xposed.XposedBridge", "com.saurik.substrate.MS", "org.frida.server"}).iterator();
        while (it.hasNext()) {
            try {
                Class.forName((String) it.next());
                return true;
            } catch (ClassNotFoundException unused) {
            }
        }
        return false;
    }

    public final boolean b() throws IOException {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String it = bufferedReader.readLine();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it == null) {
                    break;
                }
                if (StringsKt__StringsJVMKt.endsWith$default(it, ".so", false, 2, null) || StringsKt__StringsJVMKt.endsWith$default(it, ".jar", false, 2, null)) {
                    String strSubstring = it.substring(StringsKt__StringsKt.lastIndexOf$default((CharSequence) it, " ", 0, false, 6, (Object) null) + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                    hashSet.add(strSubstring);
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "com.saurik.substrate", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "XposedBridge.jar", false, 2, (Object) null)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final boolean c() {
        Iterator it = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"de.robv.android.xposed.installer", "com.saurik.substrate", "org.frida.server"}).iterator();
        while (it.hasNext()) {
            if (gd0.k((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean d() throws Exception {
        try {
            throw new Exception("detectHook");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                i++;
                if (Intrinsics.areEqual(stackTraceElement.getClassName(), "com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    return true;
                }
                String className = stackTraceElement.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "stackTraceElement.className");
                if (StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) "com.saurik.substrate.MS", false, 2, (Object) null) && Intrinsics.areEqual(stackTraceElement.getMethodName(), "invoked")) {
                    return true;
                }
                if (Intrinsics.areEqual(stackTraceElement.getClassName(), "de.robv.android.xposed.XposedBridge") && (Intrinsics.areEqual(stackTraceElement.getMethodName(), "main") || Intrinsics.areEqual(stackTraceElement.getMethodName(), "handleHookedMethod"))) {
                    return true;
                }
                String className2 = stackTraceElement.getClassName();
                Intrinsics.checkNotNullExpressionValue(className2, "stackTraceElement.className");
                if (StringsKt__StringsKt.contains$default((CharSequence) className2, (CharSequence) "org.frida.server", false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return c() || a() || d() || b();
    }
}
