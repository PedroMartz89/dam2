package ejFicheros;

import java.io.*;

public class Ficheros {
	
	//ejercicio6
	public void copiarFicheroTxt2Raf(String fuente, String destino) {

        try (BufferedReader br = new BufferedReader(new FileReader(fuente));
        RandomAccessFile raf = new RandomAccessFile(destino, "rw")){

            raf.setLength(0);
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(" ");
                int id = Integer.parseInt(partes[0]);
                long telf = Long.parseLong(partes[1]);
                String pais = partes[2];

                raf.writeInt(id);
                raf.writeLong(telf);
                raf.writeUTF(pais);

            }

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	//ejercicio7
	public void listarRegistros(String fichero) {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")){

            while (true) {
                int id = raf.readInt();
                long telf = raf.readLong();
                String pais = raf.readUTF();

                Registro r = new Registro(id, telf, pais);
                System.out.println(r);
            }

        } catch (RuntimeException | IOException e) {
            System.out.println("Fin del fichero.");
        }
    }
	
	//ejercicio8
	public Registro buscarRegistroPorCodigo (String fichero, int identificadorBuscar) {

        try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")){

            while (true) {

                int id = raf.readInt();
                long telf = raf.readLong();
                String pais = raf.readUTF();

                if (id == identificadorBuscar) {
                    System.out.println("Se ha encontrado el registro con id: " + identificadorBuscar);
                    return new Registro(id, telf, pais);
                }
            }

        } catch (RuntimeException | IOException e) {
            System.out.println("No se ha encontrado ningún registro con ese id.");
        }

        return null;
	}
}
