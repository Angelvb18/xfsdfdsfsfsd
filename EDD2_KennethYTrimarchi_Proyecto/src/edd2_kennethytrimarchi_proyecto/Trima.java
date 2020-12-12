package edd2_kennethytrimarchi_proyecto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;

/**
 *
 * Bienvenido a Java Puterias y +      <---- HAHAHAHAHAHAHAHHA
 */
public class Trima {

    private RandomAccessFile file;

    public Trima() {

    }

    public Trima(RandomAccessFile file) {
        this.file = file;
    }

    // Apertura del fichero
    public void abrir(ver_si_es_util r)
            throws IOException {
        file = new RandomAccessFile("MetaData.dat", "rw");
        //r.numCampos=file.readLong();
    }

    public void escribir(ver_si_es_util registro, Campos c) throws IOException {
        if (file != null) {
            registro.writeCampo(file, c);
        }
    }


    public void readC(ver_si_es_util reg) throws IOException, ParseException {
        reg.readCampos(file);

    }

// Cierre del fichero
    public void cerrar()
            throws IOException {
        if (file != null) {
            file.close();
        }
    }

    public long File_size() throws IOException {

        return file.length();
    }
    public void modificarC(ver_si_es_util c,Campos p) throws IOException{
        c.modificarCampo(file,p.size_dec
                ,p);
    }
/**
 * 

 */
}
