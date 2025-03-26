package ru.hollow.blockhound.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TaskDto(
        @JsonProperty("name")
        String name,
        @JsonProperty("createdBy")
        String createdBy,
        @JsonProperty("description")
        String description
) {
}
