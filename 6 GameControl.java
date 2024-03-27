package simple21;

import java.util.Scanner;
import java.util.Random;

/**
 * This is a simplified version of a common card game, "21". 
 */
public class GameControl {
    
	/**
	 * Human player.
	 */
    HumanPlayer human;
    
    /**
     * Computer player.
     */
    ComputerPlayer player1;
    
    /**
     * Computer player.
     */
    ComputerPlayer player2;
    
    /**
     * Computer player.
     */
    ComputerPlayer player3;
    
    /** 
     * A random number generator to be used for returning random "cards" in a card deck.
     * */
    Random random = new Random();
      
    /**
     * The main method just creates a GameControl object and calls its run method.
     * @param args Not used.
     */
    public static void main(String args[]) {    
        new GameControl().run();
    }
    
    /**
     * Prints a welcome method, then calls methods to perform each of the following actions:
     * - Create the players (one of them a Human)
     * - Deal the initial two cards to each player
     * - Control the play of the game
     * - Print the final results
     */
    public void run() {
    	
        Scanner scanner = new Scanner(System.in);
        
        // Students: your code goes here.
        
        System.out.println("Welcome to Simple 21!");
        System.out.println("You'll play against 3 other players (computers).");
        System.out.println("Try to get as close to 21 as possible, without going over.");
        
        System.out.print("What is your name? ");
        // record the user input, and create Human
    	String humanName = scanner.next();
        // create them, and run through the game process
    	this.createPlayers(humanName);
    	this.deal();
    	this.controlPlay(scanner);
    	this.printResults();
    	
        scanner.close();
    }
    
    /**
     * Creates one human player with the given humansName, and three computer players with hard-coded names.
     * @param humansName for human player
     */
    public void createPlayers(String humanName) {
        // Students: your code goes here.
    	// create all the players, using new
    	this.human = new HumanPlayer(humanName);
    	this.player1 = new ComputerPlayer("Player 1");
    	this.player2 = new ComputerPlayer("Player 2");
    	this.player3 = new ComputerPlayer("Player 3");
       
    }
    
    /**
     * Deals two "cards" to each player, one hidden, so that only the player who gets it knows what it is, 
     * and one face up, so that everyone can see it. (Actually, what the other players see is the total 
     * of each other player's cards, not the individual cards.)
     */
    public void deal() { 
        // Students: your code goes here.
    	
    	System.out.println();
        // given the initial setup
    	int hiddenCard = this.nextCard();
    	int visibleCard = this.nextCard();
    	
    	this.human.takeHiddenCard(hiddenCard);
    	this.human.takeVisibleCard(visibleCard);
    	
        // for the computer players
    	hiddenCard = this.nextCard();
    	visibleCard = this.nextCard();
    	
    	this.player1.takeHiddenCard(hiddenCard);
    	this.player1.takeVisibleCard(visibleCard);    	
    	
    	hiddenCard = this.nextCard();
    	visibleCard = this.nextCard();
    	
    	this.player2.takeHiddenCard(hiddenCard);
    	this.player2.takeVisibleCard(visibleCard); 
    	
    	hiddenCard = this.nextCard();
    	visibleCard = this.nextCard();
    	
    	this.player3.takeHiddenCard(hiddenCard);
    	this.player3.takeVisibleCard(visibleCard); 
    }
    
    /**
     * Returns a random "card", represented by an integer between 1 and 10, inclusive. 
     * The odds of returning a 10 are four times as likely as any other value (because in an actual
     * deck of cards, 10, Jack, Queen, and King all count as 10).
     * 
     * Note: The java.util package contains a Random class, which is perfect for generating random numbers.
     * @return a random integer in the range 1 - 10.
     */
    public int nextCard() { 
    	// Students: your code goes here.
    	
        // get the random card
    	int randomInt = random.nextInt(13) + 1;
    	if (randomInt >= 11) {
    		randomInt = 10; 
    	}
    	
    	return randomInt;
    }

    /**
     * Gives each player in turn a chance to take a card, until all players have passed. Prints a message when 
     * a player passes. Once a player has passed, that player is not given another chance to take a card.
     * @param scanner to use for user input
     */
    public void controlPlay(Scanner scanner) { 
        // Students: your code goes here.
    	
        // while loop to be still in the game
    	while (!this.checkAllPlayersHavePassed()) {
    		
    		System.out.println();
    		if (!this.human.passed) {
    			if (this.human.offerCard(this.human, this.player1, this.player2, this.player3, scanner)) {
    					this.human.takeVisibleCard(this.nextCard());
    			} else {
    				System.out.println(this.human.name + " passes.");
	    		}		
	    	}
    	
    		if(!this.player1.passed) {
    			if (this.player1.offerCard(this.human, this.player1, this.player2, this.player3)) {
    				this.player1.takeVisibleCard(this.nextCard());
    			} else {
    				System.out.println(this.player1.name + " passes.");
    			}
     		}
    		
    		if(!this.player2.passed) {
    			if (this.player2.offerCard(this.human, this.player1, this.player2, this.player3)) {
    				this.player2.takeVisibleCard(this.nextCard());
    			} else {
    				System.out.println(this.player2.name + " passes.");
    			}
     		}
    		
    		if(!this.player3.passed) {
    			if (this.player3.offerCard(this.human, this.player1, this.player2, this.player3)) {
    				this.player3.takeVisibleCard(this.nextCard());
    			} else {
    				System.out.println(this.player3.name + " passes.");
    			}
     		}
    	}
    }
     
    /**
     * Checks if all players have passed.
     * @return true if all players have passed
     */
    public boolean checkAllPlayersHavePassed() {
    	// Students: your code goes here.
    	
        // use & to make sure all passed
    	return (this.human.passed &
    			this.player1.passed &
    			this.player2.passed &
    			this.player3.passed    			
    			);
    }
    
    /**
     * Prints a summary at the end of the game.
     * Displays how many points each player had, and if applicable, who won.
     */
    public void printResults() { 
        // Students: your code goes here.
    	
    	System.out.println();
    	System.out.println("Game Over.");
    	// use the total getScore
    	System.out.println(this.human.name + " has " + this.human.getScore() + " total point(s).");
    	System.out.println(this.player1.name + " has " + this.player1.getScore() + " total point(s).");
    	System.out.println(this.player2.name + " has " + this.player2.getScore() + " total point(s).");
    	System.out.println(this.player3.name + " has " + this.player3.getScore() + " total point(s).");
    	
    	this.printWinner();
    }

    /**
     * Determines who won the game, and prints the results.
     */
    public void printWinner() { 
        // Students: your code goes here.
    	// set up initial scores
    	int humanScore = this.human.getScore();
    	int player1Score = this.player1.getScore();
    	int player2Score = this.player2.getScore();
    	int player3Score = this.player3.getScore();
    	
    	int maxScore = 0; 
    	int winningPlayer = -1; 
    	boolean tie = false; 
    	
        //check each player one by one, and set maxScore / winningPlayer
    	if(humanScore <= 21) {
    		maxScore = humanScore; 
    		winningPlayer = 0;
    	}
    	
    	if(player1Score <= 21 && player1Score >= maxScore) {
    		if (player1Score == maxScore) {
    			tie = true;
    		} else {
    			maxScore = player1Score; 
    			winningPlayer = 1; 
    		}
    	}
    	
    	if(player2Score <= 21 && player2Score >= maxScore) {
    		if (player2Score == maxScore) {
    			tie = true;
    		} else {
    			maxScore = player2Score; 
    			winningPlayer = 2; 
    		}
    	}
    	
    	if(player3Score <= 21 && player3Score >= maxScore) {
    		if (player3Score == maxScore) {
    			tie = true;
    		} else {
    			maxScore = player3Score; 
    			winningPlayer = 3; 
    		}
    	}
    	
    	if (tie) {
    		System.out.println("Tie, nobody wins.");
    	} else if (winningPlayer == -1) {
    		System.out.println("Nobody wins.");
    	} else {
    		switch (winningPlayer) {
                //different prints for different cases
    			case 0:
    				System.out.println(this.human.name + " wins with " + this.human.getScore() + " point(s)!");
    				break;
    			case 1:
    				System.out.println(this.player1.name + " wins with " + this.player1.getScore() + " point(s)!");
    				break;
    			case 2:
    				System.out.println(this.player2.name + " wins with " + this.player2.getScore() + " point(s)!");
    				break;
    			case 3:
    				System.out.println(this.player3.name + " wins with " + this.player3.getScore() + " point(s)!");
    				break;    			
    		}
    	}
    }
}
