package nl.capite.nixpoll.repositories;

import nl.capite.nixpoll.models.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PollOptionRepository  extends JpaRepository<PollOption,Integer> {

    @Modifying
    @Query("UPDATE PollOption e set e.count=?2 WHERE e.id=?1")
    @Transactional
    public void UpdateCounter(int optionId,int count);

    public PollOption getCountById(int id);

}
