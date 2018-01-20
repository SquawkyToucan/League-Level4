package Words;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class WordSwap {
	/*
	 *  - Divide String of input into chars
	 *  - Create new String[] 
	 *  - At every ' ', add new string that is all of the chars before it
	 */
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, new WordSwap().swap(JOptionPane.showInputDialog("Enter a sentence or phrase")));
	}
	public String swap(String s) {
		String joined = "";
		//Transfer string into a Character[]
		char[] characters = s.toCharArray();
		String empty = "";
		for(int i = 0; i < characters.length; i++) {
			if(characters[i] == ' ' || characters[i] == ',' || characters[i] == '.' || characters[i] == '?' || characters[i] == '!') {
				System.out.println("Space detected");
				System.out.println("Current string: " + joined);
				//Divide
				if(empty.equalsIgnoreCase("you")) {
					joined = joined + "your mom" + characters[i];
				}
				else if(empty.equalsIgnoreCase("are")) {
					joined = joined + "is" + characters[i];
				}
				else if(empty.equalsIgnoreCase("your")) {
					joined = joined + "your mom's" + characters[i];
				}
				else {
					joined = joined + empty + characters[i];
				}
				System.out.println("\nString modified to " + joined + "\n");
				System.out.println("String to add reset");
				empty = "";
			}
			else if(i + 1 == characters.length) {
				//Add final word
				System.out.println("This is the final word!");
				empty = empty + Character.toString(characters[i]);
				if(empty.equalsIgnoreCase("you")) {
					joined = joined + "your mom ";
				}
				else if(empty.equalsIgnoreCase("are")) {
					joined = joined + "is ";
				}
				else if(empty.equalsIgnoreCase("your")) {
					joined = joined + "your mom's ";
				}
				else {
					joined = joined + empty + " ";
				}
				System.out.println("\nString modified to " + joined + "\n");
			}
			else {
				//Add character to empty string
				empty = empty + Character.toString(characters[i]);
				System.out.println("The String to be added is now " + empty);
			}
			System.out.println(joined);
		}
		return joined;
	}
}
