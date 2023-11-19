import java.util.Random;
/**
* Represents a goalkeeper that is a soccer player.
* @author ssuess3
* @version 11.0.16.1
*/
public class GoalKeeper extends SoccerPlayer {
    private int totalSaves;
    private int totalShotsOnTarget;
    private double ballHandling;

    /**
    * Used to create a Goal Keeper.
    * @param n the goal keeper's name
    * @param c the goal keeper's country
    * @param s the goal keeper's starting stamina
    * @param ts the goal keeper's total number of saves
    * @param onTarget the goal keeper's total shots on target
    * @param b the goal keeper's ball handling rating
    */
    public GoalKeeper(String n, String c, int s, int ts, int onTarget, double b) {
        super(n, c, s);
        if (ts > onTarget) {
            totalSaves = onTarget;
        } else {
            totalSaves = ts;
        }
        totalShotsOnTarget = onTarget;
        ballHandling = b;
    }

    /**
    * determines the rating of a player based on their statistics.
    * @return the rating of an goal keeper
    */
    public double calculateRating() {
        double rating;
        if (totalShotsOnTarget <= 0) {
            rating = 0;
            return rating;
        } else {
            rating = (((double) totalSaves) / totalShotsOnTarget) * 100;
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

        int shots = rand.nextInt(100) + 1;
        int saves;

        if (getStamina() == 0) {
            saves = 0;
        } else {
            saves = rand.nextInt(shots + 1);
        }

        totalSaves = totalSaves + saves;
        totalShotsOnTarget = totalShotsOnTarget + shots;
        ballHandling = calculateRating();
    }

    /**
    * Overrides Object and SoccerPlayer's toString() methods.
    * @return a string that prints when a goal keeper is needed to print.
    */
    public String toString() {
        return super.toString() + ". As a Goalkeeper, I have stopped " + totalSaves + " shots from "
            + totalShotsOnTarget + " shots on target and my rating is " + String.format("%.2f", ballHandling);
    }

    /**
    * Overrides Object and SoccerPlayer's equals() methods.
    * @param o an object that is being compared to a goal keeper.
    * @return returns true is the objects are equal
    */
    public boolean equals(Object o) {
        if (!(o instanceof GoalKeeper)) {
            return false;
        }

        if (super.equals(o)) {
            GoalKeeper g;
            g = (GoalKeeper) o;
            return ((g.totalSaves == totalSaves) && (g.totalShotsOnTarget == totalShotsOnTarget)
                && (g.ballHandling == ballHandling));
        } else {
            return false;
        }
    }
}