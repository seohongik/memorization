import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File("/Users/seohong-ik/Desktop/asdf.txt");
        System.out.println(file.getPath());
        SftpClient s= new SftpClient();
        String ip = ""; // server ip
        String id = "";// server id
        String pw = "";// server password
        int port = 22; // server port default 22

        s.connectSFTP(ip,port,id,pw);

        String remoteFilePath ="";
        String localDirPath   ="";
        String remoteFileName ="";
        boolean overwrite =false;

        String dirPath ="";

        s.downloadFile(remoteFilePath,localDirPath,remoteFileName,overwrite);
        s.uploadFile(file.getPath(),dirPath);
        s.disconnectSFTP();

    }
}
