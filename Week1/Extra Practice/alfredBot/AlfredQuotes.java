import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format("Hello %s, lovely to see you!", name);
    }
    
    public String dateAnnouncement() {
        return String.format("Right now it is %s.", new Date());
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") > -1) {
            return "That bot is of no use to you! What can I do for you?";
        }
        if (conversation.indexOf("Alfred") > -1) {
            return "Always willing to help, of course. How can I best serve you?";
        }
        return "Alright. And now I shall retire.";
    }
    
	// NINJA BONUS
	public String guestGreeting(String name, String dayPeriod) {
        return String.format("Hello, good %s. Lovely to see you, %s.", dayPeriod, name);
    }
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}