package com.wear.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.bean.Account;
import dc.is3;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes4.dex */
public class ChangeOnLineStatusDialog extends is3<Account> {
    public a f;

    @BindView(R.id.iv_available)
    public ImageView ivAvailable;

    @BindView(R.id.iv_busy)
    public ImageView ivBusy;

    @BindView(R.id.iv_invisible)
    public ImageView ivInvisible;

    public interface a {
        void a(Presence.Mode mode);
    }

    public ChangeOnLineStatusDialog(Context context) {
        super(context, R.style.MaterialDialogSheet);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_change_on_line_status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.is3
    public void i() {
        super.i();
        Presence.Mode statusMode = ((Account) this.c).getStatusMode();
        if (statusMode == Presence.Mode.dnd) {
            this.ivAvailable.setVisibility(4);
            this.ivBusy.setVisibility(0);
            this.ivInvisible.setVisibility(4);
        } else if (statusMode == Presence.Mode.away) {
            this.ivAvailable.setVisibility(4);
            this.ivBusy.setVisibility(4);
            this.ivInvisible.setVisibility(0);
        } else {
            this.ivAvailable.setVisibility(0);
            this.ivBusy.setVisibility(4);
            this.ivInvisible.setVisibility(4);
        }
    }

    @OnClick({R.id.ll_available, R.id.ll_busy, R.id.ll_invisible})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_available) {
            dismiss();
            a aVar = this.f;
            if (aVar != null) {
                aVar.a(Presence.Mode.chat);
                return;
            }
            return;
        }
        if (id == R.id.ll_busy) {
            dismiss();
            a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a(Presence.Mode.dnd);
                return;
            }
            return;
        }
        if (id != R.id.ll_invisible) {
            return;
        }
        dismiss();
        a aVar3 = this.f;
        if (aVar3 != null) {
            aVar3.a(Presence.Mode.away);
        }
    }

    public void setListener(a aVar) {
        this.f = aVar;
    }

    @Override // dc.is3, android.app.Dialog
    public void show() {
        super.show();
        setCanceledOnTouchOutside(true);
    }
}
