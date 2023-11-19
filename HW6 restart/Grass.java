/**
* Represents pokemon of type grass.
* @author ssuess3
* @version 11.0.16.1
*/
public class Grass implements PokemonType {

    /**
    * Implements type() from PokemonType.
    * @return a string of the pokemon's type
    */
    public String type() {
        return "Grass";
    }

    /**
    * Overrides CompareTo() from Comparable.
    * @param t should be a PokemonType.
    * @return returns an int that compares based on the different types
    */
    public int compareTo(PokemonType t) {
        if (t instanceof Grass) {
            return 0;
        } else {
            return -1;
        }
    }
}