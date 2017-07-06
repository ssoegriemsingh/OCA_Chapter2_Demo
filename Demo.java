// Imports:
import java.util.*;

// Start of class
public class Demo
{
	// Global vars:
	static String playername;
	int dealerHand = 0;
	int playerHand = 0;
	int hit = 0;
	
	Random r = new Random();
	Scanner scanner = new Scanner(System.in);
	
	// Main:
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			playername = "Player One";
		}
		else
		{
			playername = args[0];
		}

		Demo d = new Demo();
	}
	
	// Constructor:
	public Demo()
	{
		Greeting();
		Startgame();
	}
	
	// Function to display a greeting:
	public void Greeting()
	{
		String greeting = playername + ", lets play Black Jack!";
		System.out.println(greeting);
	}
	
	// Function to start the game:
	public void Startgame()
	{
		DealDealer();
		Showing();
		DealPlayer();
		CalcWinner();
	}
	
	// Function to deal to dealer and show:
	public void DealDealer()
	{
		dealerHand += r.nextInt(13) + 1;
		
		while(dealerHand < 21)
		{
			System.out.println("Debug 1 - Dealer hand: " + dealerHand);
			
			hit = r.nextInt(13) + 1;
			dealerHand += hit;
			
			System.out.println("Debug 2 - Hit: " + hit);
		}
		
		if (dealerHand > 21)
		{
			dealerHand -= hit;
		}
	}
	
	public void Showing()
	{
		int showing = dealerHand % 10;
		System.out.println("Dealer is showing: " + showing);
	}
	
	// Function to deal to player:
	public void DealPlayer()
	{
		playerHand += r.nextInt(13) + 1;
		System.out.println(playername + " has: " + playerHand);
		
		if(playerHand > 21)
		{
			System.out.println(playerHand + " BUSTED!");
		}
		else
		{
			HitOrStand();
		}
	}
	
	// Function to hit or stand:
	public void HitOrStand()
	{
		System.out.println("Hit (h) or Stand (s)?");
		String input = scanner.next();
		
		if(input.equals("h"))
		{
			DealPlayer();
		}
		else if(input.equals("s"))
		{
			DealDealer();
		}
		else
		{
			System.out.println("Please enter a valid command.");
			HitOrStand();
		}
	}
	
	public void CalcWinner()
	{
		System.out.println("Dealer has: " + dealerHand);
		System.out.println("Player has: " + playerHand);
		
		if (playerHand > 21)
		{
			System.out.println("To bad, you lost!");
		}
		else if(playerHand > dealerHand)
		{
			System.out.println("Congratulations, you've won!");
		}
		else
		{
			System.out.println("To bad, you lost!");
		}
	}
}