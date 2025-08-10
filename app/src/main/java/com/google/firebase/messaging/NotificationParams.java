package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class NotificationParams {

    @NonNull
    private final Bundle data;

    public NotificationParams(@NonNull Bundle bundle) {
        Objects.requireNonNull(bundle, "data");
        this.data = new Bundle(bundle);
    }

    private static int getLightColor(String str) {
        int color = Color.parseColor(str);
        if (color != -16777216) {
            return color;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean isAnalyticsKey(String str) {
        return str.startsWith(Constants.AnalyticsKeys.PREFIX) || str.equals("from");
    }

    private static boolean isReservedKey(String str) {
        return str.startsWith(Constants.MessagePayloadKeys.RESERVED_CLIENT_LIB_PREFIX) || str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) || str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD);
    }

    private static String keyWithOldPrefix(String str) {
        return !str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) ? str : str.replace(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX, Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD);
    }

    private String normalizePrefix(String str) {
        if (!this.data.containsKey(str) && str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
            String strKeyWithOldPrefix = keyWithOldPrefix(str);
            if (this.data.containsKey(strKeyWithOldPrefix)) {
                return strKeyWithOldPrefix;
            }
        }
        return str;
    }

    private static String userFriendlyKey(String str) {
        return str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX) ? str.substring(6) : str;
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        return "1".equals(string) || Boolean.parseBoolean(string);
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException unused) {
            String strUserFriendlyKey = userFriendlyKey(str);
            StringBuilder sb = new StringBuilder(String.valueOf(strUserFriendlyKey).length() + 38 + String.valueOf(string).length());
            sb.append("Couldn't parse value of ");
            sb.append(strUserFriendlyKey);
            sb.append("(");
            sb.append(string);
            sb.append(") into an int");
            sb.toString();
            return null;
        }
    }

    @Nullable
    public JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            String strUserFriendlyKey = userFriendlyKey(str);
            StringBuilder sb = new StringBuilder(String.valueOf(strUserFriendlyKey).length() + 50 + String.valueOf(string).length());
            sb.append("Malformed JSON for key ");
            sb.append(strUserFriendlyKey);
            sb.append(": ");
            sb.append(string);
            sb.append(", falling back to default");
            sb.toString();
            return null;
        }
    }

    @Nullable
    public int[] getLightSettings() throws JSONException {
        JSONArray jSONArray = getJSONArray(Constants.MessageNotificationKeys.LIGHT_SETTINGS);
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArray.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            iArr[0] = getLightColor(jSONArray.optString(0));
            iArr[1] = jSONArray.optInt(1);
            iArr[2] = jSONArray.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e) {
            String strValueOf = String.valueOf(jSONArray);
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 60 + String.valueOf(message).length());
            sb.append("LightSettings is invalid: ");
            sb.append(strValueOf);
            sb.append(". ");
            sb.append(message);
            sb.append(". Skipping setting LightSettings");
            sb.toString();
            return null;
        } catch (JSONException unused) {
            String strValueOf2 = String.valueOf(jSONArray);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 58);
            sb2.append("LightSettings is invalid: ");
            sb2.append(strValueOf2);
            sb2.append(". Skipping setting LightSettings");
            sb2.toString();
            return null;
        }
    }

    @Nullable
    public Uri getLink() {
        String string = getString(Constants.MessageNotificationKeys.LINK_ANDROID);
        if (TextUtils.isEmpty(string)) {
            string = getString(Constants.MessageNotificationKeys.LINK);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Uri.parse(string);
    }

    @Nullable
    public Object[] getLocalizationArgsForKey(String str) {
        JSONArray jSONArray = getJSONArray(String.valueOf(str).concat(Constants.MessageNotificationKeys.TEXT_ARGS_SUFFIX));
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    @Nullable
    public String getLocalizationResourceForKey(String str) {
        return getString(String.valueOf(str).concat(Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX));
    }

    @Nullable
    public String getLocalizedString(Resources resources, String str, String str2) {
        String localizationResourceForKey = getLocalizationResourceForKey(str2);
        if (TextUtils.isEmpty(localizationResourceForKey)) {
            return null;
        }
        int identifier = resources.getIdentifier(localizationResourceForKey, TypedValues.Custom.S_STRING, str);
        if (identifier == 0) {
            String strUserFriendlyKey = userFriendlyKey(String.valueOf(str2).concat(Constants.MessageNotificationKeys.TEXT_RESOURCE_SUFFIX));
            StringBuilder sb = new StringBuilder(String.valueOf(strUserFriendlyKey).length() + 49 + String.valueOf(str2).length());
            sb.append(strUserFriendlyKey);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            sb.toString();
            return null;
        }
        Object[] localizationArgsForKey = getLocalizationArgsForKey(str2);
        if (localizationArgsForKey == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, localizationArgsForKey);
        } catch (MissingFormatArgumentException unused) {
            String strUserFriendlyKey2 = userFriendlyKey(str2);
            String string = Arrays.toString(localizationArgsForKey);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strUserFriendlyKey2).length() + 58 + String.valueOf(string).length());
            sb2.append("Missing format argument for ");
            sb2.append(strUserFriendlyKey2);
            sb2.append(": ");
            sb2.append(string);
            sb2.append(" Default value will be used.");
            sb2.toString();
            return null;
        }
    }

    public Long getLong(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(string));
        } catch (NumberFormatException unused) {
            String strUserFriendlyKey = userFriendlyKey(str);
            StringBuilder sb = new StringBuilder(String.valueOf(strUserFriendlyKey).length() + 38 + String.valueOf(string).length());
            sb.append("Couldn't parse value of ");
            sb.append(strUserFriendlyKey);
            sb.append("(");
            sb.append(string);
            sb.append(") into a long");
            sb.toString();
            return null;
        }
    }

    public String getNotificationChannelId() {
        return getString(Constants.MessageNotificationKeys.CHANNEL);
    }

    @Nullable
    public Integer getNotificationCount() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_COUNT);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= 0) {
            return integer;
        }
        String strValueOf = String.valueOf(integer);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 67);
        sb.append("notificationCount is invalid: ");
        sb.append(strValueOf);
        sb.append(". Skipping setting notificationCount.");
        sb.toString();
        return null;
    }

    @Nullable
    public Integer getNotificationPriority() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.NOTIFICATION_PRIORITY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= -2 && integer.intValue() <= 2) {
            return integer;
        }
        String strValueOf = String.valueOf(integer);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 72);
        sb.append("notificationPriority is invalid ");
        sb.append(strValueOf);
        sb.append(". Skipping setting notificationPriority.");
        sb.toString();
        return null;
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String string = getString(str2);
        return !TextUtils.isEmpty(string) ? string : getLocalizedString(resources, str, str2);
    }

    @Nullable
    public String getSoundResourceName() {
        String string = getString(Constants.MessageNotificationKeys.SOUND_2);
        return TextUtils.isEmpty(string) ? getString(Constants.MessageNotificationKeys.SOUND) : string;
    }

    public String getString(String str) {
        return this.data.getString(normalizePrefix(str));
    }

    @Nullable
    public long[] getVibrateTimings() throws JSONException {
        JSONArray jSONArray = getJSONArray(Constants.MessageNotificationKeys.VIBRATE_TIMINGS);
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            String strValueOf = String.valueOf(jSONArray);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(strValueOf);
            sb.append(". Skipping setting vibrateTimings.");
            sb.toString();
            return null;
        }
    }

    public Integer getVisibility() {
        Integer integer = getInteger(Constants.MessageNotificationKeys.VISIBILITY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() >= -1 && integer.intValue() <= 1) {
            return integer;
        }
        String strValueOf = String.valueOf(integer);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 53);
        sb.append("visibility is invalid: ");
        sb.append(strValueOf);
        sb.append(". Skipping setting visibility.");
        sb.toString();
        return null;
    }

    public boolean hasImage() {
        return !TextUtils.isEmpty(getString(Constants.MessageNotificationKeys.IMAGE_URL));
    }

    public boolean isNotification() {
        return getBoolean(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION);
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (!isAnalyticsKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle paramsWithReservedKeysRemoved() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (isReservedKey(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public static boolean isNotification(Bundle bundle) {
        return "1".equals(bundle.getString(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)) || "1".equals(bundle.getString(keyWithOldPrefix(Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)));
    }
}
