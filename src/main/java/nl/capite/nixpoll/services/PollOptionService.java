package nl.capite.nixpoll.services;

import nl.capite.nixpoll.models.Poll;
import nl.capite.nixpoll.models.PollOption;
import nl.capite.nixpoll.repositories.PollOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PollOptionService {

    @Autowired
    private PollService pollService;

    @Autowired
    private PollOptionRepository pollOptionRepository;


    public void incrementCountForPollId(int optionId) {
        int count = pollOptionRepository.getCountById(optionId).getCount();
        count = count + 1;
        pollOptionRepository.UpdateCounter(optionId,count);
    }



}
