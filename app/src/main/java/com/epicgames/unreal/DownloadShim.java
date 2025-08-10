package com.epicgames.unreal;

import android.app.Activity;
import com.ProjectMelody.MelwareRises.DownloaderActivity;
import com.ProjectMelody.MelwareRises.OBBData;
import com.ProjectMelody.MelwareRises.OBBDownloaderService;
import com.google.android.vending.expansion.downloader.Helpers;

/* loaded from: classes.dex */
public class DownloadShim {
    public static DownloaderActivity DownloadActivity;
    public static OBBDownloaderService DownloaderService;

    public static Class<DownloaderActivity> GetDownloaderType() {
        return DownloaderActivity.class;
    }

    public static boolean expansionFilesDelivered(Activity activity, int i) {
        for (OBBData.XAPKFile xAPKFile : OBBData.xAPKS) {
            String expansionAPKFileName = Helpers.getExpansionAPKFileName(activity, xAPKFile.mIsMain, Integer.toString(i), "");
            GameActivity.Log.debug("Checking for file : " + expansionAPKFileName);
            String strGenerateSaveFileName = Helpers.generateSaveFileName(activity, expansionAPKFileName);
            String strGenerateSaveFileNameDevelopment = Helpers.generateSaveFileNameDevelopment(activity, expansionAPKFileName);
            GameActivity.Log.debug("which is really being resolved to : " + strGenerateSaveFileName + "\n Or : " + strGenerateSaveFileNameDevelopment);
            if (Helpers.doesFileExist(activity, expansionAPKFileName, xAPKFile.mFileSize, false)) {
                GameActivity.Log.debug("Found OBB here: " + strGenerateSaveFileName);
            } else {
                if (!Helpers.doesFileExistDev(activity, expansionAPKFileName, xAPKFile.mFileSize, false)) {
                    return false;
                }
                GameActivity.Log.debug("Found OBB here: " + strGenerateSaveFileNameDevelopment);
            }
        }
        return true;
    }
}
