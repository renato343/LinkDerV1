package org.renato.model.pojos;

public class User {

    private Long userId;

    private String name;

    private String email;

    private String motto;


    public User() {
    }

    public User(Long userId, String name, String email, String motto) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.motto = motto;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }
}
