package dc;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.util.WearUtils;
import com.yydcdut.sdlv.SlideAndDragListView;

/* compiled from: ScreenUtils.java */
/* loaded from: classes4.dex */
public class gg3 {
    public static gg3 c;
    public static Bitmap d;
    public int a;
    public int b;

    public gg3(Context context) {
        WindowManager windowManager;
        if ((this.a == 0 || this.b == 0) && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                this.a = i2;
                this.b = i - f(context);
            } else {
                this.a = i;
                this.b = i2;
            }
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static gg3 b(Context context) {
        if (c == null) {
            c = new gg3(context.getApplicationContext());
        }
        return c;
    }

    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int d(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 1;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        return (rotation == 0 || rotation == 2) ? rotation == 0 ? 1 : 2 : (rotation == 1 || rotation == 3) ? 2 : 1;
    }

    public static int e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int g(Context context) throws Resources.NotFoundException, ClassNotFoundException {
        int dimensionPixelSize;
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            dimensionPixelSize = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            dimensionPixelSize = -1;
        }
        return dimensionPixelSize == -1 ? h((Activity) context) : dimensionPixelSize;
    }

    public static int h(Activity activity) {
        if (activity == null) {
            return -1;
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static boolean j() {
        return Settings.System.getInt(WearUtils.x.getContentResolver(), "accelerometer_rotation", 0) == 1;
    }

    public static void k(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static void l(SlideAndDragListView slideAndDragListView, int i) {
        if (slideAndDragListView != null) {
            if (Build.VERSION.SDK_INT >= 8) {
                slideAndDragListView.smoothScrollToPosition(i);
            } else {
                slideAndDragListView.setSelection(i);
            }
        }
    }

    public static void m(Activity activity) {
        activity.setRequestedOrientation(1);
    }

    public static void n(Activity activity) {
        if (j()) {
            activity.setRequestedOrientation(-1);
        } else {
            activity.setRequestedOrientation(2);
        }
    }

    public int f(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    public float i() {
        return this.b / 1624.0f;
    }
}
