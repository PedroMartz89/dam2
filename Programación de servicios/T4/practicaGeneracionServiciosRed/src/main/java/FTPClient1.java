import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

public class FTPClient1 {
    public static void main(String[] args) throws IOException {

        FTPClient clienteFTP = new FTPClient();
        String servidorFTP = "ftp.rediris.es";

        int codigoRespuesta;
        echo("Conectando a " + servidorFTP + " ...");
        clienteFTP.connect(servidorFTP);

        //respuesta del servidor
        codigoRespuesta = clienteFTP.getReplyCode();

        //código de respuesta
        if (!FTPReply.isPositiveCompletion(codigoRespuesta)) {
            clienteFTP.disconnect();
            echo("Conexíon rechazada " + codigoRespuesta);
            System.exit(0);
        }
        clienteFTP.disconnect();
        echo("Conexión finalizada");
    }
        private static void echo(String e){
            System.out.println(e);
        }
}