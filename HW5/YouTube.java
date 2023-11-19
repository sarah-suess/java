/**
* Driver class for Video and Comment classes.
* @author ssuess3
* @version 11.0.16.1
*/
public class YouTube {
    /** Main method.
    * @param args The command line arguments.
    */
    public static void main(String[] args) {
        Video one = new Video(4.5, 7, 35);
        Video two = new Video(-3.2, -4, -5);

        System.out.println(one);
        //System.out.println(two);

        Comment three = new Comment(40, 50, "comment v", true);
        Comment four = new Comment(2000, 20, "String v", false);
        Comment five = new Comment(300, 150, "String v", false);
        Comment six = new Comment(10, 10, "String v", false);

        System.out.println(three);
        System.out.println(four);

        one.createComment(three);
        one.createComment(four);
        //one.createComment(five);
        //one.createComment(six);
        //System.out.println(Arrays.toString(one.toArray()));
        System.out.println(one);
        System.out.println(one.spamComments());
        System.out.println(one.getComments());
        System.out.println(one);
        //System.out.println(Arrays.toString(one.toArray()));

        //System.out.println(Arrays.toString(one.topAndWorstComment()));

        //System.out.println(one.toString());

        //System.out.println(one.equals(one));
        //System.out.println(two.equals(one));

        //System.out.println(three.compareTo(four));
        //System.out.println(four.compareTo(three));
        //System.out.println(three.compareTo(three));

        //System.out.println(four);

        //System.out.println(three.equals(four));
        //System.out.println(four.equals(three));
        //System.out.println(three.equals(three));
    }
}