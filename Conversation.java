import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import org.apache.commons.lang.ArrayUtils;
import javax.lang.model.type.ArrayType;

class Conversation {

  private static boolean check(String[] arr, String toCheckValue)
    {
        boolean test = false;
        for (String element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
 
        return test;
    }

  public static void main(String[] arguments) {
    System.out.println("How many rounds of conversation?");
    Scanner input = new Scanner(System.in);
    int rounds = input.nextInt(); //takes in integer number of conversation rounds wanted
    input.nextLine();
    
    String[] cannedResponses = {"Oh yeah?","Mhmm...","Uh huh?","Really?", "I see.."}; //generic responses for chatbot
    ArrayList <String> transcript = new ArrayList();
    String firstline = "Hi! How are you today?";
    
    transcript.add("Bot:"+firstline);
    System.out.println(firstline); //chatbot starts off conversation
    String [] mirrorWordsIn = {"I", "me", "am", "you", "my","your","I'm", "you're"};
    String [] mirrorWordsOut = {"you","you","are","i","your","my","you're","i'm"};
    

    for (int i = 0; i < rounds; i++) {
      String userDialog = input.nextLine(); //user inputs their entry
      Boolean wordIsMirrored = false;//boolean to check if any word has been mirrored fromthe user dialog
      transcript.add("You:"+userDialog);
      String[] words = userDialog.split(" ");
      for (int j =0; j<words.length; i++){
        if (check(mirrorWordsIn, words[j])){
          words[j] =mirrorWordsOut[ArrayUtils.indexOf(mirrorWordsIn, words[j])];
          wordIsMirrored = true;
        
        }
      
          
      }
      if (wordIsMirrored) {
        String response = "";
        for (int k=0; k<words.length; k++){
          response += words[k];
        }
        System.out.println(response);
        transcript.add("Bot:"+response);
      }
      else {
        Random rand = new Random();
      int upperbound = cannedResponses.length; // generates a random value from 0 to the length of cannedResponses -1

      String response = cannedResponses[rand.nextInt(upperbound)];
      System.out.println(response);
      transcript.add("Bot:"+response);
      }
      
    }
    System.out.println("Find the transcript of this conversation below:");
    System.out.println(transcript);
    input.close();
  }
}
