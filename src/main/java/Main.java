import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.apache.log4j.BasicConfigurator;
import java.io.*;


public class Main {
    public static void main(String[] args){

        String minecraftServerIP = "TheGreatestServerEve.aternos.me";


        BasicConfigurator.configure();
        String botToken = "tokenFailure";
        try {
            botToken = getBotTokenFromTextFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JDABuilder jdaBuilder = JDABuilder.createDefault(botToken);

        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        System.out.println("-Bot is now online-\n\n\n");
        jdaBuilder.addEventListeners(new receiveMessage());
        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        jdaBuilder.build();
    }

    public static String getBotTokenFromTextFile() throws IOException {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/bot-token.txt"));

        while ((sCurrentLine = br.readLine()) != "-1") {
            System.out.println("Your Bot token is:   -" + sCurrentLine + "-     do not share this token with anyone!\n\n\n");
            break;
        }
        return sCurrentLine;

    }


}