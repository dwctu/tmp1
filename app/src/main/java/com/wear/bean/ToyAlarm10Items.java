package com.wear.bean;

import androidx.annotation.NonNull;
import com.wear.util.WearUtils;
import dc.iq1;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ToyAlarm10Items implements Comparable<ToyAlarm10Items> {
    public String alarmId;
    public long alarmTimes;
    public HashMap<String, Integer> toyAiIndex = new HashMap<>();

    public ToyAlarm10Items(String str, long j) {
        this.alarmId = "";
        this.alarmTimes = 0L;
        this.alarmId = str;
        this.alarmTimes = j;
    }

    public void addIndex(String str, int i) {
        if (WearUtils.e1(str) || i < 0 || i > 9) {
            return;
        }
        this.toyAiIndex.put(str, Integer.valueOf(i));
    }

    public void cleanAlarmIndex(int i) {
        for (final Map.Entry<String, Integer> entry : this.toyAiIndex.entrySet()) {
            final Toy toyQ = WearUtils.x.G().Q(entry.getKey());
            if (toyQ != null && toyQ.isConnected() && !WearUtils.e1(toyQ.getAiString())) {
                WearUtils.x.l.postDelayed(new Runnable() { // from class: com.wear.bean.ToyAlarm10Items.1
                    @Override // java.lang.Runnable
                    public void run() {
                        iq1.j(toyQ.getAddress(), ((Integer) entry.getValue()).intValue());
                    }
                }, i * 80);
            }
        }
        this.toyAiIndex.clear();
    }

    public String getAlarmId() {
        return this.alarmId;
    }

    public long getAlarmTimes() {
        return this.alarmTimes;
    }

    public Integer getIndex(String str) {
        if (WearUtils.e1(str)) {
            return null;
        }
        return this.toyAiIndex.get(str);
    }

    public void removeIndex(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        this.toyAiIndex.remove(str);
    }

    @Override // java.lang.Comparable
    public synchronized int compareTo(@NonNull ToyAlarm10Items toyAlarm10Items) {
        long alarmTimes;
        alarmTimes = getAlarmTimes() - toyAlarm10Items.getAlarmTimes();
        return alarmTimes > 0 ? 1 : alarmTimes < 0 ? -1 : 0;
    }
}
