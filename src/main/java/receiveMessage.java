import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class receiveMessage extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent message)
    {
        String messageContentStripped = null;
        System.out.println(message.getMessage().getContentStripped() + " from: " + message.getAuthor().getName());

        TextChannel textChannel = message.getGuild().getTextChannelsByName("schlafzyklen",true).get(0);


        switch (message.getMessage().getContentStripped().toString()) {

            case "gn":
                String userNameAvatarId = message.getAuthor().getAvatarId().toString();
                String username = message.getAuthor().getName().toString();
                long currentTime = System.currentTimeMillis();
                sleepTimeCount.sleepTimeStore(username, userNameAvatarId, currentTime);
                break;

            case "gm":
                String userNameAvatarId_comparison = message.getAuthor().getAvatarId().toString();
                String username_comparison = message.getAuthor().getName().toString();
                long currentTime_comparison = System.currentTimeMillis();
                String sleepTime = sleepTimeCount.sleepTime(username_comparison, userNameAvatarId_comparison, currentTime_comparison);

                System.out.println(sleepTime);
                String user = message.getAuthor().getName();

                textChannel.sendMessage(user + sleepTime).queue();
                break;
        }


    }
}
