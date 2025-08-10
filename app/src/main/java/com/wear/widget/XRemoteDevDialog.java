package com.wear.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.adapter.GalleyUsedAdapter;
import com.wear.bean.GalleryUsedBean;
import com.wear.widget.dialog.CustomBottomSheetDialog;
import dc.br;
import dc.ce3;
import dc.pc1;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class XRemoteDevDialog extends CustomBottomSheetDialog implements View.OnClickListener {
    public a b;
    public TextView c;
    public RecyclerView d;
    public LinearLayoutManager e;
    public GalleyUsedAdapter f;
    public b g;

    public interface a {
        void a(b bVar);
    }

    public enum b {
        COMMON_SETTING,
        COMMON_PATTERNS_TOYS,
        APP_GALLERY_BUTTON_REOPEN,
        CANCEL
    }

    public XRemoteDevDialog(Context context) {
        super(context);
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(int[] iArr, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        int i2 = iArr[i];
        if (i2 == R.string.app_gallery_buttion_reopen) {
            this.g = b.APP_GALLERY_BUTTON_REOPEN;
        } else if (i2 == R.string.common_patterns_toys) {
            this.g = b.COMMON_PATTERNS_TOYS;
        } else if (i2 == R.string.common_setting) {
            this.g = b.COMMON_SETTING;
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.g);
        }
    }

    public final void e(View view) {
        this.d = (RecyclerView) view.findViewById(R.id.recyclerView);
        ArrayList arrayList = new ArrayList();
        final int[] iArr = {R.string.common_setting, R.string.common_patterns_toys, R.string.app_gallery_buttion_reopen};
        int[] iArr2 = {R.drawable.gallery_setting, pc1.a.P().size() > 0 ? R.drawable.gallery_toy_connect : R.drawable.gallery_toy_disconnect, R.drawable.gallery_reload};
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < 3; i++) {
            linkedList.add(i, Integer.valueOf(iArr[i]));
            linkedList2.add(i, Integer.valueOf(iArr2[i]));
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            GalleryUsedBean galleryUsedBean = new GalleryUsedBean();
            galleryUsedBean.setUsedName(((Integer) linkedList.get(i2)).intValue());
            galleryUsedBean.setUsedImg(((Integer) linkedList2.get(i2)).intValue());
            arrayList.add(galleryUsedBean);
        }
        this.f = new GalleyUsedAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.e = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.d.setLayoutManager(this.e);
        this.d.setAdapter(this.f);
        this.f.y0(arrayList);
        this.d.addItemDecoration(new com.library.flowlayout.SpaceItemDecoration(ce3.a(getContext(), 12.0f)));
        TextView textView = (TextView) view.findViewById(R.id.cancel_tv);
        this.c = textView;
        textView.setOnClickListener(this);
        this.f.E0(new br() { // from class: dc.hn3
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i3) {
                this.a.g(iArr, baseQuickAdapter, view2, i3);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.cancel_tv) {
            return;
        }
        b bVar = b.CANCEL;
        this.g = bVar;
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(bVar);
        }
        dismiss();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_xremote_dev, (ViewGroup) null);
        setContentView(viewInflate);
        e(viewInflate);
    }

    public XRemoteDevDialog(Context context, a aVar) {
        super(context);
        this.g = null;
        this.b = aVar;
    }
}
