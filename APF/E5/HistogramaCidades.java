/*
 * Rafael Ferreira - APF
 */
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class HistogramaCidades{
	AssociativeArray<Pessoa> cityTraveler = new AssociativeArray<Pessoa>(); 

	class Pessoa{
		String cidade;
		Pessoa next;
	}

	public void cityIn(String cityName){
		File cityFile = new File(cityName);

		try{
			Scanner sc = new Scanner(cityFile);
			while(sc.hasNextLine()){
				String pessoa = sc.nextLine();
				String cidade = cityFile.getName();

				Pessoa nova = new Pessoa();
				
				if(cityTraveler.exists(pessoa)){
					Pessoa old = cityTraveler.get(pessoa);
					
					nova.cidade = cidade;
					nova.next = old;
					old = nova;

				}else
					nova.cidade = cidade;
				
				cityTraveler.set(pessoa, nova);

			}
		}catch(FileNotFoundException e){
			System.err.println("ERROR in file \""+cityFile.getName()+"\": read failure!");
			System.exit(1);
		}
	}

	public void printHistogram(){
		String keys[] = cityTraveler.keysToArray();

		for(String key : keys){
			Pessoa funcionario = cityTraveler.get(key);
			System.out.printf("%-15s:",key);

			String cidades = "";
			while(funcionario!=null){
				cidades = " "+funcionario.cidade+cidades;
				funcionario = funcionario.next;
			}

			System.out.println(cidades);
		}
	}
}