# Wzorce projektowe - zadania

## Zadania

### Zadanie 1 - singleton

Stwórz singleton `Servers` typu `lazy`. Singleton ten przechowuje listę serwerów (jako `String`).
Zaimplementuj następujące funkcjonalności:

* dodanie serwera do listy
    * metoda dodająca serwer do listy powinna zwracać `boolean` (`true` jeżeli serwer dostał dodany do liste, `false` w przeciwnym wypadku)
    * dodanie jest możliwe, jeżeli jego nazwa zaczyna się od `http` lub `https`
    * dodanie zduplikowanej nazwy jest niemożliwe.
* pobranie listy serwerów, których nazwa zaczyna się od `http`.
* pobranie listy serwerów, których nazwa zaczyna się od `https`.

### Zadanie 2 - singleton

Zmień singleton z zadania 1 w taki sposób, aby można było z niego korzystać w aplikacji wielowątkowej. 

### Zadanie 3 - singleton

Zmień typ singletonu z poprzedniego zadania. Wykorzystaj singleton typu `eager`.

### Zadanie 4 - singleton

Zmień typ singletonu z poprzedniego zadania. Wykorzystaj `enum`. 

### Zadanie 5 - builder    

Stwórz builder dla klasy, która ma następujące pola:

```java
public class Dog {

  private String name;
  private String type;
  private Integer age;
  private List<String> toys;
```             

Builder powinien zostać zdefiniowany wewnątrz klasy `Dog` i powinien być <b>jedynym</b> sposobem stworzenia jej instancji.

### Zadania 6 - adapter

Stwórz adapter klasy `ComputerGame` do interfejsu `PCGame`.

Uwagi:
* liczba w nazwie wartości `PegiAgeRating` oznacza minimalny wiek gracza
* potraktuj grę jako `TripleA` jeżeli jej budżet przekracza 50 milionów.

```java
public class ComputerGame {
  private final String name;
  private final PegiAgeRating pegiAgeRating;
  private final Double budgetInMillionsOfDollars;
  private final Integer minimumGpuMemoryInMegabytes;
  private final Integer diskSpaceNeededInGB;
  private final Integer ramNeededInGb;
  private final Integer coresNeeded;
  private final Double coreSpeedInGhz;

  public ComputerGame(final String name, final PegiAgeRating pegiAgeRating, final Double budgetInMillionsOfDollars, final Integer minimumGpuMemoryInMegabytes, final Integer diskSpaceNeededInGB, final Integer ramNeededInGb, final Integer coresNeeded, final Double coreSpeedInGhz) {
    this.name = name;
    this.pegiAgeRating = pegiAgeRating;
    this.budgetInMillionsOfDollars = budgetInMillionsOfDollars;
    this.minimumGpuMemoryInMegabytes = minimumGpuMemoryInMegabytes;
    this.diskSpaceNeededInGB = diskSpaceNeededInGB;
    this.ramNeededInGb = ramNeededInGb;
    this.coresNeeded = coresNeeded;
    this.coreSpeedInGhz = coreSpeedInGhz;
  }

  public String getName() {
    return name;
  }

  public PegiAgeRating getPegiAgeRating() {
    return pegiAgeRating;
  }

  public Double getBudgetInMillionsOfDollars() {
    return budgetInMillionsOfDollars;
  }

  public Integer getMinimumGpuMemoryInMegabytes() {
    return minimumGpuMemoryInMegabytes;
  }

  public Integer getDiskSpaceNeededInGB() {
    return diskSpaceNeededInGB;
  }

  public Integer getRamNeededInGb() {
    return ramNeededInGb;
  }

  public Integer getCoresNeeded() {
    return coresNeeded;
  }

  public Double getCoreSpeedInGhz() {
    return coreSpeedInGhz;
  }
}
``` 

```java
public enum PegiAgeRating {
  P3, P7, P12, P16, P18
}
```

```java
public class Requirements {
  private final Integer gpuGb;
  private final Integer HDDGb;
  private final Integer RAMGb;
  private final Double cpuGhz;
  private final Integer coresNum;

  public Requirements(final Integer gpuGb, final Integer HDDGb, final Integer RAMGb, final Double cpuGhz, final Integer coresNum) {
    this.gpuGb = gpuGb;
    this.HDDGb = HDDGb;
    this.RAMGb = RAMGb;
    this.cpuGhz = cpuGhz;
    this.coresNum = coresNum;
  }

  public Integer getGpuGb() {
    return gpuGb;
  }

  public Integer getHDDGb() {
    return HDDGb;
  }

  public Integer getRAMGb() {
    return RAMGb;
  }

  public Double getCpuGhz() {
    return cpuGhz;
  }

  public Integer getCoresNum() {
    return coresNum;
  }
}
```

```java
public interface PCGame {
  String getTitle();
  Integer getPegiAllowedAge();
  boolean isTripleAGame();
  Requirements getRequirements();
}
```

### Zadanie 7 - decorator

Dla klasy `ExecutionTimesBaseStatistics`, wykorzystując interfejs `StatisticsLogger`, stwórz dwa dekoratory, które dodają następującą funkcjonalność:

* `WithMeanStatisticsLogger`, który wyświetla średnią wyników (wartości listy `executionTimes` w `ExecutionTimesBaseStatistics`) <b>przed</b> wyświetleniem poszczególnych wyników
* `WithSummaryStatisticsLogger`, która <b>przed</b> wyświetleniem poszczególnych wyników, wyświetla następujące statystyki:
    * ilość rekordów
    * suma
    * wartość minimalna
    * wartość maksymalna
    
```java
import java.util.List;

public interface StatisticsLogger {
  void displayStatistics();
  List<Double> getExecutionTimes();
}
```

```java
import java.util.List;

public class ExecutionTimesBaseStatistics implements StatisticsLogger {
  private final List<Double> executionTimes;

  public ExecutionTimesBaseStatistics(final List<Double> executionTimes) {
    this.executionTimes = executionTimes;
  }

  @Override
  public void displayStatistics() {
    final StringBuilder stringBuilder = new StringBuilder();
    executionTimes.forEach(executionTime -> stringBuilder.append("Execution time: ").append(executionTime).append("\n"));
    System.out.println(stringBuilder.toString());
  }

  @Override
  public List<Double> getExecutionTimes() {
    return executionTimes;
  }
}
```

Przykładowy main:
```java
public class DecoratorDemo {
  public static void main(String[] args) {
    final StatisticsLogger statisticsLogger = new WithMeanStatisticsLogger(new WithSummaryStatisticsLogger(new ExecutionTimesBaseStatistics(List.of(1.2, 2.2, 3.4))));
    statisticsLogger.displayStatistics();
  }
}
```

### Zadanie 8 - observer



## Rozwiązania:

### Zadanie 1

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Servers {

  private static Servers instance;

  public Servers getInstance() {
    if (instance == null) {
      instance = new Servers();
    }
    return instance;
  }

  private final List<String> serverList;

  private Servers() {
    serverList = new ArrayList<>();
  }

  public boolean addServer(final String server) {
    if ((server.startsWith("http") || server.startsWith("https")) && !serverList.contains(server)) {
      return serverList.add(server);
    }
    return false;
  }

  public List<String> getHttpServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("http"))
        .collect(Collectors.toUnmodifiableList());
  }

  private List<String> getServersStartingWith(final String prefix) {
    return serverList.stream()
        .filter(server -> server.startsWith(prefix))
        .collect(Collectors.toUnmodifiableList());
  }

  public List<String> getHttpsServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("https"))
        .collect(Collectors.toUnmodifiableList());
  }
}
```

### Zadanie 2

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Servers {

  private static Servers instance;

  public Servers getInstance() {
    if (instance == null) {
      synchronized (Servers.class) {
        if (instance == null) {
          instance = new Servers();
        }
      }
    }
    return instance;
  }

  private final List<String> serverList;

  private Servers() {
    serverList = new ArrayList<>();
  }

  public boolean addServer(final String server) {
    if ((server.startsWith("http") || server.startsWith("https")) && !serverList.contains(server)) {
      return serverList.add(server);
    }
    return false;
  }

  public List<String> getHttpServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("http"))
        .collect(Collectors.toUnmodifiableList());
  }

  private List<String> getServersStartingWith(final String prefix) {
    return serverList.stream()
        .filter(server -> server.startsWith(prefix))
        .collect(Collectors.toUnmodifiableList());
  }

  public List<String> getHttpsServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("https"))
        .collect(Collectors.toUnmodifiableList());
  }
}
```

### Zadanie 3

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Servers {

  private static final Servers INSTANCE = new Servers();

  public Servers getInstance() {
    return INSTANCE;
  }

  private final List<String> serverList;

  private Servers() {
    serverList = new ArrayList<>();
  }

  public boolean addServer(final String server) {
    if ((server.startsWith("http") || server.startsWith("https")) && !serverList.contains(server)) {
      return serverList.add(server);
    }
    return false;
  }

  public List<String> getHttpServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("http"))
        .collect(Collectors.toUnmodifiableList());
  }

  private List<String> getServersStartingWith(final String prefix) {
    return serverList.stream()
        .filter(server -> server.startsWith(prefix))
        .collect(Collectors.toUnmodifiableList());
  }

  public List<String> getHttpsServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("https"))
        .collect(Collectors.toUnmodifiableList());
  }
}

```

### Zadanie 4

```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum Servers {
  INSTANCE;

  private final List<String> serverList;

  Servers() {
    serverList = new ArrayList<>();
  }

  public boolean addServer(final String server) {
    if ((server.startsWith("http") || server.startsWith("https")) && !serverList.contains(server)) {
      return serverList.add(server);
    }
    return false;
  }

  public List<String> getHttpServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("http"))
        .collect(Collectors.toUnmodifiableList());
  }

  private List<String> getServersStartingWith(final String prefix) {
    return serverList.stream()
        .filter(server -> server.startsWith(prefix))
        .collect(Collectors.toUnmodifiableList());
  }

  public List<String> getHttpsServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("https"))
        .collect(Collectors.toUnmodifiableList());
  }
}

```

### Zadanie 5

```java
import java.util.List;

public class Dog {

  private String name;
  private String type;
  private Integer age;
  private List<String> toys;

  protected Dog(final String name, final String type, final Integer age, final List<String> toys) {
    this.name = name;
    this.type = type;
    this.age = age;
    this.toys = toys;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(final Integer age) {
    this.age = age;
  }

  public List<String> getToys() {
    return toys;
  }

  public void setToys(final List<String> toys) {
    this.toys = toys;
  }

  public static class Builder {
    private String name;
    private String type;
    private Integer age;
    private List<String> toys;

    public Builder withName(final String name) {
      this.name = name;
      return this;
    }

    public Builder withType(final String type) {
      this.type = type;
      return this;
    }

    public Builder withName(final Integer age) {
      this.age = age;
      return this;
    }

    public Builder withToys(final List<String> toys) {
      this.toys = toys;
      return this;
    }

    public Dog build() {
      return new Dog(name, type, age, toys);
    }
  }
}
```

### Zadanie 6

```java
public class ComputerGameAdapter implements PCGame {

  private final ComputerGame computerGame;

  public ComputerGameAdapter(final ComputerGame computerGame) {
    this.computerGame = computerGame;
  }

  @Override
  public String getTitle() {
    return computerGame.getName();
  }

  @Override
  public Integer getPegiAllowedAge() {
    switch (computerGame.getPegiAgeRating()) {
      case P3:
        return 3;
      case P7:
        return 7;
      case P12:
        return 12;
      case P16:
        return 16;
      case P18:
        return 18;
    }
    throw new RuntimeException("Unsupported PEGI rating");
  }

  @Override
  public boolean isTripleAGame() {
    return computerGame.getBudgetInMillionsOfDollars() > 50;
  }

  @Override
  public Requirements getRequirements() {
    return new Requirements(computerGame.getMinimumGpuMemoryInMegabytes() / 1024,
        computerGame.getDiskSpaceNeededInGB(), computerGame.getRamNeededInGb(), computerGame.getCoreSpeedInGhz(),
        computerGame.getCoresNeeded());
  }
}
```

### Zadanie 7

```java
import java.util.List;

public class WithMeanStatisticsLogger implements StatisticsLogger {

  private final StatisticsLogger statisticsLogger;

  public WithMeanStatisticsLogger(final StatisticsLogger statisticsLogger) {
    this.statisticsLogger = statisticsLogger;
  }

  @Override
  public void displayStatistics() {
    final double mean = getExecutionTimes().stream().mapToDouble(x -> x).sum() / getExecutionTimes().size();
    System.out.println("Mean is " + mean);
    statisticsLogger.displayStatistics();
  }

  @Override
  public List<Double> getExecutionTimes() {
    return statisticsLogger.getExecutionTimes();
  }
}
```

```java
import java.util.List;

public class WithSummaryStatisticsLogger implements StatisticsLogger {
  private final StatisticsLogger statisticsLogger;

  public WithSummaryStatisticsLogger(final StatisticsLogger statisticsLogger) {
    this.statisticsLogger = statisticsLogger;
  }

  @Override
  public void displayStatistics() {
    System.out.println(getExecutionTimes().stream()
        .mapToDouble(x -> x).summaryStatistics());
    statisticsLogger.displayStatistics();
  }

  @Override
  public List<Double> getExecutionTimes() {
    return statisticsLogger.getExecutionTimes();
  }
}
```
