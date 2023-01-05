package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "prev_next_stations")
@NoArgsConstructor
public class PrevNextStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "line_id")
    private MetroLine metroLine;
    @ManyToOne
    @JoinColumn(name = "prev_station")
    private Station prevStation;

    @ManyToOne
    @JoinColumn(name = "next_station")
    private Station nextStation;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    public PrevNextStation(Station station, MetroLine  metroLine, Station nextStation, Station prevStation){
        setStation(station);
        setMetroLine(metroLine);
        setPrevStation(prevStation);
        setNextStation(nextStation);
    }
}
