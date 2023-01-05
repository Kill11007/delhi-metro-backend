package com.knackitsolutions.delhimetro.delhimetrobackend.repository;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.StationFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationFacilityRepository extends JpaRepository<StationFacility, Long> {
}
