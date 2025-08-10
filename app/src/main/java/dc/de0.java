package dc;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.spotify.sdk.android.player.Config;
import dc.xe0;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: LogUtils.java */
/* loaded from: classes.dex */
public final class de0 {
    public static final char[] a = {'V', 'D', 'I', 'W', 'E', 'A'};
    public static final String b = System.getProperty("file.separator");
    public static final String c = System.getProperty("line.separator");
    public static final d d = new d(null);
    public static final ExecutorService e = Executors.newSingleThreadExecutor();
    public static final SimpleArrayMap<Class, f> f = new SimpleArrayMap<>();
    public static SimpleDateFormat g;

    /* compiled from: LogUtils.java */
    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ j b;
        public final /* synthetic */ String c;

        public a(int i, j jVar, String str) {
            this.a = i;
            this.b = jVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            de0.C(this.a, this.b.a, this.b.c + this.c);
        }
    }

    /* compiled from: LogUtils.java */
    public class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return de0.y(str);
        }
    }

    /* compiled from: LogUtils.java */
    public class c implements Runnable {
        public final /* synthetic */ File a;

        public c(File file) {
            this.a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.delete()) {
                return;
            }
            String str = "delete " + this.a + " failed!";
        }
    }

    /* compiled from: LogUtils.java */
    public static final class d {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public String g;
        public boolean h;
        public String i;
        public String j;
        public String k;
        public String l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public String r;
        public e s;
        public h t;
        public i u;
        public xe0.a v;

        public /* synthetic */ d(a aVar) {
            this();
        }

        public final d A(@IntRange(from = 1) int i) {
            this.q = i;
            return this;
        }

        public final char h() {
            return de0.a[this.m - 2];
        }

        public final String i() {
            String str = this.j;
            return str == null ? this.i : str;
        }

        public final String j() {
            return this.l;
        }

        public final char k() {
            return de0.a[this.n - 2];
        }

        public final String l() {
            return this.k;
        }

        public final String m() {
            return xe0.K(this.g) ? "" : this.g;
        }

        public final String n() {
            String str = this.r;
            return str == null ? "" : str.replace(SignatureImpl.INNER_SEP, Config.IN_FIELD_SEPARATOR);
        }

        public final int o() {
            return this.q;
        }

        public final int p() {
            return this.o;
        }

        public final int q() {
            return this.p;
        }

        public final boolean r() {
            return this.b;
        }

        public final boolean s() {
            return this.c;
        }

        public final boolean t() {
            return this.e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("process: ");
            sb.append(n());
            sb.append(de0.c);
            sb.append("logSwitch: ");
            sb.append(v());
            sb.append(de0.c);
            sb.append("consoleSwitch: ");
            sb.append(r());
            sb.append(de0.c);
            sb.append("tag: ");
            sb.append(m().equals("") ? "null" : m());
            sb.append(de0.c);
            sb.append("headSwitch: ");
            sb.append(u());
            sb.append(de0.c);
            sb.append("fileSwitch: ");
            sb.append(s());
            sb.append(de0.c);
            sb.append("dir: ");
            sb.append(i());
            sb.append(de0.c);
            sb.append("filePrefix: ");
            sb.append(l());
            sb.append(de0.c);
            sb.append("borderSwitch: ");
            sb.append(t());
            sb.append(de0.c);
            sb.append("singleTagSwitch: ");
            sb.append(w());
            sb.append(de0.c);
            sb.append("consoleFilter: ");
            sb.append(h());
            sb.append(de0.c);
            sb.append("fileFilter: ");
            sb.append(k());
            sb.append(de0.c);
            sb.append("stackDeep: ");
            sb.append(p());
            sb.append(de0.c);
            sb.append("stackOffset: ");
            sb.append(q());
            sb.append(de0.c);
            sb.append("saveDays: ");
            sb.append(o());
            sb.append(de0.c);
            sb.append("formatter: ");
            sb.append(de0.f);
            sb.append(de0.c);
            sb.append("fileWriter: ");
            sb.append(this.s);
            sb.append(de0.c);
            sb.append("onConsoleOutputListener: ");
            sb.append(this.t);
            sb.append(de0.c);
            sb.append("onFileOutputListener: ");
            sb.append(this.u);
            sb.append(de0.c);
            sb.append("fileExtraHeader: ");
            sb.append(this.v.c());
            return sb.toString();
        }

        public final boolean u() {
            return this.d;
        }

        public final boolean v() {
            return this.a;
        }

        public final boolean w() {
            return this.f;
        }

        public final d x(boolean z) {
            this.b = z;
            return this;
        }

        public final d y(boolean z) {
            this.c = z;
            return this;
        }

        public final d z(boolean z) {
            this.a = z;
            return this;
        }

        public d() {
            this.a = true;
            this.b = true;
            this.c = false;
            this.d = true;
            this.e = true;
            this.f = true;
            this.g = "";
            this.h = true;
            this.k = "util";
            this.l = PSOProgramService.LogExt;
            this.m = 2;
            this.n = 2;
            this.o = 1;
            this.p = 0;
            this.q = -1;
            this.r = xe0.p();
            this.v = new xe0.a("Log");
            if (!xe0.J() || ve0.a().getExternalFilesDir(null) == null) {
                this.i = ve0.a().getFilesDir() + de0.b + "log" + de0.b;
                return;
            }
            this.i = ve0.a().getExternalFilesDir(null) + de0.b + "log" + de0.b;
        }
    }

    /* compiled from: LogUtils.java */
    public interface e {
        void a(String str, String str2);
    }

    /* compiled from: LogUtils.java */
    public static abstract class f<T> {
        public abstract String a(T t);
    }

    /* compiled from: LogUtils.java */
    public static final class g {
        public static String a(Object obj) {
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }

        public static String b(Bundle bundle) {
            Iterator<String> it = bundle.keySet().iterator();
            if (!it.hasNext()) {
                return "Bundle {}";
            }
            StringBuilder sb = new StringBuilder(128);
            sb.append("Bundle { ");
            while (true) {
                String next = it.next();
                Object obj = bundle.get(next);
                sb.append(next);
                sb.append('=');
                if (obj instanceof Bundle) {
                    sb.append(obj == bundle ? "(this Bundle)" : b((Bundle) obj));
                } else {
                    sb.append(de0.p(obj));
                }
                if (!it.hasNext()) {
                    sb.append(" }");
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        }

        @RequiresApi(api = 16)
        public static void c(ClipData clipData, StringBuilder sb) {
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt == null) {
                sb.append("ClipData.Item {}");
                return;
            }
            sb.append("ClipData.Item { ");
            String htmlText = itemAt.getHtmlText();
            if (htmlText != null) {
                sb.append("H:");
                sb.append(htmlText);
                sb.append("}");
                return;
            }
            CharSequence text = itemAt.getText();
            if (text != null) {
                sb.append("T:");
                sb.append(text);
                sb.append("}");
                return;
            }
            Uri uri = itemAt.getUri();
            if (uri != null) {
                sb.append("U:");
                sb.append(uri);
                sb.append("}");
                return;
            }
            Intent intent = itemAt.getIntent();
            if (intent == null) {
                sb.append("NULL");
                sb.append("}");
            } else {
                sb.append("I:");
                sb.append(e(intent));
                sb.append("}");
            }
        }

        public static String d(String str) throws TransformerException, IllegalArgumentException {
            try {
                StreamSource streamSource = new StreamSource(new StringReader(str));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
                transformerNewTransformer.setOutputProperty("indent", "yes");
                transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformerNewTransformer.transform(streamSource, streamResult);
                return streamResult.getWriter().toString().replaceFirst(SimpleComparison.GREATER_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION + de0.c);
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        public static String e(Intent intent) {
            boolean z;
            Intent selector;
            ClipData clipData;
            StringBuilder sb = new StringBuilder(128);
            sb.append("Intent { ");
            String action = intent.getAction();
            boolean z2 = true;
            boolean z3 = false;
            if (action != null) {
                sb.append("act=");
                sb.append(action);
                z = false;
            } else {
                z = true;
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("cat=[");
                for (String str : categories) {
                    if (!z2) {
                        sb.append(',');
                    }
                    sb.append(str);
                    z2 = false;
                }
                sb.append("]");
                z = false;
            }
            Uri data = intent.getData();
            if (data != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("dat=");
                sb.append(data);
                z = false;
            }
            String type = intent.getType();
            if (type != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("typ=");
                sb.append(type);
                z = false;
            }
            int flags = intent.getFlags();
            if (flags != 0) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("flg=0x");
                sb.append(Integer.toHexString(flags));
                z = false;
            }
            String str2 = intent.getPackage();
            if (str2 != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("pkg=");
                sb.append(str2);
                z = false;
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("cmp=");
                sb.append(component.flattenToShortString());
                z = false;
            }
            Rect sourceBounds = intent.getSourceBounds();
            if (sourceBounds != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("bnds=");
                sb.append(sourceBounds.toShortString());
                z = false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 16 && (clipData = intent.getClipData()) != null) {
                if (!z) {
                    sb.append(' ');
                }
                c(clipData, sb);
                z = false;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("extras={");
                sb.append(b(extras));
                sb.append(MessageFormatter.DELIM_STOP);
            } else {
                z3 = z;
            }
            if (i >= 15 && (selector = intent.getSelector()) != null) {
                if (!z3) {
                    sb.append(' ');
                }
                sb.append("sel={");
                sb.append(selector == intent ? "(this Intent)" : e(selector));
                sb.append("}");
            }
            sb.append(" }");
            return sb.toString();
        }

        public static String f(Object obj) {
            if (obj instanceof CharSequence) {
                return xe0.k(obj.toString());
            }
            try {
                return xe0.s().toJson(obj);
            } catch (Throwable unused) {
                return obj.toString();
            }
        }

        public static String g(Object obj) {
            return h(obj, -1);
        }

        public static String h(Object obj, int i) {
            return obj.getClass().isArray() ? a(obj) : obj instanceof Throwable ? xe0.r((Throwable) obj) : obj instanceof Bundle ? b((Bundle) obj) : obj instanceof Intent ? e((Intent) obj) : i == 32 ? f(obj) : i == 48 ? d(obj.toString()) : obj.toString();
        }
    }

    /* compiled from: LogUtils.java */
    public interface h {
        void a(int i, String str, String str2);
    }

    /* compiled from: LogUtils.java */
    public interface i {
        void a(String str, String str2);
    }

    /* compiled from: LogUtils.java */
    public static final class j {
        public String a;
        public String[] b;
        public String c;

        public j(String str, String[] strArr, String str2) {
            this.a = str;
            this.b = strArr;
            this.c = str2;
        }
    }

    public static void A(int i2, String str, String str2) {
        Log.println(i2, str, str2);
        d dVar = d;
        if (dVar.t != null) {
            dVar.t.a(i2, str, str2);
        }
    }

    public static void B(int i2, String str, String[] strArr, String str2) {
        if (d.w()) {
            H(i2, str, K(i2, str, strArr, str2));
            return;
        }
        D(i2, str, true);
        F(i2, str, strArr);
        G(i2, str, str2);
        D(i2, str, false);
    }

    public static void C(int i2, String str, String str2) {
        Date date = new Date();
        String str3 = u().format(date);
        String strSubstring = str3.substring(0, 10);
        String strS = s(date);
        if (!h(strS, strSubstring)) {
            String str4 = "create " + strS + " failed!";
            return;
        }
        x(strS, str3.substring(11) + a[i2 - 2] + "/" + str + str2 + c);
    }

    public static void D(int i2, String str, boolean z) {
        if (d.t()) {
            A(i2, str, z ? "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────" : "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
    }

    public static void E(String str, String str2) {
        d dVar = d;
        dVar.v.a("Date of Log", str2);
        x(str, dVar.v.toString());
    }

    public static void F(int i2, String str, String[] strArr) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (d.t()) {
                    str2 = "│ " + str2;
                }
                A(i2, str, str2);
            }
            if (d.t()) {
                A(i2, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
        }
    }

    public static void G(int i2, String str, String str2) {
        int length = str2.length();
        int i3 = length / 1100;
        if (i3 <= 0) {
            I(i2, str, str2);
            return;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 1100;
            I(i2, str, str2.substring(i5, i6));
            i4++;
            i5 = i6;
        }
        if (i5 != length) {
            I(i2, str, str2.substring(i5, length));
        }
    }

    public static void H(int i2, String str, String str2) {
        int length = str2.length();
        d dVar = d;
        int i3 = 1100;
        int i4 = dVar.t() ? (length - 113) / 1100 : length / 1100;
        if (i4 <= 0) {
            A(i2, str, str2);
            return;
        }
        int i5 = 1;
        if (!dVar.t()) {
            A(i2, str, str2.substring(0, 1100));
            while (i5 < i4) {
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(c);
                int i6 = i3 + 1100;
                sb.append(str2.substring(i3, i6));
                A(i2, str, sb.toString());
                i5++;
                i3 = i6;
            }
            if (i3 != length) {
                A(i2, str, " " + c + str2.substring(i3, length));
                return;
            }
            return;
        }
        A(i2, str, str2.substring(0, 1100) + c + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        while (i5 < i4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            String str3 = c;
            sb2.append(str3);
            sb2.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb2.append(str3);
            sb2.append("│ ");
            int i7 = i3 + 1100;
            sb2.append(str2.substring(i3, i7));
            sb2.append(str3);
            sb2.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            A(i2, str, sb2.toString());
            i5++;
            i3 = i7;
        }
        if (i3 != length - 113) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" ");
            String str4 = c;
            sb3.append(str4);
            sb3.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb3.append(str4);
            sb3.append("│ ");
            sb3.append(str2.substring(i3, length));
            A(i2, str, sb3.toString());
        }
    }

    public static void I(int i2, String str, String str2) {
        if (!d.t()) {
            A(i2, str, str2);
            return;
        }
        for (String str3 : str2.split(c)) {
            A(i2, str, "│ " + str3);
        }
    }

    public static String J(int i2, Object... objArr) {
        String string;
        if (objArr != null) {
            if (objArr.length == 1) {
                string = o(i2, objArr[0]);
            } else {
                StringBuilder sb = new StringBuilder();
                int length = objArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = objArr[i3];
                    sb.append("args");
                    sb.append("[");
                    sb.append(i3);
                    sb.append("]");
                    sb.append(" = ");
                    sb.append(p(obj));
                    sb.append(c);
                }
                string = sb.toString();
            }
        } else {
            string = "null";
        }
        return string.length() == 0 ? "log nothing" : string;
    }

    public static String K(int i2, String str, String[] strArr, String str2) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        if (d.t()) {
            sb.append(" ");
            String str3 = c;
            sb.append(str3);
            sb.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb.append(str3);
            if (strArr != null) {
                for (String str4 : strArr) {
                    sb.append("│ ");
                    sb.append(str4);
                    sb.append(c);
                }
                sb.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                sb.append(c);
            }
            String[] strArrSplit = str2.split(c);
            int length = strArrSplit.length;
            while (i3 < length) {
                String str5 = strArrSplit[i3];
                sb.append("│ ");
                sb.append(str5);
                sb.append(c);
                i3++;
            }
            sb.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        } else {
            if (strArr != null) {
                sb.append(" ");
                sb.append(c);
                int length2 = strArr.length;
                while (i3 < length2) {
                    sb.append(strArr[i3]);
                    sb.append(c);
                    i3++;
                }
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    public static j L(String str) {
        String strSubstring;
        String strM;
        String strSubstring2;
        d dVar = d;
        if (dVar.h || dVar.u()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int iQ = dVar.q() + 3;
            if (iQ >= stackTrace.length) {
                if (stackTrace.length <= 0) {
                    return new j("", null, ": ");
                }
                String strT = t(stackTrace[stackTrace.length <= 3 ? stackTrace.length - 1 : 3]);
                if (dVar.h && xe0.K(str)) {
                    int iIndexOf = strT.indexOf(46);
                    strSubstring2 = iIndexOf == -1 ? strT : strT.substring(0, iIndexOf);
                } else {
                    strSubstring2 = str;
                }
                return new j(strSubstring2, null, ": ");
            }
            StackTraceElement stackTraceElement = stackTrace[iQ];
            String strT2 = t(stackTraceElement);
            if (dVar.h && xe0.K(str)) {
                int iIndexOf2 = strT2.indexOf(46);
                strSubstring = iIndexOf2 == -1 ? strT2 : strT2.substring(0, iIndexOf2);
            } else {
                strSubstring = str;
            }
            if (dVar.u()) {
                String name = Thread.currentThread().getName();
                String string = new Formatter().format("%s, %s.%s(%s:%d)", name, stackTraceElement.getClassName(), stackTraceElement.getMethodName(), strT2, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                String str2 = " [" + string + "]: ";
                if (dVar.p() <= 1) {
                    return new j(strSubstring, new String[]{string}, str2);
                }
                int iMin = Math.min(dVar.p(), stackTrace.length - iQ);
                String[] strArr = new String[iMin];
                strArr[0] = string;
                int length = name.length() + 2;
                String string2 = new Formatter().format("%" + length + "s", "").toString();
                for (int i2 = 1; i2 < iMin; i2++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2 + iQ];
                    strArr[i2] = new Formatter().format("%s%s.%s(%s:%d)", string2, stackTraceElement2.getClassName(), stackTraceElement2.getMethodName(), t(stackTraceElement2), Integer.valueOf(stackTraceElement2.getLineNumber())).toString();
                }
                return new j(strSubstring, strArr, str2);
            }
            strM = strSubstring;
        } else {
            strM = dVar.m();
        }
        return new j(strM, null, ": ");
    }

    public static void M(Object... objArr) {
        z(5, d.m(), objArr);
    }

    public static boolean h(String str, String str2) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!xe0.e(file.getParentFile())) {
            return false;
        }
        try {
            k(str, str2);
            boolean zCreateNewFile = file.createNewFile();
            if (zCreateNewFile) {
                E(str, str2);
            }
            return zCreateNewFile;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void i(Object... objArr) {
        z(3, d.m(), objArr);
    }

    public static void j(String str, Object... objArr) {
        z(3, str, objArr);
    }

    public static void k(String str, String str2) {
        File[] fileArrListFiles;
        if (d.o() > 0 && (fileArrListFiles = new File(str).getParentFile().listFiles(new b())) != null && fileArrListFiles.length > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());
            try {
                long time = simpleDateFormat.parse(str2).getTime() - (r0.o() * 86400000);
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    name.length();
                    if (simpleDateFormat.parse(n(name)).getTime() <= time) {
                        e.execute(new c(file));
                    }
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void l(Object... objArr) {
        z(6, d.m(), objArr);
    }

    public static void m(String str, Object... objArr) {
        z(6, str, objArr);
    }

    public static String n(String str) {
        Matcher matcher = Pattern.compile("[0-9]{4}_[0-9]{2}_[0-9]{2}").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    public static String o(int i2, Object obj) {
        return obj == null ? "null" : i2 == 32 ? g.h(obj, 32) : i2 == 48 ? g.h(obj, 48) : p(obj);
    }

    public static String p(Object obj) {
        f fVar;
        if (obj == null) {
            return "null";
        }
        SimpleArrayMap<Class, f> simpleArrayMap = f;
        return (simpleArrayMap.isEmpty() || (fVar = simpleArrayMap.get(q(obj))) == null) ? g.g(obj) : fVar.a(obj);
    }

    public static Class q(Object obj) {
        String string;
        Class<?> cls = obj.getClass();
        if (cls.isAnonymousClass() || cls.isSynthetic()) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces.length == 1) {
                Type rawType = genericInterfaces[0];
                while (rawType instanceof ParameterizedType) {
                    rawType = ((ParameterizedType) rawType).getRawType();
                }
                string = rawType.toString();
            } else {
                Type genericSuperclass = cls.getGenericSuperclass();
                while (genericSuperclass instanceof ParameterizedType) {
                    genericSuperclass = ((ParameterizedType) genericSuperclass).getRawType();
                }
                string = genericSuperclass.toString();
            }
            if (string.startsWith("class ")) {
                string = string.substring(6);
            } else if (string.startsWith("interface ")) {
                string = string.substring(10);
            }
            try {
                return Class.forName(string);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return cls;
    }

    public static d r() {
        return d;
    }

    public static String s(Date date) {
        String strSubstring = u().format(date).substring(0, 10);
        StringBuilder sb = new StringBuilder();
        d dVar = d;
        sb.append(dVar.i());
        sb.append(dVar.l());
        sb.append(Config.IN_FIELD_SEPARATOR);
        sb.append(strSubstring);
        sb.append(Config.IN_FIELD_SEPARATOR);
        sb.append(dVar.n());
        sb.append(dVar.j());
        return sb.toString();
    }

    public static String t(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName != null) {
            return fileName;
        }
        String className = stackTraceElement.getClassName();
        String[] strArrSplit = className.split("\\.");
        if (strArrSplit.length > 0) {
            className = strArrSplit[strArrSplit.length - 1];
        }
        int iIndexOf = className.indexOf(36);
        if (iIndexOf != -1) {
            className = className.substring(0, iIndexOf);
        }
        return className + ".java";
    }

    public static SimpleDateFormat u() {
        if (g == null) {
            g = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.getDefault());
        }
        return g;
    }

    public static void v(Object... objArr) {
        z(4, d.m(), objArr);
    }

    public static void w(String str, Object... objArr) {
        z(4, str, objArr);
    }

    public static void x(String str, String str2) {
        d dVar = d;
        if (dVar.s == null) {
            xe0.V(str, str2, true);
        } else {
            dVar.s.a(str, str2);
        }
        if (dVar.u != null) {
            dVar.u.a(str, str2);
        }
    }

    public static boolean y(String str) {
        return str.matches("^" + d.l() + "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$");
    }

    public static void z(int i2, String str, Object... objArr) {
        d dVar = d;
        if (dVar.v()) {
            int i3 = i2 & 15;
            int i4 = i2 & PsExtractor.VIDEO_STREAM_MASK;
            if (dVar.r() || dVar.s() || i4 == 16) {
                if (i3 >= dVar.m || i3 >= dVar.n) {
                    j jVarL = L(str);
                    String strJ = J(i4, objArr);
                    if (dVar.r() && i4 != 16 && i3 >= dVar.m) {
                        B(i3, jVarL.a, jVarL.b, strJ);
                    }
                    if ((dVar.s() || i4 == 16) && i3 >= dVar.n) {
                        e.execute(new a(i3, jVarL, strJ));
                    }
                }
            }
        }
    }
}
