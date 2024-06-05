package com.techelevator.dao;

import com.techelevator.model.Vote;
import com.techelevator.model.VoteDTO;

import java.util.List;

public interface VoteDao {


    Vote getVoteById(int voteId);

    Vote createVote(VoteDTO voteDTO);

    //Vote getVoteByUserAndIssue(int userId, int issueId);

   // Vote getVotebyIssueAndSelectedOption(int issueId, int selectedOption);

    List<Integer> getSelectedOptionsByIssueId(int issueId);

    boolean hasVoteByUserAndIssue(int userId, int issueId);
}