package no.experis.ballc.repository;

import no.experis.ballc.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestJpaRepository extends JpaRepository<Test, Integer> {
}
