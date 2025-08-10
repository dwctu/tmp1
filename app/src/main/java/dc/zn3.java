package dc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: SelectDialog.java */
/* loaded from: classes4.dex */
public class zn3 extends AlertDialog {
    public View a;
    public Context b;

    /* compiled from: SelectDialog.java */
    public interface a {
        void a(zn3 zn3Var);

        void b(zn3 zn3Var);
    }

    public zn3(Context context, int i, int i2) {
        super(context, i);
        this.a = null;
        this.b = context;
        this.a = LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
    }

    public void a(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        view.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int iA = ce3.a(this.b, i);
        int iE = (gg3.e(this.b) - iA) - ce3.a(this.b, 16.0f);
        int iA2 = i3 + ce3.a(this.b, i2);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = iE;
        layoutParams.width = iA;
        layoutParams.gravity = 51;
        layoutParams.y = iA2;
        window.setAttributes(layoutParams);
    }

    public void b(View view, int i, int i2, int i3, int i4, a aVar) {
        int i5;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        view.getLocationOnScreen(iArr);
        int i6 = iArr[1];
        int i7 = iArr[0];
        int width = view.getWidth();
        int height = view.getHeight();
        int iA = ce3.a(this.b, i);
        int iA2 = ce3.a(this.b, i2);
        int iE = gg3.e(this.b);
        int iC = gg3.c(this.b);
        int i8 = (iC / 2) - (iA2 / 2);
        int iA3 = (((i7 + width) - iA) - ((iE / 2) - (iA / 2))) + ce3.a(this.b, i3);
        int iA4 = ce3.a(this.b, 56.0f);
        int iA5 = ce3.a(this.b, i4);
        int i9 = (height / 2) + i6 + iA5;
        if (i9 + iA2 > iC - iA4) {
            i5 = ((i6 - iA5) - iA2) - i8;
            if (aVar != null) {
                aVar.a(this);
            }
        } else {
            i5 = i9 - i8;
            if (aVar != null) {
                aVar.b(this);
            }
        }
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = iA3;
        layoutParams.y = i5;
        window.setAttributes(layoutParams);
    }

    @Override // android.app.Dialog
    public View findViewById(int i) {
        return this.a.findViewById(i);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = this.a;
        if (view != null) {
            setContentView(view);
        }
        setCanceledOnTouchOutside(true);
    }
}
