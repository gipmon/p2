/**
 * Rafael Ferreira - APF
 * Uma estrutura de dados baseada numa fila, mas em que só ficam
 * armazenados os últimos N números inseridos. Quando a fila está
 * preenchida (N elementos) a inserção de um novo número implica
 * a saída do primeiro (que deixa de existir).
 */
import java.lang.System.*;

public class LeakyQueue{
	private double array[];
	private int size;
	private double minimum;

	public LeakyQueue(int N){
		array = new double[N];
		size=0;
	}
	public double minimum(){
		return minimum;
	}
	public void in(double valor){
		if(isFull())
			out();
		array[size++] = valor;
		setMinimum();
		assert !isEmpty();
	}
	private void setMinimum(){
		assert !isEmpty();
		minimum = array[0];
		for(int i=0; i<size; i++)
			if(array[i]<minimum)
				minimum=array[i];
	}
	public void print(){
		if(size==0)
			return;
		for(int i=0; i<size-1; i++)
			System.out.printf("%5s",Double.toString(array[i]));
		System.out.printf("%5s",Double.toString(array[size-1]));
	}

	public void out(){
		assert !isEmpty();
		size--;
		for(int i=0; i<size; i++)
			array[i]=array[i+1];
		setMinimum();
		assert !isFull();
	}
	public boolean isEmpty(){
		return size==0;
	}
	public boolean isFull(){
		return size==array.length;
	}
	public int size(){
		return size;
	}
}

