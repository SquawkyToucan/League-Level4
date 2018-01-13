package Anagrams;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Anagram {
	//This program solves anagrams by going through a list of words.
	//STRATEGY: Take anagram - scramble into all possible combinations
	//Go through entire list, checking each combination
	
	//Make it faster - exclude words that have letters that don't fit in the original
	//Only the same length
	//CHECK:
	//if(is same length) -> if(contains all letters) -> if(contains no letters outside of the ones) 
	//if this works then it will scramble and find if it's a match
	static String scrambled;
	static int len;
	static ArrayList<Character> unshared = new ArrayList<Character>();
	static char[] chars;
	public static void main(String[] args) {
		scrambled = JOptionPane.showInputDialog("Please enter the anagram.").toLowerCase();
		len = scrambled.length();
		chars = scrambled.toCharArray();
		char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		boolean letra = false;
		for(int i = 0; i < 26; i++) {
			letra = false;
			for(int j = 0; j < chars.length; j++) {
				if(chars[j] == letters[i]) {
					letra = true;
				}
				if(j == chars.length-1) {
					if(letra == false) {
						unshared.add(letters[i]);
					}
				}
			}
		}
		System.out.println(unshared.toString());
		JOptionPane.showMessageDialog(null, "Here is a list of the results: " + finalScramble(getAnagram()).toString());
	}
	public static ArrayList<String> getAnagram() {
		ArrayList<String> possibilities = new ArrayList<String>();
		//Create FileReader
		System.out.println("Finding possiblities... please wait");
		try {
			BufferedReader read = new BufferedReader(new FileReader(new File("/Users/league/Desktop/League-Level4/src/Anagrams/words.txt")));
			String temp = read.readLine().toLowerCase();
			int it = 0;
			while(it < 235885) {
				if(temp.length() == len) {
					//The lengths are the same
					//There's a chance for them to be anagrams so we need to check that it contains all of the correct letters
					boolean t = true;
					for(int i = 0; i < chars.length; i++) {
						if(!temp.contains(Character.toString(chars[i]))) {
							t = false;
							break;
						}
					}
					//Will turn up here IF -> missed, succeeded
					//Use boolean "t" to see if it survived
					if(t) {
						for(int i = 0; i < unshared.size(); i++) {
							if(temp.contains(Character.toString(unshared.get(i)))) {
								t = false;
								break;
							}
						}
					}
					if(t) {
						possibilities.add(temp);
					}
				}
				it++;
				temp = read.readLine().toLowerCase();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return possibilities;
	}
	public static ArrayList<String> finalScramble(ArrayList<String> stuff) {
		ArrayList<String> finalResults = new ArrayList<String>();
		//Create arrays in for loop, go through and check char to char
		if(stuff.size() == 0) {
			finalResults.add("There were no matches found in this char set.");
		}
		else if(stuff.size() == 1) {
			finalResults.add(stuff.get(0));
			System.out.println(stuff.get(0));
		}
		else {
			//There are multiple possible combinations, which is problematic - most are probably incorrect.
			System.out.println("There are multiple combos");
			for(int i = 0; i < stuff.size(); i++) {
				ArrayList<Character> letterArray = new ArrayList<Character>();
				//Convert into ArrayList<> to check against
				System.out.println(stuff.get(i).length());
				for(int j = 0; j < stuff.get(i).length(); j++) {
					System.out.println("I: " + i + " J: " + j);
					letterArray.add(stuff.get(i).toCharArray()[j]);
				}
				System.out.println(letterArray.toString());
				char[] anagram = scrambled.toCharArray();
				for(int j = 0; j < anagram.length; j++) {
					if(letterArray.contains(anagram[j])) {
						//Contains letter, remove it
						System.out.println(anagram[j]);
						letterArray.remove(new Character(anagram[j]));
						if(letterArray.size() < 1) {
							System.out.println("Adding...");
							System.out.println(stuff.get(i));
							finalResults.add(stuff.get(i));
						}
					}
					else {
						//Doesn't contain letter, break
						break;
					}
				}
			}
		}
		return finalResults;
	}
}
