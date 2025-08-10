package com.wear.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.discover.FFBasicSelectMsgAdapter;
import com.wear.bean.FFBasicMsgBean;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import dc.cg3;
import java.util.List;

/* loaded from: classes4.dex */
public class FFBasicMsgSelectDialog extends Dialog {
    public final List<FFBasicMsgBean> a;
    public Context b;
    public FFBasicSelectMsgAdapter c;
    public b d;

    @BindView(R.id.rv_select)
    public RecyclerView rvSelect;

    @BindView(R.id.tv_title)
    public MediumBoldTextView tvTitle;

    public class a implements BaseAdapter.b<FFBasicMsgBean> {
        public a() {
        }

        @Override // com.wear.adapter.BaseAdapter.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void a0(FFBasicMsgBean fFBasicMsgBean, int i, View view) {
            for (int i2 = 0; i2 < FFBasicMsgSelectDialog.this.a.size(); i2++) {
                if (fFBasicMsgBean.getValue() == ((FFBasicMsgBean) FFBasicMsgSelectDialog.this.a.get(i2)).getValue()) {
                    ((FFBasicMsgBean) FFBasicMsgSelectDialog.this.a.get(i2)).setSelect(true);
                    b bVar = FFBasicMsgSelectDialog.this.d;
                    if (bVar != null) {
                        bVar.a(fFBasicMsgBean);
                    }
                } else {
                    ((FFBasicMsgBean) FFBasicMsgSelectDialog.this.a.get(i2)).setSelect(false);
                }
            }
            FFBasicMsgSelectDialog.this.c.notifyDataSetChanged();
            FFBasicMsgSelectDialog.this.dismiss();
        }
    }

    public interface b {
        void a(FFBasicMsgBean fFBasicMsgBean);
    }

    public FFBasicMsgSelectDialog(Context context, List<FFBasicMsgBean> list) {
        super(context, R.style.MaterialDialogSheet);
        this.b = context;
        this.a = list;
    }

    public void c() {
        setContentView(LayoutInflater.from(this.b).inflate(R.layout.dialog_ff_age_gender_orientation, (ViewGroup) null));
        ButterKnife.bind(this);
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        FFBasicSelectMsgAdapter fFBasicSelectMsgAdapter = new FFBasicSelectMsgAdapter(this.a, R.layout.item_ff_basic_msg);
        this.c = fFBasicSelectMsgAdapter;
        cg3.a(this.rvSelect, fFBasicSelectMsgAdapter, 3);
        this.c.s(new a());
    }

    public void d(b bVar) {
        this.d = bVar;
    }

    public void e(int i) {
        MediumBoldTextView mediumBoldTextView = this.tvTitle;
        if (mediumBoldTextView == null) {
            return;
        }
        if (i == 0) {
            mediumBoldTextView.setText(this.b.getString(R.string.user_infor_age));
        } else if (i == 1) {
            mediumBoldTextView.setText("Gender");
        } else {
            if (i != 2) {
                return;
            }
            mediumBoldTextView.setText(ExifInterface.TAG_ORIENTATION);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
    }
}
