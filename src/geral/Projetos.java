package geral;
import java.util.ArrayList;
public class Projetos extends Producao{
	ArrayList <Publicacao> producoes = new ArrayList<Publicacao>();
	int temUmProfessor;
	int andamento;
	int numeroDePublicacoes;
	int numeroDegraduandoscom2;
	String financiadora;
	float valorFinanciado;
	String objetivo;
	String descricao;
	public ArrayList <Publicacao> getListaPublicacoes(){
		return producoes;
	}
}
