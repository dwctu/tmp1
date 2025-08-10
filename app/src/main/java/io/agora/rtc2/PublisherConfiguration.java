package io.agora.rtc2;

import io.agora.rtc2.internal.Logging;
import io.agora.rtc2.video.VideoCaptureFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PublisherConfiguration {
    private JSONObject jsonObject;

    public static class Builder {
        private PublisherParameters params = new PublisherParameters();

        public Builder bitRate(int i) {
            this.params.bitrate = i;
            return this;
        }

        public PublisherConfiguration build() {
            return new PublisherConfiguration(this);
        }

        public Builder defaultLayout(int i) {
            this.params.defaultLayout = i;
            return this;
        }

        public Builder extraInfo(String str) {
            this.params.extraInfo = str;
            return this;
        }

        public Builder frameRate(int i) {
            this.params.framerate = i;
            return this;
        }

        public Builder injectStream(String str, int i, int i2) {
            if (str != null && i != 0 && i2 != 0) {
                PublisherParameters publisherParameters = this.params;
                publisherParameters.injectStreamUrl = str;
                publisherParameters.injectStreamWidth = i;
                publisherParameters.injectStreamHeight = i2;
            }
            return this;
        }

        public Builder owner(boolean z) {
            this.params.owner = z;
            return this;
        }

        public Builder publishUrl(String str) {
            this.params.publishUrl = str;
            return this;
        }

        public Builder rawStreamUrl(String str) {
            this.params.rawStreamUrl = str;
            return this;
        }

        public Builder size(int i, int i2) {
            PublisherParameters publisherParameters = this.params;
            publisherParameters.width = i;
            publisherParameters.height = i2;
            return this;
        }

        public Builder streamLifeCycle(int i) {
            this.params.lifecycle = i;
            return this;
        }
    }

    private PublisherConfiguration(Builder builder) throws JSONException {
        try {
            this.jsonObject = new JSONObject().put("owner", builder.params.owner).put("lifecycle", builder.params.lifecycle).put("defaultLayout", builder.params.defaultLayout).put(VideoCaptureFormat.keyWidth, builder.params.width).put(VideoCaptureFormat.keyHeight, builder.params.height).put("framerate", builder.params.framerate).put("bitrate", builder.params.bitrate).put("mosaicStream", builder.params.publishUrl).put("rawStream", builder.params.rawStreamUrl).put("extraInfo", builder.params.extraInfo);
            if (builder.params.injectStreamUrl == null || builder.params.injectStreamWidth == 0 || builder.params.injectStreamHeight == 0) {
                return;
            }
            this.jsonObject.put("injectInfo", new JSONObject().put("injectStream", builder.params.injectStreamUrl).put(VideoCaptureFormat.keyWidth, builder.params.injectStreamWidth).put(VideoCaptureFormat.keyHeight, builder.params.injectStreamHeight));
        } catch (JSONException unused) {
            this.jsonObject = null;
            Logging.e("failed to create PublisherConfiguration");
        }
    }

    public String toJsonString() {
        if (validate()) {
            return this.jsonObject.toString();
        }
        return null;
    }

    public boolean validate() {
        return this.jsonObject != null;
    }
}
