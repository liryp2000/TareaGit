/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Ejercicio5 {
 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero ");
        String ruta = teclado.nextLine();
        File f = new File(ruta);
        
        System.out.println("Introduce el texto ");
        String texto = teclado.nextLine();
        
        escribirFichero(ruta, texto);
 
        mostrarFicheroMay(ruta);
 
    }   
 
    public static void escribirFichero(String nomFich, String texto){
        File f = new File(nomFich);
        FileWriter fw = null;
        if (!f.exists()) {
            try {
                f.createNewFile(); //lanza IOException
            } catch (IOException ioex) {
                System.out.println("Error creando el fichero.");
            }
        }
        try{
            fw = new FileWriter(f, true);
            //Escribimos el texto en el fichero
            System.out.println("Escribiendo ....");
            fw.write(texto);
        }catch(IOException e){
            System.out.println("Problemas en la escritura E/S "+e);
        }finally{
            try{
               if(fw!=null) fw.close();
            }catch(IOException ee){
                System.out.println("Error cerrando el fichero");
                
            }
        }
    }
 
    public static void mostrarFicheroMay(String nomFich){
        FileReader fr = null;
        try{
            fr = new FileReader (nomFich);
            int valor=fr.read();
            while(valor!=-1){
                //Solo cambiara el caracter si es una minuscula o una mayuscula
                char caracter = (char)valor;
                if(Character.isLowerCase(caracter)){
                    caracter = Character.toUpperCase(caracter);
                }else{
                    caracter = Character.toLowerCase(caracter);
                }
                System.out.print(caracter);
                valor=fr.read();
            }
 
        }catch(IOException e){//Tratamiento general -> hemos visto otros ejemplos con un tratamiento más detallado
            System.out.println("Problema con la E/S "+e);
        }
        finally{
            try{
               if(fr!=null) fr.close();
            }catch(IOException ee){
                System.out.println("Error cerrando el fichero");
                
            }
        }
    }
 
}