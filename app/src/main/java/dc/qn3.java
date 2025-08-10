package dc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;

/* compiled from: FindInChatDialog.java */
/* loaded from: classes4.dex */
public class qn3 extends AlertDialog {
    public LayoutInflater a;
    public View b;
    public LinearLayout c;
    public TextView d;
    public Context e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* compiled from: FindInChatDialog.java */
    public interface a {
        void a(View view);
    }

    public qn3(Context context) {
        super(context, R.style.MenuDialog);
        this.b = null;
        this.c = null;
        this.f = 45;
        this.g = 108;
        this.h = 0;
        this.e = context;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.a = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.find_in_chat_layout, (ViewGroup) null);
        this.b = viewInflate;
        this.c = (LinearLayout) viewInflate.findViewById(R.id.root_layout);
        this.d = (TextView) this.b.findViewById(R.id.action_row_text);
    }

    public TextView a() {
        return this.d;
    }

    public final void b() {
        getWindow().setFlags(32, 32);
        getWindow().setFlags(262144, 262144);
    }

    public void c(View view, int i, int i2, a aVar) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        view.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int i4 = iArr[0];
        int width = view.getWidth();
        int height = view.getHeight();
        int iA = ce3.a(this.e, (this.g * 1) + (this.h * 2));
        int i5 = this.i;
        if (i5 == 1 || i5 == 2) {
            iA = ce3.a(this.e, (this.g * i5) + (this.h * 2));
        }
        int iA2 = ce3.a(this.e, (this.f * 1) + (this.h * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = iA;
        layoutParams.height = ce3.a(this.e, 6.0f) + iA2;
        this.c.setLayoutParams(layoutParams);
        int i6 = iA / 2;
        int iE = (gg3.e(this.e) / 2) - i6;
        int iC = (gg3.c(this.e) / 2) - (iA2 / 2);
        int i7 = (((i4 + width) - iA) - iE) + 0;
        if (i4 > iE + i6) {
            i7 = (i4 - i6) + (width / 2);
        }
        ce3.a(this.e, 56.0f);
        int iA3 = ((i3 + (height / 2)) + ce3.a(this.e, i2)) - iC;
        if (aVar != null) {
            aVar.a(this.c);
        }
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.x = i7;
        layoutParams2.y = iA3;
        layoutParams2.width = iA;
        layoutParams2.height = iA2;
        window.setAttributes(layoutParams2);
    }

    public void d(int i) {
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = this.b;
        if (view != null) {
            setContentView(view);
        }
        setCanceledOnTouchOutside(true);
        b();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (4 != motionEvent.getAction()) {
            return super.onTouchEvent(motionEvent);
        }
        dismiss();
        return true;
    }
}
