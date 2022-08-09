import com.jcraft.jsch.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class SftpClient {

    private Session jschSession = null;
    private Channel channel = null;
    private ChannelSftp channelSftp = null;

    /**
     * 파일 업로드
     *
     * @param fileName
     * @param dirPath
     * @throws Exception
     */
    public boolean uploadFile(String fileName, String dirPath) throws Exception {
        boolean isSuccess = false;
        FileInputStream fis = null;

        try {

            File file = new File(fileName);
            fis = new FileInputStream(file);

            System.out.println(file.getName());
            // 파일 업로드
            channelSftp.put(fis, dirPath+file.getName());
            isSuccess = true;
            System.out.println("File uploaded : " + file.getAbsolutePath() + " => " + dirPath + "/" + file.getName());

        } catch (Exception e) {
            throw e;
        } finally {
            close(fis);
        }

        return isSuccess;
    }

    /**
     * 파일 다운로드
     *
     * @param remoteFilePath
     * @param localDirPath
     * @param overwrite
     * @return
     * @throws Exception
     */
    public boolean downloadFile(String remoteFilePath, String localDirPath, String remoteFileName, boolean overwrite) throws Exception {
        if (remoteFilePath == null || remoteFilePath.length() == 0) {
            return false;
        }

        boolean isSuccess = false;

        byte[] buffer = new byte[1024];

        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            remoteFilePath = remoteFilePath.replaceAll("\\\\", "/");
            File destFile = new File(localDirPath + File.separator + remoteFileName);
            if (destFile.exists()) {
                if (overwrite) {
                    destFile.delete();
                } else {
                    System.out.println("File Download canceled. File already exists : " + destFile.getAbsolutePath());
                    return false;
                }
            }

            // 파일 다운로드
            bis = new BufferedInputStream(channelSftp.get(remoteFileName));
            fos = new FileOutputStream(destFile);
            bos = new BufferedOutputStream(fos);
            int readCount = 0;
            while ((readCount = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, readCount);
            }
            isSuccess = true;
            System.out.println("File downloaded : " + remoteFilePath + " => " + destFile.getAbsolutePath());

        } catch (Exception e) {
            throw e;

        } finally {
            close(bos);
            close(fos);
            close(bis);
        }
        return isSuccess;
    }

    /**
     * 폴더 생성
     *
     * @param dirPath
     * @param dirName
     * @throws Exception
     */
    public boolean mkdir(String dirPath, String dirName) throws Exception {
        boolean isSuccess = false;
        String destDirPath = dirPath;
        boolean destDirExists = false;
        try {
            destDirExists = true;
        } catch (Exception e) {
            destDirExists = false;
        }
        if (destDirExists) {
            System.out.println("Folder Creation canceled. Folder already exists : " + destDirPath);
            return false;
        }
        // 대상폴더 이동
        channelSftp.cd(dirPath);
        // 폴더 생성
        channelSftp.mkdir(dirName);
        isSuccess = true;
        System.out.println("Folder created : " + destDirPath);
        return isSuccess;
    }

    /**
     * SFTP 접속하기
     *
     * @return
     * @throws JSchException
     * @throws Exception
     */
    public void connectSFTP(String host, int port, String userName, String password) throws IOException, JSchException {
        // JSch 객체를 생성

        String key = "/Users/seohong-ik/.ssh/id_rsa";
        JSch jsch = new JSch();
            //ssh-keygen -m PEM -t rsa

        final byte[] emptyPassPhrase = new byte[0]; // Empty passphrase for now, get real passphrase from MyUserInfo
        File file = new File("/Users/seohong-ik/.ssh/id_rsa.pub");
        FileInputStream fileInputStream = new FileInputStream(file);
        int data=0;
        List<Byte> list = new ArrayList<>();
        while ((data = fileInputStream.read()) != -1) {
            list.add((byte) data);
        }

        byte[] bytes = new byte[list.size()];
        for (int i=0; i<list.size(); i++) {
            bytes[i] = list.get(i);
        }

        jsch.addIdentity("/Users/seohong-ik/.ssh/id_rsa.pub", bytes);
        jsch.setKnownHosts("/Users/seohong-ik/.ssh/known_hosts.old");
        jschSession=jsch.getSession(userName,host,port);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");

        jschSession.setConfig(config);
        jschSession.connect();
        channel = jschSession.openChannel("sftp");
        channelSftp = (ChannelSftp) channel;
        channelSftp.connect();


    }

    /**
     * SFTP 접속해제
     */
    public void disconnectSFTP() {
        try {
            if (channelSftp != null && channelSftp.isConnected()) {
                channelSftp.disconnect();
            }
        } catch (Exception e) {
        } finally {
            channelSftp = null;
        }
        try {
            if (channel != null && channel.isConnected()) {
                channel.disconnect();
            }
        } catch (Exception e) {
        } finally {
            channel = null;
        }
        try {
            if (jschSession != null && jschSession.isConnected()) {
                jschSession.disconnect();
            }
        } catch (Exception e) {
        } finally {
            jschSession = null;
        }
    }

    /**
     * FileInputStream 객체 닫기
     *
     * @param fis
     */
    private void close(FileInputStream fis) {
        try {
            if (fis != null) {
                fis.close();
            }
        } catch (Exception e) {
        } finally {
            fis = null;
        }
    }

    /**
     * BufferedInputStream 객체 닫기
     *
     * @param bis
     */
    private void close(BufferedInputStream bis) {
        try {
            if (bis != null) {
                bis.close();
            }
        } catch (Exception e) {
        } finally {
            bis = null;
        }
    }

    /**
     * FileOutputStream 객체 닫기
     *
     * @param fos
     */
    private void close(FileOutputStream fos) {

        try {
            if (fos != null) {
                fos.flush();
            }
        } catch (Exception e) {
        }

        try {
            if (fos != null) {
                fos.close();
            }
        } catch (Exception e) {
        } finally {
            fos = null;
        }
    }

    /**
     * BufferedOutputStream 객체 닫기
     *
     * @param bos
     */
    private void close(BufferedOutputStream bos) {
        try {
            if (bos != null) {
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (bos != null) {
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bos = null;
        }
    }

}

