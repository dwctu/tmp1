package dc;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: SoftKeyBoardListener.java */
/* loaded from: classes3.dex */
public class ov1 {
    public int a;
    public b b;

    /* compiled from: SoftKeyBoardListener.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.a.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height();
            ov1 ov1Var = ov1.this;
            int i = ov1Var.a;
            if (i == 0) {
                ov1Var.a = iHeight;
                return;
            }
            if (i == iHeight) {
                return;
            }
            if (i - iHeight > 200) {
                if (ov1Var.b != null) {
                    ov1.this.b.b(ov1.this.a - iHeight);
                }
                ov1.this.a = iHeight;
            } else if (iHeight - i > 200) {
                if (ov1Var.b != null) {
                    ov1.this.b.a(iHeight - ov1.this.a);
                }
                ov1.this.a = iHeight;
            }
        }
    }

    /* compiled from: SoftKeyBoardListener.java */
    public interface b {
        void a(int i);

        void b(int i);
    }

    public ov1(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view));
    }

    public void b(b bVar) {
        c(bVar);
    }

    public final void c(b bVar) {
        this.b = bVar;
    }
}
