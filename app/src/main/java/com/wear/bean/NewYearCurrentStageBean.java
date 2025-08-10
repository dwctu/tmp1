package com.wear.bean;

/* loaded from: classes3.dex */
public class NewYearCurrentStageBean {
    private int code;
    private DataBean data;
    private Object message;
    private boolean result;

    public static class DataBean {
        private Round1Bean round1;
        private Round2Bean round2;
        private Round3Bean round3;
        private long serverCurrentTimeMillis;

        public static class Round1Bean {
            private long endTime;
            private String name;
            private long startTime;

            public long getEndTime() {
                return this.endTime;
            }

            public String getName() {
                return this.name;
            }

            public long getStartTime() {
                return this.startTime;
            }

            public void setEndTime(long j) {
                this.endTime = j;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setStartTime(long j) {
                this.startTime = j;
            }
        }

        public static class Round2Bean {
            private long endTime;
            private String name;
            private long startTime;

            public long getEndTime() {
                return this.endTime;
            }

            public String getName() {
                return this.name;
            }

            public long getStartTime() {
                return this.startTime;
            }

            public void setEndTime(long j) {
                this.endTime = j;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setStartTime(long j) {
                this.startTime = j;
            }
        }

        public static class Round3Bean {
            private long endTime;
            private String name;
            private long startTime;

            public long getEndTime() {
                return this.endTime;
            }

            public String getName() {
                return this.name;
            }

            public long getStartTime() {
                return this.startTime;
            }

            public void setEndTime(long j) {
                this.endTime = j;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setStartTime(long j) {
                this.startTime = j;
            }
        }

        public Round1Bean getRound1() {
            return this.round1;
        }

        public Round2Bean getRound2() {
            return this.round2;
        }

        public Round3Bean getRound3() {
            return this.round3;
        }

        public long getServerCurrentTimeMillis() {
            return this.serverCurrentTimeMillis;
        }

        public void setRound1(Round1Bean round1Bean) {
            this.round1 = round1Bean;
        }

        public void setRound2(Round2Bean round2Bean) {
            this.round2 = round2Bean;
        }

        public void setRound3(Round3Bean round3Bean) {
            this.round3 = round3Bean;
        }

        public void setServerCurrentTimeMillis(long j) {
            this.serverCurrentTimeMillis = j;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public Object getMessage() {
        return this.message;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMessage(Object obj) {
        this.message = obj;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}
