package com.yydcdut.sdlv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import dc.bv3;
import dc.yu3;
import java.util.List;

/* loaded from: classes4.dex */
public class SlideAndDragListView extends SlideListView {

    public interface a {
        void a(int i, int i2);

        void b(int i);

        void c(int i);
    }

    public interface b {
        void a(View view, int i);
    }

    public interface c {
        void a(View view, int i);
    }

    public interface d {
        int b(View view, int i, int i2, int i3);
    }

    public interface e {
        void a(View view, View view2, int i, int i2);

        void b(View view, View view2, int i, int i2);
    }

    public SlideAndDragListView(Context context) {
        this(context, null);
    }

    @Override // com.yydcdut.sdlv.SlideListView, android.widget.ListView, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    @Override // com.yydcdut.sdlv.SlideListView
    public /* bridge */ /* synthetic */ void setMenu(yu3 yu3Var) {
        super.setMenu(yu3Var);
    }

    public void setNotDragFooterCount(int i) {
        bv3 wrapperAdapter = getWrapperAdapter();
        if (wrapperAdapter != null) {
            wrapperAdapter.D(wrapperAdapter.getCount() - i);
        }
    }

    public void setNotDragHeaderCount(int i) {
        bv3 wrapperAdapter = getWrapperAdapter();
        if (wrapperAdapter != null) {
            wrapperAdapter.L(i - 1);
        }
    }

    @Override // com.yydcdut.sdlv.DragListView
    public /* bridge */ /* synthetic */ void setOnDragDropListener(a aVar) {
        super.setOnDragDropListener(aVar);
    }

    @Override // com.yydcdut.sdlv.SlideListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    @Override // com.yydcdut.sdlv.SlideListView
    public /* bridge */ /* synthetic */ void setOnItemDeleteListener(b bVar) {
        super.setOnItemDeleteListener(bVar);
    }

    @Override // com.yydcdut.sdlv.SlideListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        super.setOnItemLongClickListener(onItemLongClickListener);
    }

    @Override // com.yydcdut.sdlv.SlideListView
    public /* bridge */ /* synthetic */ void setOnItemScrollBackListener(c cVar) {
        super.setOnItemScrollBackListener(cVar);
    }

    @Override // com.yydcdut.sdlv.SlideListView
    public /* bridge */ /* synthetic */ void setOnMenuItemClickListener(d dVar) {
        super.setOnMenuItemClickListener(dVar);
    }

    @Override // com.yydcdut.sdlv.SlideListView, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        super.setOnScrollListener(onScrollListener);
    }

    @Override // com.yydcdut.sdlv.SlideListView
    public /* bridge */ /* synthetic */ void setOnSlideListener(e eVar) {
        super.setOnSlideListener(eVar);
    }

    public SlideAndDragListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.yydcdut.sdlv.SlideListView
    public /* bridge */ /* synthetic */ void setMenu(List list) {
        super.setMenu((List<yu3>) list);
    }

    public SlideAndDragListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.yydcdut.sdlv.SlideListView
    public /* bridge */ /* synthetic */ void setMenu(yu3[] yu3VarArr) {
        super.setMenu(yu3VarArr);
    }
}
