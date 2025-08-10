package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dalvik.annotation.optimization.FastNative;
import dc.jg1;
import dc.kg1;
import dc.lg1;
import dc.mg1;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    public static final EnumMap<mg1, Integer> a;
    public static final EnumMap<lg1, Integer> b;
    public static final lg1[] c;
    public static final Set<Long> d;
    public static String e;
    public static boolean f;
    public static final HashMap<String, Parcelable.Creator<?>> g;
    public static kg1 h;
    public static boolean i;
    public static jg1 j;
    private final long nativeHandle;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[lg1.values().length];
            a = iArr;
            try {
                iArr[lg1.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[lg1.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[lg1.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[lg1.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[lg1.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface b {
        void loadLibrary(String str);
    }

    static {
        EnumMap<mg1, Integer> enumMap = new EnumMap<>(mg1.class);
        a = enumMap;
        enumMap.put((EnumMap<mg1, Integer>) mg1.OnErrorDiscard, (mg1) 0);
        enumMap.put((EnumMap<mg1, Integer>) mg1.OnErrorRecover, (mg1) 1);
        EnumMap<lg1, Integer> enumMap2 = new EnumMap<>(lg1.class);
        b = enumMap2;
        lg1 lg1Var = lg1.LevelDebug;
        enumMap2.put((EnumMap<lg1, Integer>) lg1Var, (lg1) 0);
        lg1 lg1Var2 = lg1.LevelInfo;
        enumMap2.put((EnumMap<lg1, Integer>) lg1Var2, (lg1) 1);
        lg1 lg1Var3 = lg1.LevelWarning;
        enumMap2.put((EnumMap<lg1, Integer>) lg1Var3, (lg1) 2);
        lg1 lg1Var4 = lg1.LevelError;
        enumMap2.put((EnumMap<lg1, Integer>) lg1Var4, (lg1) 3);
        lg1 lg1Var5 = lg1.LevelNone;
        enumMap2.put((EnumMap<lg1, Integer>) lg1Var5, (lg1) 4);
        c = new lg1[]{lg1Var, lg1Var2, lg1Var3, lg1Var4, lg1Var5};
        d = new HashSet();
        e = null;
        f = true;
        g = new HashMap<>();
        i = false;
    }

    public MMKV(long j2) {
        this.nativeHandle = j2;
    }

    public static void B(lg1 lg1Var, String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = b.get(lg1Var);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    public static MMKV a(long j2, String str, int i2) throws RuntimeException {
        String str2;
        if (j2 == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
        }
        if (!f) {
            return new MMKV(j2);
        }
        Set<Long> set = d;
        synchronized (set) {
            if (!set.contains(Long.valueOf(j2))) {
                if (!checkProcessMode(j2)) {
                    if (i2 == 1) {
                        str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                    } else {
                        str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                    }
                    throw new IllegalArgumentException(str2);
                }
                set.add(Long.valueOf(j2));
            }
        }
        return new MMKV(j2);
    }

    private native long actualSize(long j2);

    private native String[] allKeys(long j2, boolean z);

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, @Nullable String str3);

    private static native boolean checkProcessMode(long j2);

    private native boolean containsKey(long j2, String str);

    private native long count(long j2, boolean z);

    private static native long createNB(int i2);

    private native boolean decodeBool(long j2, String str, boolean z);

    @Nullable
    private native byte[] decodeBytes(long j2, String str);

    private native double decodeDouble(long j2, String str, double d2);

    private native float decodeFloat(long j2, String str, float f2);

    private native int decodeInt(long j2, String str, int i2);

    private native long decodeLong(long j2, String str, long j3);

    @Nullable
    private native String decodeString(long j2, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j2, String str);

    private static native void destroyNB(long j2, int i2);

    private native boolean encodeBool(long j2, String str, boolean z);

    private native boolean encodeBool_2(long j2, String str, boolean z, int i2);

    private native boolean encodeBytes(long j2, String str, @Nullable byte[] bArr);

    private native boolean encodeBytes_2(long j2, String str, @Nullable byte[] bArr, int i2);

    private native boolean encodeDouble(long j2, String str, double d2);

    private native boolean encodeDouble_2(long j2, String str, double d2, int i2);

    private native boolean encodeFloat(long j2, String str, float f2);

    private native boolean encodeFloat_2(long j2, String str, float f2, int i2);

    private native boolean encodeInt(long j2, String str, int i2);

    private native boolean encodeInt_2(long j2, String str, int i2, int i3);

    private native boolean encodeLong(long j2, String str, long j3);

    private native boolean encodeLong_2(long j2, String str, long j3, int i2);

    private native boolean encodeSet(long j2, String str, @Nullable String[] strArr);

    private native boolean encodeSet_2(long j2, String str, @Nullable String[] strArr, int i2);

    private native boolean encodeString(long j2, String str, @Nullable String str2);

    private native boolean encodeString_2(long j2, String str, @Nullable String str2, int i2);

    private static native long getDefaultMMKV(int i2, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i2, int i3, @Nullable String str2);

    private static native long getMMKVWithID(String str, int i2, @Nullable String str2, @Nullable String str3, long j2);

    private static native long getMMKVWithIDAndSize(String str, int i2, int i3, @Nullable String str2);

    private native boolean isCompareBeforeSetEnabled();

    @FastNative
    private native boolean isEncryptionEnabled();

    @FastNative
    private native boolean isExpirationEnabled();

    public static native boolean isFileValid(String str, @Nullable String str2);

    public static MMKV j() throws RuntimeException {
        if (e != null) {
            return a(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static native void jniInitialize(String str, String str2, int i2, boolean z);

    public static void k() {
        synchronized (d) {
            f = false;
        }
    }

    public static String l(String str, String str2, b bVar, lg1 lg1Var, boolean z) {
        if (bVar != null) {
            bVar.loadLibrary("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        jniInitialize(str, str2, w(lg1Var), z);
        e = str;
        return str;
    }

    public static void m() {
        synchronized (d) {
            f = true;
        }
    }

    private static void mmkvLogImp(int i2, String str, int i3, String str2, String str3) {
        kg1 kg1Var = h;
        if (kg1Var == null || !i) {
            int i4 = a.a[c[i2].ordinal()];
        } else {
            kg1Var.a(c[i2], str, i3, str2, str3);
        }
    }

    @FastNative
    private native void nativeEnableCompareBeforeSet();

    private static void onContentChangedByOuterProcess(String str) {
        jg1 jg1Var = j;
        if (jg1Var != null) {
            jg1Var.a(str);
        }
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        mg1 mg1VarB = mg1.OnErrorDiscard;
        kg1 kg1Var = h;
        if (kg1Var != null) {
            mg1VarB = kg1Var.b(str);
        }
        B(lg1.LevelInfo, "Recover strategic for " + str + " is " + mg1VarB);
        Integer num = a.get(mg1VarB);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        mg1 mg1VarD = mg1.OnErrorDiscard;
        kg1 kg1Var = h;
        if (kg1Var != null) {
            mg1VarD = kg1Var.d(str);
        }
        B(lg1.LevelInfo, "Recover strategic for " + str + " is " + mg1VarD);
        Integer num = a.get(mg1VarD);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    public static native boolean removeStorage(String str, @Nullable String str2);

    private native void removeValueForKey(long j2, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, @Nullable String str3);

    private static native void setCallbackHandler(boolean z, boolean z2);

    private static native void setLogLevel(int i2);

    private static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j2);

    public static String u(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + "/mmkv";
        v(context, str, null, lg1.LevelInfo, null);
        return str;
    }

    public static String v(Context context, String str, b bVar, lg1 lg1Var, kg1 kg1Var) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            k();
        } else {
            m();
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        h = kg1Var;
        if (kg1Var != null && kg1Var.c()) {
            i = true;
        }
        l(str, absolutePath, bVar, lg1Var, i);
        if (h != null) {
            setCallbackHandler(i, true);
        }
        return str;
    }

    private native int valueSize(long j2, String str, boolean z);

    public static native String version();

    public static int w(lg1 lg1Var) {
        int i2 = a.a[lg1Var.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 != 3) {
            return i2 != 4 ? 1 : 4;
        }
        return 3;
    }

    private native int writeValueToNB(long j2, String str, long j3, int i2);

    public static MMKV x(String str, int i2, int i3, String str2) throws RuntimeException {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i2, i3, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException("Fail to create an ashmem MMKV instance [" + str + "] in JNI");
    }

    public static MMKV y(Context context, String str, int i2, int i3, @Nullable String str2) throws RuntimeException {
        MMKV mmkvA;
        if (e == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        String strB = MMKVContentProvider.b(context, Process.myPid());
        if (strB == null || strB.length() == 0) {
            B(lg1.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        if (strB.contains(SignatureImpl.INNER_SEP)) {
            Uri uriA = MMKVContentProvider.a(context);
            if (uriA == null) {
                B(lg1.LevelError, "MMKVContentProvider has invalid authority");
                throw new IllegalStateException("MMKVContentProvider has invalid authority");
            }
            lg1 lg1Var = lg1.LevelInfo;
            B(lg1Var, "getting parcelable mmkv in process, Uri = " + uriA);
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_SIZE", i2);
            bundle.putInt("KEY_MODE", i3);
            if (str2 != null) {
                bundle.putString("KEY_CRYPT", str2);
            }
            Bundle bundleCall = context.getContentResolver().call(uriA, "mmkvFromAshmemID", str, bundle);
            if (bundleCall != null) {
                bundleCall.setClassLoader(ParcelableMMKV.class.getClassLoader());
                ParcelableMMKV parcelableMMKV = (ParcelableMMKV) bundleCall.getParcelable("KEY");
                if (parcelableMMKV != null && (mmkvA = parcelableMMKV.a()) != null) {
                    B(lg1Var, mmkvA.mmapID() + " fd = " + mmkvA.ashmemFD() + ", meta fd = " + mmkvA.ashmemMetaFD());
                    return mmkvA;
                }
            }
        }
        B(lg1.LevelInfo, "getting mmkv in main process");
        long mMKVWithIDAndSize = getMMKVWithIDAndSize(str, i2, i3 | 8, str2);
        if (mMKVWithIDAndSize != 0) {
            return new MMKV(mMKVWithIDAndSize);
        }
        throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + str + "]");
    }

    public static MMKV z(String str, int i2) throws RuntimeException {
        if (e != null) {
            return a(getMMKVWithID(str, i2, null, null, 0L), str, i2);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public void A(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public boolean b(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public boolean c(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearAllWithKeepingSpace();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return b(str);
    }

    @Nullable
    public native String cryptKey();

    public int d(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    public native boolean disableAutoKeyExpire();

    public native void disableCompareBeforeSet();

    public long e(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public native boolean enableAutoKeyExpire(int i2);

    @Nullable
    public <T extends Parcelable> T f(String str, Class<T> cls, @Nullable T t) {
        byte[] bArrDecodeBytes;
        Parcelable.Creator<?> creator;
        if (cls == null || (bArrDecodeBytes = decodeBytes(this.nativeHandle, str)) == null) {
            return t;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrDecodeBytes, 0, bArrDecodeBytes.length);
        parcelObtain.setDataPosition(0);
        try {
            String string = cls.toString();
            HashMap<String, Parcelable.Creator<?>> map = g;
            synchronized (map) {
                creator = map.get(string);
                if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                    map.put(string, creator);
                }
            }
            if (creator != null) {
                return (T) creator.createFromParcel(parcelObtain);
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + string);
        } catch (Exception e2) {
            B(lg1.LevelError, e2.toString());
            return t;
        } finally {
            parcelObtain.recycle();
        }
    }

    @Nullable
    public String g(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        return decodeFloat(this.nativeHandle, str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        return decodeInt(this.nativeHandle, str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return h(str, set);
    }

    @Nullable
    public Set<String> h(String str, @Nullable Set<String> set) {
        return i(str, set, HashSet.class);
    }

    @Nullable
    public Set<String> i(String str, @Nullable Set<String> set, Class<? extends Set> cls) throws IllegalAccessException, InstantiationException {
        String[] strArrDecodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (strArrDecodeStringSet == null) {
            return set;
        }
        try {
            Set<String> setNewInstance = cls.newInstance();
            setNewInstance.addAll(Arrays.asList(strArrDecodeStringSet));
            return setNewInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public native void lock();

    public native String mmapID();

    public boolean n(String str, int i2) {
        return encodeInt(this.nativeHandle, str, i2);
    }

    public boolean o(String str, long j2) {
        return encodeLong(this.nativeHandle, str, j2);
    }

    public boolean p(String str, @Nullable Parcelable parcelable) {
        if (parcelable == null) {
            return encodeBytes(this.nativeHandle, str, null);
        }
        return encodeBytes(this.nativeHandle, str, t(parcelable));
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        encodeFloat(this.nativeHandle, str, f2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        encodeInt(this.nativeHandle, str, i2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        encodeLong(this.nativeHandle, str, j2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        r(str, set);
        return this;
    }

    public boolean q(String str, @Nullable String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean r(String str, @Nullable Set<String> set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
    }

    public native boolean reKey(@Nullable String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        A(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public boolean s(String str, boolean z) {
        return encodeBool(this.nativeHandle, str, z);
    }

    public final byte[] t(@NonNull Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }
}
