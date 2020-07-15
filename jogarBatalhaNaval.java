package projeto;
import java.util.Scanner;
public class jogarBatalhaNaval {

	public static void main(String[] args) {
		iniciarBatalhaNaval BN = new iniciarBatalhaNaval();
		menuBatalhaNaval M = new menuBatalhaNaval();
		Scanner ler = new Scanner(System.in);
		
		BN.setAcertos(0);
		BN.setPontos(0);
		BN.setRodada(0);
		BN.setTiroX(0);
		BN.setTiroY(0);
		BN.setCerto(false);
			
		BN.gerarTabuleiro();
		BN.gerarNavios(0,0,0);
		M.setJogar(false);
		M.setMenu(0);
		M.menu();
		System.exit(0);
	}

}
