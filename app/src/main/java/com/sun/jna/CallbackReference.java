package com.sun.jna;

import com.sun.jna.Library;
import com.sun.jna.Structure;
import dc.gg1;
import java.io.Closeable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class CallbackReference extends WeakReference<Callback> implements Closeable {
    private static final Class<?> DLL_CALLBACK_CLASS;
    private static final Method PROXY_CALLBACK_METHOD;
    private static final Map<Callback, CallbackThreadInitializer> initializers;
    public int callingConvention;
    public Pointer cbstruct;
    public gg1.b cleanable;
    public Method method;
    public CallbackProxy proxy;
    public Pointer trampoline;
    public static final Map<Callback, CallbackReference> callbackMap = new WeakHashMap();
    public static final Map<Callback, CallbackReference> directCallbackMap = new WeakHashMap();
    public static final Map<Pointer, Reference<Callback>[]> pointerCallbackMap = new WeakHashMap();
    public static final Map<Object, Object> allocations = Collections.synchronizedMap(new WeakHashMap());
    private static final Map<Long, Reference<CallbackReference>> allocatedMemory = new ConcurrentHashMap();

    public static class AttachOptions extends Structure {
        public static final List<String> FIELDS = Structure.createFieldsOrder("daemon", "detach", "name");
        public boolean daemon;
        public boolean detach;
        public String name;

        public AttachOptions() {
            setStringEncoding("utf8");
        }

        @Override // com.sun.jna.Structure
        public List<String> getFieldOrder() {
            return FIELDS;
        }
    }

    public static final class CallbackReferenceDisposer implements Runnable {
        private Pointer cbstruct;

        public CallbackReferenceDisposer(Pointer pointer) {
            this.cbstruct = pointer;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Pointer pointer = this.cbstruct;
            if (pointer != null) {
                try {
                    Native.freeNativeCallback(pointer.peer);
                    CallbackReference.allocatedMemory.remove(Long.valueOf(this.cbstruct.peer));
                    this.cbstruct.peer = 0L;
                    this.cbstruct = null;
                } catch (Throwable th) {
                    CallbackReference.allocatedMemory.remove(Long.valueOf(this.cbstruct.peer));
                    this.cbstruct.peer = 0L;
                    this.cbstruct = null;
                    throw th;
                }
            }
        }
    }

    public class DefaultCallbackProxy implements CallbackProxy {
        private final Method callbackMethod;
        private final String encoding;
        private final FromNativeConverter[] fromNative;
        private ToNativeConverter toNative;

        public DefaultCallbackProxy(Method method, TypeMapper typeMapper, String str) {
            this.callbackMethod = method;
            this.encoding = str;
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> returnType = method.getReturnType();
            this.fromNative = new FromNativeConverter[parameterTypes.length];
            if (NativeMapped.class.isAssignableFrom(returnType)) {
                this.toNative = NativeMappedConverter.getInstance(returnType);
            } else if (typeMapper != null) {
                this.toNative = typeMapper.getToNativeConverter(returnType);
            }
            for (int i = 0; i < this.fromNative.length; i++) {
                if (NativeMapped.class.isAssignableFrom(parameterTypes[i])) {
                    this.fromNative[i] = new NativeMappedConverter(parameterTypes[i]);
                } else if (typeMapper != null) {
                    this.fromNative[i] = typeMapper.getFromNativeConverter(parameterTypes[i]);
                }
            }
            if (method.isAccessible()) {
                return;
            }
            try {
                method.setAccessible(true);
            } catch (SecurityException unused) {
                throw new IllegalArgumentException("Callback method is inaccessible, make sure the interface is public: " + method);
            }
        }

        private Object convertArgument(Object obj, Class<?> cls) throws IllegalArgumentException {
            Object wString;
            if (!(obj instanceof Pointer)) {
                if ((Boolean.TYPE == cls || Boolean.class == cls) && (obj instanceof Number)) {
                    return Function.valueOf(((Number) obj).intValue() != 0);
                }
                return obj;
            }
            if (cls == String.class) {
                return ((Pointer) obj).getString(0L, this.encoding);
            }
            if (cls == WString.class) {
                wString = new WString(((Pointer) obj).getWideString(0L));
            } else {
                if (cls == String[].class) {
                    return ((Pointer) obj).getStringArray(0L, this.encoding);
                }
                if (cls == WString[].class) {
                    return ((Pointer) obj).getWideStringArray(0L);
                }
                if (Callback.class.isAssignableFrom(cls)) {
                    return CallbackReference.getCallback(cls, (Pointer) obj);
                }
                if (!Structure.class.isAssignableFrom(cls)) {
                    return obj;
                }
                if (!Structure.ByValue.class.isAssignableFrom(cls)) {
                    Structure structureNewInstance = Structure.newInstance((Class<Structure>) cls, (Pointer) obj);
                    structureNewInstance.conditionalAutoRead();
                    return structureNewInstance;
                }
                Structure structureNewInstance2 = Structure.newInstance(cls);
                int size = structureNewInstance2.size();
                byte[] bArr = new byte[size];
                ((Pointer) obj).read(0L, bArr, 0, size);
                structureNewInstance2.getPointer().write(0L, bArr, 0, size);
                structureNewInstance2.read();
                wString = structureNewInstance2;
            }
            return wString;
        }

        private Object convertResult(Object obj) {
            ToNativeConverter toNativeConverter = this.toNative;
            if (toNativeConverter != null) {
                obj = toNativeConverter.toNative(obj, new CallbackResultContext(this.callbackMethod));
            }
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (Structure.class.isAssignableFrom(cls)) {
                return Structure.ByValue.class.isAssignableFrom(cls) ? obj : ((Structure) obj).getPointer();
            }
            if (cls == Boolean.TYPE || cls == Boolean.class) {
                return Boolean.TRUE.equals(obj) ? Function.INTEGER_TRUE : Function.INTEGER_FALSE;
            }
            if (cls == String.class || cls == WString.class) {
                return CallbackReference.getNativeString(obj, cls == WString.class);
            }
            if (cls != String[].class && cls != WString[].class) {
                return Callback.class.isAssignableFrom(cls) ? CallbackReference.getFunctionPointer((Callback) obj) : obj;
            }
            StringArray stringArray = cls == String[].class ? new StringArray((String[]) obj, this.encoding) : new StringArray((WString[]) obj);
            CallbackReference.allocations.put(obj, stringArray);
            return stringArray;
        }

        private Object invokeCallback(Object[] objArr) {
            Class<?>[] parameterTypes = this.callbackMethod.getParameterTypes();
            int length = objArr.length;
            Object[] objArr2 = new Object[length];
            for (int i = 0; i < objArr.length; i++) {
                Class<?> cls = parameterTypes[i];
                Object obj = objArr[i];
                if (this.fromNative[i] != null) {
                    objArr2[i] = this.fromNative[i].fromNative(obj, new CallbackParameterContext(cls, this.callbackMethod, objArr, i));
                } else {
                    objArr2[i] = convertArgument(obj, cls);
                }
            }
            Object objConvertResult = null;
            Callback callback = getCallback();
            if (callback != null) {
                try {
                    objConvertResult = convertResult(this.callbackMethod.invoke(callback, objArr2));
                } catch (IllegalAccessException e) {
                    Native.getCallbackExceptionHandler().uncaughtException(callback, e);
                } catch (IllegalArgumentException e2) {
                    Native.getCallbackExceptionHandler().uncaughtException(callback, e2);
                } catch (InvocationTargetException e3) {
                    Native.getCallbackExceptionHandler().uncaughtException(callback, e3.getTargetException());
                }
            }
            for (int i2 = 0; i2 < length; i2++) {
                if ((objArr2[i2] instanceof Structure) && !(objArr2[i2] instanceof Structure.ByValue)) {
                    ((Structure) objArr2[i2]).autoWrite();
                }
            }
            return objConvertResult;
        }

        @Override // com.sun.jna.CallbackProxy
        public Object callback(Object[] objArr) {
            try {
                return invokeCallback(objArr);
            } catch (Throwable th) {
                Native.getCallbackExceptionHandler().uncaughtException(getCallback(), th);
                return null;
            }
        }

        public Callback getCallback() {
            return CallbackReference.this.getCallback();
        }

        @Override // com.sun.jna.CallbackProxy
        public Class<?>[] getParameterTypes() {
            return this.callbackMethod.getParameterTypes();
        }

        @Override // com.sun.jna.CallbackProxy
        public Class<?> getReturnType() {
            return this.callbackMethod.getReturnType();
        }
    }

    public static class NativeFunctionHandler implements InvocationHandler {
        private final Function function;
        private final Map<String, ?> options;

        public NativeFunctionHandler(Pointer pointer, int i, Map<String, ?> map) {
            this.options = map;
            this.function = new Function(pointer, i, (String) map.get(Library.OPTION_STRING_ENCODING));
        }

        public Pointer getPointer() {
            return this.function;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (Library.Handler.OBJECT_TOSTRING.equals(method)) {
                return ("Proxy interface to " + this.function) + " (" + CallbackReference.findCallbackClass(((Method) this.options.get(Function.OPTION_INVOKING_METHOD)).getDeclaringClass()).getName() + ")";
            }
            if (Library.Handler.OBJECT_HASHCODE.equals(method)) {
                return Integer.valueOf(hashCode());
            }
            if (!Library.Handler.OBJECT_EQUALS.equals(method)) {
                if (Function.isVarArgs(method)) {
                    objArr = Function.concatenateVarArgs(objArr);
                }
                return this.function.invoke(method.getReturnType(), objArr, this.options);
            }
            Object obj2 = objArr[0];
            if (obj2 == null || !Proxy.isProxyClass(obj2.getClass())) {
                return Boolean.FALSE;
            }
            return Function.valueOf(Proxy.getInvocationHandler(obj2) == this);
        }
    }

    static {
        try {
            PROXY_CALLBACK_METHOD = CallbackProxy.class.getMethod(Callback.METHOD_NAME, Object[].class);
            if (Platform.isWindows()) {
                try {
                    DLL_CALLBACK_CLASS = Class.forName("dc.ig1");
                } catch (ClassNotFoundException e) {
                    throw new Error("Error loading DLLCallback class", e);
                }
            } else {
                DLL_CALLBACK_CLASS = null;
            }
            initializers = new WeakHashMap();
        } catch (Exception unused) {
            throw new Error("Error looking up CallbackProxy.callback() method");
        }
    }

    private CallbackReference(Callback callback, int i, boolean z) {
        long jCreateNativeCallback;
        super(callback);
        TypeMapper typeMapper = Native.getTypeMapper(callback.getClass());
        this.callingConvention = i;
        boolean zIsPPC = Platform.isPPC();
        if (z) {
            Method callbackMethod = getCallbackMethod(callback);
            Class<?>[] parameterTypes = callbackMethod.getParameterTypes();
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                if ((zIsPPC && (parameterTypes[i2] == Float.TYPE || parameterTypes[i2] == Double.TYPE)) || (typeMapper != null && typeMapper.getFromNativeConverter(parameterTypes[i2]) != null)) {
                    z = false;
                    break;
                }
            }
            if (typeMapper != null && typeMapper.getToNativeConverter(callbackMethod.getReturnType()) != null) {
                z = false;
            }
        }
        String stringEncoding = Native.getStringEncoding(callback.getClass());
        if (z) {
            Method callbackMethod2 = getCallbackMethod(callback);
            this.method = callbackMethod2;
            Class<?>[] parameterTypes2 = callbackMethod2.getParameterTypes();
            Class<?> returnType = this.method.getReturnType();
            Class<?> cls = DLL_CALLBACK_CLASS;
            jCreateNativeCallback = Native.createNativeCallback(callback, this.method, parameterTypes2, returnType, i, (cls == null || !cls.isInstance(callback)) ? 1 : 3, stringEncoding);
        } else {
            if (callback instanceof CallbackProxy) {
                this.proxy = (CallbackProxy) callback;
            } else {
                this.proxy = new DefaultCallbackProxy(getCallbackMethod(callback), typeMapper, stringEncoding);
            }
            Class<?>[] parameterTypes3 = this.proxy.getParameterTypes();
            Class<?> returnType2 = this.proxy.getReturnType();
            if (typeMapper != null) {
                for (int i3 = 0; i3 < parameterTypes3.length; i3++) {
                    FromNativeConverter fromNativeConverter = typeMapper.getFromNativeConverter(parameterTypes3[i3]);
                    if (fromNativeConverter != null) {
                        parameterTypes3[i3] = fromNativeConverter.nativeType();
                    }
                }
                ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(returnType2);
                if (toNativeConverter != null) {
                    returnType2 = toNativeConverter.nativeType();
                }
            }
            for (int i4 = 0; i4 < parameterTypes3.length; i4++) {
                parameterTypes3[i4] = getNativeType(parameterTypes3[i4]);
                if (!isAllowableNativeType(parameterTypes3[i4])) {
                    throw new IllegalArgumentException("Callback argument " + parameterTypes3[i4] + " requires custom type conversion");
                }
            }
            Class<?> nativeType = getNativeType(returnType2);
            if (!isAllowableNativeType(nativeType)) {
                throw new IllegalArgumentException("Callback return type " + nativeType + " requires custom type conversion");
            }
            Class<?> cls2 = DLL_CALLBACK_CLASS;
            jCreateNativeCallback = Native.createNativeCallback(this.proxy, PROXY_CALLBACK_METHOD, parameterTypes3, nativeType, i, (cls2 == null || !cls2.isInstance(callback)) ? 0 : 2, stringEncoding);
        }
        this.cbstruct = jCreateNativeCallback != 0 ? new Pointer(jCreateNativeCallback) : null;
        if (jCreateNativeCallback != 0) {
            allocatedMemory.put(Long.valueOf(jCreateNativeCallback), new WeakReference(this));
            this.cleanable = gg1.d().e(this, new CallbackReferenceDisposer(this.cbstruct));
        }
    }

    private static Reference<Callback>[] addCallbackToArray(Callback callback, Reference<Callback>[] referenceArr) {
        int i = 0;
        int i2 = 1;
        if (referenceArr != null) {
            for (int i3 = 0; i3 < referenceArr.length; i3++) {
                if (referenceArr[i3].get() == null) {
                    referenceArr[i3] = null;
                } else {
                    i2++;
                }
            }
        }
        Reference<Callback>[] referenceArr2 = new Reference[i2];
        if (referenceArr != null) {
            int i4 = 0;
            while (i < referenceArr.length) {
                if (referenceArr[i] != null) {
                    referenceArr2[i4] = referenceArr[i];
                    i4++;
                }
                i++;
            }
            i = i4;
        }
        referenceArr2[i] = new WeakReference(callback);
        return referenceArr2;
    }

    private static Method checkMethod(Method method) {
        if (method.getParameterTypes().length <= 256) {
            return method;
        }
        throw new UnsupportedOperationException("Method signature exceeds the maximum parameter count: " + method);
    }

    private static Callback createCallback(Class<?> cls, Pointer pointer) {
        int i = AltCallingConvention.class.isAssignableFrom(cls) ? 63 : 0;
        HashMap map = new HashMap(Native.getLibraryOptions(cls));
        map.put(Function.OPTION_INVOKING_METHOD, getCallbackMethod(cls));
        return (Callback) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new NativeFunctionHandler(pointer, i, map));
    }

    public static void disposeAll() {
        Iterator it = new LinkedList(allocatedMemory.values()).iterator();
        while (it.hasNext()) {
            CallbackReference callbackReference = (CallbackReference) ((Reference) it.next()).get();
            if (callbackReference != null) {
                callbackReference.close();
            }
        }
    }

    public static Class<?> findCallbackClass(Class<?> cls) {
        if (!Callback.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls.getName() + " is not derived from com.sun.jna.Callback");
        }
        if (!cls.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int i = 0;
            while (true) {
                if (i >= interfaces.length) {
                    break;
                }
                if (Callback.class.isAssignableFrom(interfaces[i])) {
                    try {
                        getCallbackMethod(interfaces[i]);
                        return interfaces[i];
                    } catch (IllegalArgumentException unused) {
                        return Callback.class.isAssignableFrom(cls.getSuperclass()) ? findCallbackClass(cls.getSuperclass()) : cls;
                    }
                }
                i++;
            }
        } else {
            return cls;
        }
    }

    public static Callback getCallback(Class<?> cls, Pointer pointer) {
        return getCallback(cls, pointer, false);
    }

    private static Method getCallbackMethod(Callback callback) {
        return getCallbackMethod(findCallbackClass(callback.getClass()));
    }

    public static Pointer getFunctionPointer(Callback callback) {
        return getFunctionPointer(callback, false);
    }

    private static Pointer getNativeFunctionPointer(Callback callback) throws IllegalArgumentException {
        if (!Proxy.isProxyClass(callback.getClass())) {
            return null;
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(callback);
        if (invocationHandler instanceof NativeFunctionHandler) {
            return ((NativeFunctionHandler) invocationHandler).getPointer();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pointer getNativeString(Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        NativeString nativeString = new NativeString(obj.toString(), z);
        allocations.put(obj, nativeString);
        return nativeString.getPointer();
    }

    private Class<?> getNativeType(Class<?> cls) {
        if (Structure.class.isAssignableFrom(cls)) {
            Structure.validate(cls);
            if (!Structure.ByValue.class.isAssignableFrom(cls)) {
                return Pointer.class;
            }
        } else {
            if (NativeMapped.class.isAssignableFrom(cls)) {
                return NativeMappedConverter.getInstance(cls).nativeType();
            }
            if (cls == String.class || cls == WString.class || cls == String[].class || cls == WString[].class || Callback.class.isAssignableFrom(cls)) {
                return Pointer.class;
            }
        }
        return cls;
    }

    private static Callback getTypeAssignableCallback(Class<?> cls, Reference<Callback>[] referenceArr) {
        if (referenceArr == null) {
            return null;
        }
        for (Reference<Callback> reference : referenceArr) {
            Callback callback = reference.get();
            if (callback != null && cls.isAssignableFrom(callback.getClass())) {
                return callback;
            }
        }
        return null;
    }

    private static ThreadGroup initializeThread(Callback callback, AttachOptions attachOptions) {
        CallbackThreadInitializer callbackThreadInitializer;
        if (callback instanceof DefaultCallbackProxy) {
            callback = ((DefaultCallbackProxy) callback).getCallback();
        }
        Map<Callback, CallbackThreadInitializer> map = initializers;
        synchronized (map) {
            callbackThreadInitializer = map.get(callback);
        }
        if (callbackThreadInitializer == null) {
            return null;
        }
        ThreadGroup threadGroup = callbackThreadInitializer.getThreadGroup(callback);
        attachOptions.name = callbackThreadInitializer.getName(callback);
        attachOptions.daemon = callbackThreadInitializer.isDaemon(callback);
        attachOptions.detach = callbackThreadInitializer.detach(callback);
        attachOptions.write();
        return threadGroup;
    }

    private static boolean isAllowableNativeType(Class<?> cls) {
        return cls == Void.TYPE || cls == Void.class || cls == Boolean.TYPE || cls == Boolean.class || cls == Byte.TYPE || cls == Byte.class || cls == Short.TYPE || cls == Short.class || cls == Character.TYPE || cls == Character.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Double.TYPE || cls == Double.class || (Structure.ByValue.class.isAssignableFrom(cls) && Structure.class.isAssignableFrom(cls)) || Pointer.class.isAssignableFrom(cls);
    }

    private void setCallbackOptions(int i) {
        this.cbstruct.setInt(Native.POINTER_SIZE, i);
    }

    public static CallbackThreadInitializer setCallbackThreadInitializer(Callback callback, CallbackThreadInitializer callbackThreadInitializer) {
        Map<Callback, CallbackThreadInitializer> map = initializers;
        synchronized (map) {
            if (callbackThreadInitializer != null) {
                return map.put(callback, callbackThreadInitializer);
            }
            return map.remove(callback);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        gg1.b bVar = this.cleanable;
        if (bVar != null) {
            bVar.a();
        }
        this.cbstruct = null;
    }

    @Deprecated
    public void dispose() {
        close();
    }

    public Pointer getTrampoline() {
        if (this.trampoline == null) {
            this.trampoline = this.cbstruct.getPointer(0L);
        }
        return this.trampoline;
    }

    private static Callback getCallback(Class<?> cls, Pointer pointer, boolean z) {
        if (pointer == null) {
            return null;
        }
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("Callback type must be an interface");
        }
        Map<Callback, CallbackReference> map = z ? directCallbackMap : callbackMap;
        Map<Pointer, Reference<Callback>[]> map2 = pointerCallbackMap;
        synchronized (map2) {
            Reference<Callback>[] referenceArr = map2.get(pointer);
            Callback typeAssignableCallback = getTypeAssignableCallback(cls, referenceArr);
            if (typeAssignableCallback != null) {
                return typeAssignableCallback;
            }
            Callback callbackCreateCallback = createCallback(cls, pointer);
            map2.put(pointer, addCallbackToArray(callbackCreateCallback, referenceArr));
            map.remove(callbackCreateCallback);
            return callbackCreateCallback;
        }
    }

    private static Method getCallbackMethod(Class<?> cls) throws SecurityException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Method[] methods = cls.getMethods();
        HashSet hashSet = new HashSet(Arrays.asList(declaredMethods));
        hashSet.retainAll(Arrays.asList(methods));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (Callback.FORBIDDEN_NAMES.contains(((Method) it.next()).getName())) {
                it.remove();
            }
        }
        Method[] methodArr = (Method[]) hashSet.toArray(new Method[0]);
        if (methodArr.length == 1) {
            return checkMethod(methodArr[0]);
        }
        for (Method method : methodArr) {
            if (Callback.METHOD_NAME.equals(method.getName())) {
                return checkMethod(method);
            }
        }
        throw new IllegalArgumentException("Callback must implement a single public method, or one public method named 'callback'");
    }

    private static Pointer getFunctionPointer(Callback callback, boolean z) throws NoSuchFieldException, SecurityException, IllegalArgumentException {
        Pointer trampoline;
        if (callback == null) {
            return null;
        }
        Pointer nativeFunctionPointer = getNativeFunctionPointer(callback);
        if (nativeFunctionPointer != null) {
            return nativeFunctionPointer;
        }
        Map<String, Object> libraryOptions = Native.getLibraryOptions(callback.getClass());
        int iIntValue = callback instanceof AltCallingConvention ? 63 : (libraryOptions == null || !libraryOptions.containsKey(Library.OPTION_CALLING_CONVENTION)) ? 0 : ((Integer) libraryOptions.get(Library.OPTION_CALLING_CONVENTION)).intValue();
        Map<Callback, CallbackReference> map = z ? directCallbackMap : callbackMap;
        Map<Pointer, Reference<Callback>[]> map2 = pointerCallbackMap;
        synchronized (map2) {
            CallbackReference callbackReference = map.get(callback);
            if (callbackReference == null) {
                callbackReference = new CallbackReference(callback, iIntValue, z);
                map.put(callback, callbackReference);
                map2.put(callbackReference.getTrampoline(), addCallbackToArray(callback, null));
                if (initializers.containsKey(callback)) {
                    callbackReference.setCallbackOptions(1);
                }
            }
            trampoline = callbackReference.getTrampoline();
        }
        return trampoline;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Callback getCallback() {
        return get();
    }
}
