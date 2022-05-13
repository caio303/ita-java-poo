package utils;

public class DesenharVida {

	public static String desenharPontosDeVida(int vidaRestante) {

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < vidaRestante; i++) {
			str.append("   _  _ ");
		}

		str.append("\n");

		for (int i = 0; i < vidaRestante; i++) {
			str.append("  ( `' )");
		}

		str.append("\n");

		for (int i = 0; i < vidaRestante; i++) {
			str.append("   `.,' ");
		}

		return str.toString();
	}
}
