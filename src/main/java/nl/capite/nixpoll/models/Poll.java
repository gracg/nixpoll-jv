package nl.capite.nixpoll.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "polls")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="pollId", referencedColumnName = "id")
    private List<PollOption> options;

    public Poll() {
    }

    public Poll(int id, String title, String description, ArrayList<PollOption> options) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PollOption> getOptions() {
        return options;
    }

    public void setOptions(List<PollOption> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poll poll = (Poll) o;
        return id == poll.id && Objects.equals(title, poll.title) && Objects.equals(description, poll.description) && Objects.equals(options, poll.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, options);
    }
}
