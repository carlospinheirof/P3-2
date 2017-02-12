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
		int comando = 0;
		Colaboradores colaux = null, colaux2 = null;
		Producao proaux = null;
		Publicacao pubaux = null;
		int npElaboracao = 0;
		int npAndamento = 0;
		int npConcluidos = 0;
		boolean v;
		while(true){
			System.out.println("Escolha o que deseja fazer.");
			System.out.println("1 - Adicionar um novo colaborador ao sistema");
			System.out.println("2 - Adicionar um novo projeto ao sistema");
			System.out.println("3 - Informa��o sobre um colaborador");
			System.out.println("4 - Informa��o de um projeto");
			System.out.println("5 - Adicionar uma publica��o");
			System.out.println("6 - Adicionar orienta��o");
			System.out.println("7 - Associar um colaborador a um projeto");
			System.out.println("8 - Alterar status de um projeto");
			System.out.println("9 - Relatorio Geral do laborat�rio");
			v = false;
			while(!v){
				try{
					comando = ler.nextInt();
					n = ler.nextLine();
					v = true;
				}
				catch(Exception e){
					System.out.println("entrada inv�lida, tente novamente");
					ler.nextLine();
				}
			}
			switch(comando){
				case 1:																							//1 - Adicionar um novo colaborador ao sistema
					v = false;
					while(!v){
						try{
							System.out.println("Diga se ele �:");
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
								System.out.println("Digitou um comando inv�lido");
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
							v = true;
						}
						catch(Exception e){
							System.out.println("entrada inv�lida, tente novamente");
							ler.nextLine();
						}
					}	
					break;	
				case 2:                                                        //2 - Adicionar um novo projeto ao sistema
					v = false;
					while(!v){
						try{		
							System.out.println("Digite o nome do projeto");
							proaux = new Projetos();
							proaux.nome = ler.nextLine();
							System.out.println("Digite o ano de inicio do projeto");
							proaux.anoInicio = ler.nextInt(); //exception
							while(proaux.anoInicio <= 0){
								System.out.println("voc� digitou um n�mero invalido, digite novamente.");
								proaux.anoInicio = ler.nextInt();
							}
							System.out.println("Digite o m�s de inicio do projeto");
							proaux.mesInicio = ler.nextInt(); //exception
							while(proaux.mesInicio <= 0 || proaux.mesInicio > 12){
								System.out.println("voc� digitou um n�mero invalido, digite novamente.");
								proaux.mesInicio = ler.nextInt();
							}
							System.out.println("Digite o dia de inicio do projeto");
							proaux.diaInicio = ler.nextInt(); //exception
							while(proaux.diaInicio <= 0 || proaux.diaInicio > 31){
								System.out.println("voc� digitou um n�mero invalido, digite novamente.");
								proaux.diaInicio = ler.nextInt();
							}
							n = ler.nextLine();
							proaux.diaFinal = 0; proaux.mesFinal = 0; proaux.anoFinal = 0;
							System.out.println("Digite o nome da ag�ncia financiadora");
							((Projetos)proaux).financiadora = ler.nextLine();
							System.out.println("Digite o objetivo do projeto");
							((Projetos)proaux).objetivo = ler.nextLine();
							System.out.println("Digite a descri��o em uma linha do projeto");
							((Projetos)proaux).descricao = ler.nextLine();
							System.out.println("Digite o valor financiado");
							((Projetos)proaux).valorFinanciado = ler.nextFloat();
							((Projetos)proaux).numeroDePublicacoes = 0;
							((Projetos)proaux).andamento = 1;
							if(producoes.add(proaux)){
								System.out.println("Projeto adicionado com sucesso");
								npElaboracao++;
							}
							v = true;
						}
						catch(Exception e){
							System.out.println("entrada inv�lida, tente novamente");
							ler.nextLine();
						}
					}	
					break;
				case 3:															///n�o acabada.
					v = false;
					while(!v){
						try{
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
								System.out.println("Esse colaborador n�o foi encontrando.");
								break;
							}
							System.out.printf("Nome: %s\n", colaux.getname());
							System.out.printf("Email: %s\n", colaux.email);
							if(colaux instanceof Professores){
								System.out.println("Professor");
								System.out.println("Orienta��es:");
								((Professores) colaux).listarOrientandos();
							}else if(colaux instanceof Graduandos){
								System.out.println("Graduando");
							}else if(colaux instanceof Pesquisadores){
								System.out.println("Pesquisador");
							}else{
								System.out.println("Menstrando");
							}
							//System.out.printf("Est� linkado a %d\n", colaux.quantosProjetos);
							System.out.println("Projetos:");
							 ArrayList<Projetos> proj = colaux.getListaProjetos();
			                    proj.sort((p1, p2) -> Long.compare(p2.totalComparar, p1.totalComparar));
			                    System.out.println(proj.size());
							for(i = 0; i < colaux.projetos.size(); i++){
								proaux = proj.get(i);
								System.out.printf("Nome : %s     ", proaux.nome);
								if(((Projetos)proaux).andamento == 1){
									System.out.println("Em elabora��o.");
									System.out.printf("Inicio: %d/%d/%d\n", proaux.diaInicio, proaux.mesInicio, proaux.anoInicio);
								}else if(((Projetos)proaux).andamento == 2){
									System.out.println("Em andamento.");
									System.out.printf("Inicio: %d/%d/%d\n", proaux.diaInicio, proaux.mesInicio, proaux.anoInicio);
								}else{
									System.out.println("Concluido.");
									System.out.printf("Inicio: %d/%d/%d    Fim: %d/%d/%d\n", proaux.diaInicio, proaux.mesInicio, proaux.anoInicio, proaux.diaFinal, proaux.mesFinal, proaux.anoFinal);
								}
							}
							System.out.println("Publica��es Acad�micas: ");
							if(colaux.getListaPublicacoes() != null){
			                    ArrayList<Publicacao> publ = colaux.getListaPublicacoes();
			                    publ.sort((p1, p2) -> Long.compare(p2.totalComparar, p1.totalComparar));
			                    System.out.println(publ.size());
			                    for(i= 0 ; i < publ.size(); i++){
			                    	pubaux = publ.get(i);
			                    	System.out.printf("%s  data: %d/%d/%d\nConfer�ncia: %s\n", pubaux.nome, pubaux.diaFinal, pubaux.mesFinal, pubaux.anoFinal, pubaux.conferencia);
			                    	if(pubaux.projeto != null){
			                    		System.out.printf("projeto associado %s\n", pubaux.projeto.nome);
			                    	}
			                    }
							}else{
								System.out.println("n�o possui publica��es");
							}
							v = true;
						}
						catch(Exception e){
							System.out.println("entrada inv�lida, tente novamente");
							ler.nextLine();
						}
					}
					break;
				case 4:
					v = false;
					while(!v){
						try{
							System.out.println("Digite o nome do projeto que deseja as informa��es");
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
								System.out.println("Esse projeto n�o foi encontrando.");
								break;
							}
							System.out.printf("Descri��o do projeto:\n%s\n", ((Projetos) proaux).descricao);
							System.out.printf("Objetivo:\n%s\n", ((Projetos) proaux).objetivo);
							System.out.printf("Ag�ncia financiadora:\n%s\n", ((Projetos) proaux).financiadora);
							System.out.printf("Valor financiado: %.2f\n", ((Projetos) proaux).valorFinanciado);
							if(((Projetos) proaux).andamento == 1) System.out.printf("Em elabora��o\n");
							if(((Projetos) proaux).andamento == 2) System.out.printf("Em andamento\n");
							if(((Projetos) proaux).andamento == 3) System.out.printf("Concluido\n");
							System.out.println("Colaboradores associados:");
							for(i = 0; i < proaux.colaboradores.size(); i++){
								colaux = proaux.colaboradores.get(i);
								System.out.printf("%s\n", colaux.getname());
							}
							System.out.println("Publica��es Acad�micas: ");
							if(colaux.getListaPublicacoes() != null){
			                    ArrayList<Publicacao> publ = ((Projetos) proaux).getListaPublicacoes();
			                    publ.sort((p1, p2) -> Long.compare(p2.totalComparar, p1.totalComparar));
			                    System.out.println(publ.size());
			                    for(i= 0 ; i < publ.size(); i++){
			                    	pubaux = publ.get(i);
			                    	System.out.printf("%s  data: %d/%d/%d\nConfer�ncia: %s\n", pubaux.nome, pubaux.diaFinal, pubaux.mesFinal, pubaux.anoFinal, pubaux.conferencia);
			                    }
							}else{
								System.out.println("n�o possui publica��es");
							}
							v = true;
						}
						catch(Exception e){
							System.out.println("entrada inv�lida, tente novamente");
							ler.nextLine();
						}
					}
					break;
				case 5:
					v = false;
					while(!v){
						try{	
							System.out.println("Digite o nome da publica��o");
							pubaux = new Publicacao();
							pubaux.nome = ler.nextLine();
							System.out.println("Digite o nome da confer�ncia");
							pubaux.conferencia = ler.nextLine();
							System.out.println("Digite o ano da publica��o");
							pubaux.anoFinal = ler.nextInt(); //exception
							while(pubaux.anoFinal <= 0){
								System.out.println("voc� digitou um n�mero invalido, digite novamente.");
								pubaux.anoFinal = ler.nextInt();
							}
							System.out.println("Digite o m�s de inicio do projeto");
							pubaux.mesFinal = ler.nextInt(); //exception
							while(pubaux.mesFinal <= 0 || pubaux.mesFinal > 12){
								System.out.println("voc� digitou um n�mero invalido, digite novamente.");
								pubaux.mesFinal = ler.nextInt();
							}
							System.out.println("Digite o dia de inicio do projeto");
							pubaux.diaFinal = ler.nextInt(); //exception
							while(pubaux.diaFinal <= 0 || pubaux.diaFinal > 31){
								System.out.println("voc� digitou um n�mero invalido, digite novamente.");
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
									System.out.println("Esse colaborador n�o foi encontrando.");
									i--;
								}else{
									if(pubaux.umnovocolaborador(colaux) && colaux.producoes.add(pubaux)){
										System.out.println("Adicionado a publica��o");
									}	
								}						
							}
							System.out.println("Essa publica��o est� relacionada a algum projeto? Digite 1 - sim e 2 - n�o");
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
										System.out.println("Esse projeto n�o foi encontrando.");
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
									System.out.println("O projeto � necess�rio estar em andamento.");
								}
							}
							else{
								pubaux.projeto = null;
							}
							publicacoes.add(pubaux);
							v = true;
						}
						catch(Exception e){
							System.out.println("entrada inv�lida, tente novamente");
							ler.nextLine();
						}
					}	
					break;
				case 6:
					v = false;
					while(!v){
						try{
							System.out.println("Digite o nome do professor");
							n = ler.nextLine();
							j = 0;
							while(j == 0){
								for(i = 0; i < colaboradores.size(); i++){
									colaux = colaboradores.get(i);
									if(n.equals(colaux.getname())){
										i = colaboradores.size();
										j = 1;
									}
								}
								if(j == 0){
									System.out.println("Esse colaborador n�o foi encontrando, tente novamento");
								}else if(!(colaux instanceof Professores)){
									System.out.println("O colaborador precisa ser um professor");
									j = 1;
								}
								else{
									j = 1;
								}
							}
							System.out.println("Digite o nome do orientando");
							n = ler.nextLine();
							j = 0;
							while(j == 0){
								for(i = 0; i < colaboradores.size(); i++){
									colaux2 = colaboradores.get(i);
									if(n.equals(colaux2.getname())){
										i = colaboradores.size();
										j = 1;
									}
								}
								if(j == 0){
									System.out.println("Esse colaborador n�o foi encontrando, tente novamento");
								}
								else{
									j = 1;
								}
							}
							if(((Professores) colaux).adicionarOrientando(colaux2)){
								System.out.println("adicionado com sucesso");
							}
							v = true;
						}
						catch(Exception e){
							System.out.println("entrada inv�lida, tente novamente");
							ler.nextLine();
						}
					}
					break;
				case 7:															//associar um colaborador a um projeto
					v = false;
					while(!v){
						try{	
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
								System.out.println("Esse projeto n�o foi encontrando.");
								break;
							}
							if(((Projetos)proaux).andamento != 1){	
								System.out.println("o projeto precisa estar em elabora��o para ter um colaborador assosciado.");
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
								System.out.println("Esse colaborador n�o foi encontrando.");
								break;
							}
							else{
								if(colaux instanceof Graduandos){
									if(((Graduandos)colaux).estaEmProjetoEmAndamento > 2){
										System.out.println("ele n�o pode estar em mais de dois projetos em andamento.");
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
									System.out.println("n�o foi possivel adicionar.");
								}
							}
							v = true;
						}
						catch(Exception e){
							System.out.println("entrada inv�lida, tente novamente");
							ler.nextLine();
						}
					}
					break;
				case 8:																///alterar o andamento do projeto.
					v = false;
					while(!v){
						try{
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
										npAndamento ++;
										npElaboracao--;
									}
									else if(((Projetos)proaux).temUmProfessor == 0 && ((Projetos)proaux).andamento == 1){
										System.out.println("O projeto n�o possui um professor associado");
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
										npAndamento--;
										npConcluidos++;
									}
									else{
										System.out.println("O projeto n�o possui nenhuma publica��o");
									}
								}
								if(j==0){
									System.out.println("Projeto n�o encontrado.");
								}
								else{
									System.out.println("Concluido.");
								}
							}
						}
						catch(Exception e){
							System.out.println("entrada inv�lida, tente novamente");
							ler.nextLine();
						}
					}
					break;
				case 9:
					System.out.println("Relat�rio geral do projeto");
					System.out.printf("Numero de colaboradores: %d\n", colaboradores.size());
					System.out.printf("Numero de Projetos: %d\n", producoes.size());
					System.out.printf("Projetos em elabora��o: %d\n", npElaboracao);
					System.out.printf("Projetos em andamento: %d\n", npAndamento);
					System.out.printf("Projetos concluidos: %d\n", npConcluidos);
					System.out.printf("Numero de publica��es: %d\n", publicacoes.size());
					break;
				default:
					System.out.println("comando inv�lido");
					break;
			}
			
		}
		

	}

}
