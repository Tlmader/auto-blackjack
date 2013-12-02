import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJack{

	private DeckOfCards myDeck;
	private Player dealer;
	private Player player;
	
	public static boolean playRound(){
		Scanner input = new Scanner(System.in);
		DealerStrategy dealerStrat = new DealerStrategy();
		AggressiveStrategy aggressive = new AggressiveStrategy();
		TimidStrategy timid = new TimidStrategy();
		Player player = new Player(aggressive);
		Player dealer = new Player(dealerStrat);
		Card newCard = new Card("", "");
		int playerRound = -1;
		int dealerRound = -1;
		int strategyChoice = 0;
		boolean unsuccessful = true;
		boolean playing = true;
		boolean playerWin = false;
		DeckOfCards myDeck = new DeckOfCards();
		while(unsuccessful){
			System.out.println("Choose a strategy:\n1. Timid\n2. Aggressive");
			try{
				strategyChoice = input.nextInt();
				if(strategyChoice == 1 || strategyChoice == 2){
					unsuccessful = false;
				}
			}
			catch(InputMismatchException ime){
				System.out.println("Please enter an integer.");
				input.next();
			}
		}
		if(strategyChoice == 1){
			player = new Player(timid);
		}
		if(strategyChoice == 2){
			player = new Player(aggressive);
		}
		while(player.takeTurn() == 1 || dealer.takeTurn() == 1){
			if(player.takeTurn() == 1){ 
				playerRound = playerRound + 1;
				System.out.println("Round " + (playerRound + 1));
				System.out.println("The player hits.");
				newCard = myDeck.dealCard();
				System.out.println("* " + newCard.toString());
				player.giveCard(newCard, playerRound);
				player.printHand(playerRound);
				if(player.getHandValue(playerRound) > 21){
					System.out.println("The player busts!");
					playing = false;
				}
				if(player.takeTurn() == 0 && playing == true){
					System.out.println("The player stands.");
					playing = false;
				}
			}	
			if(dealer.takeTurn() == 1){
				dealerRound = dealerRound + 1;
				newCard = myDeck.dealCard();
				dealer.giveCard(newCard, dealerRound);
			}
		}
		System.out.println("The player's hand: " + player.getHandValue(playerRound));
		if(player.getHandValue(playerRound) <= 21){
			System.out.println("The dealer's hand: " + dealer.getHandValue(dealerRound));
		}
		if((player.getHandValue(playerRound) > dealer.getHandValue(dealerRound) && player.getHandValue(playerRound) <= 21) || (player.getHandValue(playerRound) < dealer.getHandValue(dealerRound) && dealer.getHandValue(dealerRound) > 21 && player.getHandValue(playerRound) <= 21)){
			System.out.println("The player wins this round!");
			playerWin = true;
		}
		if(player.getHandValue(playerRound) > 21 || (dealer.getHandValue(dealerRound) <= 21 && dealer.getHandValue(dealerRound) > player.getHandValue(playerRound))){
			System.out.println("The dealer wins this round!");
		}
		if(player.getHandValue(playerRound) < 21 && player.getHandValue(playerRound) == dealer.getHandValue(dealerRound)){
			System.out.println("A tie!");
			playerWin = playRound();
		}
		return playerWin;
	}
}