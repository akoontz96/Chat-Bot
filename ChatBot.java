package chatBot;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChatBot {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String user = "";

		// Asking first question with a Yes/No response
		System.out.println("Do you like to play video games?");
		user = input.nextLine().toUpperCase();
		// System.out.println(user);
		if (user.equals("YES")) {
			System.out.println("What do you like about video games?");
			user = input.nextLine();
			reply(user);
		} else {
			System.out.println("Why do you not like video games?");
			user = input.nextLine();
			reply(user);
		}
	}

	// Generating a reply to the user
	public static void reply(String user) {
		Scanner input = new Scanner(System.in);

		String temp = " ";

		// Making random integer for generic answers
		Random rand = new Random();
		int generic = 0;

		// Creating 2D array with keywords and corresponding responses
		String response[][] = new String[11][2];
		response[0][0] = "fun";
		response[0][1] = "Why are they fun?";
		response[1][0] = "challenging";
		response[1][1] = "What makes them challenging?";
		response[2][0] = "friends";
		response[2][1] = "How many friends do you play with?";
		response[3][0] = "boring";
		response[3][1] = "How are them boring?";
		response[4][0] = "time";
		response[4][1] = "Why do you not have more time?";
		response[5][0] = "game";
		response[5][1] = "What is so special about that game?";
		response[6][0] = "multiplayer";
		response[6][1] = "Are you better than the others players?";
		response[7][0] = "no";
		response[7][1] = "Why not?";
		response[8][0] = "like";
		response[8][1] = "Why do you like that?";
		response[9][0] = "because";
		response[9][1] = "Could you elaborate?";
		response[10][0] = "everything";
		response[10][1] = "Could you be more specific?";

		// String Tokenizers for taking apart answers
		StringTokenizer st = new StringTokenizer(user);
		StringTokenizer st2 = new StringTokenizer(user);

		// Checking to see if it matches a predetermined keyword
		while (st.hasMoreTokens()) {
			temp = st.nextToken();
			for (int i = 0; i < 11; i++) {
				if (temp.equals(response[i][0])) {
					System.out.println(response[i][1]);
					user = input.nextLine();
					reply(user);
				}
			}
		}

		// If no keyword is found, checks for "I am" and then gives a generic
		// response
		while (st2.hasMoreTokens()) {
			if (st2.nextToken().equals("I")) {
				if (st2.nextToken().equals("am")) {
					System.out.print("You are");
					while (st2.hasMoreTokens()) {
						System.out.print(" " + st2.nextToken());
					}
					System.out.print("? Why?\n");
				}
			} else {
				generic = rand.nextInt(4);
				switch (generic) {
				case 0:
					System.out.println("Tell me more about it.");
					user = input.nextLine();
					reply(user);
					break;
				case 1:
					System.out.println("What did you say?");
					user = input.nextLine();
					reply(user);
					break;
				case 2:
					System.out.println("What makes you think that?");
					user = input.nextLine();
					reply(user);
					break;
				case 3:
					System.out.println("Could you be more specific?");
					user = input.nextLine();
					reply(user);
					break;
				}
			}
		}
	}
}