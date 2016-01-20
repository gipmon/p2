/* Ficheiros - Aula 5 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.io.*;
import java.util.*;

public class p54{
  public static void main(String[] args){
    try{
      if(args.length!=2)
        throw new IllegalArgumentException("Usage: java -ea p54 <source-file> <column-number>");
      else
        Val(args[0], Integer.parseInt(args[1]));
    }catch(Throwable e){
      System.err.println(e.getMessage());
    }
  }
  private static void Val(String a, int b) throws Throwable{
    File f1 = new File(a);

    if(!f1.exists())
      throw new FileNotFoundException("ERROR: input file \""+a+"\" does not exist!");
    if(!f1.canRead())
      throw new IOException("ERROR: cannot read from input file \""+a+"\"!");
    if(f1.isDirectory())
      throw new IOException("ERROR: input file \""+a+"\" is a directory!");
    
    Colunas(f1, b);
    
  }
  private static void Colunas(File fileorigem, int b) throws IOException{
    int i=0;
    String[] linhas;

    Scanner scanorigem = new Scanner(fileorigem);

    while(scanorigem.hasNextLine()){
        i++;
        scanorigem.nextLine();
	}
    scanorigem.close();

    linhas = new String[i];
   
    i=0;

    scanorigem = new Scanner(fileorigem);

    while(scanorigem.hasNextLine())
      linhas[i++]=scanorigem.nextLine();

    scanorigem.close();

    for(String s : linhas)
      	System.out.println(getWord(s, b));
  }
  private static String getWord(String a, int coluna){
    int palavras = 1;
    String palavra = new String();

    for(int w = 0; w < a.length(); w++)
      	if(Character.isLetterOrDigit(a.charAt(w)))
        	for(int z=w; z<a.length(); z++) 
          		if(!Character.isLetterOrDigit(a.charAt(z)) || z==a.length()-1){
            		w=z;
            		
            		if(Character.isLetterOrDigit(a.charAt(z)) && coluna==palavras)
            			palavra+=a.charAt(z);

            		palavras++;
            		break;
          		}else if(coluna==palavras)
          			palavra+=a.charAt(z);
    
    if(palavra==null)
      	palavra="\n";

    return palavra;
  }
}
