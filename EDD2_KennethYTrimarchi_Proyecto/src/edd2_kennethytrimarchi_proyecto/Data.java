/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_kennethytrimarchi_proyecto;


import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author X
 */
public class Data implements Serializable{
    //Available in patch 2.0.2.19
    long ubicacion;
    int key;
    String size_alter;
    ArrayList<Object> datos=new ArrayList<>();

    public Data() {
        size_alter="|";
    }

    
    public long getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(long ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public String getSize_alter() {
        return size_alter;
    }

    public void setSize_alter(String size_alter) {
        this.size_alter = size_alter;
    }

    public ArrayList<Object> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Object> datos) {
        this.datos = datos;
        key=(int)datos.get(0);
    }

    @Override
    public String toString() {
        return "Data{" + "ubicacion=" + ubicacion + ", key=" + key +'}';
    }
    
    
}
