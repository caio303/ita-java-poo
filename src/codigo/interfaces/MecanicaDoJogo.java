package codigo.interfaces;

public interface MecanicaDoJogo {
	
	String embaralhar(String palavraSorteadaPeloBanco) throws Exception;

	boolean tentativasAcabaram();
	
	boolean tentativaDoUsuario(String tentativaDeResposta) throws Exception;
	
	boolean isJogoFinalizado();
	
	int tentativasRestantes();
	
	Integer getPontuacao();
	
}