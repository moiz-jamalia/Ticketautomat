package Ticketkauf;

public class Grid_price {

	private static String vOrt;
	private static String nOrt;
	private static String viaOrt;
	private static double price;

	public static void calcPrice() {

		vOrt = Ortschaft.GetVOrt();
		nOrt = Ortschaft.GetNOrt();
		viaOrt = Ortschaft.GetViaOrt();

		double[] coordinates = Main.selectCity(vOrt, nOrt, viaOrt);

		double streckeABX = coordinates[0] - coordinates[2];
		double streckeABY = coordinates[1] - coordinates[3];
		double streckeBCX = coordinates[2] - coordinates[4];
		double streckeBCY = coordinates[3] - coordinates[5];

		if (streckeABX < 0) {
			streckeABX = streckeABX * -1;
		} else if (streckeABY < 0) {
			streckeABY = streckeABY * -1;
		} else if (streckeBCX < 0) {
			streckeBCX = streckeBCX * -1;
		} else if (streckeBCY < 0) {
			streckeBCY = streckeBCY * -1;
		}

		double AB = Math.sqrt(streckeABX) + Math.sqrt(streckeABY);
		double BC = Math.sqrt(streckeBCX) + Math.sqrt(streckeBCY);

		double streckeAB = Math.sqrt(AB);
		double streckeBC = Math.sqrt(BC);
		double streckeABC = streckeAB + streckeBC;

		price = Math.round((streckeABC * 0.8) / 0.05) * 0.05;

		System.out.println(String.format("%1.2f", price) + " CHF");
	}

	public static double GetPrice() {
		return price;
	}
}