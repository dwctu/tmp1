package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* loaded from: classes5.dex */
public class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 4096;
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List<SubscriberInfoIndex> subscriberInfoIndexes;
    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap();
    private static final FindState[] FIND_STATE_POOL = new FindState[4];

    public static class FindState {
        public Class<?> clazz;
        public boolean skipSuperClasses;
        public Class<?> subscriberClass;
        public SubscriberInfo subscriberInfo;
        public final List<SubscriberMethod> subscriberMethods = new ArrayList();
        public final Map<Class, Object> anyMethodByEventType = new HashMap();
        public final Map<String, Class> subscriberClassByMethodKey = new HashMap();
        public final StringBuilder methodKeyBuilder = new StringBuilder(128);

        private boolean checkAddWithMethodSignature(Method method, Class<?> cls) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(method.getName());
            StringBuilder sb = this.methodKeyBuilder;
            sb.append(Typography.greater);
            sb.append(cls.getName());
            String string = this.methodKeyBuilder.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.subscriberClassByMethodKey.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.subscriberClassByMethodKey.put(string, clsPut);
            return false;
        }

        public boolean checkAdd(Method method, Class<?> cls) {
            Object objPut = this.anyMethodByEventType.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!checkAddWithMethodSignature((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.anyMethodByEventType.put(cls, this);
            }
            return checkAddWithMethodSignature(method, cls);
        }

        public void initForSubscriber(Class<?> cls) {
            this.clazz = cls;
            this.subscriberClass = cls;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        public void moveToSuperclass() {
            if (this.skipSuperClasses) {
                this.clazz = null;
                return;
            }
            Class<? super Object> superclass = this.clazz.getSuperclass();
            this.clazz = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.clazz = null;
            }
        }

        public void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }
    }

    public SubscriberMethodFinder(List<SubscriberInfoIndex> list, boolean z, boolean z2) {
        this.subscriberInfoIndexes = list;
        this.strictMethodVerification = z;
        this.ignoreGeneratedIndex = z2;
    }

    public static void clearCaches() {
        METHOD_CACHE.clear();
    }

    private List<SubscriberMethod> findUsingInfo(Class<?> cls) throws SecurityException {
        FindState findStatePrepareFindState = prepareFindState();
        findStatePrepareFindState.initForSubscriber(cls);
        while (findStatePrepareFindState.clazz != null) {
            SubscriberInfo subscriberInfo = getSubscriberInfo(findStatePrepareFindState);
            findStatePrepareFindState.subscriberInfo = subscriberInfo;
            if (subscriberInfo != null) {
                for (SubscriberMethod subscriberMethod : subscriberInfo.getSubscriberMethods()) {
                    if (findStatePrepareFindState.checkAdd(subscriberMethod.method, subscriberMethod.eventType)) {
                        findStatePrepareFindState.subscriberMethods.add(subscriberMethod);
                    }
                }
            } else {
                findUsingReflectionInSingleClass(findStatePrepareFindState);
            }
            findStatePrepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(findStatePrepareFindState);
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> cls) throws SecurityException {
        FindState findStatePrepareFindState = prepareFindState();
        findStatePrepareFindState.initForSubscriber(cls);
        while (findStatePrepareFindState.clazz != null) {
            findUsingReflectionInSingleClass(findStatePrepareFindState);
            findStatePrepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(findStatePrepareFindState);
    }

    private void findUsingReflectionInSingleClass(FindState findState) throws SecurityException {
        Method[] methods;
        try {
            try {
                methods = findState.clazz.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = findState.clazz.getMethods();
                findState.skipSuperClasses = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & MODIFIERS_IGNORE) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        Subscribe subscribe = (Subscribe) method.getAnnotation(Subscribe.class);
                        if (subscribe != null) {
                            Class<?> cls = parameterTypes[0];
                            if (findState.checkAdd(method, cls)) {
                                findState.subscriberMethods.add(new SubscriberMethod(method, cls, subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
                            }
                        }
                    } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                        throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                    }
                } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                    throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                }
            }
        } catch (LinkageError e) {
            String str = "Could not inspect methods of " + findState.clazz.getName();
            throw new EventBusException(this.ignoreGeneratedIndex ? str + ". Please consider using EventBus annotation processor to avoid reflection." : str + ". Please make this class visible to EventBus annotation processor to avoid reflection.", e);
        }
    }

    private List<SubscriberMethod> getMethodsAndRelease(FindState findState) {
        ArrayList arrayList = new ArrayList(findState.subscriberMethods);
        findState.recycle();
        synchronized (FIND_STATE_POOL) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                FindState[] findStateArr = FIND_STATE_POOL;
                if (findStateArr[i] == null) {
                    findStateArr[i] = findState;
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private SubscriberInfo getSubscriberInfo(FindState findState) {
        SubscriberInfo subscriberInfo = findState.subscriberInfo;
        if (subscriberInfo != null && subscriberInfo.getSuperSubscriberInfo() != null) {
            SubscriberInfo superSubscriberInfo = findState.subscriberInfo.getSuperSubscriberInfo();
            if (findState.clazz == superSubscriberInfo.getSubscriberClass()) {
                return superSubscriberInfo;
            }
        }
        List<SubscriberInfoIndex> list = this.subscriberInfoIndexes;
        if (list == null) {
            return null;
        }
        Iterator<SubscriberInfoIndex> it = list.iterator();
        while (it.hasNext()) {
            SubscriberInfo subscriberInfo2 = it.next().getSubscriberInfo(findState.clazz);
            if (subscriberInfo2 != null) {
                return subscriberInfo2;
            }
        }
        return null;
    }

    private FindState prepareFindState() {
        synchronized (FIND_STATE_POOL) {
            for (int i = 0; i < 4; i++) {
                FindState[] findStateArr = FIND_STATE_POOL;
                FindState findState = findStateArr[i];
                if (findState != null) {
                    findStateArr[i] = null;
                    return findState;
                }
            }
            return new FindState();
        }
    }

    public List<SubscriberMethod> findSubscriberMethods(Class<?> cls) {
        Map<Class<?>, List<SubscriberMethod>> map = METHOD_CACHE;
        List<SubscriberMethod> list = map.get(cls);
        if (list != null) {
            return list;
        }
        List<SubscriberMethod> listFindUsingReflection = this.ignoreGeneratedIndex ? findUsingReflection(cls) : findUsingInfo(cls);
        if (!listFindUsingReflection.isEmpty()) {
            map.put(cls, listFindUsingReflection);
            return listFindUsingReflection;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
