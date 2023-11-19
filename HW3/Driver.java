import java.util.Scanner;
/**
* Gathers user input and prints/run test cases from WordStatistics.
* @author ssuess3
* @version 11.0.16.1
*/
public class Driver {
    /** Main method. Used to run methods from WordStatics.
    * @param args The command line arguments.
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Set text: ");
        String textInput = scan.nextLine();
        System.out.println("Enter the initial number of words: ");
        int numWords = scan.nextInt();
        System.out.println("Word Counts:");

        WordStatistics ws = new WordStatistics(textInput, "Published_18700101");

        String[][] print = ws.countInitWords(numWords);

        for (int i = 0; i < print.length; i++) {
            System.out.println(print[i][0] + " " + print[i][1]);
        }

        System.out.print("Longest Sentence: ");
        ws.longestSentence();
        System.out.print("Age of text: ");
        System.out.print(ws.textAge());
    }
}