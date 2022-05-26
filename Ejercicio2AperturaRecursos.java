/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author SUSANA
 */
public class Ejercicio2AperturaRecursos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el fichero a copiar");
        String origen = teclado.nextLine();
        System.out.println("Introduce la ruta destino");
        String destino = teclado.nextLine();
        // Creamos el objeto File
        File f = new File(origen);
        System.out.println("ruta "+f.getAbsolutePath());
         // Construimos el nuevo nombre
        String newName = origen.substring(0, origen.lastIndexOf('.'));
        newName = newName + "_copia";
        newName = newName + origen.substring(origen.lastIndexOf('.'), origen.length());

        // Vemos si existe un fichero con ese nombre y sino lo creamos
        File fCopy = new File(newName);
        try (
                BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream(fCopy));
                BufferedInputStream bufis = new BufferedInputStream(new FileInputStream(f));
                ){
            System.out.println("Haciendo la copia...");

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
        } 
        
    }
}
