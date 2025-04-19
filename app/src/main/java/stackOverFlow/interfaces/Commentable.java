package app.src.main.java.stackOverFlow.interfaces;

import java.util.List;

import app.src.main.java.stackOverFlow.Comment;

public interface Commentable {
List<Comment> getComments();
void addComment(Comment comment);    
}
