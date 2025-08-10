package com.ProjectMelody.MelwareRises;

import com.google.android.vending.expansion.downloader.impl.DownloaderService;

/* loaded from: classes.dex */
public class OBBDownloaderService extends DownloaderService {
    private static final String BASE64_PUBLIC_KEY = "";
    private static final byte[] SALT = {1, 43, -12, -1, 54, 98, -100, -12, 43, 2, -8, -4, 9, 5, -106, -108, -33, 45, -1, 84};

    public static int getPublicKeyLength() {
        return 0;
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public String getAlarmReceiverClassName() {
        return AlarmReceiver.class.getName();
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public String getPublicKey() {
        return "";
    }

    @Override // com.google.android.vending.expansion.downloader.impl.DownloaderService
    public byte[] getSALT() {
        return SALT;
    }
}
