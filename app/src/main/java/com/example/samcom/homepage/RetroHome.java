package com.example.samcom.homepage;

public class RetroHome {

    String uname;

    public RetroHome(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    String password;

    public String getUname() {
        return uname;
    }

    public String getPassword() {
        return password;
    }
}
