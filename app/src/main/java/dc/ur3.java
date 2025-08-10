package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.lovense.wear.R;

/* compiled from: BurnAfterReadingTipDialog.java */
/* loaded from: classes4.dex */
public class ur3 extends Dialog {
    public View a;
    public int[] b;

    /* compiled from: BurnAfterReadingTipDialog.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Window window = ur3.this.getWindow();
            WindowManager.LayoutParams attributes = ur3.this.getWindow().getAttributes();
            attributes.gravity = 51;
            attributes.y = ur3.this.b[1] - ur3.this.a.getHeight();
            int[] iArr = new int[2];
            ur3.this.a.findViewById(R.id.iv_burn_after_reading).getLocationInWindow(iArr);
            attributes.x = ur3.this.b[0] - iArr[0];
            window.setAttributes(attributes);
        }
    }

    public ur3(@NonNull Context context, int[] iArr) {
        super(context, R.style.FulldialogNoAnimation);
        this.b = iArr;
    }

    public final void c() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public void d() {
        this.a.post(new a());
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.dialog_burn_after_reading_tip, (ViewGroup) null);
        this.a = viewGroup;
        setContentView(viewGroup);
        c();
        d();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        dismiss();
        return super.onTouchEvent(motionEvent);
    }
}
