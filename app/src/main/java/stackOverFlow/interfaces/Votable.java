package stackOverFlow.interfaces;

import stackOverFlow.Vote;

public interface Votable {
    void updateVote(Vote vote);
    int getVotes();
}
