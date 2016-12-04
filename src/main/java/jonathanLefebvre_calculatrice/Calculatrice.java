package jonathanLefebvre_calculatrice;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculatrice {

	private String calcul;
	private ArrayList<Integer> pile;

	public Calculatrice() {
		this.pile = new ArrayList<Integer>();
	}

	public Calculatrice(String calcul) {
		this.pile = new ArrayList<Integer>();
		this.calcul = calcul;
		evaluer(calcul);
	}

	private int evaluer(String source) {
		Scanner sc = new Scanner(source);
		sc.useDelimiter(" ");

		while (sc.hasNext()) {
			String tmp = sc.next();
			if (Character.isDigit(tmp.charAt(0)))
				pile.add(Integer.parseInt("" + tmp));
			else {
				switch (tmp) {
				case "+":
					if (pile.size() > 1) {
						int a = pile.get(pile.size() - 2);
						int b = pile.get(pile.size() - 1);
						pile.remove(pile.size() - 1);
						pile.remove(pile.size() - 1);
						pile.add(addition(a, b));
						break;
					} else
						System.err.println("Erreur dans la String passée en paramètre");
					return 1;
				case "-":
					if (pile.size() > 1) {
						int a = pile.get(pile.size() - 2);
						int b = pile.get(pile.size() - 1);
						pile.remove(pile.size() - 1);
						pile.remove(pile.size() - 1);
						pile.add(soustraction(a, b));
						break;
					} else
						System.err.println("Erreur dans la String passée en paramètre");
					return 1;
				case "*":
					if (pile.size() > 1) {
						int a = pile.get(pile.size() - 2);
						int b = pile.get(pile.size() - 1);
						pile.remove(pile.size() - 1);
						pile.remove(pile.size() - 1);
						pile.add(multiplication(a, b));
						break;
					} else
						System.err.println("Erreur dans la String passée en paramètre");
					return 1;
				case "/":
					if (pile.size() > 1) {
						int a = pile.get(pile.size() - 2);
						int b = pile.get(pile.size() - 1);
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
						System.err.println("Erreur dans la String passée en paramètre");
					return 1;
				default:
					System.err.println("Erreur dans la String passée en paramètre");
					return 1;
				}

			}

		}

		sc.close();
		if(pile.size() != 1) {
			System.err.println("Erreur dans la String passée en paramètre");
			return 1;
		}
		else
			System.out.println(pile.get(0));
		return 0;
	}

	public int addition(int a, int b) {
		return a + b;
	}

	public int soustraction(int a, int b) {
		return a - b;
	}

	public int multiplication(int a, int b) {
		return a * b;
	}

	public int division(int a, int b) {
		return a / b;
	}
}
