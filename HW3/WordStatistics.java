import java.util.Scanner;
/**
* Gathers statistics on sentences given by user input.
* @author ssuess3
* @version 11.0.16.1
*/
public class WordStatistics {
    /** stores sentences for each instance */
    private String text;

    /** stores the date for each instance */
    private String history;

    /** stores the total number of words counted for all instances */
    private static int totalWordCount = 0;

    /** stores the longest sentence length counted for all instances */
    private static int longestSentenceLength = 0;

    /**
    * Creates a WordStatistics with text and history.
    * @param t one sentence or more of text.
    * @param h the date given in this format "Published_18700101"
    */
    public WordStatistics(String t, String h) {
        text = t;
        history = h;
    }

    /**
    * Creates an array with a given amount of unique words.
    * Each array element holds the lowercase word and its frequency throughout the given text.
    * @param count is the number of unique words to add to the array.
    * @return countArr the String array of unique words and their frequencies.
    */
    public String[][] countInitWords(int count) {
        String test = this.text.toLowerCase();
        test = test.replaceAll("\\p{Punct}", "");
        String[][] countArr = new String[count][2];

        Scanner scan = new Scanner(test);
        String checker = "";
        while (scan.hasNext()) {
            String word = scan.next();
            for (int i = 0; i < countArr.length; i++) {
                if (countArr[i][0] == null && !(checker.contains(word))) {
                    countArr[i][0] = word;
                    countArr[i][1] = "0";
                    checker = checker.concat(word);
                }
            }
        }

        scan = new Scanner(test);
        while (scan.hasNext()) {
            String word = scan.next();
            for (int i = 0; i < countArr.length; i++) {
                if (countArr[i][0].equals(word)) {
                    countArr[i][1] = String.valueOf(Integer.valueOf(countArr[i][1]) + 1);
                }
            }
        }

        int total = 0;
        for (int n = 0; n < countArr.length; n++) {
            total += Integer.valueOf(countArr[n][1]);
        }

        if (this.totalWordCount < total) {
            this.totalWordCount = total;
        }

        return countArr;
    }

    /**
    * Finds the longest sentence in the given text.
    * Updates longestSentenceLength if the length is the biggest ever passed through this method
    * Prints out the longest sentence in the given text.
    * @return the number of words in the longest sentence in the given text.
    */
    public int longestSentence() {
        String[] textArr = this.text.split("[.]");
        int total = 0;
        int numSentences = textArr.length;
        int[] totals = new int[numSentences];

        for (int i = 0; i < textArr.length; i++) {
            String sent = textArr[i];
            Scanner scan = new Scanner(sent);
            while (scan.hasNext()) {
                String word = scan.next();
                total++;
            }
            totals[i] = total;
            if (total > this.longestSentenceLength) {
                this.longestSentenceLength = total;
            }
            total = 0;
        }

        int initial = totals[0];
        int largest = 0;
        String longest = "";
        for (int i = 0; i < totals.length; i++) {
            if (totals[i] > initial) {
                largest = totals[i];
                longest = textArr[i];
                initial = largest;
            }
        }

        if (totals.length == 1) {
            longest = textArr[0];
            largest = totals[0];
        }
        System.out.println(longest);
        return largest;
    }

    /**
    * @return the age of the given text.
    */
    public int textAge() {
        int age;
        int year = Integer.valueOf(this.history.substring(10, 14));
        age = 2022 - year + 1;
        return age;
    }
}