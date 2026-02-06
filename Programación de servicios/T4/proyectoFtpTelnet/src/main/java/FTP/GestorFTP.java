package FTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.*;
import java.nio.file.Files;

public class GestorFTP {
    private FTPClient ftpClient;

    public GestorFTP() {
        this.ftpClient = new FTPClient();
    }

    public boolean conectar(String server, String user, String pass) {
        try {
            ftpClient.connect(server, 5000);
            if (ftpClient.login(user, pass)) {
                ftpClient.enterLocalPassiveMode();
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void listar() {
        try {
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                String tipo = file.isDirectory() ? "[DIR]" : "[FILE]";
                System.out.println(tipo + " " + file.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean cambiarDirectorio(String path) throws IOException {
        return ftpClient.changeWorkingDirectory(path); // [cite: 19]
    }

    public void descargar(String nombreArchivo) throws FileNotFoundException {
        File local = new File(nombreArchivo);

        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(local.toPath()))) {
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); // asegura integridad del archivo

            if (ftpClient.retrieveFile(nombreArchivo, os)) {
                System.out.println("Descargado en: " + local.getAbsolutePath());
            } else {
                System.out.println("No se puedo descargar el archivo solicitado.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void cerrar() {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException ignored) {}
    }

    public boolean estaConectado() {
        return ftpClient.isConnected();
    }
}
