package dc;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.lang.reflect.Field;
import java.util.Stack;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: NotificationCompatColor.java */
/* loaded from: classes3.dex */
public class nd2 {
    public boolean a;
    public Context d;
    public int b = 0;
    public int c = 0;
    public String e = "";

    public nd2(Context context) {
        this.a = false;
        this.d = context;
        boolean zJ = j(context);
        this.a = zJ;
        if (zJ) {
            m("start ->" + toString());
        }
    }

    public static int h(String str) throws NoSuchFieldException {
        int identifier = Resources.getSystem().getIdentifier(str, TtmlNode.ATTR_ID, DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier > 0) {
            return identifier;
        }
        try {
            Field field = Class.forName("com.android.internal.R$id").getField(str);
            field.setAccessible(true);
            return field.getInt(null);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean j(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean k(int i) {
        return i >= 128;
    }

    public static boolean l(int i) {
        return k(n(i));
    }

    public static int n(int i) {
        return (int) ((((Color.red(i) + Color.green(i)) + Color.blue(i)) / 3.0f) + 0.5f);
    }

    public final RemoteViews a(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("fakeContentTitle").setContentText("fakeContentText").setTicker("fackTicker");
        return Build.VERSION.SDK_INT >= 24 ? builder.createContentView() : builder.getNotification().contentView;
    }

    public nd2 b() {
        RemoteViews remoteViewsA = a(this.d);
        if (!g(remoteViewsA) && !e(remoteViewsA) && !d(remoteViewsA)) {
            f();
        }
        if (this.a) {
            m("end ->" + toString());
        }
        return this;
    }

    public final boolean c(TextView textView, TextView textView2) {
        if (textView != null) {
            this.b = textView.getTextColors().getDefaultColor();
        }
        if (textView2 != null) {
            this.c = textView2.getTextColors().getDefaultColor();
        }
        if (this.a) {
            m("checkAndGuessColor-> beforeGuess->" + toString());
        }
        int i = this.b;
        if (i != 0 && this.c != 0) {
            return true;
        }
        if (i != 0) {
            if (l(i)) {
                this.c = -6710887;
            } else {
                this.c = -10066330;
            }
            return true;
        }
        int i2 = this.c;
        if (i2 == 0) {
            return false;
        }
        if (l(i2)) {
            this.b = -1;
        } else {
            this.b = ViewCompat.MEASURED_STATE_MASK;
        }
        return true;
    }

    public final boolean d(RemoteViews remoteViews) {
        this.e = "ByAnyTextView";
        if (remoteViews != null) {
            try {
                if (remoteViews.getLayoutId() > 0) {
                    TextView textView = null;
                    View viewInflate = LayoutInflater.from(this.d).inflate(remoteViews.getLayoutId(), (ViewGroup) null);
                    Stack stack = new Stack();
                    stack.push(viewInflate);
                    while (true) {
                        if (stack.isEmpty()) {
                            break;
                        }
                        View view = (View) stack.pop();
                        if (view instanceof TextView) {
                            textView = (TextView) view;
                            break;
                        }
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            int childCount = viewGroup.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                stack.push(viewGroup.getChildAt(i));
                            }
                        }
                    }
                    stack.clear();
                    if (textView != null) {
                        if (l(textView.getTextColors().getDefaultColor())) {
                            this.b = -1;
                            this.c = -6710887;
                            return true;
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.b = -570425344;
                            this.c = -1979711488;
                            return true;
                        }
                        this.b = ViewCompat.MEASURED_STATE_MASK;
                        this.c = -10066330;
                        return true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final boolean e(RemoteViews remoteViews) {
        if (this.a) {
            m("fetchNotificationTextColorById");
        }
        this.e = "ById";
        try {
            int iH = h(MessageBundle.TITLE_ENTRY);
            int iH2 = h("text");
            if (this.a) {
                m("systemNotificationContentId -> #" + Integer.toHexString(iH2));
            }
            if (remoteViews == null || remoteViews.getLayoutId() <= 0) {
                return false;
            }
            View viewInflate = LayoutInflater.from(this.d).inflate(remoteViews.getLayoutId(), (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(iH);
            return c(viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null, iH2 > 0 ? (TextView) viewInflate.findViewById(iH2) : null);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void f() {
        this.e = "BySdkVersion";
        int i = Build.VERSION.SDK_INT;
        if (i >= 11 && i < 21) {
            this.b = -1;
            this.c = -6710887;
        } else if (i >= 21) {
            this.b = -570425344;
            this.c = -1979711488;
        } else {
            this.b = ViewCompat.MEASURED_STATE_MASK;
            this.c = -10066330;
        }
    }

    public final boolean g(RemoteViews remoteViews) {
        if (this.a) {
            m("fetchNotificationTextColorByText");
        }
        this.e = "ByText";
        if (remoteViews != null) {
            try {
                View viewApply = remoteViews.apply(this.d, new FrameLayout(this.d));
                Stack stack = new Stack();
                stack.push(viewApply);
                TextView textView = null;
                TextView textView2 = null;
                while (!stack.isEmpty()) {
                    View view = (View) stack.pop();
                    if (view instanceof TextView) {
                        TextView textView3 = (TextView) view;
                        CharSequence text = textView3.getText();
                        if (TextUtils.equals("fakeContentTitle", text)) {
                            if (this.a) {
                                m("fetchNotificationTextColorByText -> contentTitleTextView -> OK");
                            }
                            textView = textView3;
                        } else if (TextUtils.equals("fakeContentText", text)) {
                            if (this.a) {
                                m("fetchNotificationTextColorByText -> contentTextTextView -> OK");
                            }
                            textView2 = textView3;
                        }
                        if (textView != null && textView2 != null) {
                            break;
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(viewGroup.getChildAt(i));
                        }
                    }
                }
                stack.clear();
                return c(textView, textView2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public int i() {
        return this.c;
    }

    @SuppressLint({"LongLogTag"})
    public final void m(String str) {
    }

    public String toString() {
        return "NotificationCompatColor." + this.e + "\ncontentTitleColor=#" + Integer.toHexString(this.b) + "\ncontentTextColor=#" + Integer.toHexString(this.c) + "";
    }
}
