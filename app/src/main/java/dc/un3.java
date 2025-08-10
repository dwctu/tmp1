package dc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;

/* compiled from: MenuDialog.java */
/* loaded from: classes4.dex */
public class un3 extends AlertDialog {
    public LayoutInflater a;
    public View b;
    public LinearLayout c;
    public LinearLayout d;
    public Context e;
    public int f;
    public int g;

    /* compiled from: MenuDialog.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.a(view.getId());
            un3.this.dismiss();
        }
    }

    /* compiled from: MenuDialog.java */
    public interface b {
        void a(int i);
    }

    /* compiled from: MenuDialog.java */
    public interface c {
        void a(View view);

        void b(View view);
    }

    public un3(Context context) {
        super(context, R.style.MenuDialog);
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = 68;
        this.g = -1;
        this.e = context;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.a = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.menu_sheet_layout, (ViewGroup) null);
        this.b = viewInflate;
        this.c = (LinearLayout) viewInflate.findViewById(R.id.root_layout);
        this.d = (LinearLayout) this.b.findViewById(R.id.content_layout);
        this.c.removeAllViews();
        this.d.removeAllViews();
    }

    public LinearLayout a(String str, boolean z, b bVar) {
        return b(str, z, false, bVar);
    }

    public LinearLayout b(String str, boolean z, boolean z2, b bVar) {
        View viewInflate = this.a.inflate(R.layout.menu_sheet_layout_item, (ViewGroup) null);
        this.d.addView(viewInflate);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.action_row);
        if (bVar != null) {
            linearLayout.setOnClickListener(new a(bVar));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.action_row_text);
        textView.setText(str);
        if (z2) {
            textView.setGravity(17);
        }
        int i = this.f + 45;
        this.f = i;
        if (z) {
            this.f = i + 1;
            this.d.addView(this.a.inflate(R.layout.menu_sheet_layout_line, (ViewGroup) null));
        }
        return linearLayout;
    }

    public void c(View view, int i, int i2, c cVar) {
        int i3;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        view.getLocationOnScreen(iArr);
        int i4 = iArr[1];
        int i5 = iArr[0];
        int width = view.getWidth();
        int height = view.getHeight();
        float f = i;
        int iA = ce3.a(this.e, f);
        int iA2 = ce3.a(this.e, this.f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = iA;
        layoutParams.height = ce3.a(this.e, 6.0f) + iA2;
        this.c.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        int iA3 = ce3.a(this.e, 7590.0f / f);
        layoutParams2.width = iA - (iA3 * 2);
        layoutParams2.height = iA2 - (this.d.getChildCount() * ce3.a(this.e, 3.0f));
        layoutParams2.leftMargin = iA3;
        layoutParams2.rightMargin = iA3;
        this.d.setLayoutParams(layoutParams2);
        int iE = gg3.e(this.e);
        int iC = gg3.c(this.e);
        int i6 = iA / 2;
        int i7 = (iE / 2) - i6;
        int i8 = (iC / 2) - (iA2 / 2);
        int i9 = (((i5 + width) - iA) - i7) + 0;
        if (i5 > i7 + i6) {
            i9 = (i5 - i6) + (width / 2);
        }
        int iA4 = ce3.a(this.e, 56.0f);
        int iA5 = ce3.a(this.e, i2);
        int i10 = (height / 2) + i4 + iA5;
        if (i10 + iA2 > iC - iA4) {
            i3 = ((i4 - iA5) - iA2) - i8;
            if (cVar != null) {
                cVar.b(this.c);
            }
        } else {
            i3 = i10 - i8;
            if (cVar != null) {
                cVar.a(this.c);
            }
        }
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams();
        layoutParams3.x = i9;
        layoutParams3.y = i3;
        layoutParams3.width = iA;
        layoutParams3.height = iA2;
        window.setAttributes(layoutParams3);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = this.b;
        if (view != null) {
            setContentView(view);
        }
        setCanceledOnTouchOutside(true);
    }
}
