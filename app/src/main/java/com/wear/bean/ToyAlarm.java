package com.wear.bean;

import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyAlarm {
    public String alarmId = "";
    public boolean isLocal = true;
    public List<ToyAlarm10Items> items = new ArrayList();
    public HashMap<Long, ToyAlarm10Items> itemsMap = new HashMap<>();
    public long alarmLongTime = 0;

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0171, code lost:
    
        r12 = r12 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017a, code lost:
    
        r12 = r5 - r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Calendar getNextTime(java.util.Calendar r11, com.wear.bean.AlarmListItems r12) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.ToyAlarm.getNextTime(java.util.Calendar, com.wear.bean.AlarmListItems):java.util.Calendar");
    }

    public void addToyAlarmIndex(String str, int i, long j) {
        if (WearUtils.e1(str) || i < 0 || i > 9 || this.itemsMap.get(Long.valueOf(j)) == null) {
            return;
        }
        this.itemsMap.get(Long.valueOf(j)).addIndex(str, i);
    }

    public void createNext9Times(Calendar calendar) throws ParseException {
        this.items.clear();
        this.itemsMap.clear();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        ToyAlarm10Items toyAlarm10Items = new ToyAlarm10Items(this.alarmId, calendar.getTimeInMillis());
        this.items.add(toyAlarm10Items);
        this.itemsMap.put(Long.valueOf(calendar.getTimeInMillis()), toyAlarm10Items);
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(this.alarmId);
        if (alarmListItemsFindById.getFrequency().equals("customer")) {
            return;
        }
        for (int i = 0; i < 9; i++) {
            Calendar nextTime = getNextTime(calendar2, alarmListItemsFindById);
            ToyAlarm10Items toyAlarm10Items2 = new ToyAlarm10Items(this.alarmId, nextTime.getTimeInMillis());
            this.items.add(toyAlarm10Items2);
            this.itemsMap.put(Long.valueOf(nextTime.getTimeInMillis()), toyAlarm10Items2);
            calendar2.setTimeInMillis(nextTime.getTimeInMillis());
        }
    }

    public void deleteToyAlarm() {
        Iterator<ToyAlarm10Items> it = this.items.iterator();
        int i = 1;
        while (it.hasNext()) {
            it.next().cleanAlarmIndex(i);
            i++;
        }
    }

    public String getAlarmId() {
        return this.alarmId;
    }

    public long getAlarmLongTime() {
        return this.alarmLongTime;
    }

    public List<ToyAlarm10Items> getItems() {
        return this.items;
    }

    public HashMap<Integer, Integer> getToyAlarmIndex(String str, long j) {
        Integer index;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (ToyAlarm10Items toyAlarm10Items : this.items) {
            if (toyAlarm10Items.getAlarmTimes() == j && (index = toyAlarm10Items.getIndex(str)) != null) {
                map.put(index, index);
            }
        }
        return map;
    }

    public boolean isLocal() {
        return this.isLocal;
    }

    public void removeToyAlarmIndex(String str, long j) {
        if (WearUtils.e1(str) || this.itemsMap.get(Long.valueOf(j)) == null) {
            return;
        }
        this.itemsMap.get(Long.valueOf(j)).removeIndex(str);
    }

    public void setAlarmId(String str) {
        this.alarmId = str;
    }

    public void setAlarmLongTime(long j) {
        this.alarmLongTime = j;
    }

    public void setLocal(boolean z) {
        this.isLocal = z;
    }
}
