package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import io.agora.rtc2.Constants;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class BaseImageDecoder implements ImageDecoder {
    public static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    public static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    public static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    public static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    public static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    public final boolean loggingEnabled;

    public static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        public ImageFileInfo(ImageSize imageSize, ExifInfo exifInfo) {
            this.imageSize = imageSize;
            this.exif = exifInfo;
        }
    }

    public BaseImageDecoder(boolean z) {
        this.loggingEnabled = z;
    }

    private boolean canDefineExifParams(String str, String str2) {
        return MimeTypes.IMAGE_JPEG.equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    public Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imageDecodingInfo, int i, boolean z) {
        Matrix matrix = new Matrix();
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.EXACTLY || imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize imageSize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i);
            float fComputeImageScale = ImageSizeUtils.computeImageScale(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(fComputeImageScale, 1.0f) != 0) {
                matrix.setScale(fComputeImageScale, fComputeImageScale);
                if (this.loggingEnabled) {
                    L.d(LOG_SCALE_IMAGE, imageSize, imageSize.scale(fComputeImageScale), Float.valueOf(fComputeImageScale), imageDecodingInfo.getImageKey());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                L.d(LOG_FLIP_IMAGE, imageDecodingInfo.getImageKey());
            }
        }
        if (i != 0) {
            matrix.postRotate(i);
            if (this.loggingEnabled) {
                L.d(LOG_ROTATE_IMAGE, Integer.valueOf(i), imageDecodingInfo.getImageKey());
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    @Override // com.nostra13.universalimageloader.core.decode.ImageDecoder
    public Bitmap decode(ImageDecodingInfo imageDecodingInfo) throws IOException {
        InputStream imageStream = getImageStream(imageDecodingInfo);
        try {
            ImageFileInfo imageFileInfoDefineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
            imageStream = resetStream(imageStream, imageDecodingInfo);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(imageStream, null, prepareDecodingOptions(imageFileInfoDefineImageSizeAndRotation.imageSize, imageDecodingInfo));
            if (bitmapDecodeStream == null) {
                L.e(ERROR_CANT_DECODE_IMAGE, imageDecodingInfo.getImageKey());
                return bitmapDecodeStream;
            }
            ExifInfo exifInfo = imageFileInfoDefineImageSizeAndRotation.exif;
            return considerExactScaleAndOrientatiton(bitmapDecodeStream, imageDecodingInfo, exifInfo.rotation, exifInfo.flipHorizontal);
        } finally {
            IoUtils.closeSilently(imageStream);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public ExifInfo defineExifOrientation(String str) {
        int i = 0;
        boolean z = 1;
        try {
        } catch (IOException unused) {
            L.w("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1)) {
            case 1:
            default:
                z = 0;
                break;
            case 2:
                break;
            case 3:
                z = i;
                i = 180;
                break;
            case 4:
                i = 1;
                z = i;
                i = 180;
                break;
            case 5:
                i = 1;
                z = i;
                i = Constants.VIDEO_ORIENTATION_270;
                break;
            case 6:
                z = i;
                i = 90;
                break;
            case 7:
                i = 1;
                z = i;
                i = 90;
                break;
            case 8:
                z = i;
                i = Constants.VIDEO_ORIENTATION_270;
                break;
        }
        return new ExifInfo(i, z);
    }

    public ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String imageUri = imageDecodingInfo.getImageUri();
        ExifInfo exifInfoDefineExifOrientation = (imageDecodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) ? defineExifOrientation(imageUri) : new ExifInfo();
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exifInfoDefineExifOrientation.rotation), exifInfoDefineExifOrientation);
    }

    public InputStream getImageStream(ImageDecodingInfo imageDecodingInfo) throws IOException {
        return imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader());
    }

    public BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo imageDecodingInfo) {
        int iComputeImageSampleSize;
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.NONE) {
            iComputeImageSampleSize = 1;
        } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
            iComputeImageSampleSize = ImageSizeUtils.computeMinImageSampleSize(imageSize);
        } else {
            iComputeImageSampleSize = ImageSizeUtils.computeImageSampleSize(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (iComputeImageSampleSize > 1 && this.loggingEnabled) {
            L.d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(iComputeImageSampleSize), Integer.valueOf(iComputeImageSampleSize), imageDecodingInfo.getImageKey());
        }
        BitmapFactory.Options decodingOptions = imageDecodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = iComputeImageSampleSize;
        return decodingOptions;
    }

    public InputStream resetStream(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) throws IOException {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException unused) {
            IoUtils.closeSilently(inputStream);
            return getImageStream(imageDecodingInfo);
        }
    }

    public static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        public ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        public ExifInfo(int i, boolean z) {
            this.rotation = i;
            this.flipHorizontal = z;
        }
    }
}
