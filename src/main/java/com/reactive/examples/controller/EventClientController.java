package com.reactive.examples.controller;

import com.reactive.examples.client.EventClient;
import com.reactive.examples.model.Artist;
import com.reactive.examples.model.Event;
import com.reactive.examples.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.List;

@RestController
@RequestMapping("/artists/")
public class EventClientController {

    @Autowired
    private EventClient eventClient;

    @GetMapping("/{artistId}")
    public Flux<Tuple2<Artist,Event>> searchArtists(@PathVariable Integer artistId) {
        return eventClient.getAllArtists(artistId);
    }

}
