import java.util.*;

import static java.lang.System.out;

abstract class Person { // base class (parent, super, root)
    protected String firstName; // protected je dostupan samo u child klasama (derived, subclass, extended)
    protected String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class Player extends Person {
    private int number;
    private int shoeSize;

    public Player(String firstName, String lastName, int number, int shoeSize) {
        super(firstName, lastName);
        this.number = number;
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (#" + number + ")";
    }
}

class Coach extends Person {
    private int yearsOfExperience;

    public Coach(String firstName, String lastName, int yearsOfExperience) {
        super(firstName, lastName);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Experience: " + yearsOfExperience + " years)";
    }
}

class Club {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String city;
    private Coach coach;

    public Club(String name, String city, Coach coach) {
        this.id = idCounter++;
        this.name = name;
        this.city = city;
        this.coach = coach;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + city + ") - Coach: " + coach;
    }
}

class Match {
    private static int idCounter = 1;
    public int id;
    private Club homeClub;
    private Club awayClub;
    private int homeResult;
    private int awayResult;
    private List<Player> homeScorers;
    private List<Player> awayScorers;

    public Match(Club homeClub, Club awayClub) {
        this.id = idCounter++;
        this.homeClub = homeClub;
        this.awayClub = awayClub;
        this.homeScorers = new ArrayList<>();
        this.awayScorers = new ArrayList<>();
    }

    public void addScorer(Player player, boolean isHomeTeam) {
        if (isHomeTeam) {
            homeScorers.add(player);
        } else {
            awayScorers.add(player);
        }
    }

    public void setResult() {
        if (homeScorers.isEmpty() && awayScorers.isEmpty()) {
            throw new IllegalStateException("Cannot set result without scorers");
        }
        homeResult = homeScorers.size();
        awayResult = awayScorers.size();
    }

    @Override
    public String toString() {
        return "Match " + id + ": " + homeClub.getName() + " " + homeResult + " - " + awayResult + " " + awayClub.getName()
                + "\n" + "Strijelac za domacine: " + homeScorers
                + "\n" + "Strijelci za goste: " + awayScorers;
    }
}

class League {
    private List<Club> clubs;
    private List<Match> matches;

    public League() {
        clubs = new ArrayList<>();
        matches = new ArrayList<>();
    }

    public void addClub(Club club) {
        clubs.add(club);
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public void printActiveClubs() {
        out.println("Active Clubs:");
        for (Club club : clubs) {
            out.println(club);
        }
    }

    public void printMatches() {
        out.println("Match Results:");
        for (Match match : matches) {
            out.println(match);
        }
    }

    public void printClubById(int clubId) {
        for (Club club : clubs) {
            if (club.getId() == clubId) {
                out.println(club);
                return;
            }
        }
        out.println("Club with ID " + clubId + " not found.");
    }

    public void printMatchById(int matchId) {
        for (Match match : matches) {
            if (match.id == matchId) {
                out.println(match);
                return;
            }
        }
        out.println("Match with ID " + matchId + " not found.");
    }
}

class CroatianLeagueTracker {
    public static void main(String[] args) {
        League league = new League();

        Coach coach1 = new Coach("Fabio", "Cannavaro", 10);
        Coach coach2 = new Coach("Gennaro", "Gattuso", 8);
        Coach coach3 = new Coach("Carlo", "Ancelotti", 30);
        Coach coach4 = new Coach("Josep", "Guardiola", 20);

        Club club1 = new Club("Dinamo", "Zagreb", coach1);
        Club club2 = new Club("Hajduk", "Split", coach2);
        Club club3 = new Club("Real Madrid", "Madrid", coach3);
        Club club4 = new Club("Barcelona", "Barcelona", coach4);

        league.addClub(club1);
        league.addClub(club2);
        league.addClub(club3);
        league.addClub(club4);

        Player player1 = new Player("Luka", "Modric", 10, 42);
        Player player2 = new Player("Ivan", "Perisic", 4, 43);
        Player player3 = new Player("Cristiano", "Ronaldo", 7, 42);
        Player player4 = new Player("Leo", "Messi", 10, 41);
        Player player5 = new Player("Cristiano", "Ronaldo", 7, 42);
        Player player6 = new Player("Leo", "Messi", 10, 41);
        Player player7 = new Player("Cristiano", "Ronaldo", 7, 42);
        Player player8 = new Player("Leo", "Messi", 10, 41);
        Player player9 = new Player("Leo", "Messi", 10, 41);

        Match match1 = new Match(club1, club2);
        Match match2 = new Match(club3, club4);

        match1.addScorer(player1, true);
        match1.addScorer(player2, false);
        match2.addScorer(player3, true);
        match2.addScorer(player4, false);
        match2.addScorer(player5, true);
        match2.addScorer(player6, false);
        match2.addScorer(player7, true);
        match2.addScorer(player8, false);
        match2.addScorer(player9, false);

        match1.setResult();
        match2.setResult();

        league.addMatch(match1);
        league.addMatch(match2);

        out.println("\n-------------------Print clubs: --------------------------");

        league.printActiveClubs();

        out.println("\n---------------Print matches: ------------------------");

        league.printMatches();

        out.println("\n-----------------Print club by ID: ----------------------");

        league.printClubById(2); // Prints club with ID 2

        out.println("\n-----------------Print match by ID: ----------------------");

        league.printMatchById(2); // Example: prints the match with ID 1

    }
}
