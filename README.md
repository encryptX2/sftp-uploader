Simple SFTP Upload tool + Eclipse project

* Tool allows the upload of a file over sftp after supplying the following params:
HOST, PORT, USER, PASS, SFTPDIR, LOCALFILE

e.g. : java -jar sftp-upload.jar 192.0.0.1 22 USER_NAME USER_PASS "sftp/dir/" "c:/localFile.txt"