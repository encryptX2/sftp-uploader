package main;

import java.io.File;
import java.io.FileInputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SFTPSender {

    public void send(SFTPParams params) {

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        System.out.println("preparing the host information for sftp.");
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(params.getUser(), params.getHost(), params.getPort());
            session.setPassword(params.getPass());
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.connect();
            System.out.println("Host connected.");
            channel = session.openChannel("sftp");
            channel.connect();
            System.out.println("sftp channel opened and connected.");
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(params.getSftpDir());
            File f = new File(params.getLocalFile());
            channelSftp.put(new FileInputStream(f), f.getName());
            System.out.println("File transfered successfully to host.");
        } catch (Exception ex) {
            System.out.println("Exception found while tranfer the response.");
            ex.printStackTrace();
        } finally {
            if(channelSftp != null){
                channelSftp.exit();
            }
            System.out.println("sftp Channel exited.");
            if(channel != null){
                channel.disconnect();
            }
            System.out.println("Channel disconnected.");
            if(session != null){
                session.disconnect();
            }
            System.out.println("Host Session disconnected.");
        }
    }

}
