package com.wear.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes3.dex */
public class SpotifyPlaylist {
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
        private boolean publicX;
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

        public boolean isPublicX() {
            return this.publicX;
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

        public void setPublicX(boolean z) {
            this.publicX = z;
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
