package com.reactive.examples.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Artist {
    @Id
    private Integer id;
    private String name;
    private String imgSrc;
    private String url;
    private Integer rank;
}
