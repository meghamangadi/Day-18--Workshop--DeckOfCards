package com.bridgelabz.deckofcards;

import java.util.Scanner;

public class DeckOfCards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[][] players = new String[4][13];
		String[][] cardCollection = new String[4][13];
		 
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] Ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		String[][] Cards = DeckOfCards.deckOfCard2DArray(suits, Ranks, players);
		System.out.println("Total Cards in Pack are 52");
		System.out.println();
		DeckOfCards.displayCards2DArrayAllCards(Cards);
		System.out.println();
		System.out.println("Enter the number of players \n");
		int maxPlayers = sc.nextInt();
		
		 if(maxPlayers > 2 && maxPlayers <= 4){
			    System.out.println("Maximum numbers of players are    : " + maxPlayers + "\n");
				System.out.println("Players Sequence : ");
				playerSequence(maxPlayers);
				System.out.println("Please Enter how many time you want to suffle");
				int numberoftimesuffle = sc.nextInt();
				
				System.out.println("Cards distributed based on players sequence");
				DeckOfCards.ShuffletheCards(numberoftimesuffle, Cards, maxPlayers); 
			 
		 }else {
			 
			 System.out.println("Invalid Number of players");
		 }
		

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

	public static void ShuffletheCards(int numberoftimes, String[][] Cards, int noPlayers) {
		int rowforfirstcard = 0;
		int columnforfirstcard = 0;
		int rowforsecondcard = 0;
		int columnforsecondcard = 0;
		String[][] newcards = new String[4][13];

		for (int i = 0; i < numberoftimes; i++) {

			rowforfirstcard = shuffletheCardsrow();
			columnforfirstcard = shuffletheCardscolumn();
			rowforsecondcard = shuffletheCardsrow();
			columnforsecondcard = shuffletheCardscolumn();
			newcards = shuffleTwoCards(rowforfirstcard, columnforfirstcard, rowforsecondcard, columnforsecondcard,
					Cards);

		}
		
		DeckOfCards.displayCards2DArray(newcards, noPlayers);
	}

	private static String[][] shuffleTwoCards(int rowforfirstcard, int columnforfirstcard, int rowforsecondcard,
			int columnforsecondcard, String[][] Cards) {

		String temp = Cards[rowforfirstcard][columnforfirstcard].toString();
		Cards[rowforfirstcard][columnforfirstcard] = Cards[rowforsecondcard][columnforsecondcard];
		Cards[rowforsecondcard][columnforsecondcard] = temp;

		return Cards;

	}
	
	
	public static void deckOfCard2DArray(String[][] cards, int noOfPlayer,int m) {
		

		System.out.println();
		int Countclubs = 0, CountDiamonds = 0, CountHearts = 0, CountSpades = 0;
		for (int i = m; i < noOfPlayer;i++) {
			 
			for (int j = 0; j < 9; j++) {
				String value =cards[i][j];
				if(value.startsWith("C")) {
				 
					 Countclubs++;
				}else if(value.startsWith("D")){
				  
					 CountDiamonds++;
				}else if(value.startsWith("H"))
						{
					 CountHearts++;
						}else if(value.startsWith("S")){
					 CountSpades++;
						}
				 }
			
			System.out.println("Clubs " +Countclubs   + "    Diamonds " + CountDiamonds+ "   Hearts " + CountHearts + "   Spades " + CountSpades );
			break;
				 
			}
		 
			System.out.println();
		}

	
		
	 

	public static void displayCards2DArray(String[][] cards, int noOfPlayer) {
		System.out.println();
		for (int i = 0; i < noOfPlayer; i++) {
			int player = i + 1;
			System.out.println("Player  :" + player);
			
			for (int j = 0; j < 9; j++) {
				 
				System.out.print(cards[i][j] + " ");
			}
			deckOfCard2DArray( cards,   noOfPlayer,i);
			
			System.out.println();
		}

	}

	public static int shuffletheCardsrow() {
		int row = (int) (Math.random() * ((3 - 0) + 1)) + 0;

		return row;

	}

	public static int shuffletheCardscolumn() {
		int column = (int) (Math.random() * ((12 - 0) + 1)) + 0;

		return column;

	}

}
