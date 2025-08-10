package com.wear.bean;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class LanApiCommandBean {
    private List<CommandFunctionActionBean> commandFunction;
    private int commandType;
    private int count;
    private double duration;
    private Map<String, LanFunctionBean> functionMap;
    private Timer functionTimer;
    private List<String> pattern;
    private Timer patternStopTimer;
    private Timer patternTimer;
    private double pending;
    private int presetCount;
    private String[] presetPatterns;
    private Timer presetStopTimer;
    private Timer presetTimer;
    private String[] rControl;
    private Integer rTime;
    private String stroke;
    private double timePresetSec;
    private double timeSec;
    private double timeSecFun;
    private String toyFunId;
    private String toyId;
    private String toyPresetId;

    public static class LanFunctionBean {
        private double duration;
        private boolean isSending;
        private double pending;
        private long startTime;
        private long tempTime;
        private double timeSecFun;
        private int value;

        public double getDuration() {
            return this.duration;
        }

        public double getPending() {
            return this.pending;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public long getTempTime() {
            return this.tempTime;
        }

        public double getTimeSecFun() {
            return this.timeSecFun;
        }

        public int getValue() {
            return this.value;
        }

        public boolean isSending() {
            return this.isSending;
        }

        public void setDuration(double d) {
            this.duration = d;
        }

        public void setPending(double d) {
            this.pending = d;
        }

        public void setSending(boolean z) {
            this.isSending = z;
        }

        public void setStartTime(long j) {
            this.startTime = j;
        }

        public void setTempTime(long j) {
            this.tempTime = j;
        }

        public void setTimeSecFun(double d) {
            this.timeSecFun = d;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    public LanApiCommandBean(double d, String[] strArr, List<String> list, Integer num, String str, Timer timer, Timer timer2) {
        this.timeSec = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.rControl = null;
        this.pattern = new ArrayList();
        this.rTime = 0;
        this.toyId = null;
        this.count = 0;
        this.commandFunction = new ArrayList();
        this.duration = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.pending = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.toyFunId = null;
        this.functionMap = new HashMap();
        this.timePresetSec = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.toyPresetId = null;
        this.presetPatterns = null;
        this.presetCount = 0;
        this.timeSec = d;
        this.rControl = strArr;
        this.pattern = list;
        this.rTime = num;
        this.toyId = str;
        this.patternTimer = timer;
        this.patternStopTimer = timer2;
        this.count = 0;
        this.commandType = 0;
    }

    public List<CommandFunctionActionBean> getCommandFunction() {
        return this.commandFunction;
    }

    public int getCommandType() {
        return this.commandType;
    }

    public int getCount() {
        return this.count;
    }

    public double getDuration() {
        return this.duration;
    }

    public Map<String, LanFunctionBean> getFunctionMap() {
        return this.functionMap;
    }

    public Timer getFunctionTimer() {
        return this.functionTimer;
    }

    public List<String> getPattern() {
        return this.pattern;
    }

    public Timer getPatternStopTimer() {
        return this.patternStopTimer;
    }

    public Timer getPatternTimer() {
        return this.patternTimer;
    }

    public double getPending() {
        return this.pending;
    }

    public int getPresetCount() {
        return this.presetCount;
    }

    public String[] getPresetPatterns() {
        return this.presetPatterns;
    }

    public Timer getPresetStopTimer() {
        return this.presetStopTimer;
    }

    public Timer getPresetTimer() {
        return this.presetTimer;
    }

    public String getStroke() {
        return this.stroke;
    }

    public double getTimePresetSec() {
        return this.timePresetSec;
    }

    public double getTimeSec() {
        return this.timeSec;
    }

    public double getTimeSecFun() {
        return this.timeSecFun;
    }

    public String getToyFunId() {
        return this.toyFunId;
    }

    public String getToyId() {
        return this.toyId;
    }

    public String getToyPresetId() {
        return this.toyPresetId;
    }

    public String[] getrControl() {
        return this.rControl;
    }

    public Integer getrTime() {
        return this.rTime;
    }

    public void setCommandFunction(List<CommandFunctionActionBean> list) {
        this.commandFunction = list;
    }

    public void setCommandType(int i) {
        this.commandType = i;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setDuration(double d) {
        this.duration = d;
    }

    public void setFunctionMap(Map map) {
        this.functionMap = map;
    }

    public void setFunctionTimer(Timer timer) {
        this.functionTimer = timer;
    }

    public void setPattern(List<String> list) {
        this.pattern = list;
    }

    public void setPatternStopTimer(Timer timer) {
        this.patternStopTimer = timer;
    }

    public void setPatternTimer(Timer timer) {
        this.patternTimer = timer;
    }

    public void setPending(double d) {
        this.pending = d;
    }

    public void setPresetCount(int i) {
        this.presetCount = i;
    }

    public void setPresetPatterns(String[] strArr) {
        this.presetPatterns = strArr;
    }

    public void setPresetStopTimer(Timer timer) {
        this.presetStopTimer = timer;
    }

    public void setPresetTimer(Timer timer) {
        this.presetTimer = timer;
    }

    public void setStroke(String str) {
        this.stroke = str;
    }

    public void setTimePresetSec(double d) {
        this.timePresetSec = d;
    }

    public void setTimeSec(double d) {
        this.timeSec = d;
    }

    public void setTimeSecFun(double d) {
        this.timeSecFun = d;
    }

    public void setToyFunId(String str) {
        this.toyFunId = str;
    }

    public void setToyId(String str) {
        this.toyId = str;
    }

    public void setToyPresetId(String str) {
        this.toyPresetId = str;
    }

    public void setrControl(String[] strArr) {
        this.rControl = strArr;
    }

    public void setrTime(Integer num) {
        this.rTime = num;
    }

    public String toFuncString() {
        return "LanApiCommandBean{duration=" + this.duration + ", pending=" + this.pending + ", toyFunId='" + this.toyFunId + '\'' + MessageFormatter.DELIM_STOP;
    }

    public String toPatternString() {
        return "NewCommandBean{timeSec=" + this.timeSec + ", rTime=" + this.rTime + ", toyId='" + this.toyId + "', count=" + this.count + MessageFormatter.DELIM_STOP;
    }

    public String toPresetString() {
        return "LanApiCommandBean{timePresetSec=" + this.timePresetSec + ", toyPresetId='" + this.toyPresetId + "', presetPatterns=" + this.presetPatterns.length + ", presetCount=" + this.presetCount + MessageFormatter.DELIM_STOP;
    }

    public void updateFunctionCommandBean(List<CommandFunctionActionBean> list, double d, double d2, double d3) {
        LanFunctionBean lanFunctionBean;
        for (CommandFunctionActionBean commandFunctionActionBean : list) {
            if (this.functionMap.containsKey(commandFunctionActionBean.getOpertion())) {
                lanFunctionBean = this.functionMap.get(commandFunctionActionBean.getOpertion());
            } else {
                lanFunctionBean = new LanFunctionBean();
                this.functionMap.put(commandFunctionActionBean.getOpertion(), lanFunctionBean);
            }
            lanFunctionBean.setValue(commandFunctionActionBean.getValue());
            lanFunctionBean.setTimeSecFun(d);
            lanFunctionBean.setDuration(d2);
            lanFunctionBean.setPending(d3);
            lanFunctionBean.setSending(false);
            lanFunctionBean.setStartTime(0L);
            lanFunctionBean.setTempTime(0L);
        }
    }

    public LanApiCommandBean(Timer timer, List<CommandFunctionActionBean> list, String str, double d, double d2, double d3, String str2) {
        this.timeSec = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.rControl = null;
        this.pattern = new ArrayList();
        this.rTime = 0;
        this.toyId = null;
        this.count = 0;
        this.commandFunction = new ArrayList();
        this.duration = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.pending = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.toyFunId = null;
        this.functionMap = new HashMap();
        this.timePresetSec = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.toyPresetId = null;
        this.presetPatterns = null;
        this.presetCount = 0;
        this.functionTimer = timer;
        this.commandFunction = list;
        this.toyFunId = str;
        this.timeSecFun = d;
        this.duration = d2;
        this.pending = d3;
        this.stroke = str2;
        this.commandType = 1;
        updateFunctionCommandBean(list, d, d2, d3);
    }

    public LanApiCommandBean(double d, Timer timer, String str, String[] strArr, Timer timer2) {
        this.timeSec = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.rControl = null;
        this.pattern = new ArrayList();
        this.rTime = 0;
        this.toyId = null;
        this.count = 0;
        this.commandFunction = new ArrayList();
        this.duration = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.pending = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.toyFunId = null;
        this.functionMap = new HashMap();
        this.timePresetSec = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.toyPresetId = null;
        this.presetPatterns = null;
        this.presetCount = 0;
        this.timePresetSec = d;
        this.presetTimer = timer;
        this.toyPresetId = str;
        this.presetPatterns = strArr;
        this.presetStopTimer = timer2;
        this.presetCount = 0;
        this.commandType = 2;
    }
}
