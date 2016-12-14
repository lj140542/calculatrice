package jonathanLefebvre_calculatrice;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Calculatrice {

	private String calcul;
	private ArrayList<Double> pile;
	private boolean trace = false;
	private boolean stop = false;

	public static void main(String[] args) {
		Calculatrice calc = new Calculatrice();
		try {
			calc.evaluer(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Mode interactif: ");
			calc.entree();
			System.out.println("Fin du mode interactif");
		}

	}

	public Calculatrice() {
		this.pile = new ArrayList<Double>();
	}

	private int entree() {
		Scanner sc = new Scanner(System.in);
		while (!stop) {
			String test = sc.next();
			if (Character.isDigit(test.charAt(0)))
				pile.add(Double.parseDouble("" + test));
			else
				calcul(test);
			if (trace)
				System.out.println(this);
		}

		sc.close();
		if (pile.size() != 1) {
			System.out.println(this);
			return 1;
		} else
			System.out.println("Resultat : " + pile.get(pile.size() - 1));
		return 0;
	}

	private int evaluer(String source) {
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
			System.out.println(this);
			return 1;
		} else
			System.out.println("Resultat : " + pile.get(pile.size() - 1));
		return 0;
	}

	public void calcul(String tmp) {
		if (!pile.isEmpty()) {
			switch (tmp) {
			case "+":
				if (pile.size() > 1) {
					double[] tab = gerePile(1);
					pile.add(addition(tab[0], tab[1]));
					break;
				} else {
					System.err.println("Erreur dans le nombre de paramètre");
					break;
				}
			case "-":
				if (pile.size() > 1) {
					double[] tab = gerePile(1);
					pile.add(soustraction(tab[0], tab[1]));
					break;
				} else {
					System.err.println("Erreur dans le nombre de paramètre");
					break;
				}
			case "*":
				if (pile.size() > 1) {
					double[] tab = gerePile(1);
					pile.add(multiplication(tab[0], tab[1]));
					break;
				} else {
					System.err.println("Erreur dans le nombre de paramètre");
					break;
				}
			case "/":
				if (pile.size() > 1) {
					if (sommet() != 0) {
						double[] tab = gerePile(1);
						pile.add(division(tab[0], tab[1]));
						break;
					} else {
						System.err.println("Erreur division par 0");
						break;
					}
				} else {
					System.err.println("Erreur dans le nombre de paramètre");
					break;
				}
			case "sqrt":
				if (sommet() >= 0) {
					pile.add(racine(gerePile(0)[0]));
					break;
				} else {
					System.err.println("Erreur racine de nombre negatif");
					break;
				}
			case "carré":
				pile.add(carre(gerePile(0)[0]));
				break;
			case "sin":
				pile.add(sin(gerePile(0)[0]));
				break;
			case "cos":
				pile.add(cos(gerePile(0)[0]));
				break;
			case "tan":
				pile.add(tan(gerePile(0)[0]));
				break;
			case "inv":
				if (sommet() != 0) {
					pile.add(inv(gerePile(0)[0]));
					break;
				} else {
					System.err.println("Erreur division par 0");
					break;
				}
			case "opp":
				pile.add(opp(gerePile(0)[0]));
				break;
			case "puiss":
				if (pile.size() > 1) {
					double[] tab = gerePile(1);
					pile.add(puiss(tab[0], tab[1]));
					break;
				} else {
					System.err.println("Erreur dans le nombre de paramètre");
					break;
				}
			case "!":
				pile.add(gamma(gerePile(0)[0]));
				break;
			case "trace":
				this.trace = true;
				break;
			case "notrace":
				this.trace = false;
				break;
			case "pile":
				System.out.println(this);
				break;
			case "stop":
				this.stop = true;
				break;
			default:
				System.err.println("Erreur operateur non reconnu");
				break;
			}
		} else {
			System.err.println("Erreur dans le nombre de paramètre");
		}
	}

	public double[] gerePile(int i) {
		switch (i) {
		case 0:
			double[] tab = { sommet() };
			pile.remove(pile.size() - 1);
			return tab;
		case 1:
			double[] tab2 = { pile.get(pile.size() - 2), sommet() };
			pile.remove(pile.size() - 1);
			pile.remove(pile.size() - 1);
			return tab2;
		default:
			return null;
		}
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

	public double tan(double a) {
		return Math.tan(a);
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

	public void addPile(double d) {
		this.pile.add(d);
	}

	public String toString() {
		return "Etat de la pile : " + pile.toString();
	}
}
