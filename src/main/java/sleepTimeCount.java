import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class sleepTimeCount {
    public static void sleepTimeStore(String username, String userAvatarId, long time)
    {
        try {
            FileWriter myWriter = new FileWriter("src/main/java/userSleepTime/" + username + " "+ userAvatarId+".txt");
            myWriter.write(username + " " + userAvatarId + " " + time);
            myWriter.close();
            System.out.println("Successfully wrote to userSleepTimeCount");
        } catch (IOException e) {
            System.out.println("An error occurred writing to the userSleepTimeFile");
            e.printStackTrace();
        }
    }
    public static String sleepTime(String username_comparison, String userAvatarId_comparison, long currentTime_comparison)
    {
        String userSleepInfo = null;
        try {
            File myObj = new File("src/main/java/userSleepTime/" + username_comparison + " " + userAvatarId_comparison + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                userSleepInfo = data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] userData = userSleepInfo.split(" ");

        long sleepTime = Long.parseLong(userData[2]);

        sleepTime = currentTime_comparison - sleepTime;

        int hours = (int) (sleepTime / (60 * 60 * 1000));
        int minutes = (int) (sleepTime / (60 * 1000)) % 60;
        int seconds = (int) (sleepTime / 1000) % 60;

        return " hat " + hours + " stunden " + minutes +" minuten und " + seconds +" sekunden geschlafen!";
    }
}
