package projeto;
import java.util.Random;
import java.util.Scanner;
public class iniciarBatalhaNaval extends menuBatalhaNaval {
	// Atributos
	private static int tabuleiro[][] = new int[8][8];
	private static int navios2P[][] = new int[8][8];
	private static int navios3P[][] = new int[8][8];
	private static int navios4P[][] = new int[8][8];
	private String tiroXstr;
	private String tiroYstr;
	private int tiroX;
	private int tiroY;
	private int acertos;
	private int pontos;
	private int rodada;
	private boolean certo;

	// Get e set
	public int[][] getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int[][] getNavios2P() {
		return navios2P;
	}
	public void setNavios2P(int[][] navios2p) {
		navios2P = navios2p;
	}

	public int[][] getNavios3P() {
		return navios3P;
	}
	public void setNavios3P(int[][] navios3p) {
		navios3P = navios3p;
	}

	public int[][] getNavios4P() {
		return navios4P;
	}
	public void setNavios4P(int[][] navios4p) {
		navios4P = navios4p;
	}

	public String getTiroXstr() {
		return tiroXstr;
	}
	public void setTiroX(String tiroXstr) {
		this.tiroXstr = tiroXstr;
	}
	
	public String getTiroYstr() {
		return tiroYstr;
	}
	public void setTiroY(String tiroYstr) {
		this.tiroYstr = tiroYstr;
	}

	public int getTiroX() {
		return tiroX;
	}
	public void setTiroX(int tiroX) {
		this.tiroX = tiroX;
	}

	public int getTiroY() {
		return tiroY;
	}
	public void setTiroY(int tiroY) {
		this.tiroY = tiroY;
	}

	public int getAcertos() {
		return acertos;
	}
	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getRodada() {
		return rodada;
	}
	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public boolean isCerto() {
		return certo;
	}
	public void setCerto(boolean certo) {
		this.certo = certo;
	}

	// construtor
	public iniciarBatalhaNaval() {
	}

	public iniciarBatalhaNaval(int[][] tabuleiro, int[][] navios2p, int[][] navios3p, int[][] navios4p, int tiroX,
			int tiroY, int acertos, int pontos, int rodada, boolean certo, String tiroXstr, String tiroYstr) {
		super();
		this.tabuleiro = tabuleiro;
		navios2P = navios2p;
		navios3P = navios3p;
		navios4P = navios4p;
		this.tiroXstr = tiroXstr;
		this.tiroYstr = tiroYstr;
		this.tiroX = tiroX;
		this.tiroY = tiroY;
		this.acertos = acertos;
		this.pontos = pontos;
		this.rodada = rodada;
		this.certo = certo;
	}

	// MÉTODO JOGAR: Rodar a batalha naval até vencer.
	public void jogar(int fim) {
		Scanner ler = new Scanner(System.in);
		do {
			mostrarTabuleiro();
			atirarBomba();
			atualizarRodada();
		} while (acertos != 5);
		mostrarTabuleiro();
		System.out.println("[PARABÉNS] Você ganhou a batalha naval!");
		System.out.println("[NAVIOS] Você acertou todos os " + acertos + " navios.");
		System.out.println("[PONTOS] A sua pontuação foi: " + pontos);
		System.out.println("[TENTATIVAS] Você tentou no total de " + rodada + " vezes.");
		System.out.println("-----===X===----------===X===----------===X===-----");
		System.out.println("[JOGO FINALIZADO] Voltar para o menu? 0- Menu, 1- Reiniciar");
		fim = ler.nextInt();
		switch (fim) {
		case 0:
			for (int i = 0; i < 25; ++i)
				System.out.println();
			gerarTabuleiro();
			gerarNavios(0, 0, 0);
			acertos = 0;
			rodada = 0;
			pontos = 0;
			certo = false;
			break;
		case 1:
			for (int i = 0; i < 25; ++i)
				System.out.println();
			gerarTabuleiro();
			gerarNavios(0, 0, 0);
			acertos = 0;
			rodada = 0;
			pontos = 0;
			certo = false;
			System.out.println("-----===X===------RODADA INICIAL-------===X===-----");
		    System.out.println("[JOGAR] Você escolheu a opção de jogar, tenha uma boa sorte.");
		    System.out.println("[NAVIOS] Existem no total 5 navios para você destruir.");
		    System.out.println("Contamos contigo, você consegue derrota-los!");
			jogar(0);
			break;
		default:
			System.out.println("[ERRO] Tem que ser o número 0 ou 1.");
		}
	}

	// MÉTODO GERARTABULEIRO: Ele cria o tabuleito 8x8.
	// Ele cria um tabuleiro do tamanho da array, nesse caso 8 por 8.
	public void gerarTabuleiro() {
		for (int linha = 0; linha < tabuleiro.length; linha++)
			for (int coluna = 0; coluna < tabuleiro.length; coluna++)
				tabuleiro[linha][coluna] = 0;
	}

	// MÉTODO MOSTRARTABULEIRO: Ele mostra o tabuleiro montado.
	// Ele puxa o tabuleiro criado e atualiza de acordo com o valor.
	public void mostrarTabuleiro() {
		System.out.println("-----===X===----------===X===----------===X===-----");
		int numeroDaColuna = 1;
		String numerosDoTabuleiro = "          | ";

		for (int i = 0; i < 8; i++) {
			numerosDoTabuleiro += (numeroDaColuna++) + " | ";
		}
		System.out.println(numerosDoTabuleiro);
		System.out.println("        -----------------------------------");

		String linhaDoTabuleiro = " ";
		char letraDaLinha = 65;
		for (int linha = 0; linha < tabuleiro.length; linha++) {
			System.out.print("        " + (letraDaLinha++) + " ");
			for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
				if (tabuleiro[linha][coluna] == 0) {
					System.out.print("|   "); // Água
				} else if (tabuleiro[linha][coluna] == -1) {
					System.out.print("| O "); // Errou
				} else if (tabuleiro[linha][coluna] == 1) {
					System.out.print("| X "); // Acertou
				} else if (tabuleiro[linha][coluna] == 2) {
					System.out.print("|   "); // Barco 2P
				} else if (tabuleiro[linha][coluna] == 3) {
					System.out.print("|   "); // Barco 3P
				} else if (tabuleiro[linha][coluna] == 4) {
					System.out.print("|   "); // Barco 4P
				}
			}
			System.out.println("| \n        -----------------------------------");
		}
		System.out.println("-----===X===----------===X===----------===X===-----");
	}

	// MÉTODO GERARNAVIOS: Cria aleatóriamente 5 navios.
	// Ele gera 5 navios aleatórios, atribui sua pontuação e ao tabuleiro.
	public void gerarNavios(int nav, int x, int y) {
		Random rand = new Random();
		// Gerar dois navios de 2 pontos:
		while (nav != 2) {
			x = rand.nextInt(8);
			y = rand.nextInt(8);
			if (((x >= 0) || (x <= 7) || (y >= 0) || (y <= 7)) && (tabuleiro[x][y] == 0)) {
				navios2P[x][y] = 2;
				tabuleiro[x][y] = 2;
				nav++;
			}
		}
		nav = 0;
		// Gerar dois navios de 3 pontos:
		while (nav != 2) {
			x = rand.nextInt(8);
			y = rand.nextInt(8);
			if (((x >= 0) || (x <= 7) || (y >= 0) || (y <= 7)) && (tabuleiro[x][y] == 0)) {
				navios3P[x][y] = 3;
				tabuleiro[x][y] = 3;
				nav++;
			}
		}
		nav = 0;
		// Gerar um navio de 4 pontos:
		while (nav != 1) {
			x = rand.nextInt(8);
			y = rand.nextInt(8);
			if (((x >= 0) || (x <= 7) || (y >= 0) || (y <= 7)) && (tabuleiro[x][y] == 0)) {
				navios4P[x][y] = 4;
				tabuleiro[x][y] = 4;
				nav++;
			}
		}
	}

	// MÉTODO ATIRARBOMBA: O jogador realiza aonde deseja atirar.
	// O jogador escolhe aonde deseja atirar, qual linha e qual coluna.
	public void atirarBomba() {
		Scanner ler = new Scanner(System.in);
		System.out.println("[RODADA Nº " + (rodada + 1) + "] Digite primeiro a linha e depois a coluna :D");
		do { //Loop da verificação.
			do { //Etapa 1: Linha.
				certo = false;
				tiroXstr= "A";
				tiroX= 0;
				System.out.print("[A-H] Linha: ");
				tiroXstr = ler.next();
				switch (tiroXstr) { //Converte a letra em número.
					case "A":
						tiroX = Integer.parseInt("1"); break;
					case "a":
						tiroX = Integer.parseInt("1"); break;
					case "B":
						tiroX = Integer.parseInt("2"); break;
					case "b":
						tiroX = Integer.parseInt("2"); break;
					case "C":
						tiroX = Integer.parseInt("3"); break;
					case "c":
						tiroX = Integer.parseInt("3"); break;
					case "D":
						tiroX = Integer.parseInt("4"); break;
					case "d":
						tiroX = Integer.parseInt("4"); break;
					case "E":
						tiroX = Integer.parseInt("5"); break;
					case "e":
						tiroX = Integer.parseInt("5"); break;
					case "F":
						tiroX = Integer.parseInt("6"); break;
					case "f":
						tiroX = Integer.parseInt("6"); break;
					case "G":
						tiroX = Integer.parseInt("7"); break;
					case "g":
						tiroX = Integer.parseInt("7"); break;
					case "H":
						tiroX = Integer.parseInt("8"); break;
					case "h":
						tiroX = Integer.parseInt("8"); break;
					default:
				}tiroX--;
				if (tiroX < 0 || tiroX > 7) {
					System.out.println("[ERRO] A letra da linha tem que ser entre A até H.");
				} else
					certo = true;
			} while (certo != true); // Verifica linha.
			do { //Etapa 2: Coluna.
				certo = false;
				tiroYstr= "1";
				tiroY= 0;
				System.out.print("[1-8] Coluna: ");
				tiroYstr = ler.next();
				switch (tiroYstr) {
					case "1":
						tiroY = Integer.parseInt("1"); break;
					case "2":
						tiroY = Integer.parseInt("2"); break;
					case "3":
						tiroY = Integer.parseInt("3"); break;
					case "4":
						tiroY = Integer.parseInt("4"); break;
					case "5":
						tiroY = Integer.parseInt("5"); break;
					case "6":
						tiroY = Integer.parseInt("6"); break;
					case "7":
						tiroY = Integer.parseInt("7"); break;
					case "8":
						tiroY = Integer.parseInt("8"); break;
					default:
				}tiroY--;
				if (tiroY < 0 || tiroY > 7) {
					System.out.println("[ERRO] O número da coluna tem que ser entre 1 até 8.");
				} else
					certo = true;
			} while (certo != true); // Verifica coluna.
			certo = false; //Etapa 3: Verificar.
			if (tabuleiro[tiroX][tiroY] == 0 || tabuleiro[tiroX][tiroY] == 2 || tabuleiro[tiroX][tiroY] == 3
					|| tabuleiro[tiroX][tiroY] == 4) {
				certo = true;
				for (int i = 0; i < 25; ++i)
					System.out.println();
			} else
				System.out.println("[ERRO] Você já tinha atirado nesse campo, escolha outro.");
		} while (certo != true); // Verifica campo.
		rodada++;

	}

	// MÉTODO ATUALIZARRODADA: Ele atualiza, informa rodadas, pontos, acertos e
	// navios restantes.
	// Após o tiro, ele vai verificar se a pessoa acertou ou não, e dará o
	// resultado.
	public void atualizarRodada() {
		System.out.println("-----===X===--------RODADA Nº " + rodada + "--------===X===-----");
		if (tabuleiro[tiroX][tiroY] == 2 || tabuleiro[tiroX][tiroY] == 3 || tabuleiro[tiroX][tiroY] == 4) {
			tabuleiro[tiroX][tiroY] = 1;
			System.out.println(
					"[ACERTOU] O navio estava no X[" + (tiroXstr.toUpperCase()) + "] e no Y[" + (tiroY + 1) + "].");
			if (navios2P[tiroX][tiroY] == 2) {
				pontos += 2;
				System.out.println("[+2 PONTOS] Era um navio de dois pontos. Pontuação atual: " + pontos);
			} else if (navios3P[tiroX][tiroY] == 3) {
				pontos += 3;
				System.out.println("[+3 PONTOS] Era um navio de três pontos. Pontuação atual: " + pontos);
			} else if (navios4P[tiroX][tiroY] == 4) {
				pontos += 4;
				System.out.println("[+4 PONTOS] Era um navio de quatro pontos. Pontuação atual: " + pontos);
			}
			acertos = acertos + 1;
			System.out.println("[NAVIOS] Resta você acertar " + (5 - acertos) + " navios!");
		} else {
			tabuleiro[tiroX][tiroY] = -1;
			System.out.println("[ERROU] Não tinha nada além de água, tente novamente :)");
			System.out.println("[PONTOS] A sua pontuação atualmente é de: " + pontos + " pontos.");
			System.out.println("[NAVIOS] Resta você acertar " + (5 - acertos) + " navios!");
		}
	}

//FIM
}