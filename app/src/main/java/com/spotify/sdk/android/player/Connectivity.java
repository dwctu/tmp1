package com.spotify.sdk.android.player;

/* loaded from: classes3.dex */
public abstract class Connectivity {
    public static final Connectivity OFFLINE = new Connectivity() { // from class: com.spotify.sdk.android.player.Connectivity.1
        @Override // com.spotify.sdk.android.player.Connectivity
        public int getStatus() {
            return 0;
        }

        public String toString() {
            return "Offline";
        }
    };
    public static final Connectivity WIRED = new Connectivity() { // from class: com.spotify.sdk.android.player.Connectivity.2
        @Override // com.spotify.sdk.android.player.Connectivity
        public int getStatus() {
            return 1;
        }

        public String toString() {
            return "Wired";
        }
    };
    public static final Connectivity WIRELESS = new Connectivity() { // from class: com.spotify.sdk.android.player.Connectivity.3
        @Override // com.spotify.sdk.android.player.Connectivity
        public int getStatus() {
            return 2;
        }

        public String toString() {
            return "Wireless";
        }
    };
    public static final Connectivity MOBILE = new Connectivity() { // from class: com.spotify.sdk.android.player.Connectivity.4
        @Override // com.spotify.sdk.android.player.Connectivity
        public int getStatus() {
            return 3;
        }

        public String toString() {
            return "Mobile";
        }
    };

    public static Connectivity fromNetworkType(int i) {
        if (i == 9) {
            return WIRED;
        }
        if (i != 17) {
            switch (i) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 1:
                    return WIRELESS;
                default:
                    return OFFLINE;
            }
        }
        return MOBILE;
    }

    public abstract int getStatus();
}
