package com.bridgelabz.deckofcards;

import java.util.Scanner;

public class DeckOfCards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[][] players = new String[4][13];

		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] Ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		String[][] Cards = DeckOfCards.deckOfCard2DArray(suits, Ranks, players);
		System.out.println("Total Cards in Pack are 52");
		System.out.println();
		DeckOfCards.displayCards2DArrayAllCards(Cards);
		System.out.println("Enter the number of players \n");
		int maxPlayers = sc.nextInt();
		sc.close();
		System.out.println("Maximum numbers of players are    : " + maxPlayers + "\n");

		System.out.println("Players Sequence : ");
		playerSequence(maxPlayers);

	}

	private static void playerSequence(int maxPlayers) {
		for (int i = 1; i <= maxPlayers; i++) {
			System.out.println("Player" + i);
		}
	}

	public static String[][] deckOfCard2DArray(String[] suits, String[] Ranks, String[][] player) {
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 13; j++) {

				player[i][j] = (suits[i] + "-" + Ranks[j]);
			}
		}
		return player;
	}

	public static void displayCards2DArrayAllCards(String[][] cards) {
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 13; j++) {
				System.out.print(cards[i][j] + " ");
			}
			System.out.println();
		}

	}

}
