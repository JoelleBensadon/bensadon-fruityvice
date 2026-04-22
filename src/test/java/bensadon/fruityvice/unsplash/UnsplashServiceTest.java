package bensadon.fruityvice.unsplash;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnsplashServiceTest {

    @Test
    void photosStructure() {

        // Given
        UnsplashService service = new UnsplashServiceFactory().create();


        // When

        Photos photos = service.search("strawberry").blockingGet();
        // Then
        assertNotNull(photos.results.get(0).urls.small);    }
}