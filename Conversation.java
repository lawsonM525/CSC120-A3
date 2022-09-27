import java.util.*;
import javax.lang.model.type.ArrayType;

/**  this class details a conversation between chatbot and user */
class Conversation {
  /** finds the index of an element in array */
  public static int findIndex(String arr[], String t)
  // using this function because I am unable to import org.apache.commons
  {
    // reference https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
    if (arr == null) {
        return -1;
    }
    int len = arr.length;
    int i = 0;
    while (i < len) {
        if (arr[i] == t) {
            return i;
        }
        else {
            i = i + 1;
        }
    }
    return -1;
  }
  /** method checks whether an element is within an array  */
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

  /** engages a conversation with the user */
  public static void main(String[] arguments) {

    System.out.println("How many rounds of conversation?");
    Scanner input = new Scanner(System.in);
    int rounds = input.nextInt(); //takes in integer number of conversation rounds wanted
    input.nextLine(); //skips enter key to allow next line input to be taken
    
    String[] cannedResponses = {"Oh yeah?","Mhmm...","Uh huh?","Really?", "I see.."}; //generic responses for chatbot
    ArrayList <String> transcript = new ArrayList();
    
    String firstline = "Hi! How are you today?";
    transcript.add("Bot:"+firstline);
    System.out.println(firstline); //chatbot starts off conversation

    // these arrays contain words that can be mirrored and what they should be mirrored to 
    String [] mirrorWordsIn = {"I", "me", "am", "you", "my","your","I'm", "you're"};
    String [] mirrorWordsOut = {"you","you","are","i","your","my","you're","i'm"};
    

    for (int i = 0; i < rounds; i++) {
      Boolean wordIsMirrored = false; //initializing boolean to check if any word has been mirrored fromthe user dialog

      String userDialog = input.nextLine(); //user inputs their entry
      transcript.add("You:" + userDialog); //storing input in transcript

      String[] words = userDialog.split(" "); //splitting user dialog string into seperate words
      for (int j = 0; j<words.length; i++){
        if (check(mirrorWordsIn, words[j])){
          words[j] =mirrorWordsOut[findIndex(mirrorWordsIn, words[j])];
          wordIsMirrored = true;
        }   
      }
      if (wordIsMirrored) {
        String response = "";
        for (int k=0; k<words.length; k++){
          response += words[k];
        }
        System.out.println(response+"?");
        transcript.add("Bot:"+response+"?");
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
    System.out.println(transcript); //displaying transcript at the end of conversation
    input.close();
  }
}
