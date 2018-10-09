package com.olebas.colibritweet.pojo;

public class Tweet {

    private User user;
    private long id;
    private String creationDate;
    private String text;
    private long retweetCount;
    private long favouriteCount;
    private String imgUrl;

    public Tweet(User user, long id, String creationDate, String text, long retweetCount, long favouriteCount, String imgUrl) {
        this.user = user;
        this.id = id;
        this.creationDate = creationDate;
        this.text = text;
        this.retweetCount = retweetCount;
        this.favouriteCount = favouriteCount;
        this.imgUrl = imgUrl;
    }

    public User getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getText() {
        return text;
    }

    public long getRetweetCount() {
        return retweetCount;
    }

    public long getFavouriteCount() {
        return favouriteCount;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (id != tweet.id) return false;
        if (retweetCount != tweet.retweetCount) return false;
        if (favouriteCount != tweet.favouriteCount) return false;
        if (user != null ? !user.equals(tweet.user) : tweet.user != null) return false;
        if (creationDate != null ? !creationDate.equals(tweet.creationDate) : tweet.creationDate != null)
            return false;
        if (text != null ? !text.equals(tweet.text) : tweet.text != null) return false;
        return imgUrl.equals(tweet.imgUrl);
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (int) (retweetCount ^ (retweetCount >>> 32));
        result = 31 * result + (int) (favouriteCount ^ (favouriteCount >>> 32));
        result = 31 * result + imgUrl.hashCode();
        return result;
    }
}
