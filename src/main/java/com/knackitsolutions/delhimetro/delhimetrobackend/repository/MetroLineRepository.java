package com.knackitsolutions.delhimetro.delhimetrobackend.repository;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.MetroLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetroLineRepository extends JpaRepository<MetroLine,Long> {
    Optional<MetroLine> findByLineId(Integer lineId);

}
