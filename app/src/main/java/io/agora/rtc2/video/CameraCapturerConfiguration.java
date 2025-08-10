package io.agora.rtc2.video;

import io.agora.base.internal.CalledByNative;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class CameraCapturerConfiguration {
    public CAMERA_DIRECTION cameraDirection;
    public CaptureFormat captureFormat;
    public boolean followEncodeDimensionRatio;

    public enum CAMERA_DIRECTION {
        CAMERA_REAR(0),
        CAMERA_FRONT(1);

        private int value;

        CAMERA_DIRECTION(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class CaptureFormat {
        public int fps;
        public int height;
        public int width;

        public CaptureFormat() {
            this.width = 640;
            this.height = 480;
            this.fps = 15;
        }

        public CaptureFormat(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.fps = i3;
        }

        @CalledByNative("CaptureFormat")
        public int getFps() {
            return this.fps;
        }

        @CalledByNative("CaptureFormat")
        public int getHeight() {
            return this.height;
        }

        @CalledByNative("CaptureFormat")
        public int getWidth() {
            return this.width;
        }

        public String toString() {
            return "CaptureFormat{width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + MessageFormatter.DELIM_STOP;
        }
    }

    public CameraCapturerConfiguration(CAMERA_DIRECTION camera_direction) {
        this.cameraDirection = camera_direction;
        this.captureFormat = new CaptureFormat();
        this.followEncodeDimensionRatio = true;
    }

    public CameraCapturerConfiguration(CAMERA_DIRECTION camera_direction, CaptureFormat captureFormat) {
        this.cameraDirection = camera_direction;
        this.captureFormat = captureFormat;
        this.followEncodeDimensionRatio = true;
    }

    public CameraCapturerConfiguration(CaptureFormat captureFormat) {
        this.captureFormat = captureFormat;
        this.cameraDirection = CAMERA_DIRECTION.CAMERA_FRONT;
        this.followEncodeDimensionRatio = true;
    }

    @CalledByNative
    public int getCameraDirection() {
        return this.cameraDirection.value;
    }

    @CalledByNative
    public CaptureFormat getCaptureFormat() {
        return this.captureFormat;
    }

    @CalledByNative
    public boolean isFollowEncodeDimensionRatio() {
        return this.followEncodeDimensionRatio;
    }

    public String toString() {
        return "CameraCapturerConfiguration{cameraDirection=" + this.cameraDirection + ", captureDimensions=" + this.captureFormat + ", followEncodeDimensionRatio=" + this.followEncodeDimensionRatio + MessageFormatter.DELIM_STOP;
    }
}
