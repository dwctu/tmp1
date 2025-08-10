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
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;

/* compiled from: MenuNewDialog.java */
/* loaded from: classes4.dex */
public class vn3 extends AlertDialog {
    public LayoutInflater a;
    public View b;
    public LinearLayout c;
    public GridLayout d;
    public Context e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    /* compiled from: MenuNewDialog.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a(view.getId());
            vn3.this.dismiss();
        }
    }

    /* compiled from: MenuNewDialog.java */
    public interface b {
        void a(int i);
    }

    /* compiled from: MenuNewDialog.java */
    public interface c {
        void a(View view);

        void b(View view);
    }

    public vn3(Context context) {
        super(context, R.style.MenuDialog2);
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = 60;
        this.g = 80;
        this.h = 15;
        this.i = -1;
        this.e = context;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.a = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.menu_new_sheet_layout, (ViewGroup) null);
        this.b = viewInflate;
        this.c = (LinearLayout) viewInflate.findViewById(R.id.root_layout);
        this.d = (GridLayout) this.b.findViewById(R.id.gly);
        this.c.removeAllViews();
        this.d.removeAllViews();
    }

    public LinearLayout a(String str, boolean z, b bVar, int i) {
        return b(str, z, false, bVar, i);
    }

    public LinearLayout b(String str, boolean z, boolean z2, b bVar, int i) {
        View viewInflate = this.a.inflate(R.layout.menu_new_sheet_layout_item, (ViewGroup) null);
        this.d.addView(viewInflate);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.action_row);
        if (bVar != null) {
            linearLayout.setOnClickListener(new a(bVar));
        }
        ((ImageView) viewInflate.findViewById(R.id.iv)).setImageResource(i);
        TextView textView = (TextView) viewInflate.findViewById(R.id.action_row_text);
        textView.setText(str);
        if (z2) {
            textView.setGravity(17);
        }
        this.j++;
        return linearLayout;
    }

    public final void c() {
        getWindow().setFlags(32, 32);
        getWindow().setFlags(262144, 262144);
    }

    public void d(View view, int i, int i2, c cVar) {
        int i3;
        int i4;
        int iA;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        view.getLocationOnScreen(iArr);
        int i5 = iArr[1];
        int i6 = iArr[0];
        int width = view.getWidth();
        int height = view.getHeight();
        int iA2 = ce3.a(this.e, (this.g * 3) + (this.h * 2));
        int i7 = this.j;
        if (i7 == 1 || i7 == 2) {
            iA2 = ce3.a(this.e, (this.g * i7) + (this.h * 2));
        }
        Context context = this.e;
        if (this.j > 3) {
            i3 = this.f * 2;
            i4 = this.h;
        } else {
            i3 = this.f * 1;
            i4 = this.h;
        }
        int iA3 = ce3.a(context, i3 + (i4 * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = iA2;
        layoutParams.height = iA3;
        this.c.setLayoutParams(layoutParams);
        int iE = gg3.e(this.e);
        int iC = gg3.c(this.e);
        int i8 = iA2 / 2;
        int i9 = (iE / 2) - i8;
        int i10 = (iC / 2) - (iA3 / 2);
        int i11 = (((i6 + width) - iA2) - i9) + 0;
        if (i6 > i9 + i8 && this.j > 1) {
            i11 = (i6 - i8) + (width / 2);
        }
        int iA4 = ce3.a(this.e, 56.0f);
        int iA5 = ce3.a(this.e, i2);
        if ((height / 2) + i5 + iA5 + iA3 > iC - iA4) {
            iA = ((i5 - iA5) - iA3) - i10;
            if (cVar != null) {
                cVar.b(this.c);
            }
        } else {
            iA = (i5 - i10) + height + ce3.a(this.e, 8.0f);
            if (cVar != null) {
                cVar.a(this.c);
            }
        }
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.x = i11;
        layoutParams2.y = iA;
        layoutParams2.width = iA2;
        layoutParams2.height = iA3;
        window.setAttributes(layoutParams2);
    }

    public void e(int i) {
        this.i = i;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = this.b;
        if (view != null) {
            setContentView(view);
        }
        setCanceledOnTouchOutside(true);
        c();
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
