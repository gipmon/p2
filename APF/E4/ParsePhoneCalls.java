/*
 * Rafael Ferreira - APF
 */
import java.io.*;
import java.util.*;

public class ParsePhoneCalls{
	
	//Estrutura de dados
	exameP2.AssociativeArray<DataInput> phoneBook = new exameP2.AssociativeArray<DataInput>();
	exameP2.Queue<Call> calls = new exameP2.Queue<Call>();

	class Call{
		String from;
		String to;
		String duration;
	}

	class DataInput{
		String firstName;
		String lastName;
		String phoneNumber;
	}
	//Estrutura de dados
	
	private void parseNames(File f){
		try{
			Scanner sc = new Scanner(f);

			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(" ");
				
				DataInput novo = new DataInput();
				novo.firstName = data[1];
				novo.lastName = data[2];
				novo.phoneNumber = data[0];

				phoneBook.set(novo.phoneNumber, novo);

			}
			
			sc.close();
		}catch(FileNotFoundException e){
			System.err.println("ERROR in file \""+f.getName()+"\": read failure!");
			System.exit(1);
		}
	}

	private void parseCalls(File f){
		try{
			Scanner sc = new Scanner(f);

			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(" ");

				Call novo = new Call();
				novo.from = data[0];
				novo.to = data[1];
				novo.duration = data[2];

				calls.in(novo);

				//Primeiro número / from call to call
				System.out.println(getName(data[0])+" to "+getName(data[1])+" ("+data[2]+" seconds)");
			}

		}catch(FileNotFoundException e){
			System.err.println("ERROR in file \""+f.getName()+"\": read failure!");
			System.exit(1);
		}
	}

	private String getName(String number){
		if(phoneBook.exists(number)){
			DataInput out = phoneBook.get(number);
			return (out.firstName+" "+out.lastName);
		}else
			return number;
	}

	private void getCalls(String number){
		//Made by
		String out = "";
		for(int i = calls.size(); i>0; i--){
			if(calls.peek().from.equals(number))
				if(phoneBook.exists(calls.peek().to))
					out="\n  - to "+getName(calls.peek().to)+" ("+calls.peek().duration+" seconds)"+out;
				else
					out="\n  - to phone "+calls.peek().to+" ("+calls.peek().duration+" seconds)"+out;
			calls.in(calls.peek());
			calls.out();
		}
		System.out.println("\nCalls made by "+getName(number)+":"+out);
		//Made by
		//Received by
		out = "";
		for(int i = calls.size(); i>0; i--){
			if(calls.peek().to.equals(number))
				if(phoneBook.exists(calls.peek().from))
					out="\n  - from "+getName(calls.peek().from)+" ("+calls.peek().duration+" seconds)"+out;
				else
					out="\n  - from phone "+calls.peek().from+" ("+calls.peek().duration+" seconds)"+out;
			calls.in(calls.peek());
			calls.out();
		}
		System.out.println("Calls received by "+getName(number)+":"+calls.size()+out);
		//Received by

	}
	//vai dar inicio ao Parse e dizer que acção vai tomar
	public void initParse(File f){
		if(analiseFileExtension(f)==0) //se a extenção do ficheiro for .nms vai ler as informações
			parseNames(f);
		else if(analiseFileExtension(f)==1) //vai listar o conteudo trocando o numero de telemovel pelo nome do dono se for conhecido
			parseCalls(f);
		else if(analiseFileExtension(f)==-1)
			getCalls(f.getName());
	}
	//Vai analisar a extensão do ficheiro e indicar por int qual a acção que deve tomar. 
	private static int analiseFileExtension(File f){
		if(f.getName().lastIndexOf(".nms") == (f.getName().length()-4))
			return 0;
		else if(f.getName().indexOf(".cls") == (f.getName().length()-4))
			return 1;
		else 
			return -1;
	}
}