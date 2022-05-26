/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author SUSANA
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el fichero a copiar");
        String origen = teclado.nextLine();
        System.out.println("Introduce la ruta destino");
        String destino = teclado.nextLine();
        // Creamos el objeto File
        File f = new File(origen);
//        System.out.println("Nombre " + f.getName());
//        System.out.println("ruta absoluta" + f.getAbsolutePath());
       // Construimos el nuevo nombre
        String newName = f.getName().substring(0, f.getName().lastIndexOf('.'));
        newName = newName + "_copia";
        newName = newName + f.getName().substring(f.getName().lastIndexOf('.'), f.getName().length());
        System.out.println(destino+"/"+newName);
        // Comprobamos que la ruta destino introducida es una carpeta y existe
        File fDestino = new File(destino);
        if (fDestino.exists() && fDestino.isDirectory()) {
            File fCopy = new File(destino+"/"+newName);
            
            // Streams para leer y escribir
            FileInputStream fis = null;
            FileOutputStream fos = null;
            BufferedInputStream bufis = null;
            BufferedOutputStream bufos = null;
            try {
                System.out.println("Haciendo la copia...");

                // Creamos los streams de entrada y de salida
                fis = new FileInputStream(f);
                fos = new FileOutputStream(fCopy);
                bufis = new BufferedInputStream(fis);
                bufos = new BufferedOutputStream(fos);
                // Vamos leyendo de un fichero y escribiendo en el otro, byte a byte
                int temp = bufis.read();
                while (temp != -1) {
                    bufos.write(temp);
                    temp = bufis.read();
                }
                System.out.println("Ficheros copiados");

            } catch (FileNotFoundException ex) {
                System.out.println("Fichero no encontrado");
            } catch (IOException ex) {
                System.out.println("Error de entrada/salida");
            } finally {
                try {
                    bufis.close();
                    bufos.close();
                } catch (IOException ex) {
                    System.out.println("Error cerrando ficheros");
                }
            }
        } else {
            System.out.println("Error----");
        }
    }
}
