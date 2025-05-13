package stackOverFlow;

import java.util.Date;

public class Comment {
    private final int id;
    private final User author;
    private final String content;
    private final Date creationDate;

    Comment(User author, String content) {
        this.id = this.generateId();
        this.author = author;
        this.content = content;
        creationDate = new Date();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public int getId() {
        return id;
    }
}
