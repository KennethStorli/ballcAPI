package no.experis.ballc.repository;

import no.experis.ballc.model.MatchPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchPositionJpaRepository extends JpaRepository<MatchPosition, Integer> {
}
