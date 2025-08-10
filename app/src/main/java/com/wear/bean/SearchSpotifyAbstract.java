package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class SearchSpotifyAbstract {
    public abstract void appendItems(boolean z, SearchSpotifyAbstract searchSpotifyAbstract);

    public int getDuration(int i) {
        return 0;
    }

    public abstract List<?> getList();

    public abstract MusicPlaylist getMusicPlaylist(int i);

    public abstract String getTracksUri(int i);

    public abstract String imageUrl(int i);

    public abstract boolean isGroupItem();

    public abstract String nextUrl();

    public abstract String notice(int i);

    public abstract String searchType();

    public abstract String title(int i);
}
