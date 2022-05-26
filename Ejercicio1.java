/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author SUSANA
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la ruta de un fichero");
        String ruta = teclado.nextLine();
        File fichero = new File(ruta);
        if(!fichero.exists())
            System.out.println("El fichero o directorio no existe");
        else {
            System.out.println("El fichero o directorio existe");
            if(fichero.isDirectory()){
                System.out.println("Es un directorio");
                String[] listado = fichero.list();
                if (listado == null || listado.length == 0) {
                    System.out.println("No hay elementos dentro de la carpeta actual");

                }
                else {
                    System.out.println("La lista de elementos del directorio es: ");
                    for (int i=0; i< listado.length; i++) {
                        System.out.println(listado[i]);
			System.out.println("estoy haciendo cambios en el ejercicio1");
                   }
                }
            }
            if(fichero.isFile()){
                System.out.println("Es un fichero");
                String name = fichero.getName();
                System.out.println(name);
                long tamano = fichero.length();
                System.out.println(tamano);
               if(fichero.canRead())
                    System.out.println("Permisos de lectura");
               if(fichero.canWrite())
                    System.out.println("Permisos de escritura");
            }
        }
        
    }
    
}
