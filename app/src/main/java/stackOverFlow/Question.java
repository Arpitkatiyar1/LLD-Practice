package stackOverFlow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import stackOverFlow.interfaces.Commentable;
import stackOverFlow.interfaces.Votable;

public class Question implements Commentable, Votable{
    private final int uniqueId;
    private final User author; 
    private final String title, content;    
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tag> tags;
    private final List<Vote> votes;
    private final Date creationDate;

    Question(User author, String title, String contet, List<String> tags) {
        this.uniqueId = this.generateId();
        this.creationDate = new Date();
        this.author = author;
        this.title = title;
        this.content = contet;
        this.tags = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        for (String tag : tags) {
            this.tags.add(new Tag(tag));
        }
    }

    public void addAnswer(Answer answer) {
        if (this.answers.contains(answer))
            this.answers.add(answer);
    }

	@Override
	public void updateVote(Vote vote) {
        if (vote.getValue() != 1 && vote.getValue() != -1)
            throw new IllegalArgumentException("vote value either should be 1 or -1");
        
        this.votes.removeIf(v -> v.getUser().equals(vote.getUser()));
        this.votes.add(vote);
        vote.getUser().setPopularity(vote.getValue()*5);        
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

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
    
    /// getters.....
    public List<Answer> getAnswers() {
        return answers;
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

    public List<Tag> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }
    public int getUniqueId() {
        return uniqueId;
    }
}
