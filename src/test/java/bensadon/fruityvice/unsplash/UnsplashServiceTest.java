package bensadon.fruityvice.unsplash;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnsplashServiceTest {

    @Test
    void photosStructure() {

        // Given
        Urls urls = new Urls();
        urls.small = "test-url";

        Result result = new Result();
        result.urls = urls;

        Photos photos = new Photos();
        photos.results = List.of(result);

        // When
        String imageUrl = photos.results.get(0).urls.small;

        // Then
        assertEquals("test-url", imageUrl);
    }
}