package guru.sfg.beer.inventory.service.bootstrap;

import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by jt on 2019-05-17.
 */
@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerInventoryRepository beerRepository;

    @Override
    public void run(String... args) {

        if (beerRepository.count() == 0) {
            loadBeerObjects();
        }
    }

    private void loadBeerObjects() {
        BeerInventory b1 = BeerInventory.builder()
                .beerId(UUID.randomUUID())
                .quantityOnHand(200)
                .upc(BEER_1_UPC)
                .build();

        BeerInventory b2 = BeerInventory.builder()
                .beerId(UUID.randomUUID())
                .quantityOnHand(200)
                .upc(BEER_2_UPC)
                .build();

        BeerInventory b3 = BeerInventory.builder()
                .beerId(UUID.randomUUID())
                .quantityOnHand(200)
                .upc(BEER_3_UPC)
                .build();

        beerRepository.save(b1);
        beerRepository.save(b2);
        beerRepository.save(b3);
    }
}