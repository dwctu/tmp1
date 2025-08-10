package com.epicgames.unreal;

import android.content.Context;
import android.view.ViewGroup;
import com.epicgames.unreal.WebViewControl;

/* compiled from: WebViewControl.java */
/* loaded from: classes.dex */
public class WebViewPositionLayout extends ViewGroup {
    private WebViewControl webViewControl;

    public WebViewPositionLayout(Context context, WebViewControl webViewControl) {
        super(context);
        this.webViewControl = webViewControl;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WebViewControl webViewControl = this.webViewControl;
        WebViewControl.GLWebView gLWebView = webViewControl.webView;
        int i5 = webViewControl.curX;
        int i6 = webViewControl.curY;
        gLWebView.layout(i5, i6, webViewControl.curW + i5, webViewControl.curH + i6);
    }
}
