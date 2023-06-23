import java.util.Scanner;
import java.util.Random;


class Oasis {

	int systemInput;
	int userInput;
	int noOfGuesses = 0;

	
	Oasis() {
		Random random = new Random();
		this.systemInput = random.nextInt(100) + 1;
	}


	
	public boolean takeUserInput() {
		if ( noOfGuesses < 10 ) {
			System.out.print("Take a guess : ");
			this.userInput = NumberGuessingGame.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Oops you finished your attempts...Best of luck for the next round\n");
			return true;
		}
	}


	
	public boolean isCorrectGuess() {

		if ( systemInput == userInput ) {
			System.out.println("HURRAY, you guessed the number " + systemInput +
			" in " + noOfGuesses + " guesses");
			switch(noOfGuesses) {
				case 1:
				System.out.println("Your score is 100");
				break;
				case 2:
				System.out.println("Your score is 90");
				break;
				case 3:
				System.out.println("Your score is 80");
				break;
				case 4:
				System.out.println("Your score is 70");
				break;
				case 5:
				System.out.println("Your score is 60");
				break;
				case 6:
				System.out.println("Your score is 50");
				break;
				case 7:
				System.out.println("Your score is 40 Better luck next time");
				break;
				case 8:
				System.out.println("Your score is 30 Better luck next time");
				break;
				case 9:
				System.out.println("Your score is 20 Better luck next time");
				break;
				case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 10 && userInput > systemInput ) {
			if ( userInput - systemInput > 10 ) {
				System.out.println("VERY HIGH");
			}
			else {
				System.out.println("A BIT HIGH");
			}
		}
		else if ( noOfGuesses < 10 && userInput < systemInput ) {
			if ( systemInput - userInput > 10 ) {
				System.out.println("VERY LOW");
			}
			else {
				System.out.println("A BIT LOW");
			}
		}
		return false;
	}
}


public class NumberGuessingGame {

	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;

		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;

				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter the value");
				flag = false;
			}
		};
		return input;
	}

	
	public static void main(String[] args) {

		
		System.out.println("1. Let's Begin \n2. Quit");
		System.out.print("Take a guess: ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;

		if ( choice == 1 ) {

			
			while ( nextRound == 1 ) {
				
				Oasis game = new Oasis();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " + ++noOfRound + " starts...");

				
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
				}
				
				System.out.println("1. Next Round \n2. End the game");
				System.out.println("Start or End : ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}