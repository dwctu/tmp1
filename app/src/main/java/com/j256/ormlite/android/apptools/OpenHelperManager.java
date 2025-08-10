package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class OpenHelperManager {
    private static final String HELPER_CLASS_RESOURCE_NAME = "open_helper_classname";
    private static Logger logger = LoggerFactory.getLogger((Class<?>) OpenHelperManager.class);
    private static Class<? extends OrmLiteSqliteOpenHelper> helperClass = null;
    private static volatile OrmLiteSqliteOpenHelper helper = null;
    private static boolean wasClosed = false;
    private static int instanceCount = 0;

    private static OrmLiteSqliteOpenHelper constructHelper(Context context, Class<? extends OrmLiteSqliteOpenHelper> cls) {
        try {
            try {
                return cls.getConstructor(Context.class).newInstance(context);
            } catch (Exception e) {
                throw new IllegalStateException("Could not construct instance of helper class " + cls, e);
            }
        } catch (Exception e2) {
            throw new IllegalStateException("Could not find public constructor that has a single (Context) argument for helper class " + cls, e2);
        }
    }

    public static synchronized <T extends OrmLiteSqliteOpenHelper> T getHelper(Context context, Class<T> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("openHelperClass argument is null");
        }
        innerSetHelperClass(cls);
        return (T) loadHelper(context, cls);
    }

    private static void innerSetHelperClass(Class<? extends OrmLiteSqliteOpenHelper> cls) {
        if (cls == null) {
            throw new IllegalStateException("Helper class was trying to be reset to null");
        }
        Class<? extends OrmLiteSqliteOpenHelper> cls2 = helperClass;
        if (cls2 == null) {
            helperClass = cls;
            return;
        }
        if (cls2 == cls) {
            return;
        }
        throw new IllegalStateException("Helper class was " + helperClass + " but is trying to be reset to " + cls);
    }

    private static <T extends OrmLiteSqliteOpenHelper> T loadHelper(Context context, Class<T> cls) {
        if (helper == null) {
            if (wasClosed) {
                logger.info("helper was already closed and is being re-opened");
            }
            if (context == null) {
                throw new IllegalArgumentException("context argument is null");
            }
            helper = constructHelper(context.getApplicationContext(), cls);
            logger.trace("zero instances, created helper {}", helper);
            BaseDaoImpl.clearAllInternalObjectCaches();
            DaoManager.clearDaoCache();
            instanceCount = 0;
        }
        instanceCount++;
        logger.trace("returning helper {}, instance count = {} ", helper, Integer.valueOf(instanceCount));
        return (T) helper;
    }

    private static Class<? extends OrmLiteSqliteOpenHelper> lookupHelperClass(Context context, Class<?> cls) throws Resources.NotFoundException {
        Type[] actualTypeArguments;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(HELPER_CLASS_RESOURCE_NAME, TypedValues.Custom.S_STRING, context.getPackageName());
        if (identifier != 0) {
            String string = resources.getString(identifier);
            try {
                return Class.forName(string);
            } catch (Exception e) {
                throw new IllegalStateException("Could not create helper instance for class " + string, e);
            }
        }
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            Type genericSuperclass = superclass.getGenericSuperclass();
            if (genericSuperclass != null && (genericSuperclass instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) != null && actualTypeArguments.length != 0) {
                for (Type type : actualTypeArguments) {
                    if (type instanceof Class) {
                        Class<? extends OrmLiteSqliteOpenHelper> cls2 = (Class) type;
                        if (OrmLiteSqliteOpenHelper.class.isAssignableFrom(cls2)) {
                            return cls2;
                        }
                    }
                }
            }
        }
        throw new IllegalStateException("Could not find OpenHelperClass because none of the generic parameters of class " + cls + " extends OrmLiteSqliteOpenHelper.  You should use getHelper(Context, Class) instead.");
    }

    @Deprecated
    public static void release() {
        releaseHelper();
    }

    public static synchronized void releaseHelper() {
        instanceCount--;
        logger.trace("releasing helper {}, instance count = {}", helper, Integer.valueOf(instanceCount));
        if (instanceCount <= 0) {
            if (helper != null) {
                logger.trace("zero instances, closing helper {}", helper);
                helper.close();
                helper = null;
                wasClosed = true;
            }
            int i = instanceCount;
            if (i < 0) {
                logger.error("too many calls to release helper, instance count = {}", Integer.valueOf(i));
            }
        }
    }

    public static synchronized void setHelper(OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper) {
        helper = ormLiteSqliteOpenHelper;
    }

    public static synchronized void setOpenHelperClass(Class<? extends OrmLiteSqliteOpenHelper> cls) {
        if (cls == null) {
            helperClass = null;
        } else {
            innerSetHelperClass(cls);
        }
    }

    @Deprecated
    public static synchronized OrmLiteSqliteOpenHelper getHelper(Context context) {
        if (helperClass == null) {
            if (context != null) {
                innerSetHelperClass(lookupHelperClass(context.getApplicationContext(), context.getClass()));
            } else {
                throw new IllegalArgumentException("context argument is null");
            }
        }
        return loadHelper(context, helperClass);
    }
}
