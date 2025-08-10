package com.wear.widget.dialog;

import android.content.Context;
import com.lovense.wear.R;
import dc.is3;

/* loaded from: classes4.dex */
public class CrashMessageDialog extends is3<String> {
    public CrashMessageDialog(Context context, int i) {
        super(context, i);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_crash_message;
    }

    public CrashMessageDialog(Context context) {
        super(context);
    }
}
