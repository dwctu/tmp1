package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SettingsV3JsonTransform implements SettingsJsonTransform {
    private static Settings.FeatureFlagData buildFeatureFlagDataFrom(JSONObject jSONObject) {
        return new Settings.FeatureFlagData(jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_REPORTS_KEY, true), jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_ANRS_KEY, false));
    }

    private static Settings.SessionData buildSessionDataFrom(JSONObject jSONObject) {
        return new Settings.SessionData(jSONObject.optInt(SettingsJsonConstants.SETTINGS_MAX_CUSTOM_EXCEPTION_EVENTS_KEY, 8), 4);
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        return jSONObject.has(SettingsJsonConstants.EXPIRES_AT_KEY) ? jSONObject.optLong(SettingsJsonConstants.EXPIRES_AT_KEY) : currentTimeProvider.getCurrentTimeMillis() + (j * 1000);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public Settings buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        int iOptInt = jSONObject.optInt(SettingsJsonConstants.SETTINGS_VERSION, 0);
        int iOptInt2 = jSONObject.optInt(SettingsJsonConstants.CACHE_DURATION_KEY, SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT);
        return new Settings(getExpiresAtFrom(currentTimeProvider, iOptInt2, jSONObject), jSONObject.has("session") ? buildSessionDataFrom(jSONObject.getJSONObject("session")) : buildSessionDataFrom(new JSONObject()), buildFeatureFlagDataFrom(jSONObject.getJSONObject(SettingsJsonConstants.FEATURES_KEY)), iOptInt, iOptInt2, jSONObject.optDouble(SettingsJsonConstants.ON_DEMAND_UPLOAD_RATE_PER_MINUTE_KEY, 10.0d), jSONObject.optDouble(SettingsJsonConstants.ON_DEMAND_BACKOFF_BASE_KEY, 1.2d), jSONObject.optInt(SettingsJsonConstants.ON_DEMAND_BACKOFF_STEP_DURATION_SECONDS_KEY, 60));
    }
}
