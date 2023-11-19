/**
* Represents a SoccerPlayer. Has subclasses Attacker, GoalKeeper, and Defender.
* @author ssuess3
* @version 11.0.16.1
*/
public abstract class SoccerPlayer {
    private String name;
    private String country;
    private int stamina;

    /**
    * Used to create a SoccerPlayer.
    * @param n the soccer player's name
    * @param c the soccer player's country
    * @param s the soccer player's starting stamina
    */
    public SoccerPlayer(String n, String c, int s) {
        if (s < 1) {
            stamina = 20;
        } else {
            stamina = s;
        }

        name = n;
        country = c;
    }


    /**
    * Overrides Object's toString method.
    * @return a string that prints when a soccer player is needed to print.
    */
    public String toString() {
        return this.name + " from " + this.country + " has " + this.stamina + " stamina left";
    }

    /**
    * Overrides Object's equals().
    * @param o can be any object that is compared to a SoccerPlayer
    * @return returns true is the objects are equal
    */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof SoccerPlayer)) {
            return false;
        }

        SoccerPlayer s;
        s = (SoccerPlayer) o;
        return ((s.name.equals(name)) && (s.country.equals(country)));
    }

    /**
    * will be overridden in subclasses to represent a player playing a game.
    */
    public abstract void play();

    /**
    * will be overriden in subclasses to determine the rating of a player based on their statistics.
    * @return will be used to return ratings for soccer players
    */
    public abstract double calculateRating();

    /**
    * Increases a soccer player's stamina by 5.
    */
    public void rest() {
        this.stamina = this.stamina + 5;
    }

    /**
    * A getter for a soccer player's stamina.
    * @return the soccer player's stamina
    */
    public int getStamina() {
        return stamina;
    }

    /**
    * A setter for a soccer player's stamina.
    * @param newVal is the soccer player's new stamina
    */
    public void setStamina(int newVal) {
        if (newVal < 0) {
            return;
        } else {
            stamina = newVal;
        }
    }
}