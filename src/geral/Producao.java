package geral;

import java.util.ArrayList;

public class Producao {
	String nome;
	int dataInicio;
	int dataFinal;
	ArrayList <Colaboradores> colaboradores = new ArrayList<Colaboradores>();
	public boolean umnovocolaborador(Colaboradores novo){
		if(colaboradores.add(novo)){
		return true;
		}
		else{
		return false;
		}
	}
	public int compareTo(Producao s){
		return 0;
	
	}
}