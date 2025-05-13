package stackOverFlow;

import java.util.ArrayList;
import java.util.List;

import stackOverFlow.interfaces.Commentable;
import stackOverFlow.interfaces.Votable;

public class User {
    private final int id;
    private final String username;
    private int popularity;
    private final String email;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    private final int questionpopularity = 5, answerpopularity = 10, commentpopularity = 2;

    User(int id,String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.popularity = 0;
    }

    public Question askQuestion(User author, String title, String content, List<String> tags) {
        Question question = new Question(author, title, content, tags);
        this.questions.add(question);
        this.setPopularity(this.questionpopularity);
        return question;
    }

    public Answer answerQuestion(User author, String content, Question question) {
        Answer answer = new Answer(author, content, question);
        this.answers.add(answer);
        this.setPopularity(answerpopularity);
        return answer;
    }

    public Comment addComment(User author, Commentable commentable, String content) {
        Comment comment = new Comment(author, content);
        commentable.addComment(comment);
        this.comments.add(comment);
        setPopularity(commentpopularity);
        return comment;
    }

    public void addVote(Votable votable, int value) {
        Vote vote = new Vote(this, value);
        votable.updateVote(vote);        
    }

    public void setPopularity(int popularity) {
        this.popularity += popularity;
        if (this.popularity < 0)
            this.popularity = 0;
    }

    public List<Answer> getAnswer() {
        return answers;
    }
    public List<Comment> getComment() {
        return comments;
    }
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public int getPopularity() {
        return popularity;
    }

    public List<Question> getQuestions() {
        return questions;
    }
    public String getUsername() {
        return username;
    }
}
