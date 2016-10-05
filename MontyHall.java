import java.util.Scanner;

/**
*This is a MontyHall Game
*In this game you will have a choice of choosing a door in hopes of getting a car
*One of the doors containing the goat will then be revealed and you will have the option to switch
*@author Luke Ittycheria
*@version 2.0
*/

public class MontyHall
{
	public static void main(String[] args)
	{
		//welcome message
		welcome();
		game();
	
	}
	/**
	* This method greets the user with instructions of the game
	* No parameters or return values
	*/
	public static void welcome()
	{
		System.out.println("Monty Hall Game");
		System.out.println("Pick a door number first. ");
		System.out.println("You will have a chance to switch it afterwards. ");
	
	}
	
	/**
	* This method is the actual gameplay
	* The user inputs their choices for the cars
	* No parameters or return values
	*/
	public static void game()
	{
		Scanner keyboard = new Scanner(System.in);
		int car = (int) (Math.random() * 3 + 1);
		
		//testing
		System.out.println("car = " + car);
		
		System.out.print("Please choose a door (1, 2, or 3): ");
		int user_pick = keyboard.nextInt();
		//get rid of the newLine from the buffer
		keyboard.nextLine();
		
		int reveal = doorToReveal1(car, user_pick);
		
		//testing
		System.out.println("Open door #: " + reveal);
		
		//testing
		System.out.print("Do you want to switch?: ");
		String answer = keyboard.nextLine();
		
		//testing
		System.out.println("The user wants to switch " + answer);
		
		if(answer.equals("yes"))
		{
			user_pick = doorToReveal(user_pick, reveal);
		}
		
		if (car == user_pick)
			System.out.println("You win!!");
		else
			System.out.println("Sorry! You lose!!!");		
	}
	/**
	* Version 1 of the doorToReveal method
	* Returns 1, 2, 3 or -1
	* @param int c, and int u
	* @return negative 1 or i
	*/
	public static int doorToReveal(int c, int u)
	{
		for(int i = 1; i < 4; i++)
		{
			if (i != c && i != u)
			{
				return i;
			}
		}
		return -1;
	}
	/**
	* Version 2 of the doorToReveal method
	* Uses the random method to determine the car
	* @param int c and int u
	* @return returns a number from 1 to 3
	*/
	public static int doorToReveal1(int c, int u)
	{
		int r = (int)(Math.random() * 3 + 1);
		while( r == c || r == u)
		{
			r = (int)(Math.random() * 3 + 1);
		}
		return r;
		
	}
			




}