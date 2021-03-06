package no.experis.ballc.repository;

import no.experis.ballc.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerJpaRepository extends JpaRepository<Owner, Integer> {
}
