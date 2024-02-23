package helmes;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationInit implements CommandLineRunner {


    @Override
    public void run(String... args) {
        // Test data insertion if necessary
    }
}
