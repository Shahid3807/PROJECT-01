import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//frontend
public class RockPaperScissorGUI extends JFrame implements ActionListener{
    //player buttons
    JButton rockButton,papperButton,scissorButton;

    //will display the choice of computer
    JLabel computerChoice;

    //will display the score of computer and player
    JLabel computerScoreLabel,playerScoreLabel;

    //backend object
    RockPapperScissor rockPapperScissor;

    public RockPaperScissorGUI() {
        //invoke constructor and set title of GUI
        super("Rock Paper Scissors Game");

        //set the size of the GUI
        setSize(450,574);

        //set the layout to null to desable default layout manager, so we can absolute positioning for the elements
        setLayout(null);

        //terminate the java vertual matchine when closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //load the layout to the center evertime we run the application
        setLocationRelativeTo(null);

        //initialize the backend object
        rockPapperScissor=new RockPapperScissor();

        //add GUI components
        addGuiComponents();
    }
    private void addGuiComponents()
    {
        //create computer score label
        computerScoreLabel = new JLabel("Computer Score: 0");

        //add the computer score label to the GUI
        add(computerScoreLabel);

        //set x,y cordinates and width,height of values
        computerScoreLabel.setBounds(0,43,450,30);

        //set font to have a font family of dialog,font weight of bold and font size of 26
        computerScoreLabel.setFont(new Font("Dialog", java.awt.Font.BOLD, 26));

        //set the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //create computer choice
        computerChoice =new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog",Font.PLAIN,18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        //create player score label
        playerScoreLabel=new JLabel("Player Score:0");
        playerScoreLabel.setBounds(8,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //player buttons
        
        //rock button
        rockButton =new JButton("Rock");
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog",Font.PLAIN,18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paper button
        papperButton =new JButton("Papper");
        papperButton.setBounds(165,387,105,81);
        papperButton.setFont(new Font("Dialog",Font.PLAIN,18));
        papperButton.addActionListener(this);
        add(papperButton);

        //scissor button
        scissorButton =new JButton("Scissors");
        scissorButton.setBounds(290,387,105,81);
        scissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
        scissorButton.addActionListener(this);
        add(scissorButton);
    }

    //dialog to display the result of the match
    private void showDialog(String message)
    {
        JDialog resultDialog =new JDialog(this,"Result",true);
        resultDialog.setSize(227,124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        //message label
        JLabel resultLabel= new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel,BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton=new JButton("Try Again");
        tryAgainButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //reset computer choice
                computerChoice.setText("?");

                //close the dialog
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton,BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //get player choice
        String playerChoice=e.getActionCommand().toString();

        //play rock papper scissor and store the result into string var
        String result = rockPapperScissor.playRockPapperScissor(playerChoice);

        //load computers choice
        computerChoice.setText(rockPapperScissor.getComputerChoice());

        //update scores
        computerScoreLabel.setText("computer score:"+rockPapperScissor.getComputerScore());
        playerScoreLabel.setText("Player Score:"+rockPapperScissor.getPlayerScore());

        //display result dialog
        showDialog(result);

    }
}