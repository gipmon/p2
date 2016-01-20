/* Programação por contratos - Aula 4 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
public class Data {
  private int dia;
  private int mes;
  private int ano;

  public Data(int dia, int mes, int ano){
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;

  }
  private static boolean bisSexto(int a){ //a=ano
    if(a%400==0 || (a%4==0 && a%100!=0))
      return true;
    else return false;  
  }
  private static int nDias(int a, int b){
    switch(b){
      case 1: return 31;
      case 2:
              if(bisSexto(a))
                return 29;
              else
                return 28;
      case 3: return 31; 
      case 4: return 30;
      case 5: return 31;
      case 6: return 30;
      case 7: return 31;
      case 8: return 31;
      case 9: return 30;
      case 10: return 31;
      case 11: return 30;
      case 12: return 31;
    }
    return 0;
  }
  public boolean dataValida(){//a=dia, b=mes    , c=ano
    if(ano<1){
      return false;
    }else if(mes>12 || mes<1){
      return false;
    }else if(dia>nDias(ano, mes) || dia<1){
      return false;
    }else 
      return true;
  }
  public void setDia(int dia){
    this.dia=dia;
  }
  public void setMes(int mes){
    this.mes=mes;
  }
  public void setAno(int ano){
    this.ano=ano;
  }
  public int getDia(){
    return dia;
  }
  public int getMes(){
    return mes;
  }
  public int getAno(){
    return ano;
  }
  public boolean igualA(Data a){

    if(a.ano==ano && a.mes==mes && a.dia==dia)
      return true;
    else{
      return false;
    }
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
  public void escreve() {
    System.out.printf("%02d-%02d-%04d\n", dia, mes, ano);
  }
}

