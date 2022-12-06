package com.knackitsolutions.delhimetro.delhimetrobackend.entity;

import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "metro_lines")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MetroLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer lineId;
    private String name;
    private String status;
    private String lineColor;
    private String lineCode;
    private String primaryColorCode;
    private String secondaryColorCode;
    private String classPrimary;
    private String classSecondary;
    @JoinColumn(name = "start_station", referencedColumnName = "id")
    @ManyToOne
    private Station startStation;
    @JoinColumn(name = "endStation", referencedColumnName = "id")
    @ManyToOne
    private Station endStation;

    @OneToMany(mappedBy = "metroLine")
    private List<PrevNextStation> prevNextStations;

    public MetroLine(DelhiMetroStationInfoResponse.MetroLine metroLine){
        setLineId(metroLine.getId());
        setName(metroLine.getName());
        setStatus(metroLine.getStatus());
        setLineColor(metroLine.getLineColor());
        setLineCode(metroLine.getLineCode());
        setPrimaryColorCode(metroLine.getPrimaryColourCode());
        setSecondaryColorCode(metroLine.getSecondaryColourCode());
        setClassPrimary(metroLine.getClassPrimary());
        setClassSecondary(metroLine.getClassSecondary());
    }

    public void update(DelhiMetroStationInfoResponse.MetroLine metroLine) {

    }

}
