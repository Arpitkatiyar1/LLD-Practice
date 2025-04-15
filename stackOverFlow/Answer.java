package stackOverFlow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import stackOverFlow.interfaces.Commentable;
import stackOverFlow.interfaces.Votable;

public class Answer implements Commentable, Votable{
    private final int id;
    private final User author;
    private final String content;
    private final Date creationdate;
    private final List<Comment> comments;
    private final List<Vote> votes;
    private final Question question;
    private boolean isAccepted;

    Answer(User autor, String content, Question question) {
        this.id = this.generateId();
        this.author = autor;
        this.content = content;
        this.creationdate = new Date();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.question = question;
        isAccepted = false;        
    }
    
    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void acceptAnswer() {
        this.isAccepted = true;
    }

	@Override
	public void updateVote(Vote vote) {
        if (vote.getValue() != 1 && vote.getValue() != 1)
            throw new IllegalArgumentException("Vote value either should be 1 or -1");
        
        this.votes.removeIf(v -> v.getUser().equals(vote.getUser()));
        this.votes.add(vote);
        vote.getUser().setPopularity(vote.getValue()*10);
	}
	@Override
    public int getVotes() {
        return this.votes.stream().mapToInt(Vote::getValue).sum();
    }
	@Override
	public List<Comment> getComments() {
        return this.comments;
	}
	@Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
    
    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public int getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }
}
