import java.security.SecureRandom;
import java.util.Scanner;


public class CAI5 {

	public static Scanner scanner = new Scanner ( System.in );
	
	
		public static void main(String[] args) {
			
			quiz();
			
		}
		
			// program logic
			static void quiz() {
				
				// use secure random
				SecureRandom random = new SecureRandom();
			    byte bytes[] = new byte[20];
			    random.nextBytes(bytes);
			    int flag = 0;
			    
			    	// restart for next turn
				    while (flag == 0) {
				    	
					    // declare variables for each turn
					    int input = 0;
					    int correct = 0;
					    int incorrect = 0;
					    int valid = 0;
					    int decision = 0;
					    int difficulty = 0;
			    		float randomValue1 = 0;
					    float randomValue2 = 0;
					    int mixed = 6;
					    int problemType = 0;
					    float answer = 0;
				    	
					    // ask difficulty
						System.out.println("\nWhat difficulty would you like? \n1 - Single Digit  2 - Double Digit  3 - Triple Digit  4 - Four Digits\n");
						difficulty = scanner.nextInt();
					    
					    // ask probem type
						System.out.println("\nWhat type of problems would you like? \n1 - Addition  2 - Multiplication  3 - Subscraction  4 - Division  5 - Mixed\n");
						problemType = scanner.nextInt();
						
					    	// main program
						    for (int i=0; i<10; i++) {
						    	
						    	switch (difficulty){
						    	case 1: 
								    randomValue1 = random.nextInt(10);
								    randomValue2 = random.nextInt(10);
								    break;
						    	case 2:
						    		randomValue1 = random.nextInt(100);
								    randomValue2 = random.nextInt(100);
								    break;
						    	case 3:
						    		randomValue1 = random.nextInt(1000);
								    randomValue2 = random.nextInt(1000);
								    break;
						    	case 4:
						    		randomValue1 = random.nextInt(10000);
								    randomValue2 = random.nextInt(10000);
								    break;
						    	}
						    	
						    	switch (problemType){
						    	case 1: 
								    answer = randomValue1 + randomValue2;
					    		    askQuestion(problemType, mixed, randomValue1, randomValue2);
								    break;
						    	case 2:
								    answer = randomValue1 * randomValue2;
					    		    askQuestion(problemType, mixed, randomValue1, randomValue2);
								    break;
						    	case 3:
								    answer = randomValue1 - randomValue2;
					    		    askQuestion(problemType, mixed, randomValue1, randomValue2);
								    break;
						    	case 4:
								    answer = randomValue1 / randomValue2;
					    		    askQuestion(problemType, mixed, randomValue1, randomValue2);
								    break;
						    	case 5:
						    		mixed = random.nextInt(4);
						    		
						    		// nested switch for mixed problems
						    		switch(mixed) {
						    		case 0:
						    			askQuestion(problemType, mixed, randomValue1, randomValue2);
									    answer = randomValue1 + randomValue2;				    		
						    			break;
						    		case 1:
						    		    askQuestion(problemType, mixed, randomValue1, randomValue2);
						    		    answer = randomValue1 * randomValue2;	
									    break;
						    		case 2:
						    		    askQuestion(problemType, mixed, randomValue1, randomValue2);
									    answer = randomValue1 - randomValue2;					    		
									    break;
						    		case 3:
						    		    askQuestion(problemType, mixed, randomValue1, randomValue2);
									    answer = randomValue1 / randomValue2;
									    break;
						    		
	
						    	}
						    }

						    
						    // take input from user and return it
						    input = readResponse();

						    // check response
						    valid = isAnswerCorrect(input, answer);
					    	
						    if (valid == 1) {
						    correct = correct + 1; 
						    displayCorrectResponse();
						    }
						    
						    if (valid == 2) {
						    incorrect = incorrect + 1; 
						    displayIncorrectResponse();
						    }
						    
					    	
					    	
					    }
					    
					displayCompletionMessage(correct);
					
						// ask if they'd like to try again
						System.out.println("\n\nWould you like to solve a new problem set?\n");
						System.out.println("\n1 = Yes   0 = No\n");
						decision = scanner.nextInt();
					
						switch (decision) {
						case 0: System.exit(0);
						case 1: break;
							
						}
				    }
		
				}
			
			
			static void askQuestion(int type, int mixed, float ran1, float ran2){
				
				if (mixed == 6) {
					
					if (type == 1)
					System.out.printf("What is %.1f added to %.1f? : ", ran1, ran2);
					
					if (type == 2)
					System.out.printf("What is %.1f multiplied by %.1f? : ", ran1, ran2);
					
					if (type == 3)
					System.out.printf("What is %.1f subtracted by %.1f? : ", ran1, ran2);
					
					if (type == 4)
					System.out.printf("What is %.1f divided by %.1f? : ", ran1, ran2);
					
				}
				
				if (mixed != 6) {
					
					if (mixed == 1)
					System.out.printf("What is %.1f times %.1f? : ", ran1, ran2);
					
					if (mixed == 2)
					System.out.printf("What is %.1f multiplied by %.1f? : ", ran1, ran2);
					
					if (mixed == 3)
					System.out.printf("What is %.1f subtracted by %.1f? : ", ran1, ran2);
					
					if (mixed == 4)
					System.out.printf("What is %.1f divided by %.1f? : ", ran1, ran2);
				
				}
	
			}
			
			// determine response validity
			static int readResponse() {
					
					int input = 0;
					input = scanner.nextInt();
			        
				return input;
				
			}
			
	
			// check if student answered question correcrly
			static int isAnswerCorrect(int response, float answer) {
				int flag = 0;
				
				if (response == answer) {
					flag = 1;
				}
			
				if (response != answer) {
					flag = 2;
				}
				
				return flag;
	
			}
			
	
			// print if correct
			static void displayCorrectResponse() {
				
				// correct random
				SecureRandom random = new SecureRandom();
			    byte bytes[] = new byte[20];
			    random.nextBytes(bytes);

			    int response = random.nextInt(4);
			    
			    switch (response) {
			    case 0: System.out.println("Very good!"); break;	    
			    case 1: System.out.println("Excellent!"); break;		    
			    case 2: System.out.println("Nice Work!"); break;			  
			    case 3: System.out.println("Keep up the good work!"); break;
			    }
			    
			}
		
			// print if not correct
			static void displayIncorrectResponse() {
				
				// incorrect random
				SecureRandom random = new SecureRandom();
			    byte bytes[] = new byte[20];
			    random.nextBytes(bytes);

			    int response = random.nextInt(4);
			    
			    switch (response) {
			    case 0: System.out.println("No. Please Try again."); break;
			    case 1: System.out.println("Wrong. Try once more."); break;
			    case 2: System.out.println("Don't give up!"); break;
			    case 3: System.out.println("No. Keep trying."); break;
			    }
			}

			static void displayCompletionMessage(int correct) {
				
				float score = 0;
				float wrong = correct;
										
				if (correct == 0) {
					score = 100;
				}

				score = (wrong / 10) * 100; 
				
			    
				// display average and message
				System.out.printf("Your Average is: %.1f",  score);

				if (score < 75)
				System.out.println("\nPlease ask your teacher for extra help.\n");
				if (score >= 75)
				System.out.println("\nCongratulations, you are ready to go to the next level!");
				
			}
}
