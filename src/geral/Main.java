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
		ArrayList <Publicacao> publicacoes = new ArrayList<Publicacao>();
		int i, j, k, l;
		String n;
		int comando;
		Colaboradores colaux = null;
		Producao proaux = null;
		Publicacao pubaux = null;
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
					comando = ler.nextInt();    ///exception
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
					n = ler.nextLine();
					colaux.setname(n);
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
					proaux.anoInicio = ler.nextInt(); //exception
					while(proaux.anoInicio <= 0){
						System.out.println("você digitou um número invalido, digite novamente.");
						proaux.anoInicio = ler.nextInt();
					}
					System.out.println("Digite o més de inicio do projeto");
					proaux.mesInicio = ler.nextInt(); //exception
					while(proaux.mesInicio <= 0 || proaux.mesInicio > 12){
						System.out.println("você digitou um número invalido, digite novamente.");
						proaux.mesInicio = ler.nextInt();
					}
					System.out.println("Digite o dia de inicio do projeto");
					proaux.diaInicio = ler.nextInt(); //exception
					while(proaux.diaInicio <= 0 || proaux.diaInicio > 31){
						System.out.println("você digitou um número invalido, digite novamente.");
						proaux.diaInicio = ler.nextInt();
					}
					n = ler.nextLine();
					proaux.diaFinal = 0; proaux.mesFinal = 0; proaux.anoFinal = 0;
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
				case 3:															///não acabada.
					System.out.println("Digite o nome do colaborador que deseja encontrar");
					n = ler.nextLine();
					j = 0;
					for(i = 0; i < colaboradores.size(); i++){
						colaux = colaboradores.get(i);
						if(n.equals(colaux.getname())){
							i = colaboradores.size();
							j = 1;
						}
					}
					if(j == 0){
						System.out.println("Esse colaborador não foi encontrando.");
						break;
					}
					System.out.printf("Nome: %s\n", colaux.getname());
					System.out.printf("Email: %s\n", colaux.email);
					if(colaux instanceof Professores){
						System.out.println("Professor");
						System.out.println("Orientações:");
					}else if(colaux instanceof Graduandos){
						System.out.println("Graduando");
					}else if(colaux instanceof Pesquisadores){
						System.out.println("Pesquisador");
					}else{
						System.out.println("Menstrando");
					}
					System.out.printf("Está linkado a %d\n", colaux.quantosProjetos);
					System.out.println("Projetos:");
					 ArrayList<Projetos> proj = colaux.getListaProjetos();
	                    proj.sort((p1, p2) -> Long.compare(p2.totalComparar, p1.totalComparar));
	                    System.out.println(proj.size());
					for(i = 0; i < colaux.projetos.size(); i++){
						proaux = proj.get(i);
						System.out.printf("Nome : %s     ", proaux.nome);
						if(((Projetos)proaux).andamento == 1){
							System.out.println("Em elaboração.");
							System.out.printf("Inicio: %d/%d/%d\n", proaux.diaInicio, proaux.mesInicio, proaux.anoInicio);
						}else if(((Projetos)proaux).andamento == 2){
							System.out.println("Em andamento.");
							System.out.printf("Inicio: %d/%d/%d\n", proaux.diaInicio, proaux.mesInicio, proaux.anoInicio);
						}else{
							System.out.println("Concluido.");
							System.out.printf("Inicio: %d/%d/%d    Fim: %d/%d/%d\n", proaux.diaInicio, proaux.mesInicio, proaux.anoInicio, proaux.diaFinal, proaux.mesFinal, proaux.anoFinal);
						}
					}
					System.out.println("Publicações Acadêmicas: ");
					if(colaux.getListaPublicacoes() != null){
	                    ArrayList<Publicacao> publ = colaux.getListaPublicacoes();
	                    publ.sort((p1, p2) -> Long.compare(p2.totalComparar, p1.totalComparar));
	                    System.out.println(publ.size());
	                    for(i= 0 ; i < publ.size(); i++){
	                    	pubaux = publ.get(i);
	                    	System.out.printf("%s  data: %d/%d/%d\nConferência%s\n", pubaux.nome, pubaux.diaFinal, pubaux.mesInicio, pubaux.anoFinal, pubaux.conferencia);
	                    	if(pubaux.projeto != null){
	                    		System.out.printf("projeto associado %s\n", pubaux.projeto.nome);
	                    	}
	                    }
					}else{
						System.out.println("não possui publicações");
					}
					break;
				case 4:
					break;
				case 5:
					System.out.println("Digite o nome da publicação");
					pubaux = new Publicacao();
					pubaux.nome = ler.nextLine();
					System.out.println("Digite o nome da conferência");
					pubaux.conferencia = ler.nextLine();
					System.out.println("Digite o ano da publicação");
					pubaux.anoFinal = ler.nextInt(); //exception
					while(pubaux.anoFinal <= 0){
						System.out.println("você digitou um número invalido, digite novamente.");
						pubaux.anoFinal = ler.nextInt();
					}
					System.out.println("Digite o més de inicio do projeto");
					pubaux.mesFinal = ler.nextInt(); //exception
					while(pubaux.mesFinal <= 0 || pubaux.mesFinal > 12){
						System.out.println("você digitou um número invalido, digite novamente.");
						pubaux.mesFinal = ler.nextInt();
					}
					System.out.println("Digite o dia de inicio do projeto");
					pubaux.diaFinal = ler.nextInt(); //exception
					while(pubaux.diaFinal <= 0 || pubaux.diaFinal > 31){
						System.out.println("você digitou um número invalido, digite novamente.");
						pubaux.diaFinal = ler.nextInt();
					}
					pubaux.totalComparar = (pubaux.anoFinal*365) + (pubaux.mesFinal*30) + pubaux.diaFinal;
					System.out.println("Quantos autores?");
					j = ler.nextInt();  //exception
					while(j <= 0){
						System.out.println("No minimo 1 autor, digite novamente");
						j = ler.nextInt(); 
					}
					n = ler.nextLine();
					for(i = 0;i < j; i++){
						System.out.println("Digite o nome de um colaborador");
						n = ler.nextLine();
						k = 0;
						for(l = 0; l < colaboradores.size(); l++){
							colaux = colaboradores.get(l);
							if(n.equals(colaux.getname())){
								l = colaboradores.size();
								k = 1;
							}
						}
						if(k == 0){
							System.out.println("Esse colaborador não foi encontrando.");
							i--;
						}else{
							if(pubaux.umnovocolaborador(colaux) && colaux.producoes.add(pubaux)){
								System.out.println("Adicionado a publicação");
							}	
						}						
					}
					System.out.println("Essa publicação está relacionada a algum projeto? Digite 1 - sim e 2 - não");
					j = ler.nextInt();  //exception
					while(j < 1 && j > 2){
						System.out.println("apenas 1 ou 2, digite novamente");
						j = ler.nextInt(); 
					}
					n = ler.nextLine();
					if(j == 1){
						k = 0;
						while(k == 0){
							System.out.println("Digite o nome do projeto");
							n = ler.nextLine();
							for(i = 0; i < producoes.size(); i++){
								proaux = producoes.get(i);
								if(n.equals(proaux.nome)){						
									i = producoes.size();
									k = 1;
								}
							}
							if(k == 0){
								System.out.println("Esse projeto não foi encontrando.");
							}
						}
						if(((Projetos)proaux).andamento == 2){
							if(((Projetos)proaux).producoes.add(pubaux)){
								pubaux.projeto = ((Projetos)proaux);
								((Projetos)proaux).numeroDePublicacoes =+ 1;
								System.out.println("adicionado com sucesso");
							}
						}
						else{
							System.out.println("O projeto é necessário estar em andamento.");
						}
					}
					else{
						pubaux.projeto = null;
					}
					publicacoes.add(pubaux);
					break;
				case 6:
					break;
				case 7:															//asssociar um colaborador a um projeto
					System.out.println("Digite o nome do projeto que deseja adicionar um novo colaborador");
					n = ler.nextLine();
					j = 0;
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
						if(n.equals(colaux.getname())){
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
							if(((Graduandos)colaux).estaEmProjetoEmAndamento > 2){
								System.out.println("ele não pode estar em mais de dois projetos em andamento.");
								break;
							}
						}
						if(proaux.umnovocolaborador(colaux) && colaux.adicionarprojeto(((Projetos) proaux))){	
							if(colaux instanceof Professores)
							{
								((Projetos) proaux).temUmProfessor = 1;
							}
							colaux.quantosProjetos++;
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
						//colaux = colaboradores.get(0);
						if(n.equals(proaux.nome)){
							j = 1;
							if(((Projetos)proaux).temUmProfessor == 1 && ((Projetos)proaux).andamento == 1){
								((Projetos)proaux).andamento += 1;
							}
							else if(((Projetos)proaux).temUmProfessor == 0 && ((Projetos)proaux).andamento == 1){
								System.out.println("O projeto não possui um professor associado");
							}
							else if(((Projetos)proaux).numeroDePublicacoes > 0 && ((Projetos)proaux).andamento == 2){
								((Projetos)proaux).andamento += 1;
								System.out.println("Digite o ano de termino");
								proaux.anoFinal = ler.nextInt(); //exception
								proaux.totalComparar = (proaux.anoFinal*365);
								System.out.println("Digite o mes do termino");		
								proaux.mesFinal = ler.nextInt(); // exception
								proaux.totalComparar += proaux.mesFinal * 30;
								System.out.println("Digite o dia do temrino");
								proaux.diaFinal = ler.nextInt(); //expcetion
								proaux.totalComparar += proaux.diaFinal;
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
