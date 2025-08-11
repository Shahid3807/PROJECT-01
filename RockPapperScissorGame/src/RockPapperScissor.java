import java.util.Random;
//backend
public class RockPapperScissor {
    //all of these choices computer can choose
    private static final String[] computerChoices= {"Rock","Papper","Scissors"};

    //store the computer choice so that we can retrive the value and display it to the frontend
    private String computerChoice;


    //store the scores so that we can retrive the value and display it to the frontend
    private int playerScore,computerScore;


    public String getComputerChoice() {
        return computerChoice;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    //generate a random choice for the computer
    private Random random;

    //constructor-to initialize random object
    public RockPapperScissor(){
        random= new Random();
    }

    //call this method to being playing rock papper scissor
    //playerchoise- the choice of player
    //this maethod return the result of the game
    public String playRockPapperScissor(String playerChoice)
    {
        //generate computer choice
        computerChoice =computerChoices[random.nextInt(computerChoices.length)];

        //will conatin the result of the game
        String result;

        //evaluate the winner
        if(computerChoice.equals("Rock"))
        {
            if(playerChoice.equals("Papper"))
            {
                result= "Player wins";
                playerScore++;
            }
            else if(playerChoice.equals("Scissors"))
            {
                result="Computer wins";
                computerScore++;
            }
            else{
                result="Draw";
            }
        }else  if(computerChoice.equals("Papper"))
        {
            if(playerChoice.equals("Scissors"))
            {
                result= "Player wins";
                playerScore++;
            }
            else if(playerChoice.equals("Rock"))
            {
                result="Computer wins";
                computerScore++;
            }
            else{
                result="Draw";
            }
        }
        else
        {
            //computer chooce scissor
            if(playerChoice.equals("Rock"))
            {
                result= "Player wins";
                playerScore++;
            }
            else if(playerChoice.equals("Papper"))
            {
                result="Computer wins";
                computerScore++;
            }
            else{
                result="Draw";
            }
        }
        return result;
    }
}
