package codigo.mecanicas_de_jogo;

import codigo.FabricaEmbaralhadores;
import codigo.interfaces.Embaralhador;
import codigo.interfaces.MecanicaDoJogo;

public class TresTentativas implements MecanicaDoJogo {

	public TresTentativas() {
		this.pontuacao = 0;
		this.tentativasRestantes = 3;
		this.embaralhador = new FabricaEmbaralhadores().sortearEmbaralhador();
	}
	
	private Embaralhador embaralhador;
	
	private String palavraSorteada;
	
	private String palavraEmbaralhada;
	
	private Integer pontuacao;
	
	private Integer tentativasRestantes;
	
	private final Integer pontuacaoPorAcerto = 8;

	@Override
	public String embaralhar(String palavraSorteada) throws Exception {
		this.palavraSorteada = palavraSorteada;
		this.palavraEmbaralhada = this.embaralhador.embaralhar(palavraSorteada);
		
		return this.palavraEmbaralhada;
	}
	
	@Override
	public boolean tentativaDoUsuario(String tentativaDeResposta) throws Exception {
		if(this.palavraSorteada == null) throw new Exception("Para haver uma 'tentativaDoUsuario', é necessário ter rodado o 'embaralhar'.");
		
		if(tentativaDeResposta.equals(palavraSorteada)) {
			this.pontuacao += pontuacaoPorAcerto;
			return true;
		}
		
		tentativasRestantes--;
		return false;
	}	
	
	@Override
	public boolean isJogoFinalizado() {
		if(this.tentativasAcabaram()) return true;
		return false;
	}

	@Override
	public boolean tentativasAcabaram() {
		if(!(this.tentativasRestantes > 0)) return true;
		return false;
	}
	
	@Override
	public Integer getPontuacao() {
		return this.pontuacao;
	}
	
	@Override
	public int tentativasRestantes() {
		return this.tentativasRestantes;
	}
}
