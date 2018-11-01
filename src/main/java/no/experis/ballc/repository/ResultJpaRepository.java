package no.experis.ballc.repository;

import no.experis.ballc.model.Result;
import no.experis.ballc.model.ResultId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultJpaRepository extends JpaRepository<Result, ResultId> {

    /*
    @Query("SELECT t FROM Result t WHERE t.")
    public Optional<Result> findById(ResultId id);
    */
}
