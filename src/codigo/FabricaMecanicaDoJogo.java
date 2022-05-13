package codigo;

import codigo.interfaces.MecanicaDoJogo;
import codigo.mecanicas_de_jogo.CincoTentativas;
import codigo.mecanicas_de_jogo.TresTentativas;

public class FabricaMecanicaDoJogo {
	
private final static MecanicaDoJogo[] mecanicasDoJogo = new MecanicaDoJogo[] { new TresTentativas(), new CincoTentativas() };
	
	public MecanicaDoJogo sortearMecanicaDoJogo() {
		int aleatorio = (int) Math.floor(Math.random() * mecanicasDoJogo.length);
		
		return mecanicasDoJogo[aleatorio];
	}
	
}
