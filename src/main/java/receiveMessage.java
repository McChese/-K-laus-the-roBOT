import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class receiveMessage extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent message)
    {
        if(message.isFromGuild())
        {
            String messageContentStripped = message.getMessage().getContentStripped();

            switch (messageContentStripped)
            {
                case "/help":
                    helpCommand();
            }
        }
    }

    public String helpCommand()
    {
        return "/help\n/memes\n/game\nsoon";
    }
}
