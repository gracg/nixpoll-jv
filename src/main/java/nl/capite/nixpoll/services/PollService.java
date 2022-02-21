package nl.capite.nixpoll.services;

import nl.capite.nixpoll.models.Poll;
import nl.capite.nixpoll.models.PollOption;
import nl.capite.nixpoll.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PollService {

    @Autowired
    private PollRepository pollRepository;


    public Poll savePoll(Poll poll) {
        Poll p = pollRepository.save(poll);
        return p;
    }

    public void savePolls(List<Poll> polls) {
        pollRepository.saveAll(polls);
    }

    public Poll getPollById(int id) {
        return pollRepository.getById(id);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }


}
