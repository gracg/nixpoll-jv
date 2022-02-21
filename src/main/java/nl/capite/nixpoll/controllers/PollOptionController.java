package nl.capite.nixpoll.controllers;

import nl.capite.nixpoll.models.PollOption;
import nl.capite.nixpoll.services.PollOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/options")
public class PollOptionController {

    @Autowired
    private PollOptionService pollOptionService;

    @GetMapping(value = "/increment/{optionId}")
    public void incrementVote(@PathVariable(value = "optionId") int optionId) {
        pollOptionService.incrementCountForPollId(optionId);
    }
}
