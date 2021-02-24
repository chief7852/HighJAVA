
@Getter @Setter
public class ChatMessage {
    private String chatRoomId;
    private String writer;
    private String message;
    private MessageType type;
    
    public enum MessageType {
        ENTER,CHAT,LEAVE
    }
}

