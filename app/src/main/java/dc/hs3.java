package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.ToyLedBean;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: LedColorDialog.java */
/* loaded from: classes4.dex */
public class hs3 extends Dialog {
    public Map<Integer, ToyLedBean> a;
    public zo1 b;
    public Context c;
    public int d;

    /* compiled from: LedColorDialog.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            hs3.this.dismiss();
        }
    }

    /* compiled from: LedColorDialog.java */
    public interface b {
        void k0(ToyLedBean toyLedBean);
    }

    public hs3(Context context, int i) {
        super(context, R.style.MaterialDialogSheet);
        this.c = context;
        this.d = i;
    }

    public void a(Map<Integer, ToyLedBean> map, Toy toy, Activity activity, b bVar) {
        this.a = map;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, ToyLedBean> entry : map.entrySet()) {
            if (toy.getaColor() == entry.getKey().intValue()) {
                entry.getValue().setSelect(true);
            } else {
                entry.getValue().setSelect(false);
            }
            arrayList.add(entry.getValue());
        }
        zo1 zo1Var = new zo1(arrayList, activity, R.layout.item_led_color);
        this.b = zo1Var;
        zo1Var.c(bVar);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(LayoutInflater.from(this.c).inflate(this.d, (ViewGroup) null));
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        ((GridView) findViewById(R.id.gv_list)).setAdapter((ListAdapter) this.b);
        findViewById(R.id.tv_cancel).setOnClickListener(new a());
    }
}
