/**
* Used to create Pokemon.
* @author ssuess3
* @version 11.0.16.1
*/
public class Pokemon {
    private String name;
    private int health;
    private int strength;
    private PokemonType type;

    /**
    * Used to create a Pokemon. Takes four arguments.
    * @param n the name of the Pokemon
    * @param h the Pokemon's starting health
    * @param t the Pokemon's type
    * @param s the Pokemon's starting strength
    */
    public Pokemon(String n, int h, PokemonType t, int s) {
        if (n == null || n.isEmpty() || n.isBlank()) {
            name = "Pikachu";
        } else {
            name = n;
        }

        if ((h < 1) || (h > 100)) {
            health = 50;
        } else {
            health = h;
        }

        if ((s < 1) || (s > 100)) {
            strength = 50;
        } else {
            strength = s;
        }

        if ((t instanceof Fire) || (t instanceof Water) || (t instanceof Grass)) {
            type = t;
        } else {
            type = new Fire();
        }
    }

    /**
    * Used to create a Pokemon. Takes two arguments.
    * @param n the name of the Pokemon
    * @param t the Pokemon's type
    */
    public Pokemon(String n, PokemonType t) {
        if (n == null || n.isEmpty() || n.isBlank()) {
            name = "Pikachu";
        } else {
            name = n;
        }

        if ((t instanceof Fire) || (t instanceof Water) || (t instanceof Grass)) {
            type = t;
        } else {
            type = new Fire();
        }

        if (type instanceof Grass) {
            health = 65;
        } else if (type instanceof Water) {
            health = 80;
        } else {
            health = 50;
        }

        double s = Math.random();
        strength = (int) (s * 100 + 1);
    }

    /**
    * Used to create a Pokemon. Takes one argument.
    * @param p a pokemon object to copy
    */
    public Pokemon(Pokemon p) {
        health = p.health;
        strength = p.strength;
        name = p.name;
        type = p.type;
    }

    /**
    * Overrides Object's toString() method.
    * @return a String to print out
    */
    public String toString() {
        return name + " is a " + type.type() + " type with health "
            + health + " and strength " + strength + ".";
    }

    /**
    * Writes a compareTo method for pokemon.
    * @param p a pokemon object
    * @return 1,-1,0 depending on if the Pokemon is greater, lesser, or equal
    */
    public int compareTo(Pokemon p) {
        if (p.health > health) {
            return -1;
        } else if (p.health < health) {
            return 1;
        }
        if (p.strength > strength) {
            return -1;
        } else if (p.strength < strength) {
            return 1;
        }
        if (type.compareTo(p.type) > 0) {
            return 1;
        } else if (type.compareTo(p.type) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
    * A getter for a pokemon's health.
    * @return the pokemons's health
    */
    public int getHealth() {
        return health;
    }
}