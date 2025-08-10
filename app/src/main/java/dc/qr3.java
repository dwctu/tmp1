package dc;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.lovense.wear.R;
import dc.zt3;
import java.util.ArrayList;

/* compiled from: AlarmNoticesDialog.java */
/* loaded from: classes4.dex */
public class qr3 extends Dialog {
    public Context a;
    public ArrayList<zt3.g> b;

    /* compiled from: AlarmNoticesDialog.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            qr3.this.dismiss();
        }
    }

    public qr3(@NonNull Context context, ArrayList<zt3.g> arrayList) {
        super(context, R.style.dialog);
        this.a = context;
        this.b = arrayList;
        a();
    }

    public final void a() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_alarm_notices_layout, (ViewGroup) null);
        setContentView(viewInflate);
        ((ListView) viewInflate.findViewById(R.id.lv_alarm_from)).setAdapter((ListAdapter) new tj1(this.b));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = ce3.a(this.a, 280.0f);
        attributes.height = ce3.a(this.a, 320.0f);
        window.setAttributes(attributes);
        viewInflate.findViewById(R.id.tv_done).setOnClickListener(new a());
    }
}
