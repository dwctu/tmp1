package com.sun.jna;

import androidx.exifinterface.media.ExifInterface;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Structure;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Window;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class Native implements Version {
    public static final int BOOL_SIZE;
    public static final int CB_HAS_INITIALIZER = 1;
    public static final int CB_OPTION_DIRECT = 1;
    public static final int CB_OPTION_IN_DLL = 2;
    private static final int CVT_ARRAY_BOOLEAN = 13;
    private static final int CVT_ARRAY_BYTE = 6;
    private static final int CVT_ARRAY_CHAR = 8;
    private static final int CVT_ARRAY_DOUBLE = 12;
    private static final int CVT_ARRAY_FLOAT = 11;
    private static final int CVT_ARRAY_INT = 9;
    private static final int CVT_ARRAY_LONG = 10;
    private static final int CVT_ARRAY_SHORT = 7;
    private static final int CVT_BOOLEAN = 14;
    private static final int CVT_BUFFER = 5;
    private static final int CVT_BYTE = 29;
    private static final int CVT_CALLBACK = 15;
    private static final int CVT_DEFAULT = 0;
    private static final int CVT_FLOAT = 16;
    private static final int CVT_INTEGER_TYPE = 21;
    private static final int CVT_JNIENV = 27;
    private static final int CVT_NATIVE_MAPPED = 17;
    private static final int CVT_NATIVE_MAPPED_STRING = 18;
    private static final int CVT_NATIVE_MAPPED_WSTRING = 19;
    private static final int CVT_OBJECT = 26;
    private static final int CVT_POINTER = 1;
    private static final int CVT_POINTER_TYPE = 22;
    private static final int CVT_SHORT = 28;
    private static final int CVT_STRING = 2;
    private static final int CVT_STRUCTURE = 3;
    private static final int CVT_STRUCTURE_BYVAL = 4;
    private static final int CVT_TYPE_MAPPER = 23;
    private static final int CVT_TYPE_MAPPER_STRING = 24;
    private static final int CVT_TYPE_MAPPER_WSTRING = 25;
    private static final int CVT_UNSUPPORTED = -1;
    private static final int CVT_WSTRING = 20;
    public static final boolean DEBUG_JNA_LOAD;
    private static final Level DEBUG_JNA_LOAD_LEVEL;
    public static final boolean DEBUG_LOAD;
    public static final Charset DEFAULT_CHARSET;
    public static final String DEFAULT_ENCODING;
    private static final Callback.UncaughtExceptionHandler DEFAULT_HANDLER;
    public static final String JNA_TMPLIB_PREFIX = "jna";
    private static final Logger LOG = Logger.getLogger(Native.class.getName());
    public static final int LONG_DOUBLE_SIZE;
    public static final int LONG_SIZE;
    public static final int MAX_ALIGNMENT;
    public static final int MAX_PADDING;
    public static final int POINTER_SIZE;
    public static final int SIZE_T_SIZE;
    private static final int TYPE_BOOL = 4;
    private static final int TYPE_LONG = 1;
    private static final int TYPE_LONG_DOUBLE = 5;
    private static final int TYPE_SIZE_T = 3;
    private static final int TYPE_VOIDP = 0;
    private static final int TYPE_WCHAR_T = 2;
    public static final int WCHAR_SIZE;
    private static final String _OPTION_ENCLOSING_LIBRARY = "enclosing-library";
    private static Callback.UncaughtExceptionHandler callbackExceptionHandler;
    private static final Object finalizer;
    public static String jnidispatchPath;
    private static final Map<Class<?>, Reference<?>> libraries;
    private static final ThreadLocal<Memory> nativeThreadTerminationFlag;
    private static final Map<Thread, Pointer> nativeThreads;
    private static final Map<Class<?>, long[]> registeredClasses;
    private static final Map<Class<?>, NativeLibrary> registeredLibraries;
    private static final Map<Class<?>, Map<String, Object>> typeOptions;

    public static class AWT {
        private AWT() {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.awt.HeadlessException */
        public static long getComponentID(Object obj) throws HeadlessException {
            if (GraphicsEnvironment.isHeadless()) {
                throw new HeadlessException("No native windows when headless");
            }
            Component component = (Component) obj;
            if (component.isLightweight()) {
                throw new IllegalArgumentException("Component must be heavyweight");
            }
            if (!component.isDisplayable()) {
                throw new IllegalStateException("Component must be displayable");
            }
            if (Platform.isX11() && System.getProperty("java.version").startsWith("1.4") && !component.isVisible()) {
                throw new IllegalStateException("Component must be visible");
            }
            return Native.getWindowHandle0(component);
        }

        public static long getWindowID(Window window) throws HeadlessException {
            return getComponentID(window);
        }
    }

    public static class Buffers {
        private Buffers() {
        }

        public static boolean isBuffer(Class<?> cls) {
            return Buffer.class.isAssignableFrom(cls);
        }
    }

    public interface ffi_callback {
        void invoke(long j, long j2, long j3);
    }

    static {
        Charset charsetForName;
        String property;
        String property2 = System.getProperty("native.encoding");
        if (property2 != null) {
            try {
                charsetForName = Charset.forName(property2);
            } catch (Exception e) {
                LOG.log(Level.WARNING, "Failed to get charset for native.encoding value : '" + property2 + "'", (Throwable) e);
            }
        } else {
            charsetForName = null;
        }
        if (charsetForName == null) {
            charsetForName = Charset.defaultCharset();
        }
        DEFAULT_CHARSET = charsetForName;
        DEFAULT_ENCODING = charsetForName.name();
        DEBUG_LOAD = Boolean.getBoolean("jna.debug_load");
        boolean z = Boolean.getBoolean("jna.debug_load.jna");
        DEBUG_JNA_LOAD = z;
        DEBUG_JNA_LOAD_LEVEL = z ? Level.INFO : Level.FINE;
        jnidispatchPath = null;
        typeOptions = Collections.synchronizedMap(new WeakHashMap());
        libraries = Collections.synchronizedMap(new WeakHashMap());
        Callback.UncaughtExceptionHandler uncaughtExceptionHandler = new Callback.UncaughtExceptionHandler() { // from class: com.sun.jna.Native.1
            @Override // com.sun.jna.Callback.UncaughtExceptionHandler
            public void uncaughtException(Callback callback, Throwable th) {
                Native.LOG.log(Level.WARNING, "JNA: Callback " + callback + " threw the following exception", th);
            }
        };
        DEFAULT_HANDLER = uncaughtExceptionHandler;
        callbackExceptionHandler = uncaughtExceptionHandler;
        loadNativeDispatchLibrary();
        if (isCompatibleVersion(Version.VERSION_NATIVE, getNativeVersion())) {
            POINTER_SIZE = sizeof(0);
            int iSizeof = sizeof(1);
            LONG_SIZE = iSizeof;
            WCHAR_SIZE = sizeof(2);
            SIZE_T_SIZE = sizeof(3);
            BOOL_SIZE = sizeof(4);
            LONG_DOUBLE_SIZE = sizeof(5);
            initIDs();
            if (Boolean.getBoolean("jna.protected")) {
                setProtected(true);
            }
            if (Platform.isSPARC() || Platform.isWindows() || ((Platform.isLinux() && (Platform.isARM() || Platform.isPPC() || Platform.isMIPS() || Platform.isLoongArch())) || Platform.isAIX() || (Platform.isAndroid() && !Platform.isIntel()))) {
                iSizeof = 8;
            }
            MAX_ALIGNMENT = iSizeof;
            MAX_PADDING = (Platform.isMac() && Platform.isPPC()) ? 8 : iSizeof;
            System.setProperty("jna.loaded", "true");
            finalizer = new Object() { // from class: com.sun.jna.Native.2
                public void finalize() throws Throwable {
                    Native.dispose();
                    super.finalize();
                }
            };
            registeredClasses = new WeakHashMap();
            registeredLibraries = new WeakHashMap();
            nativeThreadTerminationFlag = new ThreadLocal<Memory>() { // from class: com.sun.jna.Native.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                public Memory initialValue() {
                    Memory memory = new Memory(4L);
                    memory.clear();
                    return memory;
                }
            };
            nativeThreads = Collections.synchronizedMap(new WeakHashMap());
            return;
        }
        String property3 = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(property3);
        sb.append(property3);
        sb.append("There is an incompatible JNA native library installed on this system");
        sb.append(property3);
        sb.append("Expected: ");
        sb.append(Version.VERSION_NATIVE);
        sb.append(property3);
        sb.append("Found:    ");
        sb.append(getNativeVersion());
        sb.append(property3);
        if (jnidispatchPath != null) {
            property = "(at " + jnidispatchPath + ")";
        } else {
            property = System.getProperty("java.library.path");
        }
        sb.append(property);
        sb.append(".");
        sb.append(property3);
        sb.append("To resolve this issue you may do one of the following:");
        sb.append(property3);
        sb.append(" - remove or uninstall the offending library");
        sb.append(property3);
        sb.append(" - set the system property jna.nosys=true");
        sb.append(property3);
        sb.append(" - set jna.boot.library.path to include the path to the version of the ");
        sb.append(property3);
        sb.append("   jnidispatch library included with the JNA jar file you are using");
        sb.append(property3);
        throw new Error(sb.toString());
    }

    private Native() {
    }

    private static native long _getDirectBufferPointer(Buffer buffer);

    private static native long _getPointer(long j);

    private static Map<String, Object> cacheOptions(Class<?> cls, Map<String, ?> map, Object obj) {
        HashMap map2 = new HashMap(map);
        map2.put(_OPTION_ENCLOSING_LIBRARY, cls);
        typeOptions.put(cls, map2);
        if (obj != null) {
            libraries.put(cls, new WeakReference(obj));
        }
        if (!cls.isInterface() && Library.class.isAssignableFrom(cls)) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Class<?> cls2 = interfaces[i];
                if (Library.class.isAssignableFrom(cls2)) {
                    cacheOptions(cls2, map2, obj);
                    break;
                }
                i++;
            }
        }
        return map2;
    }

    public static native void close(long j);

    public static native synchronized long createNativeCallback(Callback callback, Method method, Class<?>[] clsArr, Class<?> cls, int i, int i2, String str);

    public static boolean deleteLibrary(File file) throws IOException {
        if (file.delete()) {
            return true;
        }
        markTemporaryFile(file);
        return false;
    }

    public static void detach(boolean z) {
        Thread threadCurrentThread = Thread.currentThread();
        if (z) {
            nativeThreads.remove(threadCurrentThread);
            nativeThreadTerminationFlag.get();
            setDetachState(true, 0L);
        } else {
            Map<Thread, Pointer> map = nativeThreads;
            if (map.containsKey(threadCurrentThread)) {
                return;
            }
            Memory memory = nativeThreadTerminationFlag.get();
            map.put(threadCurrentThread, memory);
            setDetachState(false, memory.peer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispose() {
        CallbackReference.disposeAll();
        Memory.disposeAll();
        NativeLibrary.disposeAll();
        unregisterAll();
        jnidispatchPath = null;
        System.setProperty("jna.loaded", "false");
    }

    public static File extractFromResourcePath(String str) throws IOException {
        return extractFromResourcePath(str, null);
    }

    public static native void ffi_call(long j, long j2, long j3, long j4);

    public static native void ffi_free_closure(long j);

    public static native long ffi_prep_cif(int i, int i2, long j, long j2);

    public static native long ffi_prep_closure(long j, ffi_callback ffi_callbackVar);

    public static Class<?> findDirectMappedClass(Class<?> cls) throws SecurityException {
        for (Method method : cls.getDeclaredMethods()) {
            if ((method.getModifiers() & 256) != 0) {
                return cls;
            }
        }
        int iLastIndexOf = cls.getName().lastIndexOf("$");
        if (iLastIndexOf != -1) {
            try {
                return findDirectMappedClass(Class.forName(cls.getName().substring(0, iLastIndexOf), true, cls.getClassLoader()));
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new IllegalArgumentException("Can't determine class with native methods from the current context (" + cls + ")");
    }

    public static Class<?> findEnclosingLibraryClass(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Map<String, Object> map = typeOptions.get(cls);
        if (map != null) {
            Class<?> cls2 = (Class) map.get(_OPTION_ENCLOSING_LIBRARY);
            return cls2 != null ? cls2 : cls;
        }
        if (Library.class.isAssignableFrom(cls)) {
            return cls;
        }
        if (Callback.class.isAssignableFrom(cls)) {
            cls = CallbackReference.findCallbackClass(cls);
        }
        Class<?> clsFindEnclosingLibraryClass = findEnclosingLibraryClass(cls.getDeclaringClass());
        return clsFindEnclosingLibraryClass != null ? clsFindEnclosingLibraryClass : findEnclosingLibraryClass(cls.getSuperclass());
    }

    public static native long findSymbol(long j, String str);

    public static native void free(long j);

    public static native synchronized void freeNativeCallback(long j);

    private static NativeMapped fromNative(Class<?> cls, Object obj) {
        return (NativeMapped) NativeMappedConverter.getInstance(cls).fromNative(obj, new FromNativeContext(cls));
    }

    private static native String getAPIChecksum();

    public static native byte getByte(Pointer pointer, long j, long j2);

    public static byte[] getBytes(String str) {
        return getBytes(str, getDefaultStringEncoding());
    }

    public static Callback.UncaughtExceptionHandler getCallbackExceptionHandler() {
        return callbackExceptionHandler;
    }

    public static Class<?> getCallingClass() {
        Class<?>[] classContext = new SecurityManager() { // from class: com.sun.jna.Native.6
            @Override // java.lang.SecurityManager
            public Class<?>[] getClassContext() {
                return super.getClassContext();
            }
        }.getClassContext();
        if (classContext == null) {
            throw new IllegalStateException("The SecurityManager implementation on this platform is broken; you must explicitly provide the class to register");
        }
        if (classContext.length >= 4) {
            return classContext[3];
        }
        throw new IllegalStateException("This method must be called from the static initializer of a class");
    }

    public static native char getChar(Pointer pointer, long j, long j2);

    private static Charset getCharset(String str) {
        Charset charsetForName;
        if (str != null) {
            try {
                charsetForName = Charset.forName(str);
            } catch (IllegalCharsetNameException e) {
                LOG.log(Level.WARNING, "JNA Warning: Encoding ''{0}'' is unsupported ({1})", new Object[]{str, e.getMessage()});
            } catch (UnsupportedCharsetException e2) {
                LOG.log(Level.WARNING, "JNA Warning: Encoding ''{0}'' is unsupported ({1})", new Object[]{str, e2.getMessage()});
            }
        } else {
            charsetForName = null;
        }
        if (charsetForName != null) {
            return charsetForName;
        }
        Logger logger = LOG;
        Level level = Level.WARNING;
        Charset charset = DEFAULT_CHARSET;
        logger.log(level, "JNA Warning: Using fallback encoding {0}", charset);
        return charset;
    }

    public static long getComponentID(Component component) throws HeadlessException {
        return AWT.getComponentID(component);
    }

    public static Pointer getComponentPointer(Component component) throws HeadlessException {
        return new Pointer(AWT.getComponentID(component));
    }

    private static int getConversion(Class<?> cls, TypeMapper typeMapper, boolean z) {
        if (cls == Void.class) {
            cls = Void.TYPE;
        }
        if (typeMapper != null) {
            FromNativeConverter fromNativeConverter = typeMapper.getFromNativeConverter(cls);
            ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(cls);
            if (fromNativeConverter != null) {
                Class<?> clsNativeType = fromNativeConverter.nativeType();
                if (clsNativeType == String.class) {
                    return 24;
                }
                return clsNativeType == WString.class ? 25 : 23;
            }
            if (toNativeConverter != null) {
                Class<?> clsNativeType2 = toNativeConverter.nativeType();
                if (clsNativeType2 == String.class) {
                    return 24;
                }
                return clsNativeType2 == WString.class ? 25 : 23;
            }
        }
        if (Pointer.class.isAssignableFrom(cls)) {
            return 1;
        }
        if (String.class == cls) {
            return 2;
        }
        if (WString.class.isAssignableFrom(cls)) {
            return 20;
        }
        if (Platform.HAS_BUFFERS && Buffers.isBuffer(cls)) {
            return 5;
        }
        if (Structure.class.isAssignableFrom(cls)) {
            return Structure.ByValue.class.isAssignableFrom(cls) ? 4 : 3;
        }
        if (cls.isArray()) {
            char cCharAt = cls.getName().charAt(1);
            if (cCharAt == 'F') {
                return 11;
            }
            if (cCharAt == 'S') {
                return 7;
            }
            if (cCharAt == 'Z') {
                return 13;
            }
            if (cCharAt == 'I') {
                return 9;
            }
            if (cCharAt == 'J') {
                return 10;
            }
            switch (cCharAt) {
                case 'B':
                    return 6;
                case 'C':
                    return 8;
                case 'D':
                    return 12;
            }
        }
        if (cls.isPrimitive()) {
            return cls == Boolean.TYPE ? 14 : 0;
        }
        if (Callback.class.isAssignableFrom(cls)) {
            return 15;
        }
        if (IntegerType.class.isAssignableFrom(cls)) {
            return 21;
        }
        if (PointerType.class.isAssignableFrom(cls)) {
            return 22;
        }
        if (!NativeMapped.class.isAssignableFrom(cls)) {
            if (JNIEnv.class == cls) {
                return 27;
            }
            return z ? 26 : -1;
        }
        Class<?> clsNativeType3 = NativeMappedConverter.getInstance(cls).nativeType();
        if (clsNativeType3 == String.class) {
            return 18;
        }
        return clsNativeType3 == WString.class ? 19 : 17;
    }

    public static String getDefaultStringEncoding() {
        return System.getProperty("jna.encoding", DEFAULT_ENCODING);
    }

    public static Pointer getDirectBufferPointer(Buffer buffer) {
        long j_getDirectBufferPointer = _getDirectBufferPointer(buffer);
        if (j_getDirectBufferPointer == 0) {
            return null;
        }
        return new Pointer(j_getDirectBufferPointer);
    }

    public static native ByteBuffer getDirectByteBuffer(Pointer pointer, long j, long j2, long j3);

    public static native double getDouble(Pointer pointer, long j, long j2);

    public static native float getFloat(Pointer pointer, long j, long j2);

    public static native int getInt(Pointer pointer, long j, long j2);

    public static native int getLastError();

    public static Map<String, Object> getLibraryOptions(Class<?> cls) throws NoSuchFieldException, SecurityException {
        Map mapEmptyMap;
        Map<Class<?>, Map<String, Object>> map = typeOptions;
        Map<String, Object> map2 = map.get(cls);
        if (map2 != null) {
            return map2;
        }
        Class<?> clsFindEnclosingLibraryClass = findEnclosingLibraryClass(cls);
        if (clsFindEnclosingLibraryClass != null) {
            loadLibraryInstance(clsFindEnclosingLibraryClass);
        } else {
            clsFindEnclosingLibraryClass = cls;
        }
        Map<String, Object> map3 = map.get(clsFindEnclosingLibraryClass);
        if (map3 != null) {
            map.put(cls, map3);
            return map3;
        }
        try {
            Field field = clsFindEnclosingLibraryClass.getField("OPTIONS");
            field.setAccessible(true);
            mapEmptyMap = (Map) field.get(null);
        } catch (NoSuchFieldException unused) {
            mapEmptyMap = Collections.emptyMap();
        } catch (Exception e) {
            throw new IllegalArgumentException("OPTIONS must be a public field of type java.util.Map (" + e + "): " + clsFindEnclosingLibraryClass);
        }
        if (mapEmptyMap == null) {
            throw new IllegalStateException("Null options field");
        }
        HashMap map4 = new HashMap(mapEmptyMap);
        if (!map4.containsKey(Library.OPTION_TYPE_MAPPER)) {
            map4.put(Library.OPTION_TYPE_MAPPER, lookupField(clsFindEnclosingLibraryClass, "TYPE_MAPPER", TypeMapper.class));
        }
        if (!map4.containsKey(Library.OPTION_STRUCTURE_ALIGNMENT)) {
            map4.put(Library.OPTION_STRUCTURE_ALIGNMENT, lookupField(clsFindEnclosingLibraryClass, "STRUCTURE_ALIGNMENT", Integer.class));
        }
        if (!map4.containsKey(Library.OPTION_STRING_ENCODING)) {
            map4.put(Library.OPTION_STRING_ENCODING, lookupField(clsFindEnclosingLibraryClass, "STRING_ENCODING", String.class));
        }
        Map<String, Object> mapCacheOptions = cacheOptions(clsFindEnclosingLibraryClass, map4, null);
        if (cls != clsFindEnclosingLibraryClass) {
            typeOptions.put(cls, mapCacheOptions);
        }
        return mapCacheOptions;
    }

    public static native long getLong(Pointer pointer, long j, long j2);

    public static int getNativeSize(Class<?> cls, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            if (length > 0) {
                return length * getNativeSize(cls.getComponentType(), Array.get(obj, 0));
            }
            throw new IllegalArgumentException("Arrays of length zero not allowed: " + cls);
        }
        if (Structure.class.isAssignableFrom(cls) && !Structure.ByReference.class.isAssignableFrom(cls)) {
            return Structure.size(cls, (Structure) obj);
        }
        try {
            return getNativeSize(cls);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The type \"" + cls.getName() + "\" is not supported: " + e.getMessage());
        }
    }

    private static native String getNativeVersion();

    public static Pointer getPointer(long j) {
        long j_getPointer = _getPointer(j);
        if (j_getPointer == 0) {
            return null;
        }
        return new Pointer(j_getPointer);
    }

    public static native short getShort(Pointer pointer, long j, long j2);

    public static String getSignature(Class<?> cls) {
        if (cls.isArray()) {
            return "[" + getSignature(cls.getComponentType());
        }
        if (cls.isPrimitive()) {
            if (cls == Void.TYPE) {
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            }
            if (cls == Boolean.TYPE) {
                return "Z";
            }
            if (cls == Byte.TYPE) {
                return "B";
            }
            if (cls == Short.TYPE) {
                return ExifInterface.LATITUDE_SOUTH;
            }
            if (cls == Character.TYPE) {
                return "C";
            }
            if (cls == Integer.TYPE) {
                return "I";
            }
            if (cls == Long.TYPE) {
                return "J";
            }
            if (cls == Float.TYPE) {
                return "F";
            }
            if (cls == Double.TYPE) {
                return "D";
            }
        }
        return "L" + replace(".", "/", cls.getName()) + ";";
    }

    public static String getString(Pointer pointer, long j) {
        return getString(pointer, j, getDefaultStringEncoding());
    }

    public static native byte[] getStringBytes(Pointer pointer, long j, long j2);

    public static String getStringEncoding(Class<?> cls) {
        String str = (String) getLibraryOptions(cls).get(Library.OPTION_STRING_ENCODING);
        return str != null ? str : getDefaultStringEncoding();
    }

    public static int getStructureAlignment(Class<?> cls) {
        Integer num = (Integer) getLibraryOptions(cls).get(Library.OPTION_STRUCTURE_ALIGNMENT);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static File getTempDir() throws IOException {
        File file;
        File file2;
        String property = System.getProperty("jna.tmpdir");
        if (property != null) {
            file = new File(property);
            file.mkdirs();
        } else {
            file = new File(System.getProperty("java.io.tmpdir"));
            if (Platform.isMac()) {
                file2 = new File(System.getProperty("user.home"), "Library/Caches/JNA/temp");
            } else if (Platform.isLinux() || Platform.isSolaris() || Platform.isAIX() || Platform.isFreeBSD() || Platform.isNetBSD() || Platform.isOpenBSD() || Platform.iskFreeBSD()) {
                String str = System.getenv("XDG_CACHE_HOME");
                file2 = new File((str == null || str.trim().isEmpty()) ? new File(System.getProperty("user.home"), ".cache") : new File(str), "JNA/temp");
            } else {
                file2 = new File(file, "jna-" + System.getProperty("user.name").hashCode());
            }
            file2.mkdirs();
            if (file2.exists() && file2.canWrite()) {
                file = file2;
            }
        }
        if (!file.exists()) {
            throw new IOException("JNA temporary directory '" + file + "' does not exist");
        }
        if (file.canWrite()) {
            return file;
        }
        throw new IOException("JNA temporary directory '" + file + "' is not writable");
    }

    public static Pointer getTerminationFlag(Thread thread) {
        return nativeThreads.get(thread);
    }

    public static TypeMapper getTypeMapper(Class<?> cls) {
        return (TypeMapper) getLibraryOptions(cls).get(Library.OPTION_TYPE_MAPPER);
    }

    public static String getWebStartLibraryPath(String str) {
        if (System.getProperty("javawebstart.version") == null) {
            return null;
        }
        try {
            String str2 = (String) ((Method) AccessController.doPrivileged(new PrivilegedAction<Method>() { // from class: com.sun.jna.Native.4
                @Override // java.security.PrivilegedAction
                public Method run() throws NoSuchMethodException, SecurityException {
                    try {
                        Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                        declaredMethod.setAccessible(true);
                        return declaredMethod;
                    } catch (Exception unused) {
                        return null;
                    }
                }
            })).invoke(Native.class.getClassLoader(), str);
            if (str2 != null) {
                return new File(str2).getParent();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static native String getWideString(Pointer pointer, long j, long j2);

    public static native long getWindowHandle0(Component component);

    public static long getWindowID(Window window) throws HeadlessException {
        return AWT.getWindowID(window);
    }

    public static Pointer getWindowPointer(Window window) throws HeadlessException {
        return new Pointer(AWT.getWindowID(window));
    }

    public static native long indexOf(Pointer pointer, long j, long j2, byte b);

    private static native void initIDs();

    public static native int initialize_ffi_type(long j);

    public static native double invokeDouble(Function function, long j, int i, Object[] objArr);

    public static native float invokeFloat(Function function, long j, int i, Object[] objArr);

    public static native int invokeInt(Function function, long j, int i, Object[] objArr);

    public static native long invokeLong(Function function, long j, int i, Object[] objArr);

    public static native Object invokeObject(Function function, long j, int i, Object[] objArr);

    public static native long invokePointer(Function function, long j, int i, Object[] objArr);

    public static Structure invokeStructure(Function function, long j, int i, Object[] objArr, Structure structure) {
        invokeStructure(function, j, i, objArr, structure.getPointer().peer, structure.getTypeInfo().peer);
        return structure;
    }

    private static native void invokeStructure(Function function, long j, int i, Object[] objArr, long j2, long j3);

    public static native void invokeVoid(Function function, long j, int i, Object[] objArr);

    public static boolean isCompatibleVersion(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        if (strArrSplit.length < 3 || strArrSplit2.length < 3) {
            return false;
        }
        return Integer.parseInt(strArrSplit[0]) == Integer.parseInt(strArrSplit2[0]) && Integer.parseInt(strArrSplit[1]) <= Integer.parseInt(strArrSplit2[1]);
    }

    public static native synchronized boolean isProtected();

    public static boolean isSupportedNativeType(Class<?> cls) {
        if (Structure.class.isAssignableFrom(cls)) {
            return true;
        }
        try {
            return getNativeSize(cls) != 0;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean isUnpacked(File file) {
        return file.getName().startsWith(JNA_TMPLIB_PREFIX);
    }

    public static <T extends Library> T load(Class<T> cls) {
        return (T) load((String) null, cls);
    }

    @Deprecated
    public static <T> T loadLibrary(Class<T> cls) {
        return (T) loadLibrary((String) null, cls);
    }

    private static void loadLibraryInstance(Class<?> cls) throws SecurityException {
        if (cls == null || libraries.containsKey(cls)) {
            return;
        }
        try {
            for (Field field : cls.getFields()) {
                if (field.getType() == cls && Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    libraries.put(cls, new WeakReference(field.get(null)));
                    return;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not access instance of " + cls + " (" + e + ")");
        }
    }

    private static void loadNativeDispatchLibrary() throws Throwable {
        if (!Boolean.getBoolean("jna.nounpack")) {
            try {
                removeTemporaryFiles();
            } catch (IOException e) {
                LOG.log(Level.WARNING, "JNA Warning: IOException removing temporary files", (Throwable) e);
            }
        }
        String property = System.getProperty("jna.boot.library.name", "jnidispatch");
        String property2 = System.getProperty("jna.boot.library.path");
        if (property2 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property2, File.pathSeparator);
            while (stringTokenizer.hasMoreTokens()) {
                File file = new File(new File(stringTokenizer.nextToken()), System.mapLibraryName(property).replace(".dylib", ".jnilib"));
                String absolutePath = file.getAbsolutePath();
                Logger logger = LOG;
                Level level = DEBUG_JNA_LOAD_LEVEL;
                logger.log(level, "Looking in {0}", absolutePath);
                if (file.exists()) {
                    try {
                        logger.log(level, "Trying {0}", absolutePath);
                        System.setProperty("jnidispatch.path", absolutePath);
                        System.load(absolutePath);
                        jnidispatchPath = absolutePath;
                        logger.log(level, "Found jnidispatch at {0}", absolutePath);
                        return;
                    } catch (UnsatisfiedLinkError unused) {
                    }
                }
                if (Platform.isMac()) {
                    String str = "dylib";
                    String str2 = "jnilib";
                    if (!absolutePath.endsWith("dylib")) {
                        str2 = "dylib";
                        str = "jnilib";
                    }
                    String str3 = absolutePath.substring(0, absolutePath.lastIndexOf(str)) + str2;
                    Logger logger2 = LOG;
                    Level level2 = DEBUG_JNA_LOAD_LEVEL;
                    logger2.log(level2, "Looking in {0}", str3);
                    if (new File(str3).exists()) {
                        try {
                            logger2.log(level2, "Trying {0}", str3);
                            System.setProperty("jnidispatch.path", str3);
                            System.load(str3);
                            jnidispatchPath = str3;
                            logger2.log(level2, "Found jnidispatch at {0}", str3);
                            return;
                        } catch (UnsatisfiedLinkError e2) {
                            LOG.log(Level.WARNING, "File found at " + str3 + " but not loadable: " + e2.getMessage(), (Throwable) e2);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (!Boolean.parseBoolean(System.getProperty("jna.nosys", "true")) || Platform.isAndroid()) {
            try {
                Logger logger3 = LOG;
                Level level3 = DEBUG_JNA_LOAD_LEVEL;
                logger3.log(level3, "Trying (via loadLibrary) {0}", property);
                System.loadLibrary(property);
                logger3.log(level3, "Found jnidispatch on system path");
                return;
            } catch (UnsatisfiedLinkError unused2) {
            }
        }
        if (Boolean.getBoolean("jna.noclasspath")) {
            throw new UnsatisfiedLinkError("Unable to locate JNA native support library");
        }
        loadNativeDispatchLibraryFromClasspath();
    }

    private static void loadNativeDispatchLibraryFromClasspath() throws Throwable {
        try {
            String strReplace = System.mapLibraryName("jnidispatch").replace(".dylib", ".jnilib");
            if (Platform.isAIX()) {
                strReplace = "libjnidispatch.a";
            }
            File fileExtractFromResourcePath = extractFromResourcePath("/com/sun/jna/" + Platform.RESOURCE_PREFIX + "/" + strReplace, Native.class.getClassLoader());
            if (fileExtractFromResourcePath == null && fileExtractFromResourcePath == null) {
                throw new UnsatisfiedLinkError("Could not find JNA native support");
            }
            Logger logger = LOG;
            Level level = DEBUG_JNA_LOAD_LEVEL;
            logger.log(level, "Trying {0}", fileExtractFromResourcePath.getAbsolutePath());
            System.setProperty("jnidispatch.path", fileExtractFromResourcePath.getAbsolutePath());
            System.load(fileExtractFromResourcePath.getAbsolutePath());
            String absolutePath = fileExtractFromResourcePath.getAbsolutePath();
            jnidispatchPath = absolutePath;
            logger.log(level, "Found jnidispatch at {0}", absolutePath);
            if (!isUnpacked(fileExtractFromResourcePath) || Boolean.getBoolean("jnidispatch.preserve")) {
                return;
            }
            deleteLibrary(fileExtractFromResourcePath);
        } catch (IOException e) {
            throw new UnsatisfiedLinkError(e.getMessage());
        }
    }

    private static Object lookupField(Class<?> cls, String str, Class<?> cls2) throws NoSuchFieldException {
        try {
            Field field = cls.getField(str);
            field.setAccessible(true);
            return field.get(null);
        } catch (NoSuchFieldException unused) {
            return null;
        } catch (Exception e) {
            throw new IllegalArgumentException(str + " must be a public field of type " + cls2.getName() + " (" + e + "): " + cls);
        }
    }

    public static void main(String[] strArr) {
        Package r3 = Native.class.getPackage();
        String specificationTitle = r3 != null ? r3.getSpecificationTitle() : "Java Native Access (JNA)";
        String str = specificationTitle != null ? specificationTitle : "Java Native Access (JNA)";
        String str2 = Version.VERSION;
        String specificationVersion = r3 != null ? r3.getSpecificationVersion() : Version.VERSION;
        if (specificationVersion != null) {
            str2 = specificationVersion;
        }
        System.out.println(str + " API Version " + str2);
        String implementationVersion = r3 != null ? r3.getImplementationVersion() : "5.13.0 (package information missing)";
        String str3 = implementationVersion != null ? implementationVersion : "5.13.0 (package information missing)";
        System.out.println("Version: " + str3);
        System.out.println(" Native: " + getNativeVersion() + " (" + getAPIChecksum() + ")");
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(" Prefix: ");
        sb.append(Platform.RESOURCE_PREFIX);
        printStream.println(sb.toString());
    }

    public static native long malloc(long j);

    public static void markTemporaryFile(File file) throws IOException {
        try {
            new File(file.getParentFile(), file.getName() + ".x").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Class<?> nativeType(Class<?> cls) {
        return NativeMappedConverter.getInstance(cls).nativeType();
    }

    public static long open(String str) {
        return open(str, -1);
    }

    public static native long open(String str, int i);

    public static native void read(Pointer pointer, long j, long j2, byte[] bArr, int i, int i2);

    public static native void read(Pointer pointer, long j, long j2, char[] cArr, int i, int i2);

    public static native void read(Pointer pointer, long j, long j2, double[] dArr, int i, int i2);

    public static native void read(Pointer pointer, long j, long j2, float[] fArr, int i, int i2);

    public static native void read(Pointer pointer, long j, long j2, int[] iArr, int i, int i2);

    public static native void read(Pointer pointer, long j, long j2, long[] jArr, int i, int i2);

    public static native void read(Pointer pointer, long j, long j2, short[] sArr, int i, int i2);

    public static void register(String str) throws SecurityException {
        register(findDirectMappedClass(getCallingClass()), str);
    }

    private static native long registerMethod(Class<?> cls, String str, String str2, int[] iArr, long[] jArr, long[] jArr2, int i, long j, long j2, Method method, long j3, int i2, boolean z, ToNativeConverter[] toNativeConverterArr, FromNativeConverter fromNativeConverter, String str3);

    public static boolean registered(Class<?> cls) {
        boolean zContainsKey;
        Map<Class<?>, long[]> map = registeredClasses;
        synchronized (map) {
            zContainsKey = map.containsKey(cls);
        }
        return zContainsKey;
    }

    public static void removeTemporaryFiles() throws IOException {
        File[] fileArrListFiles = getTempDir().listFiles(new FilenameFilter() { // from class: com.sun.jna.Native.5
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".x") && str.startsWith(Native.JNA_TMPLIB_PREFIX);
            }
        });
        for (int i = 0; fileArrListFiles != null && i < fileArrListFiles.length; i++) {
            File file = fileArrListFiles[i];
            File file2 = new File(file.getParentFile(), file.getName().substring(0, r4.length() - 2));
            if (!file2.exists() || file2.delete()) {
                file.delete();
            }
        }
    }

    public static String replace(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int iIndexOf = str3.indexOf(str);
            if (iIndexOf == -1) {
                sb.append(str3);
                return sb.toString();
            }
            sb.append(str3.substring(0, iIndexOf));
            sb.append(str2);
            str3 = str3.substring(iIndexOf + str.length());
        }
    }

    public static native void setByte(Pointer pointer, long j, long j2, byte b);

    public static void setCallbackExceptionHandler(Callback.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            uncaughtExceptionHandler = DEFAULT_HANDLER;
        }
        callbackExceptionHandler = uncaughtExceptionHandler;
    }

    public static void setCallbackThreadInitializer(Callback callback, CallbackThreadInitializer callbackThreadInitializer) {
        CallbackReference.setCallbackThreadInitializer(callback, callbackThreadInitializer);
    }

    public static native void setChar(Pointer pointer, long j, long j2, char c);

    private static native void setDetachState(boolean z, long j);

    public static native void setDouble(Pointer pointer, long j, long j2, double d);

    public static native void setFloat(Pointer pointer, long j, long j2, float f);

    public static native void setInt(Pointer pointer, long j, long j2, int i);

    public static native void setLastError(int i);

    public static native void setLong(Pointer pointer, long j, long j2, long j3);

    public static native void setMemory(Pointer pointer, long j, long j2, long j3, byte b);

    public static native void setPointer(Pointer pointer, long j, long j2, long j3);

    public static native synchronized void setProtected(boolean z);

    public static native void setShort(Pointer pointer, long j, long j2, short s);

    public static native void setWideString(Pointer pointer, long j, long j2, String str);

    private static native int sizeof(int i);

    public static Library synchronizedLibrary(final Library library) throws IllegalArgumentException {
        Class<?> cls = library.getClass();
        if (!Proxy.isProxyClass(cls)) {
            throw new IllegalArgumentException("Library must be a proxy class");
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(library);
        if (invocationHandler instanceof Library.Handler) {
            final Library.Handler handler = (Library.Handler) invocationHandler;
            return (Library) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new InvocationHandler() { // from class: com.sun.jna.Native.3
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    Object objInvoke;
                    synchronized (handler.getNativeLibrary()) {
                        objInvoke = handler.invoke(library, method, objArr);
                    }
                    return objInvoke;
                }
            });
        }
        throw new IllegalArgumentException("Unrecognized proxy handler: " + invocationHandler);
    }

    public static byte[] toByteArray(String str) {
        return toByteArray(str, getDefaultStringEncoding());
    }

    public static char[] toCharArray(String str) {
        char[] charArray = str.toCharArray();
        char[] cArr = new char[charArray.length + 1];
        System.arraycopy(charArray, 0, cArr, 0, charArray.length);
        return cArr;
    }

    private static Object toNative(ToNativeConverter toNativeConverter, Object obj) {
        return toNativeConverter.toNative(obj, new ToNativeContext());
    }

    public static String toString(byte[] bArr) {
        return toString(bArr, getDefaultStringEncoding());
    }

    public static List<String> toStringList(char[] cArr) {
        return toStringList(cArr, 0, cArr.length);
    }

    public static void unregister() {
        unregister(findDirectMappedClass(getCallingClass()));
    }

    private static native void unregister(Class<?> cls, long[] jArr);

    private static void unregisterAll() {
        Map<Class<?>, long[]> map = registeredClasses;
        synchronized (map) {
            for (Map.Entry<Class<?>, long[]> entry : map.entrySet()) {
                unregister(entry.getKey(), entry.getValue());
            }
            registeredClasses.clear();
        }
    }

    public static native void write(Pointer pointer, long j, long j2, byte[] bArr, int i, int i2);

    public static native void write(Pointer pointer, long j, long j2, char[] cArr, int i, int i2);

    public static native void write(Pointer pointer, long j, long j2, double[] dArr, int i, int i2);

    public static native void write(Pointer pointer, long j, long j2, float[] fArr, int i, int i2);

    public static native void write(Pointer pointer, long j, long j2, int[] iArr, int i, int i2);

    public static native void write(Pointer pointer, long j, long j2, long[] jArr, int i, int i2);

    public static native void write(Pointer pointer, long j, long j2, short[] sArr, int i, int i2);

    public static File extractFromResourcePath(String str, ClassLoader classLoader) throws Throwable {
        String strSubstring;
        File file;
        Level level = (DEBUG_LOAD || (DEBUG_JNA_LOAD && str.contains("jnidispatch"))) ? Level.INFO : Level.FINE;
        if (classLoader == null && (classLoader = Thread.currentThread().getContextClassLoader()) == null) {
            classLoader = Native.class.getClassLoader();
        }
        Logger logger = LOG;
        logger.log(level, "Looking in classpath from {0} for {1}", new Object[]{classLoader, str});
        String strMapSharedLibraryName = str.startsWith("/") ? str : NativeLibrary.mapSharedLibraryName(str);
        if (str.startsWith("/")) {
            strSubstring = str;
        } else {
            strSubstring = Platform.RESOURCE_PREFIX + "/" + strMapSharedLibraryName;
        }
        if (strSubstring.startsWith("/")) {
            strSubstring = strSubstring.substring(1);
        }
        URL resource = classLoader.getResource(strSubstring);
        if (resource == null) {
            String str2 = Platform.RESOURCE_PREFIX;
            if (strSubstring.startsWith(str2)) {
                if (str2.startsWith("darwin")) {
                    resource = classLoader.getResource("darwin/" + strSubstring.substring(str2.length() + 1));
                }
                if (resource == null) {
                    resource = classLoader.getResource(strMapSharedLibraryName);
                }
            } else {
                if (strSubstring.startsWith("com/sun/jna/" + str2 + "/")) {
                    if (str2.startsWith("com/sun/jna/darwin")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("com/sun/jna/darwin");
                        sb.append(strSubstring.substring(("com/sun/jna/" + str2).length() + 1));
                        resource = classLoader.getResource(sb.toString());
                    }
                    if (resource == null) {
                        resource = classLoader.getResource(strMapSharedLibraryName);
                    }
                }
            }
        }
        if (resource == null) {
            String property = System.getProperty("java.class.path");
            if (classLoader instanceof URLClassLoader) {
                property = Arrays.asList(((URLClassLoader) classLoader).getURLs()).toString();
            }
            throw new IOException("Native library (" + strSubstring + ") not found in resource path (" + property + ")");
        }
        logger.log(level, "Found library resource at {0}", resource);
        FileOutputStream fileOutputStream = null;
        if (resource.getProtocol().toLowerCase().equals("file")) {
            try {
                file = new File(new URI(resource.toString()));
            } catch (URISyntaxException unused) {
                file = new File(resource.getPath());
            }
            File file2 = file;
            LOG.log(level, "Looking in {0}", file2.getAbsolutePath());
            if (file2.exists()) {
                return file2;
            }
            throw new IOException("File URL " + resource + " could not be properly decoded");
        }
        if (Boolean.getBoolean("jna.nounpack")) {
            return null;
        }
        InputStream inputStreamOpenStream = resource.openStream();
        if (inputStreamOpenStream == null) {
            throw new IOException("Can't obtain InputStream for " + strSubstring);
        }
        try {
            try {
                File fileCreateTempFile = File.createTempFile(JNA_TMPLIB_PREFIX, Platform.isWindows() ? ".dll" : null, getTempDir());
                if (!Boolean.getBoolean("jnidispatch.preserve")) {
                    fileCreateTempFile.deleteOnExit();
                }
                logger.log(level, "Extracting library to {0}", fileCreateTempFile.getAbsolutePath());
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileCreateTempFile);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamOpenStream.read(bArr, 0, 1024);
                        if (i > 0) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException unused2) {
                            }
                        }
                    }
                    inputStreamOpenStream.close();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                    return fileCreateTempFile;
                } catch (IOException e) {
                    fileOutputStream = fileOutputStream2;
                    e = e;
                    throw new IOException("Failed to create temporary file for " + str + " library: " + e.getMessage());
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        inputStreamOpenStream.close();
                    } catch (IOException unused4) {
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException unused5) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private static NativeMapped fromNative(Method method, Object obj) {
        Class<?> returnType = method.getReturnType();
        return (NativeMapped) NativeMappedConverter.getInstance(returnType).fromNative(obj, new MethodResultContext(returnType, null, null, method));
    }

    public static byte[] getBytes(String str, String str2) {
        return getBytes(str, getCharset(str2));
    }

    public static String getString(Pointer pointer, long j, String str) {
        byte[] stringBytes = getStringBytes(pointer, pointer.peer, j);
        if (str != null) {
            try {
                return new String(stringBytes, str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new String(stringBytes);
    }

    public static <T extends Library> T load(Class<T> cls, Map<String, ?> map) {
        return (T) load(null, cls, map);
    }

    @Deprecated
    public static <T> T loadLibrary(Class<T> cls, Map<String, ?> map) {
        return (T) loadLibrary(null, cls, map);
    }

    public static void register(NativeLibrary nativeLibrary) throws SecurityException {
        register(findDirectMappedClass(getCallingClass()), nativeLibrary);
    }

    public static byte[] toByteArray(String str, String str2) {
        return toByteArray(str, getCharset(str2));
    }

    public static String toString(byte[] bArr, String str) {
        return toString(bArr, getCharset(str));
    }

    public static List<String> toStringList(char[] cArr, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            if (cArr[i] == 0) {
                if (i4 == i) {
                    return arrayList;
                }
                arrayList.add(new String(cArr, i4, i - i4));
                i4 = i + 1;
            }
            i++;
        }
        if (i4 < i3) {
            arrayList.add(new String(cArr, i4, i3 - i4));
        }
        return arrayList;
    }

    public static void unregister(Class<?> cls) {
        Map<Class<?>, long[]> map = registeredClasses;
        synchronized (map) {
            long[] jArr = map.get(cls);
            if (jArr != null) {
                unregister(cls, jArr);
                map.remove(cls);
                registeredLibraries.remove(cls);
            }
        }
    }

    public static byte[] getBytes(String str, Charset charset) {
        return str.getBytes(charset);
    }

    public static <T extends Library> T load(String str, Class<T> cls) {
        return (T) load(str, cls, Collections.emptyMap());
    }

    @Deprecated
    public static <T> T loadLibrary(String str, Class<T> cls) {
        return (T) loadLibrary(str, cls, Collections.emptyMap());
    }

    public static void register(Class<?> cls, String str) throws SecurityException {
        register(cls, NativeLibrary.getInstance(str, (Map<String, ?>) Collections.singletonMap(Library.OPTION_CLASSLOADER, cls.getClassLoader())));
    }

    public static byte[] toByteArray(String str, Charset charset) {
        byte[] bytes = getBytes(str, charset);
        byte[] bArr = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    public static String toString(byte[] bArr, Charset charset) {
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (bArr[i] == 0) {
                length = i;
                break;
            }
            i++;
        }
        return length == 0 ? "" : new String(bArr, 0, length, charset);
    }

    private static Object fromNative(FromNativeConverter fromNativeConverter, Object obj, Method method) {
        return fromNativeConverter.fromNative(obj, new MethodResultContext(method.getReturnType(), null, null, method));
    }

    public static <T extends Library> T load(String str, Class<T> cls, Map<String, ?> map) throws IllegalArgumentException {
        if (Library.class.isAssignableFrom(cls)) {
            Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new Library.Handler(str, cls, map));
            cacheOptions(cls, map, objNewProxyInstance);
            return cls.cast(objNewProxyInstance);
        }
        throw new IllegalArgumentException("Interface (" + cls.getSimpleName() + ") of library=" + str + " does not extend " + Library.class.getSimpleName());
    }

    @Deprecated
    public static <T> T loadLibrary(String str, Class<T> cls, Map<String, ?> map) throws IllegalArgumentException {
        if (Library.class.isAssignableFrom(cls)) {
            Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new Library.Handler(str, cls, map));
            cacheOptions(cls, map, objNewProxyInstance);
            return cls.cast(objNewProxyInstance);
        }
        throw new IllegalArgumentException("Interface (" + cls.getSimpleName() + ") of library=" + str + " does not extend " + Library.class.getSimpleName());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b8 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void register(java.lang.Class<?> r36, com.sun.jna.NativeLibrary r37) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.Native.register(java.lang.Class, com.sun.jna.NativeLibrary):void");
    }

    public static String toString(char[] cArr) {
        int length = cArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (cArr[i] == 0) {
                length = i;
                break;
            }
            i++;
        }
        return length == 0 ? "" : new String(cArr, 0, length);
    }

    public static int getNativeSize(Class<?> cls) {
        if (NativeMapped.class.isAssignableFrom(cls)) {
            cls = NativeMappedConverter.getInstance(cls).nativeType();
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return 4;
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return 1;
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return 2;
        }
        if (cls != Character.TYPE && cls != Character.class) {
            if (cls == Integer.TYPE || cls == Integer.class) {
                return 4;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return 8;
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return 4;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return 8;
            }
            if (Structure.class.isAssignableFrom(cls)) {
                if (Structure.ByValue.class.isAssignableFrom(cls)) {
                    return Structure.size(cls);
                }
                return POINTER_SIZE;
            }
            if (!Pointer.class.isAssignableFrom(cls) && ((!Platform.HAS_BUFFERS || !Buffers.isBuffer(cls)) && !Callback.class.isAssignableFrom(cls) && String.class != cls && WString.class != cls)) {
                throw new IllegalArgumentException("Native size for type \"" + cls.getName() + "\" is unknown");
            }
            return POINTER_SIZE;
        }
        return WCHAR_SIZE;
    }
}
