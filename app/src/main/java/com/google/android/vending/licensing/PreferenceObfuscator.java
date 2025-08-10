package com.google.android.vending.licensing;

import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class PreferenceObfuscator {
    private static final String TAG = "PreferenceObfuscator";
    private SharedPreferences.Editor mEditor = null;
    private final Obfuscator mObfuscator;
    private final SharedPreferences mPreferences;

    public PreferenceObfuscator(SharedPreferences sharedPreferences, Obfuscator obfuscator) {
        this.mPreferences = sharedPreferences;
        this.mObfuscator = obfuscator;
    }

    public void commit() {
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.commit();
            this.mEditor = null;
        }
    }

    public String getString(String str, String str2) {
        String string = this.mPreferences.getString(str, null);
        if (string == null) {
            return str2;
        }
        try {
            return this.mObfuscator.unobfuscate(string, str);
        } catch (ValidationException unused) {
            String str3 = "Validation error while reading preference: " + str;
            return str2;
        }
    }

    public void putString(String str, String str2) {
        if (this.mEditor == null) {
            this.mEditor = this.mPreferences.edit();
        }
        this.mEditor.putString(str, this.mObfuscator.obfuscate(str2, str));
    }
}
