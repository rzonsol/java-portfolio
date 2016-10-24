package org.elearning.portfolio.message;

public class Message{

    private Integer id;
    private Integer userId;
    private String title;
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