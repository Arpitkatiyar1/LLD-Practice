package stackOverFlow.interfaces;

import java.util.List;

import stackOverFlow.Comment;

public interface Commentable {
List<Comment> getComments();
void addComment(Comment comment);    
}
