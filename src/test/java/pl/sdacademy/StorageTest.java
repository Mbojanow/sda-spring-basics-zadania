package pl.sdacademy;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

  private static final String EXAMPLE_DATA = "Hello";

  private static Connection connection;
  private Storage storage;

  @BeforeAll
  static void setUpTestCase() throws InterruptedException {
    connection = new Connection();
    connection.open();
  }

  @AfterAll
  static void tearDownTestCase() throws InterruptedException {
    connection.close();
  }

  @BeforeEach
  void setUp() {
    storage = new Storage(connection);
  }

  @AfterEach
  void tearDown() {
    connection.refresh();
  }

  @Test
  void shouldAddDataToStorage() {
    final int result = storage.addValue(EXAMPLE_DATA);

    assertEquals(1, result);
    assertTrue(storage.getData().contains(EXAMPLE_DATA));
  }

  @Test
  void shouldRemoveExistingData() {
    storage.addValue(EXAMPLE_DATA);

    final boolean removeResult = storage.removeValue(EXAMPLE_DATA);

    assertTrue(removeResult);
  }

  @Test
  void shouldNotRemoveNonExistingData() {
    storage.addValue(EXAMPLE_DATA);

    final boolean removeResult = storage.removeValue("NotExistingData");

    assertFalse(removeResult);
    assertEquals(storage.getData().size(), 1);
  }

}