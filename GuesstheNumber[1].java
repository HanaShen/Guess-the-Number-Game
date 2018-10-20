/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessthenumber;

/**
 *
 * @author asus
 */
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuesstheNumber extends JFrame{

    /**
     * @param args the command line arguments
     */
    int min = 1;
    int max = 1000;
    int oldguess;
    private int randomnum;
    private final JLabel label1; 
    private  final JLabel highlabel;
    private final JTextField textField1;
    private final JButton button1;
    public GuesstheNumber(){
       super("Guess the number");
       setLayout(new FlowLayout());
       //set #
       Random random = new Random();
       randomnum = random.nextInt((max - min) +1) + min;
       //label
       label1 = new JLabel("I have a number between 1 and 1000. Can you guess my number?\n" +
       "Please enter your first guess.");
       add(label1);
       highlabel = new JLabel( "" );
       add(highlabel);
       //textfield user input
       textField1 = new JTextField( 5 );
       add(textField1);
       TextFieldHandler handler = new TextFieldHandler();
       textField1.addActionListener(handler);
       //jbutton
       button1 = new JButton("Play Again");
        add (button1);
        button1.setVisible(false);
        buttonHandler bhandler = new buttonHandler();
        button1.addActionListener(bhandler);
    }
    
      private class TextFieldHandler implements ActionListener{
          @Override
          public void actionPerformed(ActionEvent event){
              int guess;
              guess = Integer.parseInt(textField1.getText());
              if (guess > randomnum){
                  highlabel.setText("Too High");
                  
                }else if (guess < randomnum){
                  highlabel.setText("Too Low");}
                else {
                    textField1.setEditable(false);
                    highlabel.setText("Correct!");
                    button1.setVisible(true);
                    }
                
              //warmer   
                if (Math.abs(randomnum- guess) < Math.abs(randomnum - oldguess)){
                    if (guess == randomnum){
              getContentPane().setBackground(Color.white);}
                    else{getContentPane().setBackground(Color.red);
                  oldguess = guess;
                    }
              }
              else if (Math.abs(randomnum - guess)> Math.abs(randomnum - oldguess)){
                  if (guess == randomnum){
              getContentPane().setBackground(Color.white);}
                  else{
                  getContentPane().setBackground(Color.blue); 
                  oldguess = guess;
                  }
              }
          }
        }
      private class buttonHandler implements ActionListener{
          @Override
          public void actionPerformed(ActionEvent button_event){
             Random random = new Random();
             randomnum = random.nextInt((max - min) +1) + min;
             textField1.setEditable(true);
          }
      }
    public static void main(String[] args) {
        // TODO code application logic here
        GuesstheNumber game = new GuesstheNumber();
		game.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		game.setSize(700, 150);
		game.setVisible(true);
    }
    
}
