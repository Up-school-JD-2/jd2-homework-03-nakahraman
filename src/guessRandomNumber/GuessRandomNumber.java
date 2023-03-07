package guessRandomNumber;
import java.util.Random;
import java.util.Scanner;

public class GuessRandomNumber {
    static Scanner scan;
    final int columns = 2;
    int rows;
    int[][] players;

    GuessRandomNumber(int rows){
        this.rows = rows;
        this.players = new int[rows][columns];
    }
    public static void main(String[] args) {
        System.out.println("How many players: ");
        scan = new Scanner(System.in);
        isValidNumber();
        int playerNumber = scan.nextInt();

        GuessRandomNumber guessRandomNumber = new GuessRandomNumber(playerNumber);
        guessRandomNumber.guessNumber();
    }

    void guessNumber(){
        boolean nextGame = false;
        int randomNumber, guessedNumber, attempt;
        Random random = new Random();
        scan = new Scanner(System.in);

        for (int i = 0; i < rows; i++) {

            attempt = 0;

            if(nextGame) {
                i = 0;
                nextGame = false;
            }

            for (int j = 0; j+1 < columns; j++) {

                randomNumber = random.nextInt(100) + 1;
                System.out.println("*** Hint! The random number is: " + randomNumber + " ****");
                System.out.print("Player #" + (i + 1) + " make a guess with numbers between 1 and 100: ");

                do {

                    attempt++;

                    isValidNumber();

                    guessedNumber = scan.nextInt();

                    if(guessedNumber > randomNumber){
                        System.out.println("Too high, try again!");

                    }else if(guessedNumber < randomNumber){
                        System.out.println("Too low, try again!");

                    }else{
                        System.out.println("Voila! Player #" + (i +1) + " made the right guess!");
                        System.out.println();
                        players[i][j] = i + 1;
                        players[i][j+1] = attempt;
                    }
                } while (guessedNumber != randomNumber);
            }

            if(i == rows - 1) {
                nextGame = playAgain();
                if(nextGame)
                    i = 0;
            }
        }
    }

    boolean playAgain(){
        int j = 0;
        for (int i = 0; i < rows; i++) {
            System.out.println("Player #" + players[i][j] + " made the right guess in " + players[i][j+1] + " attempt(s)!");
        }

        System.out.println();
        System.out.print("Do you want to have one more go? Y/N: ");
        scan = new Scanner(System.in);
        String repeat = scan.nextLine();

        if(repeat.equals("Y") || repeat.equals("y") ){
            return true;
        }else{
            System.out.println("Bye Bye!");
            return false;
        }
    }

    static void isValidNumber(){

        while (!scan.hasNextInt()){
            scan.nextLine();
            System.out.print("Please enter an integer number: ");
        }
    }
}


