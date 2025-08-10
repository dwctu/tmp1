package dc;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SkinCompatViewInflater.java */
/* loaded from: classes5.dex */
public class hh4 {
    public static final Class<?>[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {R.attr.onClick};
    public static final String[] d = {"android.widget.", "android.view.", "android.webkit."};
    public static final Map<String, Constructor<? extends View>> e = new mh4();
    public final Object[] a = new Object[2];

    /* compiled from: SkinCompatViewInflater.java */
    public static class a implements View.OnClickListener {
        public final View a;
        public final String b;
        public Method c;
        public Context d;

        public a(View view, String str) {
            this.a = view;
            this.b = str;
        }

        public final void a(Context context, String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.b, View.class)) != null) {
                        this.c = method;
                        this.d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.c == null) {
                a(this.a.getContext(), this.b);
            }
            try {
                this.c.invoke(this.d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    public final void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || ri4.a(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    public final View b(Context context, String str, String str2) throws InflateException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String str3;
        Map<String, Constructor<? extends View>> map = e;
        Constructor<? extends View> constructor = map.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(b);
                map.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.a);
    }

    public final View c(View view, String str, Context context, AttributeSet attributeSet) {
        View viewD = d(context, str, attributeSet);
        if (viewD == null) {
            viewD = e(context, str, attributeSet);
        }
        if (viewD == null) {
            viewD = f(context, str, attributeSet);
        }
        if (viewD != null) {
            a(viewD, attributeSet);
        }
        return viewD;
    }

    public final View d(Context context, String str, AttributeSet attributeSet) {
        Iterator<ih4> it = zg4.m().k().iterator();
        View viewB = null;
        while (it.hasNext() && (viewB = it.next().b(context, str, attributeSet)) == null) {
        }
        return viewB;
    }

    public final View e(Context context, String str, AttributeSet attributeSet) {
        Iterator<ih4> it = zg4.m().l().iterator();
        View viewB = null;
        while (it.hasNext() && (viewB = it.next().b(context, str, attributeSet)) == null) {
        }
        return viewB;
    }

    public View f(Context context, String str, AttributeSet attributeSet) {
        if ("view".equals(str)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return b(context, str, null);
            }
            int i = 0;
            while (true) {
                String[] strArr = d;
                if (i >= strArr.length) {
                    return null;
                }
                View viewB = b(context, str, strArr[i]);
                if (viewB != null) {
                    return viewB;
                }
                i++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }
}
