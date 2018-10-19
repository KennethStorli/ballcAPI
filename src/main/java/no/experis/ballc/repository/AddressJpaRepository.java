package no.experis.ballc.repository;

import no.experis.ballc.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJpaRepository extends JpaRepository<Address, String> {
}
