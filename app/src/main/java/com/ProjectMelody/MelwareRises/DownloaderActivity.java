package com.ProjectMelody.MelwareRises;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Messenger;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ProjectMelody.MelwareRises.OBBData;
import com.epicgames.unreal.GameActivity;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.IDownloaderClient;
import com.google.android.vending.expansion.downloader.IDownloaderService;
import com.google.android.vending.expansion.downloader.IStub;
import dc.je;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class DownloaderActivity extends Activity implements IDownloaderClient {
    private static final String LOG_TAG = "LVLDownloader";
    private static final float SMOOTHING_FACTOR = 0.005f;
    public static DownloaderActivity _download;
    private final CharSequence[] OBBSelectItems = {"Use Store Data", "Use Development Data"};
    private Intent OutputData;
    private TextView mAverageSpeed;
    private boolean mCancelValidation;
    private View mCellMessage;
    private View mDashboard;
    private IStub mDownloaderClientStub;
    private ProgressBar mPB;
    private Button mPauseButton;
    private TextView mProgressFraction;
    private TextView mProgressPercent;
    private IDownloaderService mRemoteService;
    private int mState;
    private boolean mStatePaused;
    private TextView mStatusText;
    private TextView mTimeRemaining;
    private Button mWiFiSettingsButton;

    /* JADX INFO: Access modifiers changed from: private */
    public void ProcessOBBFiles() {
        if (GameActivity.Get().VerifyOBBOnStartUp && !expansionFilesUptoData()) {
            validateXAPKZipFiles();
            return;
        }
        this.OutputData.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 1);
        setResult(-1, this.OutputData);
        finish();
        int i = R.anim.noaction;
        overridePendingTransition(i, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void RemoveOBBFile(int i) {
        for (OBBData.XAPKFile xAPKFile : OBBData.xAPKS) {
            String expansionAPKFileName = Helpers.getExpansionAPKFileName(_download, xAPKFile.mIsMain, xAPKFile.mFileVersion, "");
            if (i == 0) {
                new File(Helpers.generateSaveFileName(_download, expansionAPKFileName)).delete();
            } else if (i == 1) {
                new File(Helpers.generateSaveFileNameDevelopment(_download, expansionAPKFileName)).delete();
            }
        }
    }

    private void initializeDownloadUI() {
        this.mDownloaderClientStub = DownloaderClientMarshaller.CreateStub(this, OBBDownloaderService.class);
        setContentView(R.layout.downloader_progress);
        this.mPB = (ProgressBar) findViewById(R.id.progressBar);
        this.mStatusText = (TextView) findViewById(R.id.statusText);
        this.mProgressFraction = (TextView) findViewById(R.id.progressAsFraction);
        this.mProgressPercent = (TextView) findViewById(R.id.progressAsPercentage);
        this.mAverageSpeed = (TextView) findViewById(R.id.progressAverageSpeed);
        this.mTimeRemaining = (TextView) findViewById(R.id.progressTimeRemaining);
        this.mDashboard = findViewById(R.id.downloaderDashboard);
        this.mCellMessage = findViewById(R.id.approveCellular);
        this.mPauseButton = (Button) findViewById(R.id.pauseButton);
        this.mWiFiSettingsButton = (Button) findViewById(R.id.wifiSettingsButton);
        this.mPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.ProjectMelody.MelwareRises.DownloaderActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DownloaderActivity.this.mStatePaused) {
                    DownloaderActivity.this.mRemoteService.requestContinueDownload();
                } else {
                    DownloaderActivity.this.mRemoteService.requestPauseDownload();
                }
                DownloaderActivity.this.setButtonPausedState(!r2.mStatePaused);
            }
        });
        this.mWiFiSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: com.ProjectMelody.MelwareRises.DownloaderActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloaderActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            }
        });
        ((Button) findViewById(R.id.resumeOverCellular)).setOnClickListener(new View.OnClickListener() { // from class: com.ProjectMelody.MelwareRises.DownloaderActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloaderActivity.this.mRemoteService.setDownloadFlags(1);
                DownloaderActivity.this.mRemoteService.requestContinueDownload();
                DownloaderActivity.this.mCellMessage.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonPausedState(boolean z) {
        this.mStatePaused = z;
        this.mPauseButton.setText(z ? R.string.text_button_resume : R.string.text_button_pause);
    }

    private void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            this.mStatusText.setText(Helpers.getDownloaderStringResourceIDFromState(i));
        }
    }

    public boolean expansionFilesDelivered() {
        for (OBBData.XAPKFile xAPKFile : OBBData.xAPKS) {
            String expansionAPKFileName = Helpers.getExpansionAPKFileName(this, xAPKFile.mIsMain, xAPKFile.mFileVersion, "");
            GameActivity.Log.debug("Checking for file : " + expansionAPKFileName);
            GameActivity.Log.debug("which is really being resolved to : " + Helpers.generateSaveFileName(this, expansionAPKFileName) + "\n Or : " + Helpers.generateSaveFileNameDevelopment(this, expansionAPKFileName));
            if (!Helpers.doesFileExist(this, expansionAPKFileName, xAPKFile.mFileSize, false) && !Helpers.doesFileExistDev(this, expansionAPKFileName, xAPKFile.mFileSize, false)) {
                return false;
            }
        }
        return true;
    }

    public boolean expansionFilesUptoData() throws IOException {
        File fileDetailsCacheFile = getFileDetailsCacheFile();
        HashMap map = new HashMap();
        if (fileDetailsCacheFile.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileDetailsCacheFile));
                ArrayList<String> arrayList = new ArrayList();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    arrayList.add(line);
                }
                bufferedReader.close();
                for (String str : arrayList) {
                    GameActivity.Log.debug("Splitting dataLine => " + str);
                    String[] strArrSplit = str.split(",");
                    map.put(strArrSplit[0], Long.valueOf(Long.parseLong(strArrSplit[1])));
                }
            } catch (Exception e) {
                GameActivity.Log.debug("Exception thrown during file details reading.");
                e.printStackTrace();
                map.clear();
            }
        }
        for (OBBData.XAPKFile xAPKFile : OBBData.xAPKS) {
            String expansionAPKFileName = Helpers.getExpansionAPKFileName(this, xAPKFile.mIsMain, xAPKFile.mFileVersion, "");
            String strGenerateSaveFileName = Helpers.generateSaveFileName(this, expansionAPKFileName);
            String strGenerateSaveFileNameDevelopment = Helpers.generateSaveFileNameDevelopment(this, expansionAPKFileName);
            File file = new File(strGenerateSaveFileName);
            File file2 = new File(strGenerateSaveFileNameDevelopment);
            long jLastModified = file.lastModified();
            long jLastModified2 = file2.lastModified();
            if ((!file.exists() || !map.containsKey(expansionAPKFileName) || jLastModified != ((Long) map.get(expansionAPKFileName)).longValue()) && (!file2.exists() || !map.containsKey(expansionAPKFileName) || jLastModified2 != ((Long) map.get(expansionAPKFileName)).longValue())) {
                return false;
            }
        }
        return true;
    }

    public File getFileDetailsCacheFile() {
        return new File(getExternalFilesDir(null), "cacheFile.txt");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GameActivity.Log.debug("Starting DownloaderActivity...");
        _download = this;
        this.OutputData = new Intent();
        initializeDownloadUI();
        GameActivity.Log.debug("... UI setup. Checking for files.");
        if (expansionFilesDelivered()) {
            GameActivity.Log.debug("... Can has! Check 'em Dano!");
            if (onlySingleExpansionFileFound()) {
                ProcessOBBFiles();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false).setTitle("Select OBB to use").setItems(this.OBBSelectItems, new DialogInterface.OnClickListener() { // from class: com.ProjectMelody.MelwareRises.DownloaderActivity.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DownloaderActivity.RemoveOBBFile(i);
                    DownloaderActivity.this.ProcessOBBFiles();
                }
            });
            builder.create().show();
            return;
        }
        GameActivity.Log.debug("... Whoops... missing; go go go download system!");
        try {
            if (OBBDownloaderService.getPublicKeyLength() == 0) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setCancelable(false).setTitle("No Google Play Store Key").setMessage("No OBB found and no store key to try to download. Please set one up in Android Project Settings").setPositiveButton("Exit", new DialogInterface.OnClickListener() { // from class: com.ProjectMelody.MelwareRises.DownloaderActivity.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DownloaderActivity.this.OutputData.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 6);
                        DownloaderActivity downloaderActivity = DownloaderActivity.this;
                        downloaderActivity.setResult(-1, downloaderActivity.OutputData);
                        DownloaderActivity.this.finish();
                    }
                });
                builder2.create().show();
                return;
            }
            Intent intent = getIntent();
            Intent intent2 = new Intent(this, getClass());
            intent2.setFlags(335544320);
            intent2.setAction(intent.getAction());
            if (intent.getCategories() != null) {
                Iterator<String> it = intent.getCategories().iterator();
                while (it.hasNext()) {
                    intent2.addCategory(it.next());
                }
            }
            if (DownloaderClientMarshaller.startDownloadServiceIfRequired(this, PendingIntent.getActivity(this, 0, intent2, 201326592), (Class<?>) OBBDownloaderService.class) != 0) {
                initializeDownloadUI();
                return;
            }
            this.OutputData.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 1);
            setResult(-1, this.OutputData);
            finish();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.mCancelValidation = true;
        super.onDestroy();
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onDownloadProgress(DownloadProgressInfo downloadProgressInfo) {
        this.mAverageSpeed.setText(getString(R.string.kilobytes_per_second, new Object[]{Helpers.getSpeedString(downloadProgressInfo.mCurrentSpeed)}));
        this.mTimeRemaining.setText(getString(R.string.time_remaining, new Object[]{Helpers.getTimeRemaining(downloadProgressInfo.mTimeRemaining)}));
        long j = downloadProgressInfo.mOverallTotal;
        downloadProgressInfo.mOverallTotal = j;
        this.mPB.setMax((int) (j >> 8));
        this.mPB.setProgress((int) (downloadProgressInfo.mOverallProgress >> 8));
        this.mProgressPercent.setText(Long.toString((downloadProgressInfo.mOverallProgress * 100) / downloadProgressInfo.mOverallTotal) + "%");
        this.mProgressFraction.setText(Helpers.getDownloadProgressString(downloadProgressInfo.mOverallProgress, downloadProgressInfo.mOverallTotal));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0040  */
    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDownloadStateChanged(int r7) {
        /*
            r6 = this;
            r6.setState(r7)
            r0 = 0
            r1 = 1
            switch(r7) {
                case 1: goto L1b;
                case 2: goto L1b;
                case 3: goto L1b;
                case 4: goto L17;
                case 5: goto L13;
                case 6: goto L8;
                case 7: goto L10;
                case 8: goto Ld;
                case 9: goto Ld;
                case 10: goto L8;
                case 11: goto L8;
                case 12: goto L10;
                case 13: goto L8;
                case 14: goto L10;
                case 15: goto Lb;
                case 16: goto Lb;
                case 17: goto L8;
                case 18: goto Lb;
                case 19: goto Lb;
                default: goto L8;
            }
        L8:
            r7 = 0
            r2 = 1
            goto L1d
        Lb:
            r7 = 0
            goto Le
        Ld:
            r7 = 1
        Le:
            r1 = 0
            goto L11
        L10:
            r7 = 0
        L11:
            r2 = 1
            goto L19
        L13:
            r6.validateXAPKZipFiles()
            return
        L17:
            r7 = 0
            r2 = 0
        L19:
            r3 = 0
            goto L1e
        L1b:
            r7 = 0
            r2 = 0
        L1d:
            r3 = 1
        L1e:
            r4 = 8
            if (r1 == 0) goto L24
            r1 = 0
            goto L26
        L24:
            r1 = 8
        L26:
            android.view.View r5 = r6.mDashboard
            int r5 = r5.getVisibility()
            if (r5 == r1) goto L33
            android.view.View r5 = r6.mDashboard
            r5.setVisibility(r1)
        L33:
            if (r7 == 0) goto L36
            goto L38
        L36:
            r0 = 8
        L38:
            android.view.View r7 = r6.mCellMessage
            int r7 = r7.getVisibility()
            if (r7 == r0) goto L45
            android.view.View r7 = r6.mCellMessage
            r7.setVisibility(r0)
        L45:
            android.widget.ProgressBar r7 = r6.mPB
            r7.setIndeterminate(r3)
            r6.setButtonPausedState(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ProjectMelody.MelwareRises.DownloaderActivity.onDownloadStateChanged(int):void");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        GameActivity.Log.debug("In onPause");
        if (this.OutputData.getIntExtra(GameActivity.DOWNLOAD_RETURN_NAME, 0) == 0) {
            GameActivity.Log.debug("onPause returning that user quit the download.");
            this.OutputData.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 3);
            setResult(-1, this.OutputData);
        }
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onServiceConnected(Messenger messenger) {
        IDownloaderService iDownloaderServiceCreateProxy = DownloaderServiceMarshaller.CreateProxy(messenger);
        this.mRemoteService = iDownloaderServiceCreateProxy;
        iDownloaderServiceCreateProxy.onClientUpdated(this.mDownloaderClientStub.getMessenger());
    }

    @Override // android.app.Activity
    public void onStart() {
        IStub iStub = this.mDownloaderClientStub;
        if (iStub != null) {
            iStub.connect(this);
        }
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        IStub iStub = this.mDownloaderClientStub;
        if (iStub != null) {
            iStub.disconnect(this);
        }
        super.onStop();
        setResult(-1, this.OutputData);
    }

    public boolean onlySingleExpansionFileFound() {
        for (OBBData.XAPKFile xAPKFile : OBBData.xAPKS) {
            String expansionAPKFileName = Helpers.getExpansionAPKFileName(this, xAPKFile.mIsMain, xAPKFile.mFileVersion, "");
            GameActivity.Log.debug("Checking for file : " + expansionAPKFileName);
            Helpers.generateSaveFileName(this, expansionAPKFileName);
            Helpers.generateSaveFileNameDevelopment(this, expansionAPKFileName);
            if (Helpers.doesFileExist(this, expansionAPKFileName, xAPKFile.mFileSize, false) && Helpers.doesFileExistDev(this, expansionAPKFileName, xAPKFile.mFileSize, false)) {
                return false;
            }
        }
        return true;
    }

    public void validateXAPKZipFiles() {
        new AsyncTask<Object, DownloadProgressInfo, Boolean>() { // from class: com.ProjectMelody.MelwareRises.DownloaderActivity.1
            @Override // android.os.AsyncTask
            public void onPreExecute() {
                DownloaderActivity.this.mDashboard.setVisibility(0);
                DownloaderActivity.this.mCellMessage.setVisibility(8);
                DownloaderActivity.this.mStatusText.setText(R.string.text_verifying_download);
                DownloaderActivity.this.mPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.ProjectMelody.MelwareRises.DownloaderActivity.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DownloaderActivity.this.mCancelValidation = true;
                    }
                });
                DownloaderActivity.this.mPauseButton.setVisibility(8);
                super.onPreExecute();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Object... objArr) throws Throwable {
                int i;
                je jeVar;
                int i2;
                int i3;
                int i4;
                OBBData.XAPKFile[] xAPKFileArr = OBBData.xAPKS;
                int length = xAPKFileArr.length;
                boolean z = false;
                int i5 = 0;
                while (i5 < length) {
                    OBBData.XAPKFile xAPKFile = xAPKFileArr[i5];
                    String expansionAPKFileName = Helpers.getExpansionAPKFileName(DownloaderActivity.this, xAPKFile.mIsMain, xAPKFile.mFileVersion, "");
                    boolean zDoesFileExist = Helpers.doesFileExist(DownloaderActivity.this, expansionAPKFileName, xAPKFile.mFileSize, z);
                    boolean zDoesFileExistDev = Helpers.doesFileExistDev(DownloaderActivity.this, expansionAPKFileName, xAPKFile.mFileSize, z);
                    if (!zDoesFileExist && !zDoesFileExistDev) {
                        return Boolean.FALSE;
                    }
                    String strGenerateSaveFileName = zDoesFileExist ? Helpers.generateSaveFileName(DownloaderActivity.this, expansionAPKFileName) : Helpers.generateSaveFileNameDevelopment(DownloaderActivity.this, expansionAPKFileName);
                    byte[] bArr = new byte[262144];
                    try {
                        je jeVar2 = new je(strGenerateSaveFileName);
                        je.a[] aVarArrB = jeVar2.b();
                        long j = 0;
                        for (je.a aVar : aVarArrB) {
                            j += aVar.h;
                        }
                        int length2 = aVarArrB.length;
                        long j2 = j;
                        float f = 0.0f;
                        int i6 = 0;
                        while (i6 < length2) {
                            je.a aVar2 = aVarArrB[i6];
                            int i7 = i5;
                            if (-1 != aVar2.g) {
                                long j3 = aVar2.i;
                                CRC32 crc32 = new CRC32();
                                DataInputStream dataInputStream = null;
                                try {
                                    DataInputStream dataInputStream2 = new DataInputStream(jeVar2.d(aVar2.b));
                                    try {
                                        long jUptimeMillis = SystemClock.uptimeMillis();
                                        long j4 = 0;
                                        while (j3 > j4) {
                                            je jeVar3 = jeVar2;
                                            int i8 = length2;
                                            long j5 = 262144;
                                            if (j3 <= j5) {
                                                j5 = j3;
                                            }
                                            int i9 = (int) j5;
                                            dataInputStream2.readFully(bArr, 0, i9);
                                            crc32.update(bArr, 0, i9);
                                            je.a aVar3 = aVar2;
                                            long j6 = i9;
                                            long j7 = j3 - j6;
                                            long jUptimeMillis2 = SystemClock.uptimeMillis();
                                            int i10 = length;
                                            long j8 = jUptimeMillis2 - jUptimeMillis;
                                            if (j8 > 0) {
                                                float f2 = i9 / j8;
                                                if (0.0f != f) {
                                                    f2 = (f2 * DownloaderActivity.SMOOTHING_FACTOR) + (f * 0.995f);
                                                }
                                                long j9 = j2 - j6;
                                                i4 = i6;
                                                publishProgress(new DownloadProgressInfo(j, j - j9, (long) (j9 / f2), f2));
                                                f = f2;
                                                j2 = j9;
                                            } else {
                                                i4 = i6;
                                            }
                                            if (DownloaderActivity.this.mCancelValidation) {
                                                Boolean bool = Boolean.TRUE;
                                                dataInputStream2.close();
                                                return bool;
                                            }
                                            aVar2 = aVar3;
                                            jeVar2 = jeVar3;
                                            j4 = 0;
                                            length2 = i8;
                                            jUptimeMillis = jUptimeMillis2;
                                            length = i10;
                                            j3 = j7;
                                            i6 = i4;
                                        }
                                        i = length;
                                        jeVar = jeVar2;
                                        i2 = length2;
                                        je.a aVar4 = aVar2;
                                        i3 = i6;
                                        if (crc32.getValue() != aVar4.g) {
                                            String str = "CRC does not match for entry: " + aVar4.b;
                                            String str2 = "In file: " + aVar4.d();
                                            Boolean bool2 = Boolean.FALSE;
                                            dataInputStream2.close();
                                            return bool2;
                                        }
                                        dataInputStream2.close();
                                    } catch (Throwable th) {
                                        th = th;
                                        dataInputStream = dataInputStream2;
                                        if (dataInputStream != null) {
                                            dataInputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } else {
                                i = length;
                                jeVar = jeVar2;
                                i2 = length2;
                                i3 = i6;
                            }
                            i6 = i3 + 1;
                            i5 = i7;
                            jeVar2 = jeVar;
                            length2 = i2;
                            length = i;
                        }
                        i5++;
                        length = length;
                        z = false;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Boolean bool) throws IOException {
                if (bool.booleanValue()) {
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DownloaderActivity.this.getFileDetailsCacheFile()));
                        for (OBBData.XAPKFile xAPKFile : OBBData.xAPKS) {
                            String expansionAPKFileName = Helpers.getExpansionAPKFileName(DownloaderActivity.this, xAPKFile.mIsMain, xAPKFile.mFileVersion, "");
                            String strGenerateSaveFileName = Helpers.generateSaveFileName(DownloaderActivity.this, expansionAPKFileName);
                            String strGenerateSaveFileNameDevelopment = Helpers.generateSaveFileNameDevelopment(DownloaderActivity.this, expansionAPKFileName);
                            GameActivity.Log.debug("Writing details for file : " + expansionAPKFileName);
                            File file = new File(strGenerateSaveFileName);
                            File file2 = new File(strGenerateSaveFileNameDevelopment);
                            if (file.exists()) {
                                long jLastModified = file.lastModified();
                                bufferedWriter.write(expansionAPKFileName);
                                bufferedWriter.write(",");
                                bufferedWriter.write(new Long(jLastModified).toString());
                                bufferedWriter.newLine();
                                GameActivity.Log.debug("Details for file : " + expansionAPKFileName + " with modified time of " + new Long(jLastModified).toString());
                            } else {
                                long jLastModified2 = file2.lastModified();
                                bufferedWriter.write(expansionAPKFileName);
                                bufferedWriter.write(",");
                                bufferedWriter.write(new Long(jLastModified2).toString());
                                bufferedWriter.newLine();
                                GameActivity.Log.debug("Details for file : " + expansionAPKFileName + " with modified time of " + new Long(jLastModified2).toString());
                            }
                        }
                        bufferedWriter.close();
                    } catch (Exception e) {
                        GameActivity.Log.debug("Exception thrown during file details writing.");
                        e.printStackTrace();
                    }
                    DownloaderActivity.this.OutputData.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 1);
                    DownloaderActivity downloaderActivity = DownloaderActivity.this;
                    downloaderActivity.setResult(-1, downloaderActivity.OutputData);
                    DownloaderActivity.this.finish();
                } else {
                    File fileDetailsCacheFile = DownloaderActivity.this.getFileDetailsCacheFile();
                    if (fileDetailsCacheFile.exists()) {
                        fileDetailsCacheFile.delete();
                    }
                    DownloaderActivity.this.mDashboard.setVisibility(0);
                    DownloaderActivity.this.mCellMessage.setVisibility(8);
                    DownloaderActivity.this.mStatusText.setText(R.string.text_validation_failed);
                    DownloaderActivity.this.mPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.ProjectMelody.MelwareRises.DownloaderActivity.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DownloaderActivity.this.OutputData.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 5);
                            DownloaderActivity downloaderActivity2 = DownloaderActivity.this;
                            downloaderActivity2.setResult(-1, downloaderActivity2.OutputData);
                            DownloaderActivity.this.finish();
                        }
                    });
                    DownloaderActivity.this.mPauseButton.setText(android.R.string.cancel);
                }
                super.onPostExecute((AnonymousClass1) bool);
            }

            @Override // android.os.AsyncTask
            public void onProgressUpdate(DownloadProgressInfo... downloadProgressInfoArr) {
                DownloaderActivity.this.onDownloadProgress(downloadProgressInfoArr[0]);
                super.onProgressUpdate((Object[]) downloadProgressInfoArr);
            }
        }.execute(new Object());
    }
}
