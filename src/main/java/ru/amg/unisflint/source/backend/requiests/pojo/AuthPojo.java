package ru.amg.unisflint.source.backend.requiests.pojo;

public class AuthPojo {

    private String username;
    private String password;

    public AuthPojo () {
    }

    public AuthPojo (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
