package app.src.main.java.stackOverFlow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import app.src.main.java.stackOverFlow.interfaces.Commentable;
import app.src.main.java.stackOverFlow.interfaces.Votable;

public class StackOverFlow {
    // private StackOverFlow stackOverFlow;
    private final Map<Integer, User> users;
    private final Map<Integer,Question> questions;
    private final Map<Integer,Answer> answers;
    private final Map<String,Tag> tags;

    public StackOverFlow() {
        users=new ConcurrentHashMap<>();
        questions=new ConcurrentHashMap<>();
        answers=new ConcurrentHashMap<>();
        tags=new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email) {
        int id = users.size() + 1;
        User user = new User(id, username, email);
        this.users.put(users.size()+1,user);
        return user;
    }

    public Question askQuestion(User author, String title, String content, List<String> tags) {
        Question question =author.askQuestion(author, title, content, tags);
        questions.put(questions.size() + 1, question);
        return question;
    }

    public Answer answerQuestion(User author, String content, Question question) {
        Answer answer = author.answerQuestion(author, content, question);
        answers.put(answers.size() + 1, answer);
        return answer;
    }

    public void acceptAnswer(Answer answer) {
        answer.acceptAnswer();
    }

    public Comment addComment(User author, Commentable commentable, String content) {
        return author.addComment(author,commentable, content);
    }

    public void addVote(User author, Votable votable, int value) {
        author.addVote(votable, value);
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public Map<String, Tag> getTags() {
        return tags;
    }
    public Map<Integer, User> getUsers() {
        return users;
    }
}
