package nl.capite.nixpoll.controllers;

import nl.capite.nixpoll.models.Poll;
import nl.capite.nixpoll.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    @CrossOrigin
    @GetMapping("/")
    private List<Poll> getPolls() {
        return pollService.getAllPolls();
    }

    @CrossOrigin
    @GetMapping("/{pollId}")
    private Poll getPollById(@PathVariable(value = "pollId") int pollId) {
        System.out.println(pollId);
        return pollService.getPollById(pollId);
    }

    @PostMapping
    private Poll savePoll(@RequestBody Poll poll) {
        Poll p = pollService.savePoll(poll);
        return p;
    }
}
