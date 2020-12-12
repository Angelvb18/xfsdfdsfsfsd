package edd2_kennethytrimarchi_proyecto;

import java.awt.JobAttributes;
import java.io.BufferedInputStream;
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
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EDD2_KennethYTrimarchi_Proyecto {

    //static Scanner read = new Scanner(System.in);
    static Metadata metadata;
    static int option;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {

        JOptionPane.showMessageDialog(null,
                ""
                + "\n\n Alpha Patch 1.93/1.94"
                + "\n 1. New Function write Metadata to the created File + Write and Modify registros in File"
                + "\n 2. Implementation of the class Data"
                + "\n 3. Load File is now operational, pending Trima's file operations."
                + "\n\n Alpha Patch 1.95"
                + "\n 1. Emergency Fix on Table's ability to identify the equality of objects."
                + "\n 2. User is now unable to modify primary keys."
                + "\n 3. InsertToTable function has been enabled for the inserts made from Files."
                + "\n 4. PATCH NOTES .TXT was created on Project Folder."
                + "\n 5. Modify Registries is now operational. Pending Deletion."
                + "\n 6. Emergency Fix on New File Operations"
                + "\n\n BETA PATCH 1.96"
                + "\n 1. Export to Excel is now operational."
                + "\n 2. Fixed an issue where user could eliminate all registries and cause a file error."
                + "\n 3. New File can now overwrite a selected file on GUI. For ease of use."
                + "\n 4. Borrar Registro is operational pending Trima update."
                + "\n 5. Professional Save function implemented 900IQ"
                + "\n 6. Included new Select feature on table to allow deletion of registries."
                + "\n 7. Table is now aware of whether you are editing or deleting."
                + "\n 8. Availist is being developed."
                + "\n 9. Fixed a rare issue where Ctrl + O would interfere on handling."
                + "\n 10. Created Patch Notes.txt on Project Folder."
                + "\n 11. UPLOADED EMERGENCY PATCH FIXING MULTIPLE BUGS."
                        + "\n 12. Funcion Buscar Registro esta hecho a la mitad Pending Trima Update.");
        //en Modificar hacer que no se cambie el primary amenos que se haga delete del registro para luego meterlo again
        //Envieo todo de la misma forma que lo recibo como un ARRAYLIST de OBJETOS

        GUI graphics = new GUI();
        graphics.setVisible(true);


        /*
        Registro test = new Registro();
        test.abrir(test);
        int resp = 0;
        //test.moficarC(test);
        do {
            System.out.println("==================================");
            System.out.print("1)Agergar Campo \n"
                    + "2)Listar Campos\n"
                    + "3)Modificar Campos\n"
                    + "4)Eliminar Campo\n"
                    + "5)Buscar Campo\n"
                    + "Que dese hacer?:");
            resp = sc.nextInt();
            switch (resp) {
                case 1:
                    System.out.println("==================================");
                    if (test.numCampos == 0) {
                        System.out.print("Ingrese Llave primaria tipo Int: ");
                        String nombre = sc.next();
                        //tipo int =1;
                        Campos prueba = new Campos(1, test.File_size(), true);
                        prueba.agregarNombre(nombre);
                        test.escribir(test, prueba);
                    } else {
                        System.out.print("Ingrese nombre del campo: ");
                        String nombre = sc.next();
                        System.out.print("1)Int\n"
                                + "2)Long\n"
                                + "3)String\n"
                                + "4)Char\n"
                                + "Que tipo de Dato Desea?: ");
                        int tipo = sc.nextInt();
                        Campos prueba = new Campos(tipo, test.File_size(), false);
                        prueba.agregarNombre(nombre);
                        test.escribir(test, prueba);
                    }

                    break;
                case 2:
                    System.out.println("==================================");
                    test.readC(test);
                    System.out.println("==================================");
                    System.out.println(test.Camps.get(0));

                    break;
                case 3:
                    System.out.println("==================================");
                    System.out.print("1)Nombre\n"
                            + "2)Tipo\n"
                            + "Que deasea Modifcar:"
                    );
                    int cambio = sc.nextInt();
                    switch (cambio) {
                        case 1:
                            String nuevo_nombre = "";
                            do {
                                System.out.print("Ingrese el Nuevo Nombre: ");
                                nuevo_nombre = sc.next();
                            } while (test.Camps.get(0).agregarNombre(nuevo_nombre) == false);
                            System.out.println("-----------" + test.Camps.get(0).cadena);
                            System.out.println("######################"+test.Camps.get(0).getSize_dec());
                            test.modificarC(test, test.Camps.get(0));
                            System.out.println("Registro Exitoso");
                            break;
                    }
                    break;
                case 4:
                    break;
            }
        } while (resp != 4);*/
        //test.escribir(test, prueba);
        //System.out.println(test.File_size() + "------" + prueba.sizeBytes);
    } //Fin del Main

}
