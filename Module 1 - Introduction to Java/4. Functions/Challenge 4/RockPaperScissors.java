import java.util.Scanner;


public class RockPaperScissors {

    private Boolean userWantsToPlay = false;
    private String winner = "Computer";
    private String username = "username";
    private String userChoice;
    private String computerOption;
    private Boolean gameOver = false;
    public static void main(String[] args) {

        RockPaperScissors newGame = new RockPaperScissors();
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello there, what's your name?");
        // username is a non-static property so to access it from withing
        // a static method, you'd need to grab the instance of the class
        // and get it's username specifically. Main is a static method
        // so it's not attached to any particular instance of the class
        // RockPaperScissors, it's attached to the class itself
        // so if you say username within main, what username are you
        // referreing to, you'd need to be more specific

        newGame.username = scan.nextLine();

        System.out.println(newGame.username + ", Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");
        String answer = scan.nextLine();

        //Task 1: See if the user wants to play. 
        // take the input
        // check if the input yes, then set a variable for play game to true
        // else keep it at false
        // if user says yes
        // say ok, my turn, have computer return value
        // have method for taking userInput
        // have method for computerInput
        // then say your turn
        // have user input value
        // compare values
        // if winner: winner is when values are not the same
        // have variable for computer input
        // have variable for user input
        // have method for returning winner
        // print out winner
        // if draw, repeat
        newGame.seeIfUserWantsToPlay(answer);

        // if user wants to play
        // while game not over
        // keep asking for input

    /*Task 2: Set up the game
    

       • if the answer is yes: 
             – print: Great!
             – print: rock - paper - scissors, shoot!
             – pick up user's choice.
             – get the computer choice (can only be done after task 3).
             – get the result (can only be done after task 4)
             – print everything (can only be done after task 5).

       • else:
             – print: Darn, some other time...!        
    */
        if(newGame.userWantsToPlay){
            System.out.println("Great!");
            newGame.play(scan);
            newGame.printWinner();
        } else {
            System.out.println("Darn, some other time...!");
        }
        
              

        scan.close();
    }

    private void seeIfUserWantsToPlay(String answer) {
        if(answer.startsWith("y") || answer.startsWith("Y")) {
            userWantsToPlay = true;
        }
    }

    private void getUserChoice(Scanner scanner){
        System.out.println("Ok, your turn, rock - paper - scissors, shoot!\n");
        userChoice = scanner.nextLine();
    }


    //Task 3  – Write a function where the computer picks a random choice.

    /**
     * Function name: computerChoice - picks randomly between rock paper and scissors
     * @return a choice (String).
     * 
     * Inside the function:
     *   1. Picks a random number between 0 and 2.
     *   2. if 0: returns the choice 'rock'
     *      if 1: returns the choice 'paper'
     *      if 2: returns the choice 'scissors'
     */
    private void computerChoice(){
        double raffle = Math.random();
        if(raffle < ((double)1/3)){
            computerOption = "rock";
            return;
        } else if (raffle < ((double)2/3)){
            computerOption = "paper";
            return;
        } else {
            computerOption = "scissors";
            return;
        }
    }



    //Task 4  – Write a function that compares the choices and returns the result.

    /**
     * Function name: result - It returns the result of the game.
     *  @param yourChoice (String)
     *  @param computerChoice (String) 
     *  @return result (String) 

     * Inside the function:
     *   
     *   1. result is "You win!" if:
     *
     *       You: "rock"      Computer: "scissors"
     *       You: "paper"     Computer: "rock"
     *       You: "scissors"  Computer: "paper"
     *
     *   2. result is "You lose" if:
     * 
     *       Computer: "rock"      You: "scissors"
     *       Computer: "paper"     You: "rock"
     *       Computer: "scissors"  You: "paper"
     *
     *   3. Otherwise, the result is "You lose!":
     * 
     * 
     *   4. Otherwise, print "INVALID CHOICE" and exit the program.
     *
     *
     */

    private void play(Scanner scanner) {
        while(!gameOver){
            computerChoice();
            getUserChoice(scanner);
            printResult();
            winnerFound(scanner);
        }
    }
 
     //Task 5  – Write a function that prints your choice, the computer's, and the result.

    /**
     * Name: printResult - It prints everything (your choice, computer choice, result)
     * @param yourChoice (String)
     * @param computerChoice (String)
     * @param result (String)
     * 
     * Inside the function:
     * 
     *  1. prints everything:
     *      – prints: You chose:          <your choice>
     *      – prints: The computer chose: <computer choice>
     *      – prints: <result>
     */
    private void printResult(){
        System.out.println("You chose: " + userChoice);
        System.out.println("The computer chose: " + computerOption);
    }

    private Boolean winnerFound(Scanner scanner){
        if(!userChoice.equals(computerOption)){
            gameOver = true;
            if(userChoice.equals("rock")){
                winner = computerOption.equals("scissors") ? username : "Computer";
            } else if(userChoice.equals("paper")){
                winner = computerOption.equals("rock") ? username : "Computer";
            } else if(userChoice.equals("scissors")) {
                winner = computerOption.equals("paper") ? username : "Computer";
            } else {
                System.out.println("Invalid option, lets try again!");
                gameOver = false;
            }
        }
        return gameOver;
    }

    private void printWinner(){
        System.out.println("Game over!");
        System.out.println((winner.equals("Computer") ? winner : "You" ) + " won!" + (winner.equals("Computer") ? "" : "Congratulations!") );
    }

}
