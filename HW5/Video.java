import java.util.ArrayList;
/**
* Represents a video page.
* @author ssuess3
* @version 11.0.16.1
*/
public class Video {
    private ArrayList<Comment> comments;
    private double length;
    private int likes;
    private int dislikes;

    /**
    * Used to create a Video page.
    * @param len the length of the video in time
    * @param l the number of likes on the video
    * @param dis the number of dislikes on the video
    */
    public Video(double len, int l, int dis) {
        if ((len < 0) || (len > 60)) {
            length = 0;
        } else {
            length = len;
        }
        if (l < 0) {
            likes = 0;
        } else {
            likes = l;
        }
        if (dis < 0) {
            dislikes = 0;
        } else {
            dislikes = dis;
        }
        comments = new ArrayList<Comment>();
    }

    /**
    * Adds a comment to the end of comments.
    * @param c a Comment
    */
    public void createComment(Comment c) {
        comments.add(c);
    }

    /**
    * Removes a specific comment from comments.
    * @param c a Comment to be removed
    * @return returns true if the comment is sucessfully removed
    */
    public boolean removeComment(Comment c) {
        if (comments.indexOf(c) >= 0) {
            int index = comments.indexOf(c);
            comments.remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
    * Picks out the spam comments from comments.
    * @return returns an arraylist of only spam comments.
    */
    public ArrayList<Comment> spamComments() {
        for (int i = 0; i < comments.size(); i++) {
            if (!comments.get(i).getIsSpam()) {
                comments.remove(i);
            }
        }
        ArrayList<Comment> spam;
        spam = comments;
        return spam;
    }

    /**
    * Changes comments into an array.
    * @return returns an array of comments.
    */
    public Object[] toArray() {
        Object[] commentsArr = comments.toArray();
        return commentsArr;
    }

    /**
    * Returns an array with the top and worst comment based on like factor.
    * @return returns a Comment array of top and worst comment.
    */
    public Comment[] topAndWorstComment() {
        int first = (comments.get(0).getLikes() - comments.get(0).getDislikes());
        int last = (comments.get(0).getLikes() - comments.get(0).getDislikes());
        Comment most = comments.get(0);
        Comment least = comments.get(0);
        for (Comment c: comments) {
            if ((c.getLikes() - c.getDislikes()) > first) {
                most = c;
                first = c.getLikes() - c.getDislikes();
            }
            if ((c.getLikes() - c.getDislikes()) < last) {
                least = c;
                last = c.getLikes() - c.getDislikes();
            }
        }
        if (comments.size() == 1) {
            most = comments.get(0);
            least = comments.get(0);
        }
        Comment[] commentArr = {most, least};
        return commentArr;
    }

    /**
    * Overrides Object's toString method.
    * @return returns a string to print out
    */
    public String toString() {
        return "This video has " + comments.size() + " comments and is " + length + " long.";
    }

    /**
    * Overrides Object's equals().
    * @param o can be any object that is compared to a Video
    * @return returns true is the objects are equal
    */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Video)) {
            return false;
        }

        Video v;
        v = (Video) o;
        return ((v.comments.size() == comments.size()) && (v.length == length)
            && (v.likes == likes) && (v.dislikes == dislikes));
    }

    /**
    * A getter for a video's length.
    * @return the video's length
    */
    public double getLength() {
        return length;
    }

    /**
    * A setter for a video's length.
    * @param l must be greater than 0 and less than 60
    */
    public void setLength(double l) {
        if ((l < 0) || (l > 60)) {
            return;
        } else {
            length = l;
        }
    }

    /**
    * A getter for a video's comment arraylist.
    * @return the video's comment arraylist
    */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    // /**
    // * A setter for a video's comment arraylist.
    // * @param c should be an arraylist with no null values
    // */
    // public void setComments(ArrayList<Comment> c) {
    //     for (Comment each: c) {
    //         if (each == null) {
    //             return;
    //         }
    //     }
    //     comments = c;
    // }

    /**
    * A getter for a video's likes.
    * @return the video's likes
    */
    public int getLikes() {
        return likes;
    }

    /**
    * A setter for a video's likes.
    * @param l should be an int greater than 0
    */
    public void setLikes(int l) {
        if (l < 0) {
            return;
        } else {
            likes = l;
        }
    }

    /**
    * A getter for a video's dislikes.
    * @return the video's dislikes
    */
    public int getDislikes() {
        return dislikes;
    }

    /**
    * A setter for a video's dislikes.
    * @param d should be an int greater than 0
    */
    public void setDislikes(int d) {
        if (d < 0) {
            return;
        } else {
            dislikes = d;
        }
    }
}