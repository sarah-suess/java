/**
* Used to search and sort Pokemon. Also contains a main (driver) method.
* @author ssuess3
* @version 11.0.16.1
*/
public class PokemonDB {

    /** Main method.
    * @param args The command line arguments.
    */
    public static void main(String[] args) {
        Fire fire = new Fire();
        Water water = new Water();
        Grass grass = new Grass();

        Pokemon one = new Pokemon("one", 100, fire, 30);
        Pokemon two = new Pokemon("two", 90, fire, 50);
        Pokemon three = new Pokemon("three", 80, fire, 50);
        Pokemon four = new Pokemon("four", 70, fire, 50);
        Pokemon five = new Pokemon("five", 17, water, 30);
        Pokemon six = new Pokemon("six", 20, grass, 30);
        Pokemon seven = new Pokemon("seven", 40, fire, 50);

        // Pokemon copy1 = new Pokemon(one);
        // copy1.name = "copy";
        // copy1.type = new Water();
        // System.out.println(one);

        //System.out.println(one.compareTo(one));

        // System.out.println(one);
        // System.out.println(two);
        // System.out.println(three);
        // System.out.println(four);
        // System.out.println(five);
        // System.out.println(six);
        // System.out.println(seven);

        Pokemon[] array = {one, two, three, four, five, six, seven};
        Pokemon[] solo = {one};
        //System.out.println(Arrays.toString(array));
        compareSort(array);
        //System.out.println(Arrays.toString(array));
        Pokemon found = findPokemon(70, array);
    }

    /**
    * Finds the Pokemon with the health passed as a param.
    * @param h the health being searched for.
    * @param arr an array of Pokemon objects.
    * @return returns a Pokemon object with matching health
    */
    public static Pokemon findPokemon(int h, Pokemon[] arr) {
        PokemonDB.compareSort(arr);
        //System.out.println(Arrays.toString(arr));
        int first = 0;
        int last = arr.length;
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid].getHealth() == h) {
                return arr[mid];
            } else if (arr[mid].getHealth() < h) {
                first = mid + 1;
                //System.out.println(first + "f");
            } else {
                last = mid - 1;
                //System.out.println(last + "l");
            }
            mid = (first + last) / 2;
            //System.out.println(mid + "m");
        }
        return null;
    }

    /** Sorts the Pokemons in ascending order based on the compareTo method in Pokemon.
    * @param arr the array being searched.
    */
    public static void compareSort(Pokemon[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            int min = i;
            for (int j = (i + 1); j < arr.length; j++) {
                if (arr[min].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }
            Pokemon temporary = arr[min];
            arr[min] = arr[i];
            arr[i] = temporary;
        }
    }
}