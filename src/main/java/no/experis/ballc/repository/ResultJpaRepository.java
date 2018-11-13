package no.experis.ballc.repository;

import no.experis.ballc.model.Player;
import no.experis.ballc.model.Result;
import no.experis.ballc.model.ResultId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultJpaRepository extends JpaRepository<Result, ResultId> {
}
