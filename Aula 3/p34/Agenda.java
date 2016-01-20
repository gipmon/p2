/* Programação modular - Aula 3 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
public class Agenda{
  private Nota a[];
  private int n=0;
  
  public void novaNota(Nota a){
    this.a=retorno(a);
  }
  private Nota[] retorno(Nota a){
    Nota b[] = new Nota[n+1]; //sendo b uma nova nota 
    
    for(int i=0; i<n; i++)
      b[i] = this.a[i].getNota();

    b[n++]=a;
   
    for(int z=0; z<b.length-1; z++)
      for(int i=z+1; i<b.length; i++)
        if(b[z].inicio.maiorDoQue(b[i].inicio)){
          Nota tmp = b[z].getNota();
          b[z]=b[i].getNota();
          b[i]=tmp.getNota();
        }

    return b;
  }
  public void escreve(){
    System.out.println("Agenda:");
    for(int i=0; i<n; i++)
      this.a[i].escreve();
  }
  public Nota[] compromissos(Data a, Data b){
    int n=0;//Variavel para saber quantos compromissos existem  
    
    for(int i=0; i<this.a.length; i++)
      if((this.a[i].inicio.maiorDoQue(a) || this.a[i].inicio.igualA(a)) && (this.a[i].inicio.menorDoQue(b) || this.a[i].inicio.igualA(b))){
        n++;
      }else if((this.a[i].fim.maiorDoQue(a) || this.a[i].fim.igualA(a)) && (this.a[i].fim.menorDoQue(b) || this.a[i].fim.igualA(b))){
        n++;
      }
    Nota c[] = new Nota[n];
    n=0;
    for(int i=0; i<this.n; i++)
      if((this.a[i].inicio.maiorDoQue(a) || this.a[i].inicio.igualA(a)) &&     (this.a[i].inicio.menorDoQue(b) || this.a[i].inicio.igualA(b)))
        c[n++]=this.a[i].getNota();
      else if((this.a[i].fim.maiorDoQue(a) || this.a[i].fim.igualA(a)) &&     (this.a[i].fim.menorDoQue(b) || this.a[i].fim.igualA(b)))
        c[n++]=this.a[i].getNota();

    return c;
  }

}
