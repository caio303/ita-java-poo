package codigo;

import codigo.interfaces.Embaralhador;

public class FabricaEmbaralhadores {

	private final static Embaralhador[] embaralhadores = new Embaralhador[] { new EmbaralhadorAleatorio(), new EmbaralhadorInversor() };
	
	public static Embaralhador sortearEmbaralhador() {
		int aleatorio = (int) Math.floor(Math.random() * embaralhadores.length);
		
		return embaralhadores[aleatorio];
	}
	
}
