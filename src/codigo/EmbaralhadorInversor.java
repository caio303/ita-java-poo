package codigo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import codigo.interfaces.Embaralhador;

public class EmbaralhadorInversor implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		
		List<String> letras = Arrays.asList(palavra.split(""));
		Collections.reverse(letras);
		
		StringBuilder palavraInvertida = new StringBuilder();
		for (String letra : letras) {
			palavraInvertida.append(letra);
		}
		
		return palavraInvertida.toString();
	}
}
