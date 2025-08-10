package org.jivesoftware.smackx.bookmarks;

/* loaded from: classes5.dex */
public class BookmarkedConference implements SharedBookmark {
    private boolean autoJoin;
    private boolean isShared;
    private final String jid;
    private String name;
    private String nickname;
    private String password;

    public BookmarkedConference(String str) {
        this.jid = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BookmarkedConference)) {
            return false;
        }
        return ((BookmarkedConference) obj).getJid().equalsIgnoreCase(this.jid);
    }

    public String getJid() {
        return this.jid;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isAutoJoin() {
        return this.autoJoin;
    }

    @Override // org.jivesoftware.smackx.bookmarks.SharedBookmark
    public boolean isShared() {
        return this.isShared;
    }

    public void setAutoJoin(boolean z) {
        this.autoJoin = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setShared(boolean z) {
        this.isShared = z;
    }

    public BookmarkedConference(String str, String str2, boolean z, String str3, String str4) {
        this.name = str;
        this.jid = str2;
        this.autoJoin = z;
        this.nickname = str3;
        this.password = str4;
    }
}
