package no.experis.ballc.repository;

import no.experis.ballc.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationJpaRepository extends JpaRepository<Association, Integer> {
}
