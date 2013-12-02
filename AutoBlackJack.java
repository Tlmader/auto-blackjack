/**
 * Ted Mader
 * CSCI 1583 Fall 2013
 * Homework 8
 * 12/04/2013
 **/
 
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class AutoBlackJack{

	public static void main(String[] args){
		int rounds = 0;
		int playerScore = 0;
		int dealerScore = 0;
		boolean unsuccessful = true;
		boolean playerWin = false;
		Scanner input = new Scanner(System.in);
		System.out.println("\n===BLACKJACK===");
		System.out.println("How many rounds do you wish to play?");
		while(unsuccessful){
			try{
				rounds = input.nextInt();
				unsuccessful = false;
			}
			catch(InputMismatchException ime){
				System.out.println("Please enter an integer.");
				input.next();
			}
		}
		for(int i = 1; i <= rounds; i++){
			System.out.println("\n===GAME " + i + "===");
			BlackJack game = new BlackJack();
			playerWin = BlackJack.playRound();
			if(playerWin == true){
				playerScore = playerScore + 1;
			}
			if(playerWin == false){
				dealerScore = dealerScore + 1;
			}
			System.out.println("SCORE:\nPlayer: " + playerScore + "\nDealer: " + dealerScore);
		}
	}
}