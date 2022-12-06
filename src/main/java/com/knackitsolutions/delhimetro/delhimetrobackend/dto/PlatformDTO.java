package com.knackitsolutions.delhimetro.delhimetrobackend.dto;

import com.knackitsolutions.delhimetro.delhimetrobackend.entity.Platform;
import lombok.Data;

@Data
public class PlatformDTO {
    private Long id;
    private String platformNames;
    private String platformCode;

    public PlatformDTO(Platform platform){
        this.id = platform.getId();
        this.platformNames = platform.getPlatformNames();
        this.platformCode = platform.getPlatformCode();
    }
}
