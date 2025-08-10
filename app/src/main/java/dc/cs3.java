package dc;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.lovense.wear.R;
import dc.is3;

/* compiled from: DialogFactory.java */
/* loaded from: classes4.dex */
public class cs3 {

    /* compiled from: DialogFactory.java */
    public class a implements DialogInterface.OnCancelListener {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b bVar = this.a;
            if (bVar != null) {
                bVar.onCancel();
            }
        }
    }

    /* compiled from: DialogFactory.java */
    public interface b {
        void onCancel();
    }

    public static is3 a(Context context, CharSequence charSequence, is3.d dVar) {
        return b(context, charSequence, null, dVar);
    }

    public static is3 b(Context context, CharSequence charSequence, CharSequence charSequence2, is3.d dVar) {
        return c(context, charSequence, charSequence2, null, dVar);
    }

    public static is3 c(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, is3.d dVar) {
        return e(context, null, charSequence, charSequence2, charSequence3, dVar, null);
    }

    public static is3 d(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, is3.d dVar, is3.c cVar) {
        is3.b bVar = new is3.b(context);
        bVar.p(charSequence);
        bVar.o(charSequence2);
        bVar.n(charSequence3);
        bVar.d(dVar);
        bVar.c(cVar);
        return h(bVar);
    }

    public static is3 e(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, is3.d dVar, is3.c cVar) {
        is3.b bVar = new is3.b(context);
        bVar.q(charSequence);
        bVar.p(charSequence2);
        bVar.o(charSequence3);
        bVar.n(charSequence4);
        bVar.d(dVar);
        bVar.c(cVar);
        return h(bVar);
    }

    public static is3 f(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z, is3.d dVar, is3.c cVar) {
        is3.b bVar = new is3.b(context);
        bVar.q(charSequence);
        bVar.p(charSequence2);
        bVar.o(charSequence3);
        bVar.n(charSequence4);
        bVar.d(dVar);
        bVar.c(cVar);
        bVar.h(z);
        return h(bVar);
    }

    public static is3 g(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, is3.d dVar) {
        is3.b bVar = new is3.b(context);
        bVar.q(charSequence);
        bVar.p(charSequence2);
        bVar.o(charSequence3);
        bVar.b(false);
        bVar.d(dVar);
        bVar.h(z);
        return h(bVar);
    }

    public static is3 h(is3.b bVar) {
        return i(bVar, is3.class);
    }

    public static <T extends is3> T i(is3.b bVar, Class<T> cls) {
        return (T) bVar.a(cls);
    }

    public static is3 j(Context context, CharSequence charSequence) {
        return k(context, charSequence, null);
    }

    public static is3 k(Context context, CharSequence charSequence, is3.d dVar) {
        return l(context, charSequence, ah4.e(R.string.common_ok), dVar);
    }

    public static is3 l(Context context, CharSequence charSequence, CharSequence charSequence2, is3.d dVar) {
        is3.b bVar = new is3.b(context);
        bVar.p(charSequence);
        bVar.o(charSequence2);
        bVar.k(R.layout.dialog_default_ok);
        bVar.d(dVar);
        return i(bVar, is3.class);
    }

    public static ProgressDialog m(Context context, b bVar) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("");
        progressDialog.setMessage(ah4.e(R.string.common_uploading));
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnCancelListener(new a(bVar));
        return progressDialog;
    }
}
