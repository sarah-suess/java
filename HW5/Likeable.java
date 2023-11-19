/**
* Used to denote whether an object can receive likes or dislikes.
* @author ssuess3
* @version 11.0.16.1
*/
public interface Likeable {
    /**
    * Denotes that an object can be liked.
    * @return returns the number of likes an object has.
    */
    int getLikes();

    /**
    * Denotes that an object can be disliked.
    * @return returns the number of dislikes an object has.
    */
    int getDislikes();
}