import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Creates scanner for game


       int playAgain = 1;

        while(playAgain == 1){
            System.out.println("Welcome! Ready to guess a secret number? You get 3 tries :O");
            System.out.println("Guess a number 1-10");
            int target =(int)(Math.random()*10) +1;
            int winner = 0;
            int guessCount = 1;
            int guess = scanner.nextInt();

            while(guessCount < 3){
                guessCount++;
                if(guess > 10 || guess < 1 ){
                    System.out.println("The number you entered (" + guess + ") is not a valid guess. Please guess within the range of 1-10.");  //ensures user guesses within 1-10 and if they do not guess within the range, their guess doesn't count as one of the 3 guesses
                    guess = scanner.nextInt();
                    guessCount--;
                } else if(guess == target){
                    winner = 1;
                    break;
                } else if(guess > target){
                    System.out.println("Your guess is too high! Try again with a smaller number."); //gives player a hint if guess is too high
                    guess = scanner.nextInt();

                } else if(guess < target){
                    System.out.println("Your guess is too small! Guess a bigger number."); //gives player hint if guess was too small
                    guess = scanner.nextInt();
                }
            }
            if(guess == target) winner = 1;
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

            playAgain++;
        }

        scanner.close();

    }


}
