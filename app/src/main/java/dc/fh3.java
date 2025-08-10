package dc;

import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.wear.util.WearUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: WearImageDecoder.java */
/* loaded from: classes4.dex */
public class fh3 extends BaseImageDecoder {
    public Map<String, ImageSize> a;

    public fh3(boolean z) {
        super(z);
        this.a = new ConcurrentHashMap();
    }

    public ImageSize a(String str) {
        Map<String, ImageSize> map = this.a;
        if (WearUtils.e1(str)) {
            str = "";
        }
        return map.get(str);
    }

    @Override // com.nostra13.universalimageloader.core.decode.BaseImageDecoder
    public BaseImageDecoder.ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) throws IOException {
        BaseImageDecoder.ImageFileInfo imageFileInfoDefineImageSizeAndRotation = super.defineImageSizeAndRotation(inputStream, imageDecodingInfo);
        this.a.put(imageDecodingInfo.getOriginalImageUri(), imageFileInfoDefineImageSizeAndRotation.imageSize);
        return imageFileInfoDefineImageSizeAndRotation;
    }
}
