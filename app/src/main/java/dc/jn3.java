package dc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.lovense.wear.R;

/* compiled from: CenterToast.java */
/* loaded from: classes4.dex */
public class jn3 {

    /* compiled from: CenterToast.java */
    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;

        public a(Context context, Integer num, String str, int i) {
            this.a = context;
            this.b = num;
            this.c = str;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.layout_centre_toast, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.toast_icon);
            if (this.b == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(this.b.intValue());
            }
            ((TextView) viewInflate.findViewById(R.id.toast_message)).setText(this.c);
            Toast toast = new Toast(this.a);
            toast.setGravity(17, 0, 100);
            toast.setDuration(this.d);
            toast.setView(viewInflate);
            toast.show();
        }
    }

    public static void a(Context context, String str, Integer num) {
        b(context, str, num, 0);
    }

    public static void b(Context context, String str, Integer num, int i) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).runOnUiThread(new a(context, num, str, i));
        }
    }
}
