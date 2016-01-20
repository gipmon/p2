/* Ficheiros - Aula 5 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.io.*;
import java.util.*;

public class p51{
    public static void main(String[] args){
        try{
            for(String filename : args)
                System.out.println(ficheiro(filename));
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }
    private static String ficheiro(String filename) throws IllegalArgumentException{
        try{
            String out = new String();

            out+=filename+":";
            out+="\n-----------------";

            File file = new File(filename);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){
                out+="\n"+sc.nextLine();
            }

            sc.close(); 
            out+="\n-----------------";
            return out; 
        }catch(FileNotFoundException e){
            throw new IllegalArgumentException("ERROR: input file \""+filename+"\" does not exist!");
        }
    }
    
}