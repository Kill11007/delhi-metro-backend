package com.knackitsolutions.delhimetro.delhimetrobackend.repository;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station,Long> {
    boolean existsByStationId(Integer id);

    List<Station> findByStationNameLike(String start);

    Optional<Station> findByStationCode(String code);
}
