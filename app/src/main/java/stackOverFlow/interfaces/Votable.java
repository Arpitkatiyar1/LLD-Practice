package app.src.main.java.stackOverFlow.interfaces;

import app.src.main.java.stackOverFlow.Vote;

public interface Votable {
    void updateVote(Vote vote);
    int getVotes();
}
