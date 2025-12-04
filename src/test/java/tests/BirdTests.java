package tests;

import animals.AnimalType;
import animals.petstore.pet.attributes.Breed;
import animals.petstore.pet.attributes.Gender;
import animals.petstore.pet.attributes.Skin;
import animals.petstore.pet.types.Bird;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BirdTests {

    private static Bird actualBird;

    @BeforeAll
    public static void createAnimals() {
        actualBird = new Bird(AnimalType.DOMESTIC, Skin.FEATHERS, Gender.UNKNOWN, Breed.UNKNOWN);
    }

    @Test
    @Order(1)
    @DisplayName("Animal Test Type Tests Domestic")
    public void animalTypeTests() {
        assertEquals(AnimalType.DOMESTIC, actualBird.getAnimalType(),
                "Animal Type Expected[" + AnimalType.DOMESTIC + "] Actual[" + actualBird.getAnimalType() + "]");
    }

    @Test
    @Order(1)
    @DisplayName("Bird Speak Tweet Tests")
    public void birdGoesTweetTest() {
        assertEquals("The bird goes tweet! tweet!", actualBird.speak(), "I was expecting tweet");
    }

    @Test
    @Order(1)
    @DisplayName("Bird Feathers is it Hyperallergetic")
    public void birdHyperAllergeticTests() {
        assertEquals("The bird is not hyperallergetic!", actualBird.birdHypoallergenic(),
                "The bird is not hyperallergetic!");
    }

    @Test
    @Order(1)
    @DisplayName("Bird has legs Test")
    public void legTests() {
        Assertions.assertNotNull(actualBird.getNumberOfLegs());
        assertEquals(2, actualBird.getNumberOfLegs(), "Birds should have 2 legs");
    }

    @Test
    @Order(1)
    @DisplayName("Bird can fly Test")
    public void canFlyTest() {
        assertTrue(actualBird.canFly(), "Domestic birds should be able to fly");
    }

    @Test
    @Order(2)
    @DisplayName("Bird Gender Test Male")
    public void genderTestMale() {
        actualBird = new Bird(AnimalType.WILD, Skin.FEATHERS, Gender.MALE, Breed.BLUE_JAY);
        assertEquals(Gender.MALE, actualBird.getGender(), "Expecting Male Gender!");
    }

    @Test
    @Order(2)
    @DisplayName("Bird Gender Test Female")
    public void genderTestFemale() {
        actualBird = new Bird(AnimalType.WILD, Skin.FEATHERS, Gender.FEMALE, Breed.CARDINAL);
        assertEquals(Gender.FEMALE, actualBird.getGender(), "Expecting Female Gender!");
    }

    @Test
    @Order(2)
    @DisplayName("Bird Breed Test BLUE_JAY")
    public void birdBreedBlueJayTest() {
        actualBird = new Bird(AnimalType.DOMESTIC, Skin.FEATHERS, Gender.MALE, Breed.BLUE_JAY);
        assertEquals(Breed.BLUE_JAY, actualBird.getBreed(), "Expecting Blue Jay breed!");
    }

    @Test
    @Order(2)
    @DisplayName("Bird Breed Test CARDINAL")
    public void birdBreedCardinalTest() {
        actualBird = new Bird(AnimalType.WILD, Skin.FEATHERS, Gender.FEMALE, Breed.CARDINAL);
        assertEquals(Breed.CARDINAL, actualBird.getBreed(), "Expecting Cardinal breed!");
    }

    @Test
    @Order(2)
    @DisplayName("Bird Speak Caw Tests - Wild")
    public void birdGoesCawTest() {
        actualBird = new Bird(AnimalType.WILD, Skin.FEATHERS, Gender.UNKNOWN, Breed.HAWK);
        assertEquals("The bird goes caw! caw!", actualBird.speak(), "I was expecting caw");
    }

    @Test
    @Order(2)
    @DisplayName("Bird Speak Chirp Tests - Unknown Type")
    public void birdGoesChirpTest() {
        actualBird = new Bird(AnimalType.UNKNOWN, Skin.FEATHERS, Gender.UNKNOWN, Breed.SPARROW);
        assertEquals("The bird goes Chirp! Chirp!", actualBird.speak(), "I was expecting Chirp");
    }

    @Test
    @Order(3)
    @DisplayName("Bird toString Test")
    public void birdToStringTest() {
        actualBird = new Bird(AnimalType.DOMESTIC, Skin.FEATHERS, Gender.MALE, Breed.ROBIN);
        String birdString = actualBird.toString();
        Assertions.assertNotNull(birdString);
        assertTrue(birdString.contains("BIRD"), "toString should contain pet type");
        assertTrue(birdString.contains("ROBIN"), "toString should contain breed");
    }

    @Test
    @Order(3)
    @DisplayName("Bird Hypoallergenic with Feathers")
    public void birdFeathersHypoallergenicTest() {
        actualBird = new Bird(AnimalType.DOMESTIC, Skin.FEATHERS, Gender.FEMALE, Breed.HUMMING_BIRD);
        assertEquals("The bird is not hyperallergenic!", actualBird.birdHypoallergenic(),
                "Birds with feathers should not be hyperallergenic");
    }
}