package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.dao.DaoUtils;
import com.wear.dao.MergerMusicDao;
import com.wear.dao.MusicPlaylistDao;
import com.wear.dao.MusicPlaylistItemsDao;
import com.wear.util.WearUtils;
import dc.cf3;
import dc.nd3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DatabaseTable(tableName = "tb_music_playlist")
/* loaded from: classes3.dex */
public class MusicPlaylist extends BaseEntity {

    @DatabaseField
    private String cover;
    private int createFromLocalDB;

    @DatabaseField
    private String email;

    @DatabaseField
    private String name;

    @DatabaseField
    private String notice;

    @DatabaseField
    private int sortId;
    private List<MusicPlaylistItems> itemsList = new ArrayList();
    private int total = 0;
    private String tracksUrl = "";
    private boolean isStreamMusic = false;

    public MusicPlaylist() {
        setId(WearUtils.E());
    }

    private boolean addAndSaveMergerMusicToPlaylist(Music music) {
        if (DaoUtils.getMergerMusicDao().isExistMergerMusic(getId(), music.getMusicType() == 0 ? String.valueOf(music.getSongId()) : music.getData())) {
            return false;
        }
        addPlaylistItemByMusicToList(music, getEmail(), false, WearUtils.e1(getTracksUrl()));
        setTotal(getTotal() + 1);
        DaoUtils.getMergerMusicDao().add((MergerMusicDao) new MergerMusic().createMergerMusic(getId(), music, this.email));
        return true;
    }

    public void addPlaylistItem(MusicPlaylistItems musicPlaylistItems) {
        this.itemsList.add(musicPlaylistItems);
    }

    public void addPlaylistItemByMusicToList(Music music, String str, boolean z, boolean z2) {
        String imageUrl;
        MusicPlaylistItems musicPlaylistItems = new MusicPlaylistItems();
        if (WearUtils.e1(str)) {
            musicPlaylistItems.setEmail("");
        } else {
            musicPlaylistItems.setEmail(str);
        }
        if (z2 && this.itemsList.size() == 0) {
            if (music.getMusicType() == 0) {
                imageUrl = "content://media/external/audio/albumart/" + music.getAlbumId();
            } else {
                imageUrl = music.getImageUrl();
            }
            setCover(imageUrl);
            DaoUtils.getMusicPlaylistDao().update((MusicPlaylistDao) this);
        }
        musicPlaylistItems.setMusic(music);
        musicPlaylistItems.setPlaylistId(getId());
        musicPlaylistItems.setSongId("" + music.getSongId());
        if (music != null) {
            if (z) {
                DaoUtils.getMusicPlaylistItemsDao().add((MusicPlaylistItemsDao) musicPlaylistItems);
            }
            this.itemsList.add(musicPlaylistItems);
        }
        String str2 = "" + this.itemsList.size();
        if (getCreateFromLocalDB() == 1) {
            setCover(cf3.i(WearUtils.x, this));
        }
    }

    public boolean checkExistInList(boolean z, Music music) {
        for (Music music2 : getMusics()) {
            if (!WearUtils.d1(Long.valueOf(music2.getSongId())) && !WearUtils.d1(Long.valueOf(music.getSongId())) && music2.getSongId() == music.getSongId()) {
                return true;
            }
            if (!WearUtils.e1(music2.getData()) && !WearUtils.e1(music.getData()) && music2.getData().equals(music.getData())) {
                return true;
            }
        }
        return false;
    }

    public void cleanMusics() {
        this.itemsList.clear();
    }

    public void findPlaylistItemByDB(String str) {
        List<MusicPlaylistItems> listFindByEmailAndPlaylistId = DaoUtils.getMusicPlaylistItemsDao().findByEmailAndPlaylistId(str, getId());
        if (listFindByEmailAndPlaylistId != null) {
            this.itemsList.addAll(listFindByEmailAndPlaylistId);
        }
    }

    public String getCover() {
        return this.cover;
    }

    public int getCreateFromLocalDB() {
        return this.createFromLocalDB;
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public List<MusicPlaylistItems> getItemsList() {
        return this.itemsList;
    }

    public List<Music> getMusics() {
        ArrayList arrayList = new ArrayList();
        for (MusicPlaylistItems musicPlaylistItems : this.itemsList) {
            if (musicPlaylistItems.getMusic() != null) {
                arrayList.add(musicPlaylistItems.getMusic());
            }
        }
        return arrayList;
    }

    public String getName() {
        return this.name;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getOldEmail() {
        return this.email;
    }

    public int getSortId() {
        return this.sortId;
    }

    public int getTotal() {
        return this.total;
    }

    public String getTracksUrl() {
        return this.tracksUrl;
    }

    public void initMusic(List<Music> list) {
        ArrayList arrayList = new ArrayList();
        for (MusicPlaylistItems musicPlaylistItems : this.itemsList) {
            boolean z = false;
            Iterator<Music> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Music next = it.next();
                if (next != null) {
                    if (musicPlaylistItems.getSongId().equals("" + next.getSongId())) {
                        musicPlaylistItems.setMusic(next);
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                arrayList.add(musicPlaylistItems);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            MusicPlaylistItems musicPlaylistItems2 = (MusicPlaylistItems) it2.next();
            this.itemsList.remove(musicPlaylistItems2);
            DaoUtils.getMusicPlaylistItemsDao().delById(musicPlaylistItems2.getId());
        }
    }

    public boolean isStreamMusic() {
        return this.isStreamMusic;
    }

    public void removeByMusic(Music music) {
        MusicPlaylistItems next;
        Iterator<MusicPlaylistItems> it = this.itemsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.getMusic() == music) {
                    break;
                }
            }
        }
        if (next != null) {
            this.itemsList.remove(next);
        }
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setCreateFromLocalDB(int i) {
        this.createFromLocalDB = i;
    }

    public void setEmail(String str) {
        this.email = nd3.p(str);
    }

    public void setItemsList(List<MusicPlaylistItems> list) {
        this.itemsList = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public void setSortId(int i) {
        this.sortId = i;
    }

    public void setStreamMusic(boolean z) {
        this.isStreamMusic = z;
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public void setTracksUrl(String str) {
        this.tracksUrl = str;
    }

    public void upAndAddKeepOneMusic(Music music) {
        findPlaylistItemByDB(this.email);
        List<MusicPlaylistItems> list = this.itemsList;
        if (list == null || list.size() == 0) {
            if (music.getMusicType() == 0) {
                addPlaylistItemByMusicToList(music, this.email, true, true);
                return;
            } else {
                addAndSaveMergerMusicToPlaylist(music);
                return;
            }
        }
        if (checkExistInList(true, music)) {
            return;
        }
        MusicPlaylistItems musicPlaylistItems = this.itemsList.get(0);
        musicPlaylistItems.setMusic(music);
        musicPlaylistItems.setPlaylistId(getId());
        musicPlaylistItems.setSongId("" + music.getSongId());
        DaoUtils.getMusicPlaylistItemsDao().updateOrAdd(musicPlaylistItems);
    }

    public void updateSorePlayList() {
        this.itemsList.clear();
        findPlaylistItemByDB(WearUtils.y.r());
    }

    public MusicPlaylist(String str) {
        setId(str);
    }
}
