import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Session {
    public String sessionID;
    public int currentScore;
    public int[] bestScoreArr;
    public int timeElapsed;

    public Session(String playerID) {
        sessionID = playerID; // each session is linked to a player
        currentScore = 0;
    }

    public void start() {

    }

    public void end() {

    }

    public void save() {

    }

    public void saveScore() {
        // save currentScore to a file
        try {
            File scoreFile = new File(sessionID + ".txt");
            if (scoreFile.createNewFile()) {
                System.out.println("File created: " + scoreFile.getName());
                FileWriter myWriter = new FileWriter(scoreFile.getName());
                myWriter.write(currentScore);
                myWriter.close();
            }
            else {
                System.out.println("File " + scoreFile.getName() + "  already exists.");
                FileWriter newWriter = new FileWriter(scoreFile.getName());
                newWriter.write(currentScore);
                newWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
