/* Ficheiros - Aula 5 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.io.*;
import java.util.*;

public class p52{
  public static void main(String[] args){
    try{
      Valida(args); //validacoes iniciais
      setToCopy(args[0], args[1]);
    }catch(Throwable e){
      System.err.println(e.getMessage());
    }
  }
  private static void Valida(String[] args) throws Throwable{ 

    if(args.length!=2)
      throw new IllegalArgumentException("Usage: java -ea p52 <source-file> <destination-file>");

    File f = new File(args[1]);
      if(f.isDirectory())
        throw new IOException("ERROR: output file \""+args[1]+"\" is a directory!");

    f = new File(args[0]);
      if(!f.exists())
        throw new FileNotFoundException("ERROR: input file \""+args[0]+"\" does not exist!");
  }
  private static void setToCopy(String a, String b) throws Throwable{

    File origem = new File(a);
    File destino = new File(b);


    if(!origem.canRead())
      throw new IOException("ERROR: cannot read from input file \""+a+"\"!");
    if(!destino.canWrite() && destino.exists())
      throw new IOException("ERROR: cannot write to output file \""+b+"\"!");

    if(destino.exists()){
      System.out.print("WARNING: output file \""+b+"\" already exists!\nCopy over existing file (y/n)? ");
      Scanner sc = new Scanner(System.in);

      char opt = sc.nextLine().charAt(0);

      if(opt!='y')
        System.exit(2);
    }
    Copy(origem, destino);

  }
  private static void Copy(File a, File b) throws Throwable{
      Scanner sc = new Scanner(a);
      PrintWriter go = new PrintWriter(b);

      while(sc.hasNextLine())
        go.println(sc.nextLine()); 
      go.close();
      sc.close();           

  }
  
}
