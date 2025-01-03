package services;

import org.example.VideoService;
import org.example.VideoServiceProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoServiceProxyTest {
    @Test
    void testAccessForPremiumUser() {
        VideoService proxy = new VideoServiceProxy(true);
        assertDoesNotThrow(() -> proxy.playVideo("Vingadores"));
    }

    @Test
    void testAccessForBasicUser() {
        VideoService proxy = new VideoServiceProxy(false);

        // Capture the output using System.setOut for assertions
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        proxy.playVideo("Exclusive Movie");

        assertTrue(outContent.toString().contains("Acesso negado"));
    }
}
