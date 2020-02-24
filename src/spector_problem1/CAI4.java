import java.security.SecureRandom;
import java.util.Scanner;


public class CAI4 {

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
			    		int randomValue1 = 0;
					    int randomValue2 = 0;
				    	
					    // ask difficulty
						System.out.println("\nWhat difficulty would you like? \n1 - Single Digit  2 - Double Digit  3 - Triple Digit  4 - Four Digits\n");
						difficulty = scanner.nextInt();
					    
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
					    	
						    int answer = randomValue1 * randomValue2;
						    
					    	// ask user
						    askQuestion(randomValue1, randomValue2);
						    
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
						System.out.println("1 = Yes   0 = No: ");
						decision = scanner.nextInt();
					
						switch (decision) {
						case 0: System.exit(0);
						case 1: break;
							
						}
				    }
		
				}
			
			
			static void askQuestion(int ran1, int ran2){
	
				System.out.printf("What is %d times %d? : ", ran1, ran2);
	
			}
			
			// determine response validity
			static int readResponse() {
					
					int input = 0;
					input = scanner.nextInt();
			        
				return input;
				
			}
			
	
			// check if student answered question correcrly
			static int isAnswerCorrect(int response, int answer) {
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
