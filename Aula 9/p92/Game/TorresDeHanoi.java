/* Pilhas e Filas - Aula 9 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
package Game;

public class TorresDeHanoi{

	Stack torre[] = new Stack[3];
	int moves = 0;

	public TorresDeHanoi(int n){
		//Inicializar cada torre com representação interna Stack
		for(int i=0; i<torre.length; i++)
			torre[i] = new Stack(n);
		
		//Fazer push até ao elemento n na primeira torre
		for(; n>=1 ; n--)
			torre[0].push(n);

		System.out.println();
		printAll();
		moverDiscos(torre[0].size(), torre[0], torre[1], torre[2]);
		System.out.println("Number of moves: "+moves);
	}
	private void moverDiscos(int n, Stack origem, Stack destino, Stack auxiliar) {
		assert n >= 0;
		
		if (n > 0) {
			moverDiscos(n-1, origem, auxiliar, destino);
				destino.push(origem.top());
				origem.pop();
					printAll();
				moves++;
			moverDiscos(n-1, auxiliar, destino, origem);
		} 
	}
	private void printAll(){
		printTorres(0, "TA");
		printTorres(1, "TB");
		printTorres(2, "TC");
		System.out.print("   |\n");

		System.out.println();
	}
	private void printTorres(int t, String name){ //t = torre
		System.out.println("   |");
		System.out.print(name+" |");
			if(torre[t].size()!=0)
				System.out.print(torre[t].toString());
		System.out.println("");
	}

}