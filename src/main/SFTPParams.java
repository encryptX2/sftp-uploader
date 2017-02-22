package main;

public class SFTPParams {
    String host;
    int port;
    String user;
    String pass;
    String sftpDir;
    String localFile;
    
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getSftpDir() {
        return sftpDir;
    }
    public void setSftpDir(String sftpDir) {
        this.sftpDir = sftpDir;
    }
    public String getLocalFile() {
        return localFile;
    }
    public void setLocalFile(String localFile) {
        this.localFile = localFile;
    }
    
    
}
