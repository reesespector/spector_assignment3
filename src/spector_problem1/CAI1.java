import java.security.SecureRandom;
import java.util.Scanner;


public class CAI1 {

	public static Scanner scanner = new Scanner ( System.in );
	
		public static void main(String[] args) {
			
			quiz();
			
		}
		
			// program logic
			static void quiz() {
				
				// use ssecure random
				SecureRandom random = new SecureRandom();
			    byte bytes[] = new byte[20];
			    random.nextBytes(bytes);
				
			    // declare variables
			    int randomValue1 = random.nextInt(10);
			    int randomValue2 = random.nextInt(10);
			    int answer = randomValue1 * randomValue2;
			    int input = 0;
			    int flag = 0;
			    
			    	// ask user
				    askQuestion(randomValue1, randomValue2);
				    
				    // take input from user and return it
				    input = readResponse();
	
				    // check response
				    flag = isAnswerCorrect(input, answer);
				    
	
				   
				    // if incorrect - loop logic
				    if (flag == 1) {
	
					    while (flag == 1) {
					    	
						    displayIncorrectResponse();
						    
					    	// ask user
						    askQuestion(randomValue1, randomValue2);
						    
						    input = readResponse();
						    
						    // check response
						    flag = isAnswerCorrect(input, answer);
					    
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
					displayCorrectResponse();
					System.exit(0);
				}
			
				if (response != answer) {
					flag = 1;
				}
				
				return flag;
	
			}
			
	
			// print if correct
			static void displayCorrectResponse() {
				System.out.println("Very good!");
	
			}
		
			// print if not correct
			static void displayIncorrectResponse() {
				System.out.println("\nNo. Please try again.");
			}

		
}
