/**
* Used to create teams of soccer players.
* @author ssuess3
* @version 11.0.16.1
*/
public class Team {
    private String teamName;
    private SoccerPlayer[] players;

    /**
    * Used to create a Team.
    * @param name the name of the team
    */
    public Team(String name) {
        teamName = name;
        players = new SoccerPlayer[11];
    }

    /**
    * Used to override Object's toString() method.
    * @return a string that prints when a team is needed to print.
    */
    public String toString() {
        String name = "Team name: " + teamName;
        String rest = "";
        for (int i = 0; i < players.length; i++) {
            if (!(players[i] == null)) {
                rest += (players[i] + "\n");
            }
        }
        return name + "\n" + rest;
    }

    /**
    * Used to add a soccer player to the team's player array.
    * @param player the soccer player being added to the array
    */
    public void addTeamMember(SoccerPlayer player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }

    /**
    * Used to play against an opponent Team.
    * @param opponent the team you are competing against
    * @return returns a String of the winning team or "Tie"
    */
    public String playAgainstTeam(Team opponent) {
        for (int i = 0; i < players.length; i++) {
            if (!(players[i] == null)) {
                players[i].play();
            }
        }
        for (int i = 0; i < opponent.players.length; i++) {
            if (!(opponent.players[i] == null)) {
                opponent.players[i].play();
            }
        }
        double opponentAvg = 0;
        double avg = 0;
        int opponentTotalPlayers = 0;
        int totalPlayers = 0;
        for (int i = 0; i < players.length; i++) {
            if (!(players[i] == null)) {
                avg = avg + players[i].calculateRating();
                totalPlayers++;
            }
        }
        if (totalPlayers != 0) {
            avg = (avg / totalPlayers);
        }

        for (int i = 0; i < opponent.players.length; i++) {
            if (!(opponent.players[i] == null)) {
                opponentAvg = opponentAvg + opponent.players[i].calculateRating();
                opponentTotalPlayers++;
            }
        }
        if (opponentTotalPlayers != 0) {
            opponentAvg = (opponentAvg / opponentTotalPlayers);
        }

        if (opponentAvg == avg) {
            return "Tie";
        } else if (opponentAvg > avg) {
            return opponent.teamName;
        } else {
            return teamName;
        }
    }
}