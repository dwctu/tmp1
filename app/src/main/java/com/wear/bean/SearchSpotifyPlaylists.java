package com.wear.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes3.dex */
public class SearchSpotifyPlaylists extends SearchSpotifyAbstract {
    private PlaylistsBean playlists;

    public static class PlaylistsBean {
        private String href;
        private List<ItemsBean> items;
        private int limit;
        private String next;
        private int offset;
        private String previous;
        private int total;

        public static class ItemsBean {
            private boolean collaborative;
            private ExternalUrlsBean external_urls;
            private String href;
            private String id;
            private List<ImagesBean> images;
            private String name;
            private OwnerBean owner;

            @SerializedName("public")
            private String publicX;
            private String snapshot_id;
            private TracksBean tracks;
            private String type;
            private String uri;

            public static class ExternalUrlsBean {
                private String spotify;

                public String getSpotify() {
                    return this.spotify;
                }

                public void setSpotify(String str) {
                    this.spotify = str;
                }
            }

            public static class ImagesBean {
                private int height;
                private String url;
                private int width;

                public int getHeight() {
                    return this.height;
                }

                public String getUrl() {
                    return this.url;
                }

                public int getWidth() {
                    return this.width;
                }

                public void setHeight(int i) {
                    this.height = i;
                }

                public void setUrl(String str) {
                    this.url = str;
                }

                public void setWidth(int i) {
                    this.width = i;
                }
            }

            public static class OwnerBean {
                private ExternalUrlsBeanX external_urls;
                private String href;
                private String id;
                private String type;
                private String uri;

                public static class ExternalUrlsBeanX {
                    private String spotify;

                    public String getSpotify() {
                        return this.spotify;
                    }

                    public void setSpotify(String str) {
                        this.spotify = str;
                    }
                }

                public ExternalUrlsBeanX getExternal_urls() {
                    return this.external_urls;
                }

                public String getHref() {
                    return this.href;
                }

                public String getId() {
                    return this.id;
                }

                public String getType() {
                    return this.type;
                }

                public String getUri() {
                    return this.uri;
                }

                public void setExternal_urls(ExternalUrlsBeanX externalUrlsBeanX) {
                    this.external_urls = externalUrlsBeanX;
                }

                public void setHref(String str) {
                    this.href = str;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public void setType(String str) {
                    this.type = str;
                }

                public void setUri(String str) {
                    this.uri = str;
                }
            }

            public static class TracksBean {
                private String href;
                private int total;

                public String getHref() {
                    return this.href;
                }

                public int getTotal() {
                    return this.total;
                }

                public void setHref(String str) {
                    this.href = str;
                }

                public void setTotal(int i) {
                    this.total = i;
                }
            }

            public ExternalUrlsBean getExternal_urls() {
                return this.external_urls;
            }

            public String getHref() {
                return this.href;
            }

            public String getId() {
                return this.id;
            }

            public List<ImagesBean> getImages() {
                return this.images;
            }

            public String getName() {
                return this.name;
            }

            public OwnerBean getOwner() {
                return this.owner;
            }

            public String getPublicX() {
                return this.publicX;
            }

            public String getSnapshot_id() {
                return this.snapshot_id;
            }

            public TracksBean getTracks() {
                return this.tracks;
            }

            public String getType() {
                return this.type;
            }

            public String getUri() {
                return this.uri;
            }

            public boolean isCollaborative() {
                return this.collaborative;
            }

            public void setCollaborative(boolean z) {
                this.collaborative = z;
            }

            public void setExternal_urls(ExternalUrlsBean externalUrlsBean) {
                this.external_urls = externalUrlsBean;
            }

            public void setHref(String str) {
                this.href = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setImages(List<ImagesBean> list) {
                this.images = list;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setOwner(OwnerBean ownerBean) {
                this.owner = ownerBean;
            }

            public void setPublicX(String str) {
                this.publicX = str;
            }

            public void setSnapshot_id(String str) {
                this.snapshot_id = str;
            }

            public void setTracks(TracksBean tracksBean) {
                this.tracks = tracksBean;
            }

            public void setType(String str) {
                this.type = str;
            }

            public void setUri(String str) {
                this.uri = str;
            }
        }

        public String getHref() {
            return this.href;
        }

        public List<ItemsBean> getItems() {
            return this.items;
        }

        public int getLimit() {
            return this.limit;
        }

        public String getNext() {
            return this.next;
        }

        public int getOffset() {
            return this.offset;
        }

        public String getPrevious() {
            return this.previous;
        }

        public int getTotal() {
            return this.total;
        }

        public void setHref(String str) {
            this.href = str;
        }

        public void setItems(List<ItemsBean> list) {
            this.items = list;
        }

        public void setLimit(int i) {
            this.limit = i;
        }

        public void setNext(String str) {
            this.next = str;
        }

        public void setOffset(int i) {
            this.offset = i;
        }

        public void setPrevious(String str) {
            this.previous = str;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public void appendItems(boolean z, SearchSpotifyAbstract searchSpotifyAbstract) {
        SearchSpotifyPlaylists searchSpotifyPlaylists = (SearchSpotifyPlaylists) searchSpotifyAbstract;
        if (!z) {
            this.playlists = searchSpotifyPlaylists.getPlaylists();
            return;
        }
        if (searchSpotifyPlaylists.getPlaylists() != null) {
            this.playlists.setHref(searchSpotifyPlaylists.getPlaylists().getHref());
            this.playlists.setLimit(searchSpotifyPlaylists.getPlaylists().getLimit());
            this.playlists.setNext(searchSpotifyPlaylists.getPlaylists().getNext());
            this.playlists.setOffset(searchSpotifyPlaylists.getPlaylists().getOffset());
            this.playlists.setPrevious(searchSpotifyPlaylists.getPlaylists().getPrevious());
            this.playlists.setTotal(searchSpotifyPlaylists.getPlaylists().getTotal());
            this.playlists.getItems().addAll(searchSpotifyPlaylists.getPlaylists().getItems());
        }
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public List<?> getList() {
        PlaylistsBean playlistsBean = this.playlists;
        if (playlistsBean != null) {
            return playlistsBean.getItems();
        }
        return null;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public MusicPlaylist getMusicPlaylist(int i) {
        PlaylistsBean playlistsBean = this.playlists;
        if (playlistsBean == null || playlistsBean.getItems() == null || i >= this.playlists.getItems().size()) {
            return null;
        }
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        musicPlaylist.setId(this.playlists.getItems().get(i).getId());
        musicPlaylist.setName(title(i));
        musicPlaylist.setCover(imageUrl(i));
        musicPlaylist.setTracksUrl(getTracksUri(i));
        return musicPlaylist;
    }

    public PlaylistsBean getPlaylists() {
        return this.playlists;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String getTracksUri(int i) {
        PlaylistsBean playlistsBean = this.playlists;
        if (playlistsBean == null || playlistsBean.getItems() == null || i >= this.playlists.getItems().size() || this.playlists.getItems().get(i).getTracks() == null) {
            return null;
        }
        return this.playlists.getItems().get(i).getTracks().getHref();
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String imageUrl(int i) {
        PlaylistsBean playlistsBean = this.playlists;
        if (playlistsBean == null || playlistsBean.getItems() == null || i >= this.playlists.getItems().size() || this.playlists.getItems().get(i).getImages() == null || this.playlists.getItems().get(i).getImages().size() <= 0) {
            return null;
        }
        return this.playlists.getItems().get(i).getImages().get(this.playlists.getItems().get(i).getImages().size() - 1).getUrl();
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public boolean isGroupItem() {
        return true;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String nextUrl() {
        PlaylistsBean playlistsBean = this.playlists;
        if (playlistsBean != null) {
            return playlistsBean.getNext();
        }
        return null;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String notice(int i) {
        PlaylistsBean playlistsBean = this.playlists;
        if (playlistsBean == null || playlistsBean.getItems() == null || i >= this.playlists.getItems().size() || this.playlists.getItems().get(i).getTracks() == null) {
            return null;
        }
        return this.playlists.getItems().get(i).getTracks().getTotal() + "";
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String searchType() {
        return "playlist";
    }

    public void setPlaylists(PlaylistsBean playlistsBean) {
        this.playlists = playlistsBean;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String title(int i) {
        PlaylistsBean playlistsBean = this.playlists;
        if (playlistsBean == null || playlistsBean.getItems() == null || i >= this.playlists.getItems().size()) {
            return null;
        }
        return this.playlists.getItems().get(i).getName();
    }
}
