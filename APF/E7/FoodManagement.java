/*
 * Rafael Ferreira - APF
 */
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class FoodManagement{

	exameP2.AssociativeArray<Integer> food = new exameP2.AssociativeArray<Integer>();
	exameP2.Queue<Order> orders = new exameP2.Queue<Order>();
	exameP2.Queue<Order> ordersServed = new exameP2.Queue<Order>();

	class Order{
		exameP2.AssociativeArray<Integer> ingredients = new exameP2.AssociativeArray<Integer>();
		
		public String toString(){
			String keys[] = ingredients.keysToArray();
			
			String out = "";

			for(String key : keys)
				out=" "+key+":"+ingredients.get(key)+out;

			return out;
		}
	}

	public void parseFile(String file){
		try{
			File f = new File(file);
			Scanner sc = new Scanner(f);

			while(sc.hasNextLine()){
				String linha = sc.nextLine();
				String line[] = linha.split(" ");

				if(line.length>1 && line[0].equals("entrada:"))
					foodIn(line[1]);
				else if(line.length>1 && line[0].equals("saida:")){
					Order nova = new Order();

					boolean orderFine = true;

					for(int i=1; i<line.length; i++){
						String ing[] = line[i].split(":");
						if(!nova.ingredients.exists(ing[0]))
							nova.ingredients.set(ing[0], Integer.parseInt(ing[1]));
						else{
							System.err.println("Erro no formato da refeição: alimento "+ing[0]+" repetido!");
							System.exit(1);
						}
					}

					if(orderFine)
						orderIn(nova);
				}else
					System.err.println("Linha de ficheiro ignorada: \""+linha+"\"");

				checkoutOrder();
			}
		}catch(FileNotFoundException e){
			System.err.println("Ficheiro desconhecido: java.io.FileNotFoundException: "+file+" (No such file or directory)");
			System.exit(1);
		}
	}

	private void foodIn(String s){
		if(food.exists(s))
			food.set(s, food.get(s)+1);
		else
			food.set(s, 1);
	}

	private void orderIn(Order nova){
		orders.in(nova);
	}

	private void checkoutOrder(){
		for(int i=0; i<orders.size(); i++){
			String ingred[] = orders.peek().ingredients.keysToArray();

			if(!ithasbeenserved(ingred, orders.peek()))
				break;
			
			ordersServed.in(orders.peek());
			served(orders.peek());
			orders.out();
		}
	}
	
	private boolean ithasbeenserved(String[] ingred, Order ord){
		for(String ing : ingred)
			if(!food.exists(ing))
				return false;
			else if(food.get(ing) < ord.ingredients.get(ing))
				return false;
		for(String ing : ingred)
			food.set(ing, food.get(ing)-ord.ingredients.get(ing));
		return true;
	}

	public void stats(){
		stock();
		pendent();
	}

	private void served(Order hasBeenServed){
		System.out.println("Refeicao servida: "+hasBeenServed.toString());
	}
	
	private void pendent(){
		for(int i=0; i<orders.size(); i++){
			System.out.println("Refeicao pendente: "+orders.peek().toString());
			orders.in(orders.peek());
			orders.out();
		}
	}
	
	private void stock(){
		String foodList[] = food.keysToArray();
		System.out.println("Comida em stock:");
		for(String fod : foodList)
			if(food.get(fod)!=0)
				System.out.println("  "+fod+": "+food.get(fod));
	}
}