package codigo;

public class Principal {

	private static BancoDePalavras bancoDePalavras;
	
	private static FabricaEmbaralhadores fabricaDeEmbalhadores;
	
	public static void main(String[] args) throws Exception {
		
		if(args.length < 2 || args.length > 2)
			throw new Exception("Deve ser informado o caminho do arquivo seguido de seu nome: java Programa [caminho_do_diretorio] [nome_do_arquivo]");

		bancoDePalavras = new BancoDePalavras(args[0], args[1]);
		
		System.out.println("\n - "+bancoDePalavras.retornarAleatorio());
	}

}
