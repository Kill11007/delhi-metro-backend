package com.knackitsolutions.delhimetro.delhimetrobackend.repository;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.PrevNextStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrevNextStationRepository extends JpaRepository<PrevNextStation,Long> {
}
