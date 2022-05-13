package codigo;

import java.util.Scanner;

import codigo.interfaces.MecanicaDoJogo;
import utils.DesenharVida;
import utils.LimpadorDeConsole;

public class Principal {

	private static BancoDePalavras bancoDePalavras;

	private static FabricaMecanicaDoJogo fabricaModoDeJogo = new FabricaMecanicaDoJogo();

	public static void main(String[] args) {

		if (args.length < 2 || args.length > 2) {
			System.out.println(
					"Deve ser informado o caminho do arquivo seguido de seu nome, ex: java Principal.javas C:\\\\Users\\\\user\\\\Documents file.txt");
			return;
		}
										  // dirName , fileName
		bancoDePalavras = new BancoDePalavras(args[0], args[1]);

		MecanicaDoJogo mecanica = fabricaModoDeJogo.sortearMecanicaDoJogo();

		Scanner sc = new Scanner(System.in);

		try {
			while (!mecanica.isJogoFinalizado()) {
				LimpadorDeConsole.limparConsole();

				String palavraSorteada = bancoDePalavras.retornarAleatorio();
				String palavraEmbaralhada = mecanica.embaralhar(palavraSorteada);
				String tentativa;
				System.out.println(DesenharVida.desenharPontosDeVida(mecanica.tentativasRestantes()));
				System.out.println("\nPontos: " + mecanica.getPontuacao() + " -------------------\n");
				System.out.println("A palavra é: " + palavraEmbaralhada);
				System.out.print("\nE aí, acha que é o que? ");

				tentativa = sc.next();

				if (mecanica.tentativaDoUsuario(tentativa)) {
					System.out.println("\nAcertou miserávi!");
					Thread.sleep(1000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("\nErro Interno, my bad...\n");
			sc.close();
			return;
		}

		LimpadorDeConsole.limparConsole();

		System.out.println("\n  ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗\n"
				+ " ██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗\n"
				+ " ██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝\n"
				+ " ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗\n"
				+ " ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║\n"
				+ "  ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝\n");

		System.out.println("[----====-----====----====-- Pontuação Final: " + mecanica.getPontuacao()
				+ " --====----====----====----]");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		sc.close();
		return;
	}

}
