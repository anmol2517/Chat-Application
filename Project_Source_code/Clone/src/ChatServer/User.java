package ChatServer;

import java.net.*;

public class User {

    String UserName;
    String Passward;
    InetAddress ip;
    int Port;

    public User() {
    }

    public User(String UserName, String Passward, InetAddress ip, int Port) {
        this.UserName = UserName;
        this.Passward = Passward;
        this.ip = ip;
        this.Port = Port;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassward() {
        return Passward;
    }

    public void setPassward(String Passward) {
        this.Passward = Passward;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }
}

