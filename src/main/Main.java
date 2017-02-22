package main;

import java.util.Properties;

public class Main {
    static Properties props;

    public static void main(String[] args) throws Exception {
        if (args.length >= 6) {
            SFTPParams params = new SFTPParams();
            params.setHost(args[0]);
            params.setPort(Integer.valueOf(args[1]));
            params.setUser(args[2]);
            params.setPass(args[3]);
            params.setSftpDir(args[4]);
            params.setLocalFile(args[5]);

            new SFTPSender().send(params);
        } else {
            throw new Exception(
                    "MANDATORY PARAMETERS NOT DETECTED! EXPECTED PARAMETERS : HOST, PORT, USER, PASS, SFTPDIR, LOCALFILE");
        }
    }
}
