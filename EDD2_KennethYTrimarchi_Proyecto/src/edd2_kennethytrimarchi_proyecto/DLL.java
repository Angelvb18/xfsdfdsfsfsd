/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd2_kennethytrimarchi_proyecto;

/**
 *
 * @author X
 */
public class DLL {
    // Class for Doubly Linked List 

    Node head; // Cabeza de la Lista

    /* D-Linked List Nodess*/
    class Node {

        Data reg;
        int data;
        long posicion;
        Node prev;//valor previo ==null si es root o inicio
        Node next;//siguiente apuntador == null si es el ultimo

        // Constructor to create a new node 
        // next and prev is by default initialized as null 
        Node(int d,long pos) {
            data = d;
            posicion=pos;
        }
    }

    public void BestFit(int new_data,long pos) {//Caso que ingresa al incio
        Node new_node = new Node(new_data,pos);
        Node last = head;
        new_node.next = null;
        boolean insertado = false;
        if (head == null) {

            new_node.prev = null;
            head = new_node;

        } else {
            if (new_data < last.data) {
                //si es menor

                new_node.prev = last.prev;
                new_node.next = last;
                last.prev = new_node;
                head = new_node;
                insertado = true;
            } else {
                //last=last.next;
                while (last.next != null) {

                    if (new_data < last.next.data) {
                        new_node.prev = last;
                        new_node.next = last.next;
                        last.next.prev = new_node;
                        last.next = new_node;

                        insertado = true;
                        break;
                    } else {
                        last = last.next;
                    }
                }
                if (!insertado) {

                    last.next = new_node;
                    new_node.prev = last;
                    //new_node.next=null;
                }
            }

        }
    }

    public Node SearchSpace(int needed) {
        Node last = head;
        boolean found = false;
        //dato maybe
        while (last.next != null) {
            if (needed > last.data) {
                last = last.next;
            } else {
                //dev=last.data;
                /**
                 * break;
                 *
                 */
                found = true;
                break;
            }
        }
        if (found == false) {
            if (needed > last.data) {
                // dev=100;
                return null;
            } else {
                //return last.data;
                return last;
            }
        } else {
            return last;
        }

    }

    /* Given a node as prev_node, insert a new node after the given node */
    void InsertEnd(int new_data,long pos) {//este metodo lo agrega al final

        Node new_node = new Node(new_data,pos);
        Node last = head;
        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        while (last.next != null) {//busca el final de la lista para insertar
            last = last.next;
        }
        // al ultimo nodo le agrega un siguiente
        last.next = new_node;

        //ahora al nuevo nodo le setiamos el anterior
        new_node.prev = last;
    }

    public void ImprimeListaEnlazada(Node node) {
        Node last = null;
        System.out.println("Direccion Normal:");
        while (node != null) {
            System.out.print("Size: "+node.data +"Pos: "+node.posicion +" ||");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Direccion Opuesta:");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    void deleteNode(Node head_ref, Node delete) {
        // Caso Base
        if (head == null || delete == null) {
            return;
        }
        // If node to be deleted is head node 
        if (head == delete) {
            head = delete.next;
        }
        if (delete.next != null) { //entra si no es el ultimo nodo
            delete.next.prev = delete.prev;
        }
        if (delete.prev != null) { //no lo hace si es el primer nodo
            delete.prev.next = delete.next;
        }
        return;
    }

}
