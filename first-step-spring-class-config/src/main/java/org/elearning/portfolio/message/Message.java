package org.elearning.portfolio.message;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
public class Message{
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "USER_ID" )
    private Integer userId;
    @Column(name = "TITLE")
    private String title;
    @Column(name="CONTENT")
    private String content;

    public void setId(Integer id){this.id = id;}

    public Integer getId(){
        return id;
    }

    public  void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}