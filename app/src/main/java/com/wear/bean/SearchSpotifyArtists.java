package com.wear.bean;

import com.huawei.hms.framework.common.ContainerUtils;
import com.wear.util.WearUtils;
import java.util.List;

/* loaded from: classes3.dex */
public class SearchSpotifyArtists extends SearchSpotifyAbstract {
    private ArtistsBean artists;

    public static class ArtistsBean {
        private String href;
        private List<ItemsBean> items;
        private int limit;
        private String next;
        private int offset;
        private String previous;
        private int total;

        public static class ItemsBean {
            private ExternalUrlsBean external_urls;
            private FollowersBean followers;
            private List<String> genres;
            private String href;
            private String id;
            private List<ImagesBean> images;
            private String name;
            private int popularity;
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

            public static class FollowersBean {
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

            public ExternalUrlsBean getExternal_urls() {
                return this.external_urls;
            }

            public FollowersBean getFollowers() {
                return this.followers;
            }

            public List<String> getGenres() {
                return this.genres;
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

            public int getPopularity() {
                return this.popularity;
            }

            public String getType() {
                return this.type;
            }

            public String getUri() {
                return this.uri;
            }

            public void setExternal_urls(ExternalUrlsBean externalUrlsBean) {
                this.external_urls = externalUrlsBean;
            }

            public void setFollowers(FollowersBean followersBean) {
                this.followers = followersBean;
            }

            public void setGenres(List<String> list) {
                this.genres = list;
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

            public void setPopularity(int i) {
                this.popularity = i;
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
        SearchSpotifyArtists searchSpotifyArtists = (SearchSpotifyArtists) searchSpotifyAbstract;
        if (!z) {
            this.artists = searchSpotifyArtists.getArtists();
            return;
        }
        if (searchSpotifyArtists.getArtists() != null) {
            this.artists.setHref(searchSpotifyArtists.getArtists().getHref());
            this.artists.setLimit(searchSpotifyArtists.getArtists().getLimit());
            this.artists.setNext(searchSpotifyArtists.getArtists().getNext());
            this.artists.setOffset(searchSpotifyArtists.getArtists().getOffset());
            this.artists.setPrevious(searchSpotifyArtists.getArtists().getPrevious());
            this.artists.setTotal(searchSpotifyArtists.getArtists().getTotal());
            this.artists.getItems().addAll(searchSpotifyArtists.getArtists().getItems());
        }
    }

    public ArtistsBean getArtists() {
        return this.artists;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public List<?> getList() {
        ArtistsBean artistsBean = this.artists;
        if (artistsBean != null) {
            return artistsBean.getItems();
        }
        return null;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public MusicPlaylist getMusicPlaylist(int i) {
        ArtistsBean artistsBean = this.artists;
        if (artistsBean == null || artistsBean.getItems() == null || i >= this.artists.getItems().size()) {
            return null;
        }
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        musicPlaylist.setId(this.artists.getItems().get(i).getId());
        musicPlaylist.setName(title(i));
        musicPlaylist.setCover(imageUrl(i));
        musicPlaylist.setTracksUrl(getTracksUri(i));
        return musicPlaylist;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String getTracksUri(int i) {
        String strSubstring;
        ArtistsBean artistsBean = this.artists;
        if (artistsBean == null || artistsBean.getItems() == null || i >= this.artists.getItems().size()) {
            return null;
        }
        if (WearUtils.e1(this.artists.getHref()) || !this.artists.getHref().contains("market=")) {
            strSubstring = "ES";
        } else {
            String strSubstring2 = this.artists.getHref().substring(this.artists.getHref().indexOf("market=") + 7);
            strSubstring = strSubstring2.substring(0, strSubstring2.indexOf(ContainerUtils.FIELD_DELIMITER));
        }
        return this.artists.getItems().get(i).href + "/top-tracks?country=" + strSubstring;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String imageUrl(int i) {
        ArtistsBean artistsBean = this.artists;
        if (artistsBean == null || artistsBean.getItems() == null || i >= this.artists.getItems().size() || this.artists.getItems().get(i).getImages() == null || this.artists.getItems().get(i).getImages().size() <= 0) {
            return null;
        }
        return this.artists.getItems().get(i).getImages().get(this.artists.getItems().get(i).getImages().size() - 1).getUrl();
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public boolean isGroupItem() {
        return true;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String nextUrl() {
        ArtistsBean artistsBean = this.artists;
        if (artistsBean != null) {
            return artistsBean.getNext();
        }
        return null;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String notice(int i) {
        return null;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String searchType() {
        return "artist";
    }

    public void setArtists(ArtistsBean artistsBean) {
        this.artists = artistsBean;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String title(int i) {
        ArtistsBean artistsBean = this.artists;
        if (artistsBean == null || artistsBean.getItems() == null || i >= this.artists.getItems().size()) {
            return null;
        }
        return this.artists.getItems().get(i).getName();
    }
}
