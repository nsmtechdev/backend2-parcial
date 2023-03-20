package com.digitalmedia.users.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
public class UserRequest {

    @Schema(example = "avatar")
    private String avatar;
}
