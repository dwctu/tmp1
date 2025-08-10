package org.jivesoftware.smackx.bookmarks;

/* loaded from: classes5.dex */
public class BookmarkedURL implements SharedBookmark {
    private final String URL;
    private boolean isRss;
    private boolean isShared;
    private String name;

    public BookmarkedURL(String str) {
        this.URL = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BookmarkedURL) {
            return ((BookmarkedURL) obj).getURL().equalsIgnoreCase(this.URL);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getURL() {
        return this.URL;
    }

    public boolean isRss() {
        return this.isRss;
    }

    @Override // org.jivesoftware.smackx.bookmarks.SharedBookmark
    public boolean isShared() {
        return this.isShared;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRss(boolean z) {
        this.isRss = z;
    }

    public void setShared(boolean z) {
        this.isShared = z;
    }

    public BookmarkedURL(String str, String str2, boolean z) {
        this.URL = str;
        this.name = str2;
        this.isRss = z;
    }
}
