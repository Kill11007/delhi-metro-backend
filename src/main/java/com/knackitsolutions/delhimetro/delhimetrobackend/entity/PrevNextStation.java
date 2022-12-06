package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "prev_next_station")
public class PrevNextStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "metro_line_id", referencedColumnName = "lineId")
    private MetroLine metroLine;
    @ManyToOne
    @JoinColumn(name = "prev_station")
    private StationInfo prevStation;

    @ManyToOne
    @JoinColumn(name = "next_station")
    private StationInfo nextStation;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private StationInfo station;
}
