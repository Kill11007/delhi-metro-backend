package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.MetroLine;
import lombok.Data;

@Data
public class MetroLineDTO {
    private Integer lineId;
    private String name;
    private String status;
    private String lineColor;
    private String lineCode;
    private String primaryColorCode;
    private String secondaryColorCode;
    private String classPrimary;
    private String classSecondary;
    private String startStation;
    private String endStation;

    public MetroLineDTO(MetroLine metroLine){
        this.lineId = metroLine.getLineId();
        this.name = metroLine.getName();
        this.status = metroLine.getStatus();
        this.lineColor = metroLine.getLineColor();
        this.lineCode = metroLine.getLineCode();
        this.primaryColorCode = metroLine.getPrimaryColorCode();
        this.secondaryColorCode = metroLine.getSecondaryColorCode();
        this.classPrimary = metroLine.getClassPrimary();
        this.classSecondary = metroLine.getClassSecondary();
        this.startStation = metroLine.getStartStation().getStationName();
        this.endStation = metroLine.getEndStation().getStationName();
    }
}
