/* Programação modular - Aula 3 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
public class Caixa{
  private long[] moedas;
  private int n=0;

  public void adicionaMoeda(long moeda){ //adicionar moedas
    moedas = retorno(moeda);
  } 
  private long[] retorno(long a){
    long b[] = new long[this.n+1];
    
    for(int i=0; i<this.n; i++)
      b[i] = this.moedas[i];

    b[this.n++]=a;
    return b;
  }
  public long[] retiraDinheiro(long valorMin){
    long totalRetirado=0;
    int l = 0;
    long sum=0;

    for(int i=0; i<this.n; i++)
      sum+=moedas[i];
    
    if(sum<valorMin){
      System.out.println("ERRO: não há dinheiro suficiente!");
      long[] a = {-1};
      return a;
    }
    for(int i=0; i<this.n; i++)
      if(totalRetirado<valorMin){
        totalRetirado+=moedas[i];
        l++;
      }
    
    this.n-=l; //numero de moedas restantes

    long b[] = new long[this.n]; // array com as moedas restantes
    long retirado[] = new long[l]; // array com as moedas retiradas
    totalRetirado=0; // valor retirado
    
    int z=0, y=0;

    for(int i=0; i<this.n+l; i++)
      if(totalRetirado<valorMin){
        totalRetirado+=moedas[i];
        retirado[z++]=moedas[i];
      }else
        b[y++]=moedas[i];
    
    moedas=b;
    
    return retirado;
  }
  public long total(){
    long carteira=0;

    for(int i=0; i<n; i++)
      carteira+=this.moedas[i];
    
    return carteira;
  }
  public long[] moedas(){
    return this.moedas;
  }
}
