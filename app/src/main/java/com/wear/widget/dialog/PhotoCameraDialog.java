package com.wear.widget.dialog;

import android.content.Context;
import android.view.View;
import butterknife.OnClick;
import com.lovense.wear.R;
import dc.is3;

/* loaded from: classes4.dex */
public class PhotoCameraDialog extends is3 {
    public PhotoCameraDialog(Context context) {
        super(context, R.style.MaterialDialogSheet);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_photo_camera_video;
    }

    @OnClick({R.id.from_album, R.id.from_camera, R.id.cancel_from})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_from /* 2131362285 */:
                dismiss();
                break;
            case R.id.from_album /* 2131362810 */:
                dismiss();
                is3.d dVar = this.a.g;
                if (dVar != null) {
                    dVar.doConfirm();
                    break;
                }
                break;
            case R.id.from_camera /* 2131362811 */:
                dismiss();
                is3.c cVar = this.a.h;
                if (cVar != null) {
                    cVar.doCancel();
                    break;
                }
                break;
        }
    }
}
