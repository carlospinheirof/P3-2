package geral;

import java.util.ArrayList;

public class Producao {
	String nome;
	int diaInicio;
	int mesInicio;
	int anoInicio;
	int diaFinal;
	int mesFinal;
	int anoFinal;
	long totalComparar;
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