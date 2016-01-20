/*
 * Rafael Ferreira - APF
Um objecto da classe Train representa um comboio composto de vários vagões
de mercadorias a granel.
Quando se cria um comboio, é necessário especificar a capacidade de cada
vagão e a capacidade total que o comboio suporta, ambas em toneladas.
Pode acrescentar-se um vagão com certa carga à cauda de um comboio
(addWagon) ou pode retirar-se um vagão da cauda (removeWagon), segundo uma
política LIFO (último a entrar é o primeiro a sair).
Naturalmente, a carga de um vagão não pode superar a sua capacidade e só
se pode acrescentar um vagão que não faça ultrapassar a carga total máxima do
comboio.
Também é possível pedir para descarregar (unload) uma dada quantidade, o que
será feito pela descarga completa e retirada de zero ou mais vagões da cauda
e pela descarga parcial de outro vagão para completar a quantidade pedida.
Em qualquer altura é possível obter uma lista da carga nos vagões do
comboio (list); saber o número de vagões (size) ou a carga total
transportada (totalCargo).

Métodos principais:
addWagon     Acrescenta um vagão com uma certa carga ao fim do comboio.
removeWagon  Retira o vagão do fim do comboio e devolve a sua carga.
unload       Descarrega uma certa quantidade, retirando os vagões que ficarem
             vazios.  Devolve o número de vagões retirados.
acceptsCargo Verifica se o comboio pode aceitar uma carga adicional,
             sem ultrapassar o limite de carga total.
list         Devolve um array com as cargas de cada vagão, do primeiro ao último.
             Não altera nada no comboio.
size         Tamanho (número de vagões) do comboio.
totalCargo   Carga total transportada no comboio.
**/

public class Train {
	
	class Wagon{
		double load;
		Wagon next;
	}

	Wagon tail = null;

	double wagonCapacity;
	double trainCapacity;

	double loadInTrain = 0;
	int size = 0;

	public Train(double wagonCapacity, double trainCapacity){
		this.trainCapacity = trainCapacity;
		this.wagonCapacity = wagonCapacity;
	}

	public void addWagon(double load){
		assert load <= wagonCapacity;

		Wagon novo = new Wagon();
		novo.load = load;
		novo.next = tail;

		tail = novo;
		loadInTrain+=load;
		size++;
	}

	public double removeWagon(){
		assert size() > 0;

		double loadTail = tail.load;
		tail = tail.next;
		
		size--;
		return loadTail;
	}

	public int unload(double aDescarregar){
		double descarregado = 0;
		double porDescarregar = aDescarregar;
		int wagonsRemoved = 0;

		while(descarregado<aDescarregar)
			if(tail.load <= porDescarregar){
				descarregado += tail.load;
				porDescarregar -= tail.load;
				tail = tail.next;
				wagonsRemoved++;
			}else{
				descarregado += porDescarregar;
				tail.load -= porDescarregar;
			}
		
		loadInTrain -= aDescarregar; 
		size -= wagonsRemoved;
		
		return wagonsRemoved;
	}

	public boolean acceptsCargo(double load){
		return ((trainCapacity-(loadInTrain+load))>=0);
	}

	public double[] list(){
		double list[] = new double[size];
		
		Wagon t = tail;

		for(int i=size-1; i>=0; i--){
			list[i] = t.load;
			t = t.next;
		}

		return list;
	}
	
	public double totalCargo(){
		return loadInTrain;
	}
	
	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size==0;
	}

}
