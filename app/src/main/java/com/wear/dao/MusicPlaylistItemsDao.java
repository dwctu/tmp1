package com.wear.dao;

import com.wear.bean.MusicPlaylistItems;
import com.wear.util.WearUtils;
import dc.nd3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MusicPlaylistItemsDao extends BaseDao<MusicPlaylistItems> {
    public int checkFavMusic(MusicPlaylistItems musicPlaylistItems) {
        List<MusicPlaylistItems> listFindByPlaylistSongId = findByPlaylistSongId(musicPlaylistItems.getPlaylistId(), musicPlaylistItems.getSongId());
        int sortId = 0;
        if (listFindByPlaylistSongId == null || listFindByPlaylistSongId.size() <= 0) {
            MusicPlaylistItems musicPlaylistItems2 = new MusicPlaylistItems();
            musicPlaylistItems2.setEmail(WearUtils.y.p());
            musicPlaylistItems2.setMusic(musicPlaylistItems.getMusic());
            musicPlaylistItems2.setPlaylistId(musicPlaylistItems.getPlaylistId());
            if (musicPlaylistItems.getMusic() != null) {
                musicPlaylistItems2.setSongId("" + musicPlaylistItems.getMusic().getSongId());
                DaoUtils.getMusicPlaylistItemsDao().addIfNotExist(musicPlaylistItems2);
            }
        } else {
            sortId = listFindByPlaylistSongId.get(0).getSortId();
            if (listFindByPlaylistSongId.size() > 1) {
                for (int i = 1; i < listFindByPlaylistSongId.size(); i++) {
                    delT(listFindByPlaylistSongId.get(i));
                }
            }
        }
        return sortId;
    }

    public List<MusicPlaylistItems> findByEmail(String str) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return this.dao.queryBuilder().orderBy("created", false).where().eq("email", str).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<MusicPlaylistItems> findByEmailAndPlaylistId(String str, String str2) {
        try {
            if (!WearUtils.e1(str)) {
                str = nd3.p(str);
            }
            return this.dao.queryBuilder().orderBy("sortId", true).where().eq("email", str).and().eq("playlistId", str2).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<MusicPlaylistItems> findByPlaylistSongId(String str, String str2) {
        if (!WearUtils.e1(str) && !WearUtils.e1(str2)) {
            try {
                return this.dao.queryBuilder().orderBy("sortId", true).where().eq("email", nd3.u(WearUtils.y.p())).and().eq("playlistId", str).and().eq("songId", str2).query();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList();
    }

    public void updateSore(MusicPlaylistItems musicPlaylistItems) {
        List<MusicPlaylistItems> listFindByPlaylistSongId = findByPlaylistSongId(musicPlaylistItems.getPlaylistId(), musicPlaylistItems.getSongId());
        if (listFindByPlaylistSongId == null || listFindByPlaylistSongId.size() <= 0) {
            return;
        }
        MusicPlaylistItems musicPlaylistItems2 = listFindByPlaylistSongId.get(0);
        musicPlaylistItems2.setSortId(musicPlaylistItems.getSortId());
        update((MusicPlaylistItemsDao) musicPlaylistItems2);
    }
}
