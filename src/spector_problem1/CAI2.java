import java.security.SecureRandom;
import java.util.Scanner;


public class CAI2 {

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
			    int randomValue1 = random.nextInt(10);
			    int randomValue2 = random.nextInt(10);
			    int answer = randomValue1 * randomValue2;
			    int input = 0;
			    
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
				
				// correct random
				SecureRandom random = new SecureRandom();
			    byte bytes[] = new byte[20];
			    random.nextBytes(bytes);

			    int response = random.nextInt(4);
			    
			    switch (response) {
			    case 0: System.out.println("Very good!"); System.exit(0);			    
			    case 1: System.out.println("Excellent!"); System.exit(0);		    
			    case 2: System.out.println("Nice Work!"); System.exit(0);			  
			    case 3: System.out.println("Keep up the good work!"); System.exit(0);
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

}
