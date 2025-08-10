package com.broadcom.bt.service.ftp;

/* loaded from: classes.dex */
public interface IFTPEventHandler {
    void onFtpServerAccessRequested(String str, int i, String str2, byte b, String str3);

    void onFtpServerClosed();

    void onFtpServerDelCompleted(String str, byte b);

    void onFtpServerFileTransferInProgress(int i, int i2);

    void onFtpServerGetCompleted(String str, byte b);

    void onFtpServerOpened(String str);

    void onFtpServerPutCompleted(String str, byte b);
}
