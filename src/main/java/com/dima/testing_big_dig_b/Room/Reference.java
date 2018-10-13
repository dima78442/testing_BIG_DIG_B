package com.dima.testing_big_dig_b.Room;

public class Reference{

    private String url;
    private String status;
    private String time;
    private int id;

    public Reference(String url, String status, String time, int id) {
        this.url = url;
        this.status = status;
        this.time = time;
        this.id = id;
    }

    public Reference(){
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String url;
        private String status;
        private String time;
        private int id;

        public Builder setUrl(String url) {
            this.url = url;

            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;

            return this;
        }

        public Builder setTimeAt(String time) {
            this.time = time;

            return this;
        }

        public Builder setId(int id) {
            this.id = id;

            return this;
        }

        public Reference build() {
            return new Reference(this.url, this.status, this.time,this.id);
        }

    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    public String getTimeAt() {
        return time;
    }

    public void setUrl(String url) { this.url = url; }

    public int getId() { return id; }
}
