package app.src.main.java.lld_practice.stackOverFlow.interfaces;

import java.util.List;

import app.src.main.java.lld_practice.stackOverFlow.Comment;

public interface Commentable {
List<Comment> getComments();
void addComment(Comment comment);    
}
