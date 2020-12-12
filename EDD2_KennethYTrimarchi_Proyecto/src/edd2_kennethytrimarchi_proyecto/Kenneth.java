package edd2_kennethytrimarchi_proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
//import javafx.scene.control.Cell;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;




import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Kenneth {

    static Scanner read = new Scanner(System.in);

    public Kenneth() {

    }

    /*RandomAccessFile raf = new RandomAccessFile(new File("Raf.txt"), "rw");
       raf.writeBytes("PENE0");
       raf.seek(0);
        //System.out.println(raf.getFilePointer());
        for (int i = 0; i < raf.length(); i++) {
            
            System.out.println( (char)raf.readByte() );
        }
        raf.close();*/
    //Metadata meta = new Metadata("Kenneth");
    //Write(meta);
    public static void Delete(int position) throws IOException {

        File file = null;
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            file = new File("Registro.txt");
            fr = new FileReader(file);
            fw = new FileWriter(file, true);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            //Si le das reset al buffered reader asi vuelve al inicio :)
            boolean continuar = true;
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            //////////////////////////////////
            char actual; //Character que estoy extrayendo
            char invalido = (char) -1; //Character basura que da el br.read para que no se use.
            int contador = 0; //contador para las posiciones.
            int contadorchar = 0; //Contador para las /
            int DisqueByte = -1; //Para reset el lector;
            int BytePosition = -1;
            int DeleterStart = 0;
            int ByteLength = 0;
            while ((actual = (char) br.read()) != invalido) {
                DisqueByte++; //Posicion que usare para marcar el inicio del borrado
                BytePosition++; //Posicion que estoy leyendo en el texto lo usare para marcar el final del borrado.
                if (actual == '/' && contadorchar == 0) {
                    br.mark(DisqueByte);
                    contadorchar++;
                } else if (actual == '/' && contadorchar == 1) {
                    contador++;
                    if (contador == position) {
                        System.out.println("Position has been reached, commencing the elimination process.");
                        br.reset();
                        String insertion = "";
                        ByteLength = (BytePosition - 1) - DeleterStart;
                        insertion += Integer.toString(ByteLength);
                        for (int i = insertion.length(); i < ByteLength; i++) {
                            insertion += "*";

                        }
                        raf.writeBytes(insertion);
                        //bw.write(insertion, DeleterStart,ByteLength);

                        break;
                    } else {
                        DeleterStart = DisqueByte;
                        br.mark(DisqueByte);

                    } //end if interno

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Loading TXT File");

        }
        br.close();
        bw.close();
        fr.close();
        fw.close();

    }

    public static void ByteDelete() {
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            file = new File("Metadata.project");
            fis = new FileInputStream(file);
            // bis = new BufferedInputStream(bis);
            ois = new ObjectInputStream(fis);

        } catch (Exception e) {

        }

    }

    public static void Write(Metadata meta) {
        File file = null;
        FileOutputStream fis = null;
        ObjectOutputStream ous = null;

        try {
            file = new File("Metadata.project");
            fis = new FileOutputStream(file);
            ous = new ObjectOutputStream(fis);

            ous.writeObject(meta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ous.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RAF() {

    }

    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    public void CreateCampos(Metadata metadata) throws IOException, ParseException {
        if (metadata.getNumregistros() == 0) {
            //System.out.println("Para dejar de insertar utilize el 0");
            JOptionPane.showMessageDialog(null, "Para dejar de insertar Ingrese 0\nEl primer campo es PRIMARY KEY");
            String input = "";

            //ArrayList<Campos> Campo=new ArrayList<>();
            ArrayList<String> campos = new ArrayList<String>();
            ArrayList<Integer> types = new ArrayList<Integer>();
            // preparing containers for the information
            int contador = 0;

            while (input.equals("0") != true) { //Mientras con centinela para que el usuario eliga cuando detenerse TEMP To deprecate.
                //   System.out.println("Ingrese el nombre del campo: ");
                boolean exito = false;
                while (exito == false) {
                    try {
                        input = JOptionPane.showInputDialog(null, "Ingrese el nombre del Campo " + (contador + 1));
                        if (input.equals("0") != true) {
                            //#Crash
                        }
                        exito = true;
                    } catch (Exception e) {
                        System.out.println("Error Prevented.");
                    }

                }

                if (input.equals("0") != true && contador == 0) {

                    campos.add(input);  //Guardo en el arraylist todos los campos
                    types.add(1);
                    contador++;
                } else if (input.equals("0") != true) {
                    try {
                        int type = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tipo: \n1.Int\n2.Long\n3.String\n4.Char"));
                        types.add(type);
                        campos.add(input);
                        contador++;

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Incorrect Value!");
                        // e.printStackTrace();
                    }
                }

            } //End while de insertar campos por usuario.

            metadata.setCampos(campos); //Lo guardo en la metadata para la Jtable.
            metadata.setTipos(types);
            metadata.setNombre(campos.toString());

            //metadata.setCamposArchivo(contador);//Para no afectar la estrutura hice un metodo para llenar mi Arraylist de Campos
            // System.out.println("Successfull!, check table");
            JOptionPane.showMessageDialog(null, "Success! Check Table.");
        } else {
            //  System.out.println("Ya no se puede ingresar campos. Se ingresaron registros.");
            JOptionPane.showMessageDialog(null, "Registro Ingresado, imposible realizar accion.");
        }

    } //End CreateCampos.

    public void ListCampos(Metadata metadata) {
        //System.out.println(metadata.getCampos().toString());
        JOptionPane.showMessageDialog(null, metadata.getCampos().toString() + "\n" + metadata.getTipos().toString());
    } //Fin de listar campos.

    public void ModificarCampos(Metadata metadata) {
        //System.out.println("Ingrese el numero de cammpo que va a modificar: Ingresar apartir de 1.");
        //JOptionPane.showMessageDialog(null, "Ingrese el campo a modificar a partir de 1.");
        if (metadata.getNumregistros() == 0) {
            try {

                int campo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el campo a modificar a partir de 1")); //Leo el campo a borrar
                //System.out.println("Ingrese el nuevo valor del campo:");
                //read.nextLine(); //Leo el nuevo nombre del campo
                String input = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre: ");
                int type = -1;
                if (campo == 1) {

                } else {
                    type = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo: \n1.Int\n2.Long\n3.String\n4.Char"));
                }

                campo--;
                ArrayList campos = metadata.getCampos();
                ArrayList tipos = metadata.getTipos();
                if (campo >= 0 && campo < campos.size() && campo == 0) {

                    campos.set(campo, input);
                    // tipos.set(campo, type);
                    metadata.setCampos(campos);
                    //System.out.println("Successfull! Check Table");
                    JOptionPane.showMessageDialog(null, "Success! Check Table");
                } else if (campo >= 0 && campo < campos.size()) {
                    campos.set(campo, input);
                    tipos.set(campo, type);
                } else {
                    //System.out.println("Invalid Size. Action could not be performed.");
                    JOptionPane.showMessageDialog(null, "Invalid Size");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Incorret Value Inserted.");
                //e.printStackTrace();
                System.out.println("Crash Prevented Funcion Modificar Campo.");
            }
        }

    }

    public void DeleteCampos(Metadata metadata) {
        if (metadata.getNumregistros() == 0) {
            //System.out.println("Ingrese el numero del campo a borrar. Contar desde 1.");
            System.out.println("X2");
            int campo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del campo a borrar A PARTIR DE 1"));
            System.out.println("As requested.");
            System.out.println("Modification requested Campo #:" + campo);
            campo--;
            System.out.println("PENE");
            ArrayList campos = metadata.getCampos();
            ArrayList tipos = metadata.getTipos();
            if (campo >= 0 && campo < campos.size()) {
                campos.remove(campo);
                tipos.remove(campo);
                metadata.setCampos(campos);
                metadata.setTipos(tipos);
                //System.out.println("Successfull! Check table!");
                JOptionPane.showMessageDialog(null, "Success Check table");
            } else {
                JOptionPane.showMessageDialog(null, "Action could not be performed!");
            }

        }

    }

    public void ExportToExcel(Metadata metadata, String name, JTable table) {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Estructura de Datos");
        int registros = table.getModel().getRowCount();
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", metadata.getCampos().toArray());
        for (int i = 0; i < registros; i++) {
            ArrayList Registro = new ArrayList();
            for (int j = 0; j < metadata.getCampos().size(); j++) {
                Registro.add(table.getValueAt(i, j));
            }
            data.put(Integer.toString(i + 2), Registro.toArray());
        }
        //data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        //data.put("2", new Object[] {1, "Amit", "Shukla"});
        //data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        //data.put("4", new Object[] {3, "John", "Adwards"});
        //data.put("5", new Object[] {4, "Brian", "Schultz"});

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } // cell.setIte((String)obj);
                else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }

            }
        }
        try {
            //Write the workbook in file system
            File filer = new File(name += ".xlsx");
            filer.delete();
            filer.createNewFile();
            FileOutputStream out = new FileOutputStream(filer);
            workbook.write(out);
            out.close();
            System.out.println(name + " written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
