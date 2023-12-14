package USER;

public interface Message {
    String senderEmail = null;
    String receiverEmail = null;
    String messageID = null;


    void sendMessage(String content, Integer priority);

    void deleteMessage();

    void viewMessage();

    void sendReportToTechSupport();



}
