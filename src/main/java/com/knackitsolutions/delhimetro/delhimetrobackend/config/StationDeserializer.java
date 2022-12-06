package com.knackitsolutions.delhimetro.delhimetrobackend.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;

import java.io.IOException;

public class StationDeserializer extends StdDeserializer<DelhiMetroStationInfoResponse.Station> {
    public StationDeserializer(Class<?> vc) {
        super(vc);
    }

    public StationDeserializer() {
        this(null);
    }

    @Override
    public DelhiMetroStationInfoResponse.Station deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        System.out.println("JsonParsor: " + jsonParser.getText());
        System.out.println("TreeNode: " + treeNode.textValue());
        if (treeNode.textValue() == null || treeNode.textValue().equals("")) {
            return null;
        }

        return jsonParser.readValueAs(DelhiMetroStationInfoResponse.Station.class);
    }

}
