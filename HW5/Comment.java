/**
* Represents the comments held on a video page.
* @author ssuess3
* @version 11.0.16.1
*/
public class Comment implements Comparable, Likeable {
    private boolean isSpam;
    private int likes;
    private int dislikes;
    private String value;

    /**
    * Used to create a Comment.
    * @param l the number of likes on a comment
    * @param d the number of dislikes on a comment
    * @param v string that represents the comments text
    * @param s if this is true, the comment is considered spam
    */
    public Comment(int l, int d, String v, boolean s) {
        if (l < 0) {
            likes = 0;
        } else {
            likes = l;
        }
        if (d < 0) {
            dislikes = 0;
        } else {
            dislikes = d;
        }
        if (v == null) {
            value = "";
        } else {
            value = v;
        }
        isSpam = s;
    }

    /**
    * Overrides CompareTo() from Comparable.
    * @param o should be an Object of type Comment
    * @return returns an int that compares like factor
    */
    public int compareTo(Object o) {
        Comment c;
        c = (Comment) o;
        int factor = (likes - dislikes);
        int otherFactor = (c.likes - c.dislikes);
        if (factor > otherFactor) {
            return 1;
        } else if (factor == otherFactor) {
            return 0;
        } else {
            return (-1);
        }
    }

    /**
    * Overrides Object's toString() method.
    * @return a String to print out
    */
    public String toString() {
        return value + ", " + likes + " likes, Spam: " + isSpam + ".";
    }

    /**
    * Overrides Object's equals().
    * @param o can be any object that is compared to a Comment
    * @return returns true is the objects are equal
    */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Comment)) {
            return false;
        }

        Comment c;
        c = (Comment) o;
        return ((c.likes == likes) && (c.dislikes == dislikes)
            && (c.value.equals(value)) && (c.isSpam == isSpam));
    }

    /**
    * A getter for a comment's likes.
    * @return the comments's likes
    */
    public int getLikes() {
        return likes;
    }

    /**
    * A setter for a comment's likes.
    * @param l must be greater than 0
    */
    public void setLikes(int l) {
        if (l < 0) {
            return;
        } else {
            likes = l;
        }
    }

    /**
    * A getter for a comment's dislikes.
    * @return the comments's dislikes
    */
    public int getDislikes() {
        return dislikes;
    }

    /**
    * A setter for a comment's dislikes.
    * @param d must be greater than 0
    */
    public void setDislikes(int d) {
        if (d < 0) {
            return;
        } else {
            dislikes = d;
        }
    }

    /**
    * A getter for a comment's spam value.
    * @return the comments's spam value
    */
    public boolean getIsSpam() {
        return isSpam;
    }

    /**
    * A setter for a comment's spam value.
    * @param b should be a boolean value
    */
    public void setIsSpam(boolean b) {
        isSpam = b;
    }

    /**
    * A getter for a comment's value.
    * @return the comments's value
    */
    public String getValue() {
        return value;
    }

    /**
    * A setter for a comment's value.
    * @param s can not be null
    */
    public void setValue(String s) {
        if (s == null) {
            return;
        } else {
            value = s;
        }
    }
}