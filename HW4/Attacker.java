import java.util.Random;
/**
* Represents an attacker that is a soccer player.
* @author ssuess3
* @version 11.0.16.1
*/
public class Attacker extends SoccerPlayer {
    private int totalGoals;
    private int totalShotsOnTarget;
    private double attackingRating;
    private CelebrationMove celebrationMove;

    /**
    * an enum to hold value's for attacker's celebration moves.
    */
    public enum CelebrationMove { DIVE, CARTWHEEL, SIUU };

    /**
    * Used to create a Attacker.
    * @param n the attacker's name
    * @param c the attacker's country
    * @param s the attacker's starting stamina
    * @param tg the attacker's total number of goals
    * @param shots the attacker's total number of shots on goal
    * @param rating the attacker's rating
    * @param move the attacker's celebration move
    */
    public Attacker(String n, String c, int s, int tg, int shots, double rating, CelebrationMove move) {
        super(n, c, s);
        if (tg > shots) {
            totalGoals = shots;
        } else {
            totalGoals = tg;
        }

        totalShotsOnTarget = shots;
        attackingRating = rating;
        celebrationMove = move;
    }

    /**
    * determines the rating of a player based on their statistics.
    * @return the rating of an attacker
    */
    public double calculateRating() {
        double rating;
        if (totalShotsOnTarget == 0) {
            rating = 0;
        } else {
            rating = (((double) totalGoals) / totalShotsOnTarget) * 100;
        }
        return rating;
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

        int shots = rand.nextInt(100) + 1;
        int goals = rand.nextInt(shots + 1);

        if (celebrationMove == CelebrationMove.SIUU) {
            goals = (int) ((goals * .1) + goals);
            if (goals > shots) {
                goals = shots;
            }
        }

        if (getStamina() == 0) {
            goals = 0;
        }

        totalGoals = totalGoals + goals;
        totalShotsOnTarget = totalShotsOnTarget + shots;
        attackingRating = calculateRating();
    }

    /**
    * Overrides Object and SoccerPlayer's toString() methods.
    * @return a string that prints when a attacker is needed to print.
    */
    public String toString() {
        return super.toString() + ". As an Attacker, I have scored " + totalGoals + " goals from "
            + totalShotsOnTarget + " shots on target and my rating is " + String.format("%.2f", attackingRating)
                + ". My celebration is " + celebrationMove;
    }

    /**
    * Overrides Object and SoccerPlayer's equals() methods.
    * @param o an object that is being compared with an attacker
    * @return returns true is the objects are equal
    */
    public boolean equals(Object o) {
        if (!(o instanceof Attacker)) {
            return false;
        }

        if (super.equals(o)) {
            Attacker a;
            a = (Attacker) o;
            return ((a.totalGoals == totalGoals) && (a.totalShotsOnTarget == totalShotsOnTarget)
                && (a.attackingRating == attackingRating) && (a.celebrationMove == celebrationMove));
        } else {
            return false;
        }
    }
}