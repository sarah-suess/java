import java.util.Random;
/**
* Represents a defender that is a soccer player.
* @author ssuess3
* @version 11.0.16.1
*/
public class Defender extends SoccerPlayer {
    private int totalPasses;
    private int totalPassesCompleted;
    private double defenseRating;

    /**
    * Used to create a Defender.
    * @param n the defender's name
    * @param c the defender's country
    * @param s the defender's starting stamina
    * @param tp the defender's total number of passes
    * @param complete the defender's total number of complete passes
    * @param dr the defender's rating
    */
    public Defender(String n, String c, int s, int tp, int complete, double dr) {
        super(n, c, s);
        if (complete > tp) {
            totalPassesCompleted = tp;
        } else {
            totalPassesCompleted = complete;
        }

        totalPasses = tp;
        defenseRating = dr;
    }

    /**
    * determines the rating of a player based on their statistics.
    * @return the rating of an defender
    */
    public double calculateRating() {
        double rating;
        if (totalPasses == 0) {
            rating = 0;
            return rating;
        } else {
            rating = (((double) totalPassesCompleted) / totalPasses) * 100;
            return rating;
        }
    }

    /**
    * represents a player playing a game.
    */
    public void play() {
        Random rand = new Random();
        int decrease = rand.nextInt(100) + 1;  // check if 1 to 100 inclusive
        int stamina = getStamina();
        stamina = stamina - decrease;
        if (stamina <= 0) {
            setStamina(0);
        } else {
            setStamina(stamina);
        }

        int passes = rand.nextInt(100) + 1;
        int completePasses;

        int chance = rand.nextInt(10);
        if (chance == 0) {
            completePasses = passes;
        } else {
            completePasses = rand.nextInt(passes + 1);
        }
        if (getStamina() == 0) {
            completePasses = 0;
        }

        totalPasses = totalPasses + passes;
        totalPassesCompleted = totalPassesCompleted + completePasses;
        defenseRating = calculateRating();
    }

    /**
    * Overrides Object and SoccerPlayer's toString() methods.
    * @return a string that prints when a defender is needed to print.
    */
    public String toString() {
        return super.toString() + ". As a Defender, I have completed " + totalPassesCompleted + " passes from "
            + totalPasses + " initiated passes and my rating is " + String.format("%.2f", defenseRating);
    }

    /**
    * Overrides Object and SoccerPlayer's equals() methods.
    * @param o an object that is being compared to a defender
    * @return returns true is the objects are equal
    */
    public boolean equals(Object o) {
        if (!(o instanceof Defender)) {
            return false;
        }

        if (super.equals(o)) {
            Defender d;
            d = (Defender) o;
            return ((d.totalPasses == totalPasses) && (d.totalPassesCompleted == totalPassesCompleted)
                && (d.defenseRating == defenseRating));
        } else {
            return false;
        }
    }

}