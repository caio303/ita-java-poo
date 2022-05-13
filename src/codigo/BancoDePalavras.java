package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BancoDePalavras {
	
	private List<String> lista;
	
	public BancoDePalavras(String dirName,String fileName) {
		try {
			instanciarLista(dirName,fileName);
		}catch (Exception e) {
			System.out.println("Arquivo ou diret�rio n�o existe...");
		}
	}

	
	public String retornarAleatorio() throws Exception {
		
		if(this.lista == null)
			throw new Exception("A Lista do BancoDePalavras n�o foi instanciada");
		
		int aleatorio = (int) Math.floor(Math.random() * this.lista.size());
		
		return this.lista.get(aleatorio);
	}
	
	private void instanciarLista(String dirName,String fileName) throws Exception {
		
		File dir = new File(dirName);
		
		if (!dir.exists())
			throw new Exception("Diret�rio n�o existe no caminho indicado...");

		File arq = new File(dir, fileName);

		if (!arq.exists())
			throw new Exception("Arquivo n�o existe no caminho indicado...");
		
		FileReader fileReader = new FileReader(arq);
		BufferedReader reader = new BufferedReader(fileReader);

		List<String> linhas = new ArrayList<>();
		String linha = "";
		int contadorDeLinhas = 0;
		
		while ((linha = reader.readLine()) != null && contadorDeLinhas < 20) {
			linhas.add(linha);
			contadorDeLinhas++;
		}
		
		this.lista = linhas;
		
		fileReader.close();
		reader.close();
	}
	
}
