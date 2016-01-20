/*
 * Rafael Ferreira - APF
 * Uma estrutura de dados de tipo pilha, mas com os métodos alternativos:
 * - popN(n): retira os n elementos de topo da pilha
 * - topMatches(seqChars): verifica se os últimos caracteres na pilha
 *                         coincidem com seqChars
 * - toString(): devolve uma String com todos os caracteres contidos
 *               na pilha (desde o mais antigo até ao mais recente)
 */
public class StackX
{
	class Node{
		char e;
		Node next;
	}

	Node top = null;
	int size = 0;

	public void push(char e){
		Node novo = new Node();
		novo.e = e;
		novo.next = top;
		
		top = novo;

		size++;
		assert !isEmpty();
	}

	public void popN(int n){
		for(int i=1; i<=n && top!=null; i++)
			top = top.next;
		size-=n;
	}

	public boolean topMatches(String pattern){
		Node t = top;
		String out = "";

		/* Queremos uma string do tamanho da pattern ou do tamanho máximo possível pela stack */
		for(int i=0; i<size() && i<pattern.length(); i++){
			out=t.e+out;
			t = t.next;
		}
		
		return pattern.equalsIgnoreCase(out);
	}

	private boolean isEmpty(){
		return size==0;
	}
	
	public char top(){
		assert !isEmpty();
		return top.e;
	}
	
	public String toString(){
		Node t = top;

		String out = "";

		while(t!=null){
			out=Character.toString(t.e)+out;
			t = t.next;
		}

		return out;
	}

	public int size(){
		return size;
	}
}