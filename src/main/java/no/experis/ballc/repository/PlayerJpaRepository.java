package no.experis.ballc.repository;

import no.experis.ballc.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, Integer> {
    List<Player> findByTeamId(int teamId);
}
