package geral;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
// System.out.println("");
	public static void main(String[] args) {

		System.out.println("Sistema de produtividade academica");
		Scanner ler = new Scanner(System.in);
		ArrayList <Colaboradores> colaboradores = new ArrayList<Colaboradores>(); // Criando lista de colaboradores geral.
		ArrayList <Producao> producoes = new ArrayList<Producao>(); // Criando lista de projetos geral.
		int i, j, k;
		String n;
		int comando;
		Colaboradores colaux;
		Producao proaux;
		while(true){
			System.out.println("Escolha o que deseja fazer.");
			System.out.println("1 - Adicionar um novo colaborador ao sistema");
			System.out.println("2 - Adicionar um novo projeto ao sistema");
			System.out.println("3 - Informação sobre um colaborador");
			System.out.println("4 - Informação de um projeto");
			System.out.println("5 - Adicionar uma publicação");
			System.out.println("6 - Adicionar orientação");
			System.out.println("7 - Associar um colaborador a um projeto");
			System.out.println("8 - Alterar status de um projeto");
			System.out.println("9 - Relatorio Geral do laboratório");
			comando = ler.nextInt();
			n = ler.nextLine();
			switch(comando){
				case 1:																							//1 - Adicionar um novo colaborador ao sistema
					System.out.println("Diga se ele é:");
					System.out.println("1 - Graduando\n2 - Mestrando\n3 - Professor\n4 - Pesquisador");
					comando = ler.nextInt();
					n = ler.nextLine();
					if(comando == 1){
						colaux = new Graduandos();
						((Graduandos) colaux).estaEmProjetoEmAndamento = 0;
					}
					else if(comando == 2){
						colaux = new Mestrandos();
					}
					else if(comando == 3){
						colaux = new Professores();
					}
					else if(comando == 4){
						colaux = new Pesquisadores();
					}
					else{
						System.out.println("Digitou um comando inválido");
						break;
					}
					System.out.println("Digite o nome");
					colaux.nome = ler.nextLine();
					System.out.println("Digite o email");
					colaux.email = ler.nextLine();
					colaux.quantosProjetos = 0;
					if(colaboradores.add(colaux)){
						System.out.println("adicionado corretamente.");
					}
					break;
				case 2:                                                        //2 - Adicionar um novo projeto ao sistema
					System.out.println("Digite o nome do projeto");
					proaux = new Projetos();
					proaux.nome = ler.nextLine();
					System.out.println("Digite o ano de inicio do projeto");
					proaux.dataInicio = ler.nextInt();
					n = ler.nextLine();
					proaux.dataFinal = 0;
					System.out.println("Digite o nome da agência financiadora");
					((Projetos)proaux).financiadora = ler.nextLine();
					System.out.println("Digite o objetivo do projeto");
					((Projetos)proaux).objetivo = ler.nextLine();
					System.out.println("Digite a descrição em uma linha do projeto");
					((Projetos)proaux).descricao = ler.nextLine();
					System.out.println("Digite o valor financiado");
					((Projetos)proaux).valorFinanciado = ler.nextFloat();
					((Projetos)proaux).numeroDePublicacoes = 0;
					((Projetos)proaux).andamento = 1;
					if(producoes.add(proaux)){
						System.out.println("Projeto adicionado com sucesso");
					}
					
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:															//asssociar um colaborador a um projeto
					System.out.println("Digite o nome do projeto que deseja adicionar um novo colaborador");
					n = ler.nextLine();
					j = 0;
					proaux = producoes.get(0);
					colaux = colaboradores.get(0);
					for(i = 0; i < producoes.size(); i++){
						proaux = producoes.get(i);
						if(n.equals(proaux.nome)){						
							i = producoes.size();
							j = 1;
						}
					}
					if(j == 0){
						System.out.println("Esse projeto não foi encontrando.");
						break;
					}
					if(((Projetos)proaux).andamento != 1){	
						System.out.println("o projeto precisa estar em elaboração para ter um colaborador assosciado.");
						break;
					}
					System.out.println("Digite o nome do colaborador a ser adicionado");
					n = ler.nextLine();
					j = 0;
					for(i = 0; i < colaboradores.size(); i++){
						colaux = colaboradores.get(i);
						if(n.equals(colaux.nome)){
							i = colaboradores.size();
							j = 1;
						}
					}
					if(j == 0){
						System.out.println("Esse colaborador não foi encontrando.");
						break;
					}
					else{
						if(colaux instanceof Graduandos){
							if(((Graduandos)colaux).estaEmProjetoEmAndamento > 1){
								System.out.println("ele não pode etar em dois projetos em andamento.");
								break;
							}
						}
						if(proaux.umnovocolaborador(colaux)){
							if(colaux instanceof Professores)
							{
								((Projetos) proaux).temUmProfessor = 1;
								colaux.quantosProjetos +=1;
							}
							System.out.println("Colaborador adicionado com sucesso.");
						}
						else{
							System.out.println("não foi possivel adicionar.");
						}
					}
					break;
				case 8:																///alterar o andamento do projeto.
					System.out.println("Digite o nome do projeto que deseja alterar");
					n = ler.nextLine();
					j = 0;
					for(i = 0; i < producoes.size(); i++){
						proaux = producoes.get(i);
						if(n.equals(proaux.nome)){
							j = 1;
							if(((Projetos)proaux).temUmProfessor == 1 && ((Projetos)proaux).andamento == 1){
								((Projetos)proaux).andamento += 1;
								andamentoalterado();
								
							}
							else if(((Projetos)proaux).temUmProfessor == 0 && ((Projetos)proaux).andamento == 1){
								System.out.println("O projeto não possui um professor associado");
							}
							else if(((Projetos)proaux).numeroDePublicacoes > 0 && ((Projetos)proaux).andamento == 2){
								((Projetos)proaux).andamento += 1;
								andamentoalterado();
							}
							else{
								System.out.println("O projeto não possui nenhuma publicação");
							}
						}
						if(j==0){
							System.out.println("Projeto não encontrado.");
						}
						else{
							System.out.println("Concluido.");
						}
					}
					break;
				case 9:
					break;
				default:
					System.out.println("comando inválido");
					break;
			}
			
		}
		

	}

}
