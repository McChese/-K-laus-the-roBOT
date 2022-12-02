import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String botToken = getBotTokenFromTextFile();
        JDABuilder jdaBuilder = JDABuilder.createDefault(botToken); //creates the Bot

        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        System.out.println("-Bot is now online-");

        jdaBuilder.addEventListeners(new receiveMessage());



        JDA bot = jdaBuilder.build(); //build the bot
    }

    public static String getBotTokenFromTextFile() throws IOException {
        FileInputStream fstream = new FileInputStream("src/main/java/bot-token");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        while ((strLine = br.readLine()) != null)
        {
            System.out.println ("Your set Bot token is: " + strLine + "    Do not share this token with someone!\n");
        }
        return strLine;
    }


}