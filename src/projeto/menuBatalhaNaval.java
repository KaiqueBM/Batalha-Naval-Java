package projeto;
import java.util.Scanner;
public class menuBatalhaNaval {
	//Atributos
	private int menu;
	private boolean jogar;
	private int tutorial;
	private int creditos;
	private String menuConversor;
	//Get e set
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}
	public boolean getJogar() {
		return jogar;
	}
	public void setJogar(boolean jogar) {
		this.jogar = jogar;
	}
	public int getTutorial() {
		return tutorial;
	}
	public void setTutorial(int tutorial) {
		this.tutorial = tutorial;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getMenuConversor() {
		return menuConversor;
	}
	public void setMenuConversor(String menuConversor) {
		this.menuConversor = menuConversor;
	}
	//Construtor
	public menuBatalhaNaval() {
	}
	public menuBatalhaNaval(int menu, boolean jogar, int tutorial, int creditos, String menuConversor) {
		super();
		this.menu = menu;
		this.jogar = jogar;
		this.tutorial = tutorial;
		this.creditos = creditos;
		this.menuConversor = menuConversor;
	}
	
	//MÉTODO MENU: Mostra se deseja jogar ou realizar outras funções.
	public void menu() {
		iniciarBatalhaNaval BN = new iniciarBatalhaNaval();
		Scanner ler = new Scanner(System.in);
		System.out.println("[SEJA BEM VINDO A BATALHA NAVAL]");
		System.out.println("O objetivo é acertar todos os navios.");
		System.out.println();
		do {
		System.out.println("[ -------===MENU===------- ]        ");
		System.out.println("[1] - Jogar batalha naval      ");
		System.out.println("[2] - Tutorial      ");
		System.out.println("[3] - Créditos");
		System.out.println("[0] - Sair      ");
		System.out.println("Deseja realizar qual opção?");
		menuConversor = ler.next();
		switch (menuConversor) { 
			case "1":
				menu = Integer.parseInt("1"); break;
			case "2":
				menu = Integer.parseInt("2"); break;
			case "3":
				menu = Integer.parseInt("3"); break;
			case "0":
				menu = Integer.parseInt("0"); break;
			default:
				for(int i = 0; i < 25; ++i) System.out.println();
				System.out.println("[ERRO] Tem que ser um número entre 0 a 3.");
				System.out.println();
				menu();
		}
		switch (menu) {
		case 1:
			for (int i = 0; i < 25; ++i) System.out.println ();
	        System.out.println("-----===X===------RODADA INICIAL-------===X===-----");
		    System.out.println("[JOGAR] Você escolheu a opção de jogar, tenha uma boa sorte.");
		    System.out.println("[NAVIOS] Existem no total 5 navios para você destruir.");
		    System.out.println("Contamos contigo, você consegue derrota-los!");
		    BN.jogar(0);
		    break;
		  case 2:
			  for(int i = 0; i < 25; ++i) System.out.println();
			  tutorial();
		    break;
		  case 3:
			  for(int i = 0; i < 25; ++i) System.out.println();
			  creditos();
		    break;
		  case 0:
			    System.out.println();
			    break;
		    default: System.out.println("[ERRO] O valor inserido tem quer ser 1 ou 2.");
		} }while(menu!=0);
		for(int i=0; i<25; ++i) System.out.println();
		System.out.println("[VOCÊ ESCOLHEU A OPÇÃO] Sair do jogo");
		System.out.println("Obrigado e volte sempre que quiser jogar :) ");	
	}
	
	//MÉTODO TUTORIAL: Explica como funciona o jogo.
	public void tutorial() {
		Scanner ler = new Scanner(System.in);
		System.out.println("[O QUE É BATALHA NAVAL?]");
		System.out.println("É um minigame aonde estará espalhado pelo tabuleiro, 5 navios");
		System.out.println("inimigos, na qual acertando todas as suas localizações, você");
		System.out.println("ganhará o jogo.");
		System.out.println();
		System.out.println("[SIGNIFICADOS DOS CAMPOS DE BATALHA]");
		System.out.println("Campo vazio-> É agua, aonde você deverá jogar.");
		System.out.println("Campo O -> É aonde você jogou e não tinha nada, apenas água.");
		System.out.println("Campo X -> É aonde você jogou e tinha um navio.");
		System.out.println();
		System.out.println("[COMO QUE EU JOGO?]");
		System.out.println("A cada rodada, você deverá digitar uma letra e um número,");
		System.out.println("um que é a linha, e o outro que é a coluna, ambos nas");
		System.out.println("coordenadas que deseja jogar. Ex: (G,6). ");
		System.out.println("A letra deve ser entre A à H. ");
		System.out.println("O número deve ser entre 1 à 8.");
		System.out.println();
		System.out.println("[DESEJA VOLTAR PARA O MENU?] 1- Sair, 2- Repetir");
		tutorial = ler.nextInt();
		switch(tutorial) {
			case 1:
				for(int i=0; i<25; ++i) System.out.println ();
				break;
			case 2:
				for(int i=0; i<25; ++i) System.out.println ();
				tutorial();
				break;
		  default: 
			  	for(int i=0; i<25; ++i) System.out.println ();
			  	System.out.println("[ERRO] O valor tem quer ser 1 ou 2.");
			  	System.out.println();
			  	tutorial();
		}
	}
	
	//MÉTODO CRÉDITOS: Mostra quem criou o jogo.
	public void creditos() {
		Scanner ler = new Scanner(System.in);
		System.out.println("[CCP 3ºA MATUTINO]");
		System.out.println("Kaique Miranda");
		System.out.println();
		System.out.println("[DESEJA VOLTAR PARA O MENU?] 1- Sair, 2- Repetir");
		creditos = ler.nextInt();
		switch(creditos) {
			case 1:
				for(int i=0; i<25; ++i) System.out.println ();
				break;
			case 2:
				for(int i=0; i<25; ++i) System.out.println ();
				creditos();
				break;
		  default: 
			  	for(int i=0; i<25; ++i) System.out.println ();
			  	System.out.println("[ERRO] O valor tem quer ser 1 ou 2.");
			  	System.out.println();
			  	creditos();
		}	
	}
	
//FIM	
}