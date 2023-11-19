/**
* Used to drive the soccer player program.
* @author ssuess3
* @version 11.0.16.1
*/
public class GameSim {
    /** Main method. Used to run methods from SoccerPlayer, subclasses, and Team.
    * @param args The command line arguments.
    */
    public static void main(String[] args) {
        GoalKeeper one = new GoalKeeper("dan", "ireland", 30, 8, 7, 10.0);
        Defender two = new Defender("String n", "String c", 7, 9, 10, 30.7);
        Attacker three = new Attacker("String n", "String c", 4, 7, 6, 5.0, Attacker.CelebrationMove.SIUU);

        Team team = new Team("usa");

        GoalKeeper four = new GoalKeeper("dan", "ireland", 40, 58, 24, 25.9);
        Defender five = new Defender("String n", "String c", 90, 39, 43, 40.9);
        Attacker six = new Attacker("String n", "String c", 84, 25, 48, 40.0, Attacker.CelebrationMove.DIVE);

        Team opponent = new Team("enemy");

        team.addTeamMember(one);
        team.addTeamMember(two);
        team.addTeamMember(three);
        System.out.println(team);

        opponent.addTeamMember(four);
        opponent.addTeamMember(five);
        opponent.addTeamMember(six);
        System.out.println(opponent);

        System.out.println(team.playAgainstTeam(opponent));

        //System.out.println(three.equals(three));
    }
}