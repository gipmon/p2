/* Ficheiros - Aula 5 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.io.*;
import java.util.*;

public class p55{
	public static void main(String[] args){
		try{
			if(args.length!=2)
				throw new IllegalArgumentException("Usage: java -ea p55 <source-file> <destination-file>");
			else
				Val(args[0], args[1]);
		}catch(Throwable e){
			System.err.println(e.getMessage());
		}
	}
	private static void Val(String a, String b) throws Throwable{
		File f1 = new File(a);
		File f2 = new File(b);
		String dirPath = f2.getPath().replaceAll(f2.getName(),"");
		
		if(dirPath.length()==0)
			dirPath=".";
		
		File dir = new File(dirPath);

		if(!f1.exists())
			throw new FileNotFoundException("ERROR: input file \""+a+"\" does not exist!");
		if(!f1.canRead())
			throw new IOException("ERROR: cannot read from input file \""+a+"\"!");
		if(f1.isDirectory())
			throw new IOException("ERROR: input file \""+a+"\" is a directory!");
		if(!dir.canWrite())
			throw new IOException("ERROR: cannot write to output directory \""+dirPath+"\"!");
		if(!f2.canWrite() && f2.exists())
			throw new IOException("ERROR: cannot write to output file \""+b+"\"!");
		if(f2.isDirectory())
			throw new IOException("ERROR: output file \""+b+"\" is a directory!");
		
		CopiarFicheiro(f1, f2);
		
	}
	private static void CopiarFicheiro(File fileorigem, File filedestino) throws IOException{
		int i=0;
		String tmp = new String();

		Scanner scanorigem = new Scanner(fileorigem);
		
		while(scanorigem.hasNextLine())
		{
			i++; 
			scanorigem.nextLine(); 
		}
		
		String[] linha = new String[i];
		
		scanorigem.close();
		scanorigem = new Scanner(fileorigem);
		
		for(int a=0; a<i; a++)
			linha[a]=scanorigem.nextLine();
		
		for(int a=0; a<linha.length-1; a++)
			for(int z=a+1; z<linha.length; z++)
					if(linha[z].compareTo(linha[a])<0){
						tmp = linha[a];
						linha[a]=linha[z];
						linha[z]=tmp;
					}
			
		PrintWriter impressao = new PrintWriter(filedestino);
		for(int z=0; z<linha.length; z++)
			impressao.printf("%s\n", linha[z]);
		impressao.close();
	}
}