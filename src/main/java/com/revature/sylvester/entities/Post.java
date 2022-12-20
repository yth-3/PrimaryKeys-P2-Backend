package com.revature.sylvester.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    private String postId;

    @Column(name = "posted")
    private Date posted;

    @Column(name = "content")
    private String content;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonBackReference // child
    private User user;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "post"
    )
    @JsonManagedReference // parent
    private List<Like> likes;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "post"
    )
    @JsonManagedReference // parent
    private List<Reply> replies;

    public Post() {
        super();
    }

    public Post(String postId, Date posted, String content, String imgUrl) {
        this.postId = postId;
        this.posted = posted;
        this.content = content;
        this.imgUrl = imgUrl;
    }

    public Post(String postId, Date posted, String content, String imgUrl, User user) {
        this.postId = postId;
        this.posted = posted;
        this.content = content;
        this.imgUrl = imgUrl;
        this.user = user;
    }

    public Post(String postId, Date posted, String content, String imgUrl, User user, List<Like> likes, List<Reply> replies) {
        this.postId = postId;
        this.posted = posted;
        this.content = content;
        this.imgUrl = imgUrl;
        this.user = user;
        this.likes = likes;
        this.replies = replies;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", posted=" + posted +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", user=" + user +
                ", likes=" + likes +
                ", replies=" + replies +
                '}';
    }
}
