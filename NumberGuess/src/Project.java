import java.util.Scanner;

public class Project {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); //Creates scanner for game
        
        int guessCount = 0;
        int winner= 0;
        int target =(int)(Math.random()*10) +1;
       
        
        for(int playAgain = 1; playAgain == 1; playAgain++){
            System.out.println("Welcome! Ready to guess a secret number? You get 3 tries :O");
            System.out.println("Guess a number 1-10");
            target =(int)(Math.random()*10) +1;
            winner = 0;
            guessCount = 0;
            int guess = scanner.nextInt();
           
            while(guessCount < 2){

                if(guess > 10 || guess < 1 ){
                    System.out.println("The number you entered (" + guess + ") is not a valid guess. Please guess within the range of 1-10.");  //ensures user guesses within 1-10 and if they do not guess within the range, their guess doesn't count as one of the 3 guesses
                    guess = scanner.nextInt();
                } else if(guess == target){
                    winner = 1;
                    guessCount = 3; //ends game
                } else if(guess > target){
                    System.out.println("Your guess is too high! Try again with a smaller number."); //gives player a hint if guess is too high
                    guess = scanner.nextInt();
                    guessCount++;
                } else if(guess < target){
                    System.out.println("Your guess is too small! Guess a bigger number."); //gives player hint if guess was too small
                    guess = scanner.nextInt();
                    guessCount++;
                }
            }

            if(winner == 1){
                System.out.println("Congratulations! You guessed the secret number, " + target + ", correctly."); //checks if user won
            } else{
                System.out.println("Dang, you lost! The secret number was: " + target + " :(");
            }
    
            System.out.println("Want to quit? Type QUIT to quit. Want to keep playing? Type PLAY to keep playing.");
            String quitCue = scanner.nextLine();
            quitCue = scanner.nextLine();
            if(quitCue.equals("QUIT") || quitCue.equals("quit") || quitCue.equals("Quit")){
                playAgain = 1; //ends game. after playAgain is set to 1, the for loop iterates playAgain which will cause it to equal 2 and not be able to run the game. 
            } else if(quitCue.equals("PLAY") || quitCue.equals("play") || quitCue.equals("Play")){
                playAgain = 0; //after playAgain is set to 0, the for loop iterates playAgain which will cause it to equal 1 and run again. 
            }
        }

        scanner.close();

    }
    

}
