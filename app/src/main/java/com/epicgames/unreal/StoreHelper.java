package com.epicgames.unreal;

/* loaded from: classes.dex */
public interface StoreHelper {
    boolean BeginPurchase(String str, String str2);

    void ConsumePurchase(String str);

    boolean IsAllowedToMakePurchases();

    boolean QueryExistingPurchases();

    boolean QueryInAppPurchases(String[] strArr);

    void onDestroy();
}
