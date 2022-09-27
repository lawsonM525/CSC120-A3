import java.util.*;
import javax.lang.model.type.ArrayType;

class Conversation {

    public static int findIndex(String arr[], String t)
    {
      // function from https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
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
  public static boolean check(String[] arr, String toCheckValue)
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
      transcript.add("You:"+userDialog);
      
      Boolean wordIsMirrored = false; //boolean to check if any word has been mirrored fromthe user dialog
      
      String[] words = userDialog.split(" "); //splits user dialog string into array
      
      for (int j =0; j<words.length; i++){
        
        if (check(mirrorWordsIn, words[j])){
          words[j] =mirrorWordsOut[findIndex(mirrorWordsIn, words[j])];
          wordIsMirrored = true;
          System.out.println("true");
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
    System.out.println(transcript);
    input.close();
  }
}
