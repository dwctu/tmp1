package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class SearchSpotifyAlbums extends SearchSpotifyAbstract {
    private AlbumsBean albums;

    public static class AlbumsBean {
        private String href;
        private List<ItemsBean> items;
        private int limit;
        private String next;
        private int offset;
        private String previous;
        private int total;

        public static class ItemsBean {
            private String album_type;
            private List<ArtistsBean> artists;
            private List<String> available_markets;
            private ExternalUrlsBean external_urls;
            private String href;
            private String id;
            private List<ImagesBean> images;
            private String name;
            private String type;
            private String uri;

            public static class ArtistsBean {
                private ExternalUrlsBeanX external_urls;
                private String href;
                private String id;
                private String name;
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

                public String getName() {
                    return this.name;
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

                public void setName(String str) {
                    this.name = str;
                }

                public void setType(String str) {
                    this.type = str;
                }

                public void setUri(String str) {
                    this.uri = str;
                }
            }

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

            public String getAlbum_type() {
                return this.album_type;
            }

            public List<ArtistsBean> getArtists() {
                return this.artists;
            }

            public List<String> getAvailable_markets() {
                return this.available_markets;
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

            public String getType() {
                return this.type;
            }

            public String getUri() {
                return this.uri;
            }

            public void setAlbum_type(String str) {
                this.album_type = str;
            }

            public void setArtists(List<ArtistsBean> list) {
                this.artists = list;
            }

            public void setAvailable_markets(List<String> list) {
                this.available_markets = list;
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
        SearchSpotifyAlbums searchSpotifyAlbums = (SearchSpotifyAlbums) searchSpotifyAbstract;
        if (!z) {
            this.albums = searchSpotifyAlbums.getAlbums();
            return;
        }
        if (searchSpotifyAlbums.getAlbums() != null) {
            this.albums.setHref(searchSpotifyAlbums.getAlbums().getHref());
            this.albums.setLimit(searchSpotifyAlbums.getAlbums().getLimit());
            this.albums.setNext(searchSpotifyAlbums.getAlbums().getNext());
            this.albums.setOffset(searchSpotifyAlbums.getAlbums().getOffset());
            this.albums.setPrevious(searchSpotifyAlbums.getAlbums().getPrevious());
            this.albums.setTotal(searchSpotifyAlbums.getAlbums().getTotal());
            this.albums.getItems().addAll(searchSpotifyAlbums.getAlbums().getItems());
        }
    }

    public AlbumsBean getAlbums() {
        return this.albums;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public List<?> getList() {
        AlbumsBean albumsBean = this.albums;
        if (albumsBean != null) {
            return albumsBean.getItems();
        }
        return null;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public MusicPlaylist getMusicPlaylist(int i) {
        AlbumsBean albumsBean = this.albums;
        if (albumsBean == null || albumsBean.getItems() == null || i >= this.albums.getItems().size()) {
            return null;
        }
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        musicPlaylist.setId(this.albums.getItems().get(i).getId());
        musicPlaylist.setName(title(i));
        musicPlaylist.setCover(imageUrl(i));
        musicPlaylist.setTracksUrl(getTracksUri(i));
        return musicPlaylist;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String getTracksUri(int i) {
        AlbumsBean albumsBean = this.albums;
        if (albumsBean == null || albumsBean.getItems() == null || i >= this.albums.getItems().size()) {
            return null;
        }
        return this.albums.getItems().get(i).href + "/tracks";
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String imageUrl(int i) {
        AlbumsBean albumsBean = this.albums;
        if (albumsBean == null || albumsBean.getItems() == null || i >= this.albums.getItems().size() || this.albums.getItems().get(i).getImages() == null || this.albums.getItems().get(i).getImages().size() <= 0) {
            return null;
        }
        return this.albums.getItems().get(i).getImages().get(this.albums.getItems().get(i).getImages().size() - 1).getUrl();
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public boolean isGroupItem() {
        return true;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String nextUrl() {
        AlbumsBean albumsBean = this.albums;
        if (albumsBean != null) {
            return albumsBean.getNext();
        }
        return null;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String notice(int i) {
        AlbumsBean albumsBean = this.albums;
        if (albumsBean == null || albumsBean.getItems() == null || i >= this.albums.getItems().size() || this.albums.getItems().get(i).getArtists() == null || this.albums.getItems().get(i).getArtists().size() <= 0) {
            return null;
        }
        return this.albums.getItems().get(i).getArtists().get(0).getName();
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String searchType() {
        return "album";
    }

    public void setAlbums(AlbumsBean albumsBean) {
        this.albums = albumsBean;
    }

    @Override // com.wear.bean.SearchSpotifyAbstract
    public String title(int i) {
        AlbumsBean albumsBean = this.albums;
        if (albumsBean == null || albumsBean.getItems() == null || i >= this.albums.getItems().size()) {
            return null;
        }
        return this.albums.getItems().get(i).getName();
    }
}
