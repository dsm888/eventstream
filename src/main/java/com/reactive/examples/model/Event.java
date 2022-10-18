package com.reactive.examples.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    @Id
    private Integer id;
    private String title;
    private String dateStatus;
    private String timeZone;
    private String startDate;
    private List<Artist> artists;
    private boolean hiddenFromSearch;
}
