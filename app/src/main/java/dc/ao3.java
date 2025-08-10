package dc;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: SelectDialogAl.java */
/* loaded from: classes4.dex */
public class ao3 extends AlertDialog {
    public View a;
    public Context b;

    /* compiled from: SelectDialogAl.java */
    public interface a {
        void a(ao3 ao3Var);

        void b(ao3 ao3Var);
    }

    public ao3(Context context, int i, int i2) {
        super(context, i);
        this.a = null;
        this.b = context;
        this.a = LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
    }

    public void a(View view, int i, int i2, int i3, int i4, a aVar) {
        int i5;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        view.getLocationOnScreen(iArr);
        int i6 = iArr[1];
        int i7 = iArr[0];
        view.getWidth();
        int height = view.getHeight();
        int iA = ce3.a(this.b, i);
        int iA2 = ce3.a(this.b, i2);
        int iE = gg3.e(this.b);
        int iC = gg3.c(this.b);
        int i8 = iE / 2;
        int i9 = iA / 2;
        int i10 = (iC / 2) - (iA2 / 2);
        ce3.a(this.b, i3);
        int iA3 = ce3.a(this.b, 56.0f);
        int iA4 = ce3.a(this.b, i4);
        int i11 = (height / 2) + i6 + iA4;
        if (i11 + iA2 > iC - iA3) {
            i5 = ((i6 - iA4) - iA2) - i10;
            if (aVar != null) {
                aVar.a(this);
            }
        } else {
            i5 = i11 - i10;
            if (aVar != null) {
                aVar.b(this);
            }
        }
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = (gg3.e(this.b) - iA) - ce3.a(this.b, 36.0f);
        layoutParams.y = i5;
        window.setAttributes(layoutParams);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
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
