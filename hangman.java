import java.util.Random;
import java.util.Scanner;


public class hangman extends Game {
    public char[] gameSoFar;
    public int turns;
    public String guesses;
    public String word;
    public Random rand;
    public String [] words;
    Scanner input;

    protected void initialize() {
        input = new Scanner(System.in);
        turns = 7;
        guesses = "";
        words = new String [] {
            "geography", "cat", "today", "java", "truck", "opportunity", 
            "fish", "token", "transportation", "bottom", "apple", "cake", 
            "remote", "pocket", "terminology", "arm", "cranberry", "implement", 
            "caterpillar", "fork", "watermelon", "laptop", "toe", "toad", 
            "fundamental", "capitol", "garbage", "anticipate", "apple"
        };
        
    }

    public void loadContent() {
        rand = new Random();
        word = words[rand.nextInt(27)];
        gameSoFar = new char[word.length()];
        for(int i = 0; i < word.length(); i++) {
            gameSoFar[i] = '*';
        }
        
        
    }
    public void userAction() {
        System.out.println("Whats you guess: ");
        char value = input.nextLine().charAt(0);
        boolean answer = containsChar(value);
        if(!answer) {
            turns--;
            System.out.println("Wrong Guess.  Guesses Remaining: " + turns);
        }
    }

    public void draw() {
        System.out.print("Word: ");
        for(int i = 0; i < word.length(); i++) 
            System.out.print(gameSoFar[i]);
        System.out.println(); 
    }
    public boolean evaluateState() {
        
        for(int i = 0; i < word.length(); i++){
            if(gameSoFar[i] == '*' && turns != 0)
                return true;
        }


        return false;
    }
    public boolean containsChar(char c) {
        boolean answer = false; 
        for(int i = 0;i < word.length(); i++){
            if(word.charAt(i) == (c)){
               gameSoFar[i] = c;
               answer = true;
            }
        }
        return answer;

    }
    public boolean winOrLose() {
        for(int i = 0; i < word.length(); i++) {
            if(gameSoFar[i] == '*')
                return false;
        }
        return true;
 
    }
    protected void report() {
        boolean answer = winOrLose();
        if(!answer){
            System.out.println("You Loss. \nCorrect answer: " + word);
        }
        else{
            System.out.println("You Win");
        }

        
    }
}

