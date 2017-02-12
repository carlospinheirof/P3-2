package geral;

import java.util.ArrayList;
public class Colaboradores {
		String nome;
		public String email;
		public ArrayList <Projetos> projetos = new ArrayList<Projetos>();
		public ArrayList <Publicacao> producoes = new ArrayList<Publicacao>();
		public int quantosProjetos;
		
		public String getname(){
			return this.nome;
		}
		public void setname(String n){
			this.nome = n;
		}
		boolean adicionarprojeto(Projetos r){
			if(projetos.add(r)){
				return true;
			}
			else{
				return false;
			}
		}
		public ArrayList <Publicacao> getListaPublicacoes(){
			return producoes;
		}
		public ArrayList <Projetos> getListaProjetos(){
			return projetos;
		}
}
