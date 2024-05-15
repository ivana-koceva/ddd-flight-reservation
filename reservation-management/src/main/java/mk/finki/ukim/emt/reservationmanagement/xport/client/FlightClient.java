package mk.finki.ukim.emt.reservationmanagement.xport.client;

import mk.finki.ukim.emt.reservationmanagement.domain.valueobjects.FlightId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class FlightClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public FlightClient(@Value("${app.flight-list.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<FlightId> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/flight").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<FlightId>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
