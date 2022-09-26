import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

import javax.lang.model.type.ArrayType;

class Conversation {

  public static void main(String[] arguments) {
    System.out.println("How many rounds of conversation?");
    Scanner input = new Scanner(System.in);
    int rounds = input.nextInt(); //takes in integer number of conversation rounds wanted
    
    String[] cannedResponses = {"Oh yeah?","Mhmm...","Uh huh?","Really?", "I see.."}; //generic responses for chatbot
    ArrayList <String> transcript = new ArrayList();

    System.out.println("Hi! How are you today?"); //chatbot starts off conversation
    

    for (int i = 0; i < rounds; i++) {
      String userDialog = input.next(); //user inputs their entry
      Random rand = new Random();
      int upperbound = cannedResponses.length; // generates a random value from 0 to the length of cannedResponses -1

      System.out.println(cannedResponses[rand.nextInt(upperbound)]);
    }

    input.close();
  }
}
