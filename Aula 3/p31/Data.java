/* Programação modular - Aula 3 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
public class Data{

  private int dia, mes, ano;

  public Data(int d, int m, int a){
    this.dia=d;
    this.mes=m;
    this.ano=a;
  }

  public boolean igualA(Data a){
    if(a.dia==dia && a.mes==mes && a.ano==ano)
      return true;
    else 
      return false;
  }
  public boolean menorDoQue(Data a){
    if(a.ano<ano)
      return false;
    else if(a.ano>ano)
      return true;
    else {
      if(a.mes<mes)
        return false;
      else if(a.mes>mes)
        return true;
      else{
        if(a.dia>dia)
          return true;
        else{
          return false;
        } 
      }   
    } 
  } 
  public boolean maiorDoQue(Data a){
    if(a.ano>ano)
      return false;
    else if(a.ano<ano)
      return true;
    else {
      if(a.mes>mes)
        return false;
      else if(a.mes<mes)
        return true;
      else{
        if(a.dia<dia)
          return true;
        else{
          return false;
        } 
      }   
    }   
  }   
  public int dia(){
    return dia;
  }
  public int mes(){
    return mes;
  }
  public int ano(){
    return ano;
  }

}
