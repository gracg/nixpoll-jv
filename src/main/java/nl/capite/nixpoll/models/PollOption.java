package nl.capite.nixpoll.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "options")
public class PollOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int count;

    public PollOption() {
    }

    public PollOption(int id, int pollId, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollOption option = (PollOption) o;
        return id == option.id && count == option.count && Objects.equals(name, option.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count);
    }
}
