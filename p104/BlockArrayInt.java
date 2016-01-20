/* Aula 10 - Lista Ligada - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
public class BlockArrayInt{
	
	class Node{
		int[] array;
		Node next;	
	}

	Node bottom = null;
	int size = 0;
	int numOfBlocks = 0;

	public BlockArrayInt(int blockSize, int numOfBlocks){

		for(int i=0; i<numOfBlocks; i++){
			Node novoBloco = new Node();
			novoBloco.array = new int[blockSize];
			
			if(bottom==null)
				bottom=novoBloco;
			else
				bottom.next=novoBloco;
			
			novoBloco = bottom;

			size += blockSize;
			this.numOfBlocks++;
		}

	}
	public void put(int element, int index){
		int bloco = (int)(index/(bottom.array.length));

		Node t = bottom;

		for(int i=1; i<=bloco && t!=null ; i++){
			t = t.next;
		}

		if(t!=null)
			t.array[index%bottom.array.length] = element;
		//else mensagem
	}
	public int get(int index){
		int bloco = (int)(index/(bottom.array.length));

		Node t = bottom;

		for(int i=1; i<=bloco && t!=null ; i++){
			t = t.next;
		}

		if(t!=null)
			return t.array[index%bottom.array.length];
		else
			return 0;
	}
	public void incrementNumberOfBlocks(){
		Node novoBloco = new Node();
		novoBloco.array = new int[bottom.array.length];
		
		if(bottom==null)
			bottom=novoBloco;
		else
			bottom.next=novoBloco;
			
		novoBloco = bottom;

		size += bottom.array.length;
		this.numOfBlocks++;
	}
	public int size(){
		return size;
	}
	public int numberOfBlocks(){
		return numOfBlocks;
	}
	public int blockSize(){
		return bottom.array.length;
	}
}