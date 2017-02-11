
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sfcar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String line;
        
        try {//Meto en un try por si salta una IOException
            Process hijo = new ProcessBuilder("java","-jar","C:\\Users\\sfcar\\Documents\\NetBeansProjects\\DAM_M09_ACT_01\\Convertidor.jar").start();//Lanzo el hijo
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));//Buffer donde guardo la salida del hijo
            PrintStream entradaHijo = new PrintStream(hijo.getOutputStream());//PritStream que manda al hijo la info a procesar.
            BufferedReader salidaHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));//Buffer que alberga lo que escribimos en el teclado
            
            line = teclado.readLine();//Inicializamos line con lo que viene del teclado
            while (!line.equals("FIN") && line != null) {//Mientras la linea sea disntita de FIN y no null
                entradaHijo.println(line);//Manda el contenido de line al hijo
                entradaHijo.flush();//Vacía el buffer de salida escribiendo su contenido
                if ((line = salidaHijo.readLine()) != null){//Ahora line alberga lo que devuelve el hijo y, si este es distinto de nul...
                    System.out.println(line);//Imprimelo por pantalla
                }
                line = teclado.readLine(); //Line vuelve a tener el valor del teclado
            }
        } catch (IOException ioE) {
            System.out.println("Error: "+ioE.getMessage());
        }
        
  
    }
    
}
