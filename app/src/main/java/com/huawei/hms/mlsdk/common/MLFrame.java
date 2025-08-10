package com.huawei.hms.mlsdk.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Pair;
import com.huawei.hms.ml.common.utils.ImageConvertUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class MLFrame {
    public static final int SCREEN_FIRST_QUADRANT = 0;
    public static final int SCREEN_FOURTH_QUADRANT = 3;
    public static final int SCREEN_SECOND_QUADRANT = 1;
    public static final int SCREEN_THIRD_QUADRANT = 2;
    private Bitmap bitmap;
    private ByteBuffer byteBuffer;
    private byte[] bytes;
    private volatile Boolean frameInit;
    private Property property;
    private int recMode;

    public static class Creator {
        private MLFrame frame = new MLFrame();

        public MLFrame create() {
            if (this.frame.byteBuffer == null && this.frame.bitmap == null) {
                throw new IllegalStateException("Failed to create image instance, both bitmap and byteBuffer data are not specified.");
            }
            return this.frame;
        }

        public Creator setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.frame.bitmap = bitmap;
            Property propertyAcquireProperty = this.frame.acquireProperty();
            propertyAcquireProperty.width = width;
            propertyAcquireProperty.height = height;
            return this;
        }

        public Creator setFramePropertyExt(Property.Ext ext) {
            this.frame.acquireProperty().ext = ext;
            return this;
        }

        public Creator setItemIdentity(int i) {
            this.frame.acquireProperty().itemIdentity = i;
            return this;
        }

        public Creator setQuadrant(int i) {
            this.frame.acquireProperty().quadrant = i;
            return this;
        }

        public Creator setTimestamp(long j) {
            this.frame.acquireProperty().timestamp = j;
            return this;
        }

        public Creator writeByteBufferData(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Parameter： data is not specified");
            }
            if (byteBuffer.capacity() < i * i2) {
                throw new IllegalArgumentException("Not enough capacity for image data size.");
            }
            if (i3 != 17 && i3 != 16 && i3 != 842094169) {
                throw new IllegalArgumentException("Parameter formatType:" + i3 + " is not supported");
            }
            this.frame.byteBuffer = byteBuffer;
            Property propertyAcquireProperty = this.frame.acquireProperty();
            if (propertyAcquireProperty != null) {
                propertyAcquireProperty.formatType = i3;
                propertyAcquireProperty.width = i;
                propertyAcquireProperty.height = i2;
            }
            return this;
        }
    }

    public static class Property {
        public static final int IMAGE_FORMAT_NV21 = 17;
        public static final int IMAGE_FORMAT_YV12 = 842094169;
        public static final int SCREEN_FIRST_QUADRANT = 0;
        public static final int SCREEN_FOURTH_QUADRANT = 3;
        public static final int SCREEN_SECOND_QUADRANT = 1;
        public static final int SCREEN_THIRD_QUADRANT = 2;
        private Ext ext;
        private int formatType;
        private int height;
        private int itemIdentity;
        private int quadrant;
        private long timestamp;
        private int width;

        public static class Creator {
            private Ext ext;
            private int formatType;
            private int height;
            private int itemIdentity;
            private int quadrant;
            private long timestamp;
            private int width;

            public Property create() {
                return new Property(this.width, this.height, this.quadrant, this.formatType, this.itemIdentity, this.timestamp, this.ext);
            }

            public Creator setExt(Ext ext) {
                this.ext = ext;
                return this;
            }

            public Creator setFormatType(int i) {
                this.formatType = i;
                return this;
            }

            public Creator setHeight(int i) {
                this.height = i;
                return this;
            }

            public Creator setItemIdentity(int i) {
                this.itemIdentity = i;
                return this;
            }

            public Creator setQuadrant(int i) {
                this.quadrant = i;
                return this;
            }

            public Creator setTimestamp(int i) {
                this.timestamp = i;
                return this;
            }

            public Creator setWidth(int i) {
                this.width = i;
                return this;
            }
        }

        public static class Ext {
            private int lensId;
            private int maxZoom;
            private Rect rect;
            private int zoom;

            public static class Creator {
                private int maxZoom;
                private Rect rect;
                private int lensId = 0;
                private int zoom = 0;

                public Ext build() {
                    return new Ext(this.lensId, this.zoom, this.maxZoom, this.rect);
                }

                public Creator setLensId(int i) {
                    this.lensId = i;
                    return this;
                }

                public Creator setMaxZoom(int i) {
                    this.maxZoom = i;
                    return this;
                }

                public Creator setRect(Rect rect) {
                    this.rect = rect;
                    return this;
                }

                public Creator setZoom(int i) {
                    this.zoom = i;
                    return this;
                }
            }

            public int getLensId() {
                return this.lensId;
            }

            public int getMaxZoom() {
                return this.maxZoom;
            }

            public Rect getRect() {
                return this.rect;
            }

            public int getZoom() {
                return this.zoom;
            }

            private Ext(int i, int i2, int i3, Rect rect) {
                this.lensId = 0;
                this.zoom = 0;
                this.lensId = i;
                this.zoom = i2;
                this.maxZoom = i3;
                this.rect = rect;
            }
        }

        public Ext getExt() {
            return this.ext;
        }

        public int getFormatType() {
            return this.formatType;
        }

        public int getHeight() {
            return this.height;
        }

        public int getItemIdentity() {
            return this.itemIdentity;
        }

        public int getQuadrant() {
            return this.quadrant;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public int getWidth() {
            return this.width;
        }

        public void resetWidthAndHeight() {
            if (this.quadrant % 2 != 0) {
                int i = this.width;
                this.width = this.height;
                this.height = i;
            }
            this.quadrant = 0;
        }

        public Property() {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.ext = new Ext.Creator().build();
        }

        public Property(Property property) {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.width = property.getWidth();
            this.height = property.getHeight();
            this.formatType = property.getFormatType();
            this.quadrant = property.getQuadrant();
            this.itemIdentity = property.getItemIdentity();
            this.timestamp = property.getTimestamp();
            this.ext = property.getExt();
        }

        private Property(int i, int i2, int i3, int i4, int i5, long j, Ext ext) {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.width = i;
            this.height = i2;
            this.quadrant = i3;
            this.formatType = i4;
            this.itemIdentity = i5;
            this.timestamp = j;
            this.ext = ext;
        }
    }

    public MLFrame() {
        this.frameInit = Boolean.FALSE;
        this.property = new Property();
        this.byteBuffer = null;
        this.bitmap = null;
    }

    public static MLFrame fromBitmap(Bitmap bitmap) {
        return new MLFrame(bitmap);
    }

    public static MLFrame fromByteArray(byte[] bArr, Property property) {
        return new MLFrame(bArr, property);
    }

    public static MLFrame fromByteBuffer(ByteBuffer byteBuffer, Property property) {
        return new MLFrame(byteBuffer, property);
    }

    public static MLFrame fromFilePath(Context context, Uri uri) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Parameter context is mandatory");
        }
        if (uri == null) {
            throw new IllegalArgumentException("Parameter uri is mandatory");
        }
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        if (bitmap != null) {
            return new MLFrame(bitmap);
        }
        throw new RuntimeException("Failed to load bitmap from uri");
    }

    @TargetApi(19)
    public static MLFrame fromMediaImage(Image image, int i) {
        int format = image.getFormat();
        if (format != 256 && format != 35) {
            throw new IllegalArgumentException("Unsupported format: " + image.getFormat() + ", Only JPEG and YUV_420_888 are supported");
        }
        MLFrame mLFrame = null;
        if (format == 256) {
            Image.Plane[] planes = image.getPlanes();
            if (planes != null && planes.length == 1 && planes[0] != null && planes[0].getBuffer() != null) {
                ByteBuffer buffer = planes[0].getBuffer();
                int iRemaining = buffer.remaining();
                byte[] bArr = new byte[iRemaining];
                buffer.get(bArr);
                mLFrame = i != 0 ? new MLFrame(rotate(BitmapFactory.decodeByteArray(bArr, 0, iRemaining), i)) : new MLFrame(bArr);
            }
        } else {
            Property.Creator creator = new Property.Creator();
            creator.setFormatType(17).setWidth(image.getWidth()).setHeight(image.getHeight()).setQuadrant(i);
            mLFrame = new MLFrame(ImageConvertUtils.getDataFromImage(image, 2), creator.create());
        }
        if (mLFrame != null) {
            return mLFrame;
        }
        throw new IllegalStateException("Failed to create frame from media image.");
    }

    private Pair<Integer, Integer> getPreviewSize() {
        Property property = this.property;
        if (property == null) {
            return null;
        }
        if (property.getItemIdentity() == -1) {
            return Pair.create(Integer.valueOf(wrapBitmap().getWidth()), Integer.valueOf(wrapBitmap().getHeight()));
        }
        boolean z = true;
        if (this.property.getQuadrant() != 1 && this.property.getQuadrant() != 3) {
            z = false;
        }
        Property property2 = this.property;
        return Pair.create(Integer.valueOf(z ? property2.getHeight() : property2.getWidth()), Integer.valueOf(z ? this.property.getWidth() : this.property.getHeight()));
    }

    private boolean isSupportedYuvFormat(int i) {
        return i == 842094169 || i == 17;
    }

    public static Bitmap rotate(Bitmap bitmap, int i) {
        if (i < 0 || i > 3) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Invalid quadrant: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i * 90);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private final Bitmap wrapBitmap() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return bitmap;
        }
        if (this.property != null) {
            try {
                byte[] bArrWrapJpeg = wrapJpeg(false);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrWrapJpeg, 0, bArrWrapJpeg.length);
                if (this.property.getQuadrant() != 0) {
                    bitmapDecodeByteArray = rotate(bitmapDecodeByteArray, this.property.getQuadrant());
                }
                this.bitmap = bitmapDecodeByteArray;
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | Exception unused) {
                return null;
            }
        }
        return this.bitmap;
    }

    public ByteBuffer acquireGrayByteBuffer() {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer != null && this.property != null) {
            ImageConvertUtils.nv21ToGray(byteBuffer.array(), this.property.width, this.property.height);
        }
        return this.byteBuffer;
    }

    public Property acquireProperty() {
        return this.property;
    }

    public final Pair<byte[], Float> create(int i, int i2) throws IOException {
        byte[] bArrBitmap2Jpeg;
        int iIntValue = ((Integer) getPreviewSize().first).intValue();
        int iIntValue2 = ((Integer) getPreviewSize().second).intValue();
        float fMin = Math.min(i / iIntValue, i2 / iIntValue2);
        float f = 1.0f;
        if (fMin >= 1.0f) {
            bArrBitmap2Jpeg = wrapJpeg(true);
        } else {
            Matrix matrix = new Matrix();
            matrix.postScale(fMin, fMin);
            f = fMin;
            bArrBitmap2Jpeg = ImageConvertUtils.bitmap2Jpeg(Bitmap.createBitmap(wrapBitmap(), 0, 0, iIntValue, iIntValue2, matrix, true), 100);
        }
        return Pair.create(bArrBitmap2Jpeg, Float.valueOf(f));
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public final synchronized MLFrame getFrame(boolean z, boolean z2) {
        if (this.frameInit.booleanValue()) {
            return this;
        }
        if (!z && this.byteBuffer != null) {
            int formatType = this.property.getFormatType();
            if (z2 && formatType != 17) {
                if (formatType == 842094169) {
                    this.byteBuffer = ByteBuffer.wrap(ImageConvertUtils.byteToNv21(ImageConvertUtils.buffer2Byte(this.byteBuffer)));
                }
                Property.Creator creator = new Property.Creator();
                creator.setFormatType(17).setWidth(this.property.getWidth()).setHeight(this.property.getHeight()).setQuadrant(this.property.getQuadrant());
                this.property = creator.create();
                this.frameInit = Boolean.TRUE;
                return this;
            }
            this.frameInit = Boolean.TRUE;
            return this;
        }
        this.bitmap = getPreviewBitmap();
        this.property = new Creator().setBitmap(readBitmap()).create().property;
        this.frameInit = Boolean.TRUE;
        return this;
    }

    public Bitmap getPreviewBitmap() {
        if (this.bytes == null && this.byteBuffer == null && this.bitmap == null) {
            throw new IllegalStateException("At least one of bytes, byteBuffer or bitmap should be not null");
        }
        return wrapBitmap();
    }

    public int getRecMode() {
        return this.recMode;
    }

    public final void initialize() {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer != null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity());
            byteBuffer.rewind();
            byteBufferAllocate.put(byteBuffer);
            byteBuffer.rewind();
            byteBufferAllocate.flip();
            this.byteBuffer = byteBufferAllocate;
        }
    }

    public Bitmap readBitmap() {
        return this.bitmap;
    }

    public void setRecMode(int i) {
        this.recMode = i;
    }

    public final byte[] wrapJpeg(boolean z) throws IOException {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArrNv21ToJpeg = null;
        if (this.byteBuffer != null) {
            int formatType = this.property.getFormatType();
            if (!isSupportedYuvFormat(formatType)) {
                throw new IllegalStateException("Only support NV21 or YV12");
            }
            if (!z || this.property.getQuadrant() == 0) {
                byte[] bArrBuffer2Byte = ImageConvertUtils.buffer2Byte(this.byteBuffer);
                if (842094169 == formatType) {
                    bArrBuffer2Byte = ImageConvertUtils.byteToNv21(bArrBuffer2Byte);
                }
                bArrNv21ToJpeg = ImageConvertUtils.nv21ToJpeg(bArrBuffer2Byte, this.property.getWidth(), this.property.getHeight());
                if (this.property.getQuadrant() == 0) {
                    this.bytes = bArrNv21ToJpeg;
                }
            }
        }
        if (bArrNv21ToJpeg != null) {
            return bArrNv21ToJpeg;
        }
        byte[] bArrBitmap2Jpeg = ImageConvertUtils.bitmap2Jpeg(wrapBitmap(), 100);
        this.bytes = bArrBitmap2Jpeg;
        return bArrBitmap2Jpeg;
    }

    private MLFrame(ByteBuffer byteBuffer, Property property) {
        this.frameInit = Boolean.FALSE;
        this.byteBuffer = byteBuffer;
        this.property = property == null ? new Property() : property;
    }

    private MLFrame(byte[] bArr, Property property) {
        this(ByteBuffer.wrap(bArr), property);
    }

    private MLFrame(Bitmap bitmap) {
        this.frameInit = Boolean.FALSE;
        this.bitmap = bitmap;
    }

    private MLFrame(Bitmap bitmap, Property property) {
        this.frameInit = Boolean.FALSE;
        this.bitmap = bitmap;
        this.property = property == null ? new Property() : property;
    }

    private MLFrame(byte[] bArr) {
        this.frameInit = Boolean.FALSE;
        this.bytes = bArr;
    }
}
