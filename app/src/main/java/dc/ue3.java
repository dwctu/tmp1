package dc;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* compiled from: KeyBoardUtils.java */
/* loaded from: classes4.dex */
public class ue3 {

    /* compiled from: KeyBoardUtils.java */
    public class a implements Runnable {
        public final /* synthetic */ EditText a;

        public a(EditText editText) {
            this.a = editText;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.requestFocus();
        }
    }

    public static void a(EditText editText, Context context) {
        b(editText, context, true);
    }

    public static void b(EditText editText, Context context, boolean z) {
        InputMethodManager inputMethodManager;
        if (editText == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        if (z) {
            editText.postDelayed(new a(editText), 500L);
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void c(Activity activity) throws Exception {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static void d(EditText editText, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        inputMethodManager.showSoftInput(editText, 0);
        inputMethodManager.toggleSoftInput(0, 1);
    }
}
