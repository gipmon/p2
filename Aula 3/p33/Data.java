/* Programação modular - Aula 3 - by Rafael Ferreira
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

