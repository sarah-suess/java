/**
* Defines methods for types of Pokemon.
* @author ssuess3
* @version 11.0.16.1
*/
public interface PokemonType extends Comparable<PokemonType> {

    /**
    * Defines a type() method for classes that implement PokemonType.
    * @return returns a string of the Pokemon's type.
    */
    String type();
}