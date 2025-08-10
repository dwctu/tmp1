package com.component.dxutilcode.lib.utils;

import android.app.Application;
import androidx.core.content.FileProvider;
import dc.ve0;

/* loaded from: classes.dex */
public class UtilsFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        ve0.b((Application) getContext().getApplicationContext());
        return true;
    }
}
