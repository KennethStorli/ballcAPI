package no.experis.ballc.repository;

import no.experis.ballc.model.MatchGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchGoalJpaRepository extends JpaRepository<MatchGoal, Integer> {
//    List<MatchGoal> findByPlayer(int playerId);
}
