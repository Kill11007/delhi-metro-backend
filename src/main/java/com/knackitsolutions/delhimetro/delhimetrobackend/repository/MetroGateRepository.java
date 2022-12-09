package com.knackitsolutions.delhimetro.delhimetrobackend.repository;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.MetroGate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetroGateRepository extends JpaRepository<MetroGate,Long> {
    boolean existsByGateCodeAndStationInfoId(String code, Long id);
}
