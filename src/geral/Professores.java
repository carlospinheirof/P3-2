package geral;

import java.util.ArrayList;

public class Professores extends Colaboradores{
	private ArrayList <Colaboradores> orientandos = new ArrayList<Colaboradores>();
	public boolean adicionarOrientando(Colaboradores o){
		if(orientandos.add(o)){
			return true;
		}
		else{
			return false;
		}	
	}
	public void listarOrientandos(){
		int i;
		System.out.printf("%d", orientandos.size());
		for(i = 0;i < orientandos.size();i++){
			System.out.printf("%s\n", orientandos.get(i).getname());
		}
	}
}
