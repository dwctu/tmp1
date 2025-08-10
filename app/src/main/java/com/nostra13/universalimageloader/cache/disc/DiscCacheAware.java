package com.nostra13.universalimageloader.cache.disc;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: classes3.dex */
public interface DiscCacheAware {
    void clear();

    void close();

    File get(String str);

    File getDirectory();

    boolean remove(String str);

    boolean save(String str, Bitmap bitmap) throws IOException;

    boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) throws IOException;
}
