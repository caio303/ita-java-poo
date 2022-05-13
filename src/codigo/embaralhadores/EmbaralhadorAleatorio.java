package codigo.embaralhadores;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import codigo.interfaces.Embaralhador;

public class EmbaralhadorAleatorio implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
	    
		List<String> letras = Arrays.asList(palavra.split(""));
	    Collections.shuffle(letras);
	    
	    StringBuilder palavraEmbaralhada = new StringBuilder(palavra.length());
	    for (String letra : letras) {
	    	palavraEmbaralhada.append(letra);
	    }
	    
	    return palavraEmbaralhada.toString();
	}
}
