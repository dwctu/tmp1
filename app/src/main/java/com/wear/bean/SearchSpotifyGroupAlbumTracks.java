package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class SearchSpotifyGroupAlbumTracks {
    private String href;
    private List<ItemsBean> items;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;

    public static class ItemsBean {
        private List<ArtistsBean> artists;
        private List<String> available_markets;
        private int disc_number;
        private int duration_ms;
        private boolean explicit;
        private ExternalUrlsBean external_urls;
        private String href;
        private String id;
        private String name;
        private String preview_url;
        private int track_number;
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

        public List<ArtistsBean> getArtists() {
            return this.artists;
        }

        public List<String> getAvailable_markets() {
            return this.available_markets;
        }

        public int getDisc_number() {
            return this.disc_number;
        }

        public int getDuration_ms() {
            return this.duration_ms;
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

        public String getName() {
            return this.name;
        }

        public String getPreview_url() {
            return this.preview_url;
        }

        public int getTrack_number() {
            return this.track_number;
        }

        public String getType() {
            return this.type;
        }

        public String getUri() {
            return this.uri;
        }

        public boolean isExplicit() {
            return this.explicit;
        }

        public void setArtists(List<ArtistsBean> list) {
            this.artists = list;
        }

        public void setAvailable_markets(List<String> list) {
            this.available_markets = list;
        }

        public void setDisc_number(int i) {
            this.disc_number = i;
        }

        public void setDuration_ms(int i) {
            this.duration_ms = i;
        }

        public void setExplicit(boolean z) {
            this.explicit = z;
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

        public void setName(String str) {
            this.name = str;
        }

        public void setPreview_url(String str) {
            this.preview_url = str;
        }

        public void setTrack_number(int i) {
            this.track_number = i;
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
