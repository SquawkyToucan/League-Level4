package Fraternity;

import java.util.Random;

import javax.swing.JOptionPane;

public class FraternitySororityGenerator {
	public static void main(String[] args) {
		String letters = JOptionPane.showInputDialog("How many letters do you want in your sorority/fraternity name?");
		int letras = Integer.parseInt(letters);
		String finalResult = "";
		for(int i = 0; i < letras; i++) {
			//Create a letter
			String[] greekAlphabet = {"Α", "B", "Γ", "Δ", "Ε", "Ζ", "H", "Θ", "I", "K", "M", "Λ", "N", "Ξ", "O", "P", "Π", "Σ", "T", "Y", "X", "Φ", "Ψ", "Ω"};
			int rand = new Random().nextInt(greekAlphabet.length);
			finalResult = finalResult + greekAlphabet[rand];
		}
		JOptionPane.showMessageDialog(null, "Your name is " + finalResult +".");
	}
}
