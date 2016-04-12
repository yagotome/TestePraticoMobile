package yagotome.testepraticomobile.domain;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

/**
 * Classe de modelo para projeto.
 */
public class Project implements Serializable {
    private long id;
    private String title;
    private String description;
    private List<String> tags;
    private Picture picture;
    private User user;
    private String likes;
    private String views;
    @Nullable private List<Comment> comments;

    public Project() {}

    public Project(String title, String description, List<String> tags, Picture picture
            , User user, String likes, String views, @Nullable List<Comment> comments) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.picture = picture;
        this.user = user;
        this.likes = likes;
        this.views = views;
        this.comments = comments;
    }

    @Nullable
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(@Nullable List<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getCommentsAmount() {
        if (comments == null || comments.size() == 0) {
            return "0";
        }
        int num = comments.size();
        int digits = 0;
        for (int x = num; x > 0; digits++) {
            x = x / 10;
        }
        String[] suf = {"k", "M", "G"};
        String amount = String.valueOf(num);
        int n = ((digits-1)%3)+1;
        amount = amount.substring(0, n);
        return amount + (digits < 4 ? "" : suf[(digits-1)/3 -1]);
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
