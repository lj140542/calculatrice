package jonathanLefebvre_calculatrice;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Calculatrice {

	private String calcul;
	private ArrayList<Double> pile;

	public Calculatrice() {
		this.pile = new ArrayList<Double>();
	}

	public Calculatrice(String calcul) {
		this.pile = new ArrayList<Double>();
		this.calcul = calcul;
		evaluer(calcul);
	}

	private double evaluer(String source) {
		Scanner sc = new Scanner(source);
		sc.useDelimiter(" ");

		while (sc.hasNext()) {
			String tmp = sc.next();
			if (Character.isDigit(tmp.charAt(0)))
				pile.add(Double.parseDouble("" + tmp));
			else
				calcul(tmp);
			// System.out.println(this);
		}

		sc.close();
		if (pile.size() != 1) {
			System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		} else
			System.out.println(pile.get(0));
		return 0;
	}

	public double calcul(String tmp) {
		switch (tmp) {
		case "+":
			if (pile.size() > 1) {
				double a = pile.get(pile.size() - 2);
				double b = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(addition(a, b));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "-":
			if (pile.size() > 1) {
				double a = pile.get(pile.size() - 2);
				double b = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(soustraction(a, b));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "*":
			if (pile.size() > 1) {
				double a = pile.get(pile.size() - 2);
				double b = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(multiplication(a, b));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "/":
			if (pile.size() > 1) {
				double a = pile.get(pile.size() - 2);
				double b = pile.get(pile.size() - 1);
				if (b != 0) {
					pile.remove(pile.size() - 1);
					pile.remove(pile.size() - 1);
					pile.add(division(a, b));
					break;
				} else {
					System.err.println("Erreur division par 0");
					return 2;
				}
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "sqrt":
			if (pile.size() > 0) {
				double a = pile.get(pile.size() - 1);
				if (a >= 0) {
					pile.remove(pile.size() - 1);
					pile.add(racine(a));
					break;
				} else {
					System.err.println("Erreur racine de nombre negatif");
					return 2;
				}
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "carré":
			if (pile.size() > 0) {
				double a = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(carre(a));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "sin":
			if (pile.size() > 0) {
				double a = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(sin(a));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "cos":
			if (pile.size() > 0) {
				double a = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(cos(a));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "inv":
			if (pile.size() > 0) {
				double a = pile.get(pile.size() - 1);
				if (a != 0) {
					pile.remove(pile.size() - 1);
					pile.add(inv(a));
					break;
				} else {
					System.err.println("Erreur division par 0");
					return 2;
				}
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "opp":
			if (pile.size() > 0) {
				double a = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(opp(a));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "puiss":
			if (pile.size() > 1) {
				double a = pile.get(pile.size() - 2);
				double b = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(puiss(a, b));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		case "!":
			if (pile.size() > 0) {
				double a = pile.get(pile.size() - 1);
				pile.remove(pile.size() - 1);
				pile.add(gamma(a));
				break;
			} else
				System.err.println("Erreur dans le nombre de paramètre");
			return 1;
		default:
			System.err.println("Erreur operateur non reconnu");
			return 1;
		}
		return 1;
	}

	public double addition(double a, double b) {
		return a + b;
	}

	public double soustraction(double a, double b) {
		return a - b;
	}

	public double multiplication(double a, double b) {
		return a * b;
	}

	public double division(double a, double b) {
		return a / b;
	}

	public double racine(double a) {
		return Math.sqrt(a);
	}

	public double carre(double a) {
		return a * a;
	}

	public double sin(double a) {
		return Math.sin(a);
	}

	public double cos(double a) {
		return Math.cos(a);
	}

	public double inv(double a) {
		return 1 / a;
	}

	public double opp(double a) {
		return a * (-1);
	}

	public double puiss(double a, double b) {
		if (b > 0) {
			double tmp = a;
			for (double cpt = 1; cpt < b; cpt++)
				tmp = tmp * a;
			return tmp;
		} else if (b == 0)
			return 1;
		else
			return inv(puiss(a, opp(b)));
	}
	
	public double gamma(double a) {
		return Gamma.gamma(a);
	}

	public double sommet() {
		return pile.get(pile.size() - 1);
	}

	public String toString() {
		return "Etat de la pile : " + pile.toString();
	}
}
