package com.project.nasa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPostDTO {

    private Long id;

    private List<Long> categoryIds;

    private List<Long> skillIds;

    private List<Long> userIds;

    private String name;
}
