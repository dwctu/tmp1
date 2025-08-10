package dc;

import android.R;
import android.view.View;
import android.widget.TextView;

/* compiled from: IToast.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class h71 {
    public static TextView a(i71 _this, View view) {
        if (!(view instanceof TextView)) {
            View viewFindViewById = view.findViewById(R.id.message);
            if (viewFindViewById instanceof TextView) {
                return (TextView) viewFindViewById;
            }
            throw new IllegalArgumentException("You must include a TextView with an ID value of message (xml code: android:id=\"@android:id/message\", java code: view.setId(android.R.id.message))");
        }
        if (view.getId() == -1) {
            view.setId(R.id.message);
        } else if (view.getId() != 16908299) {
            throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message");
        }
        return (TextView) view;
    }
}
