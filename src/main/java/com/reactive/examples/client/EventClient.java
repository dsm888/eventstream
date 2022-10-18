package com.reactive.examples.client;

import com.reactive.examples.model.Artist;
import com.reactive.examples.model.Event;
import com.reactive.examples.model.Venue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Component
@Slf4j
public class EventClient {
    private WebClient client = WebClient.create("https://iccp-interview-data.s3-eu-west-1.amazonaws.com/78656681");

    public Flux<Tuple2<Artist,Event>> getAllArtists(Integer artistId) {
        return Flux.zip(searchArtists(artistId),
                searchEvents(artistId));
    }
    public Flux<Artist> searchArtists(Integer artistId) {
        return client.get()
                .uri("/artists.json")
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(Artist.class))
                .filter(e-> e.getId()==artistId)
                .log("artists Fetched : ");
    }
    public Flux<Event> searchEvents(Integer artistId) {
        return client.get()
                .uri("/events.json")
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(Event.class))
                .filter(e-> e.getArtists().stream().anyMatch(e1-> e1.getId()==artistId))
                .log("EVents Fetched : ");
    }

    public Flux<Venue> getAllVenues() {
        return client.get()
                .uri("/venues.json")
                .exchange().flatMapMany(clientResponse -> clientResponse.bodyToFlux(Venue.class)).log("Venues Fetched : ");
    }

}
