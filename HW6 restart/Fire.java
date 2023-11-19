/**
* Represents pokemon of type fire.
* @author ssuess3
* @version 11.0.16.1
*/
public class Fire implements PokemonType {
    /**
    * Implements type() from PokemonType.
    * @return a string of the pokemon's type
    */
    public String type() {
        return "Fire";
    }

    /**
    * Overrides CompareTo() from Comparable.
    * @param t should be a PokemonType.
    * @return returns an int that compares based on the different types
    */
    public int compareTo(PokemonType t) {
        if (t instanceof Grass) {
            return 1;
        } else if (t instanceof Fire) {
            return 0;
        } else {
            return -1;
        }
    }
}