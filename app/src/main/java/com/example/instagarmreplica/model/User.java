package com.example.instagarmreplica.model;

public class User {
    private String fullname,  email, username, profile_image, password;

    public User(String fullname,String email, String user_name, String profile_image, String password) {
        this.fullname = fullname;
//        this.phone = phone;
        this.email = email;
        this.profile_image = profile_image;
        this.username = user_name;
        this.password = password;
    }

    public User(String user_name, String password) {
        this.username = user_name;
        this.password = password;
    }

    public User(String fullname, String email, String user_name, String password) {
        this.fullname = fullname;
        this.email = email;
        this.username = user_name;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
