package bensadon.fruityvice.unsplash;

import com.andrewoid.apikeys.ApiKey;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnsplashServiceTest {

    @Test
    void search() {

        // Given
        ApiKey apiKey = new ApiKey();
        String keyString = apiKey.get();
        UnsplashService service = new UnsplashServiceFactory().create();


        // When
        Photos photos = service.search(
                keyString,
                "strawberry"
        ).blockingGet();
        // Then
        assertNotNull(photos.results.get(0).urls.small);
    }
}