/*
 * Rafael Ferreira - APF
 */
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class Justify{

	exameP2.Queue<String> text = new exameP2.Queue<String>();

	int num_columns;

	public Justify(int num_columns){
		this.num_columns = num_columns;
	}

	public void in(String file){
		try{
			File f = new File(file);
			Scanner sc = new Scanner(f);

			while(sc.hasNextLine()){
				String elem[] = sc.nextLine().split(" ");

				if(elem.length==1 && elem[0].equals(""))
         	 		text.in("@,n");
         	 	else{
					String[] words = elem;
					
					for(String word : words){
						word = word.trim();
						if(word.length()>0)
							text.in(word);
					}
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("ERROR in file \""+file+"\": read failure!");
		}
	}

	public void out(){
		String words[] = new String[text.size()];

		//vamos obter todas as palavras
		for(int i=0; i<words.length; i++){
			words[i] = text.peek();
			words[i] = words[i].trim();
			text.out();
		}

		int num_words = 0;

		for(int i=0; i<words.length-1; i++){
			if(words[i].equals("@,n")){
				words[i]="\n\n";
				num_words=0;
				continue;
			}
			words[i]+=" ";
			num_words+=words[i].length();

			if(words[i+1].length()+1>(num_columns-num_words)){
				//se a proxima palavra a inserir já não tiver espaço na linha vamos ter de colocar espaços
				do
					for(int j=i; j>=0; j--){ 
						if(words[j].indexOf("\n")>-1)
							break;
						//este for vai colocar espaços em todas as entradas da array, com a condição de paragem
						//se existir um paragrafo ou for atingido o numero de colunas desjado
						
						words[j]+=" ";
						num_words+=1;
						
						if(num_columns<num_words)
							break;
					}
				while(num_columns>num_words);
			}
			
			if(num_columns==num_words){
				//se atingimos o número preciso mas temos a necessidade de colocar espaço antes da ultima palavra
				int word_with_whitespaces = words[i].length();
				words[i]=words[i].trim();
				for(int j=(word_with_whitespaces-(words[i].length())); j>1; j--)
					words[i]=" "+words[i];
				//neste for vamos colocar todos os espaços à esquerda da palavra
				words[i]+="\n";
				num_words=0;
			}else if(num_columns+1==num_words){
				//se atingimos o número preciso sem necessidade de colocar um espaço antes da ultima palavra
				words[i]=words[i].trim();
				words[i]=" "+words[i]+"\n";
				num_words=0;
			}
		}

		for(String word : words)
			System.out.print(word);
		System.out.println();
	}
}