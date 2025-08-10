package com.epicgames.unreal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes.dex */
public class BootCompleteReceiver extends BroadcastReceiver {
    public static Logger Log = new Logger("UE", "BootCompleteReceiver");

    public static class Task extends AsyncTask<Void, Void, Void> {
        private WeakReference<Context> context;
        private BroadcastReceiver.PendingResult pendingResult;

        public Task(BroadcastReceiver.PendingResult pendingResult, Context context) {
            this.pendingResult = pendingResult;
            this.context = new WeakReference<>(context.getApplicationContext());
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) throws JSONException, NumberFormatException {
            SharedPreferences sharedPreferences;
            int i;
            JSONObject jSONObject;
            Context context = this.context.get();
            if (context == null || (sharedPreferences = context.getSharedPreferences("LocalNotificationPreferences", 0)) == null) {
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(sharedPreferences.getString("notificationDetails", MessageFormatter.DELIM_STR));
                Iterator<String> itKeys = jSONObject2.keys();
                boolean z = false;
                while (itKeys.hasNext()) {
                    try {
                        String next = itKeys.next();
                        i = Integer.parseInt(next);
                        jSONObject = jSONObject2.getJSONObject(next);
                    } catch (NumberFormatException | JSONException e) {
                        BootCompleteReceiver.Log.error("Error reading notification details", e);
                        itKeys.remove();
                    }
                    if (!GameActivity.LocalNotificationScheduleAtTime(context, i, jSONObject.getString("local-notification-targetDateTime"), jSONObject.getBoolean("local-notification-localTime"), jSONObject.getString(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_TITLE), jSONObject.getString(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_BODY), jSONObject.getString(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION), jSONObject.getString(LocalNotificationReceiver.KEY_LOCAL_NOTIFICATION_ACTION_EVENT))) {
                        itKeys.remove();
                        z = true;
                    }
                }
                if (z) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("notificationDetails", jSONObject2.toString());
                    editorEdit.commit();
                }
            } catch (JSONException e2) {
                BootCompleteReceiver.Log.error("Error reading notification details", e2);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r1) {
            super.onPostExecute((Task) r1);
            this.pendingResult.finish();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        new Task(goAsync(), context).execute(new Void[0]);
    }
}
