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

  public ComputerGame(final String name, 
                      final PegiAgeRating pegiAgeRating,
                      final Double budgetInMillionsOfDollars,
                      final Integer minimumGpuMemoryInMegabytes,
                      final Integer diskSpaceNeededInGB,
                      final Integer ramNeededInGb,
                      final Integer coresNeeded,
                      final Double coreSpeedInGhz) {
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

  public Requirements(final Integer gpuGb,
                      final Integer HDDGb,
                      final Integer RAMGb,
                      final Double cpuGhz,
                      final Integer coresNum) {
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
    final StatisticsLogger statisticsLogger = new WithMeanStatisticsLogger(
                                              new WithSummaryStatisticsLogger(
                                              new ExecutionTimesBaseStatistics(List.of(1.2, 2.2, 3.4))));
    statisticsLogger.displayStatistics();
  }
}
```

### Zadanie 8 - observer

Wykorzystując wzorzec projektowy **observer** zaimplementuj program, który daje możliwość obserwowania pewnej liczby i reakcji na jej zmianę.
W tym celu zaimplementuj:

* klasę `Subject`, która ma pola: 
    * `observers` typu `List<Observer>`
    * `value` type `int`
    * oraz ma możliwość zarejestrowania `Observera` (tzn. subskrypcji), zaktualizowanie pola value i poinformowaniu wszystkich observerów o aktualizacji wartości.

* klasę **abstrakcyjną** `Observer`, która ma pola:
    * `subject` type `Subject`
    * abstrakcyjną metodę `void update()`, która jest reakcja na zmianę stanu (tzn. pola `value` w klasie `Subject`)

* 3 implementacje klasy `Observer`, które w konstruktorze przyjmują pole typu `Subject` i subskrybują się do niego
    * klasę `ConcreteValueObserver`, która w metodzie `update()` zawsze wypisuje nową wartość na ekran
    * klasę `ValueLoweredObserver`, która w metodzie `update()` wypisuje nową wartość na ekran tylko, gdy zaktualizowana wartość jest mniejsza niż poprzednia
    * klasę `ByTenChangedObserver`, która w metodzie `update()` wypisuje wartość na ekran, jeżeli nowa wartość różni się przynajmniej o 10 od poprzedniej.

* klasę, która w metodzie main stworzy instancję klasy `Subject` oraz każdy z 3 typów observerów.
Zasubskrybuj je do obiektu typu `Subject`. Następnie kilka razy zaktualizuj wartość na obiekcie `Subject` i poinformuj wszystkich observerów o zmianach.

### Zadanie 9 - memento

Stwórz prostą implementację edytora tekstowego, który ma możliwość cofnięcia ostatnich zmian (podobnie jak naciśnięcie kombinacji `Ctrl + Z` w IntelliJ).
Aplikacja ta powinna wykorzystywać wzorzec **memento**. Zaimplementuj:

* klasę `EditorText`, która posiada pole `value` typu `String`, które reprezentuje aktualną wartość tekstu w edytorze tekstowym
* klasę `EditorTextMemento`, która reprezentuje zapis obiektu `EditorText`
    * klasa ta powinna posiadać pole `value` typu `String` i powinna przyjmować obiekt typu `EditorText` w konstruktorze
* klasę `EditorTextMementoManager`, która zarządza listą obiektów memento jako stos (wykorzystaj `ArrayDeque`). Dodaj metody:
    * `save`, która dodaje nowy zapis na stos.
    * `restore`, która usuwa ostatni wpis ze stosu i go zwraca.
* do klasy `EditorText` dodaj metodę `restoreFromMemento`, która przywraca stan wartości tekstu edytora na podstawie zapisanego stanu (tzn. na podstawie obiektu `EditorTextMemento`)
* klasę z metodą `main`, przetestuj swoją implementację, zmieniając i zapisując wartość edytora tekstowego kilka razy, a następnie przywracając kolejne zapisane stany.

### Zadanie 10 - template

Wykorzystując wzorzec `template method`, stwórz szkielet testu wydajnościowego:

* stwórz klasę **abstrakcyjną** `PerformanceTestTemplate`, a niej 3 metody abstrakcyjne:
    * `void testIteration()` - wykonująca pojedynczą iterację testu
    * `int getWarmupIterationsNum()` - zwracająca ilość iteracji rozgrzewających JVM
    * `int getIterationsNum()` - zwracająca ilość iteracji w teście
* do klasy `PerformanceTestTemplate` dodaj metodę void `run()`, która najpierw wykonuje rozgrzewkowe iteracje testu (których wyniki są ignorowane), a następnie właściwe iteracje testu. Test taki po wykonaniu wszystkich iteracji powinien wyświetlić na ekranie średni czas trwania pojedynczej iteracji
* implementację klasy `PerformanceTestTemplate`, która podczas pojedynczej iteracji, stwórz listę losowych 10000 liczb całkowitych typu `Long`. Zapisz je do listy, a następnie posortuj.
* klasę, z metodą `main`, która uruchomi stworzony test.

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

### Zadanie 8

```java
public abstract class Observer {

  protected Subject subject;

  public Observer(final Subject subject) {
    this.subject = subject;
    subject.subscribe(this);
  }

  // reakcja na zmianę stanu
  public abstract void update();
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Subject {
  private final List<Observer> observers;
  private int state = 0;

  public Subject() {
    observers = new ArrayList<>();
  }

  public void subscribe(final Observer observer) {
    if (!observers.contains(observer)) {
      observers.add(observer);
    }
  }

  public void changeStateBy(final int change) {
    state += change;
    observers.forEach(Observer::update);
  }

  public int getState() {
    return state;
  }
}
```

```java
public class SpecificValueObserver extends Observer {

  public SpecificValueObserver(final Subject subject) {
    super(subject);
  }

  @Override
  public void update() {
    System.out.println("Specific value observer: " + subject.getState());
  }
}
```

```java
public class ValueLoweredObserver extends Observer {

  private int previousState;

  public ValueLoweredObserver(final Subject subject) {
    super(subject);
    previousState = subject.getState();
  }

  @Override
  public void update() {
    if (subject.getState() < previousState) {
      System.out.println("Value lowered and is now: " + subject.getState());
    }
    previousState = subject.getState();
  }
}
```

```java
public class ByTenChangedObserver extends Observer {

  private int previousState;

  public ByTenChangedObserver(final Subject subject) {
    super(subject);
    previousState = subject.getState();
  }

  @Override
  public void update() {
    if (Math.abs(subject.getState() - previousState) >= 10) {
      System.out.println("Value changed by ten and is now: " + subject.getState());
    }
    previousState = subject.getState();
  }
}
```

### Zadanie 9

```java
public class EditorText {
  private String value = "";

  public void addText(final String textToAdd) {
    value += textToAdd;
  }

  public String getValue() {
    return value;
  }

  public void restoreFromMemento(final EditorTextMemento memento) {
    value = memento.getValue();
  }
}
```

```java
public class EditorTextMemento {

  private final String value;

  public EditorTextMemento(final EditorText editorText) {
    value = editorText.getValue();
  }

  public String getValue() {
    return value;
  }
}
```

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class EditorTextMementoManager {

  private final Deque<EditorTextMemento> mementos = new ArrayDeque<>();

  public void save(final EditorTextMemento memento) {
    mementos.push(memento);
  }
  public EditorTextMemento restore() {
    return mementos.pop();
  }
}
```

```java
public class MementoDemo {
  public static void main(String[] args) {
    final EditorText editorText = new EditorText();
    final EditorTextMementoManager mementoManager = new EditorTextMementoManager();
    mementoManager.save(new EditorTextMemento(editorText));

    editorText.addText("This is first line");
    mementoManager.save(new EditorTextMemento(editorText));

    editorText.addText("\nThis is second line");
    mementoManager.save(new EditorTextMemento(editorText));

    editorText.addText("\nThis is third line");
    mementoManager.save(new EditorTextMemento(editorText));

    editorText.addText(" This is second part of 3rd line");
    mementoManager.save(new EditorTextMemento(editorText));

    System.out.println(editorText.getValue());
    System.out.println();

    mementoManager.restore();
    mementoManager.restore();
    editorText.restoreFromMemento(mementoManager.restore());
    System.out.println(editorText.getValue());

  }
}
```

### Zadanie 10

```java
import java.util.ArrayList;
import java.util.List;

public abstract class PerformanceTestTemplate {

  protected abstract int getWarmUpIterationNum();

  protected abstract int getIterationNum();

  protected abstract void iteration();

  public void run() {
    for (int idx = 0; idx < getWarmUpIterationNum(); idx++) {
      iteration();
    }

    final List<Long> iterationsExecutionTimes = new ArrayList<>();
    for (int idx = 0; idx < getIterationNum(); idx++) {
      final long start = System.currentTimeMillis();
      iteration();
      final long end = System.currentTimeMillis();
      iterationsExecutionTimes.add(end - start);
    }

    final double avg = iterationsExecutionTimes.stream()
        .mapToDouble(x -> x).sum() / getIterationNum();

    System.out.println("Avg time per iteration: " + avg);
  }
}

```

```java
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingPerformanceTest extends PerformanceTestTemplate {
  @Override
  protected int getWarmUpIterationNum() {
    return 2;
  }

  @Override
  protected int getIterationNum() {
    return 100;
  }

  @Override
  protected void iteration() {
    final List<Long> longs = Stream.generate(() -> new Random().nextLong())
        .limit(10000).collect(Collectors.toList());
    final List<Long> sortedValues = longs.stream()
        .sorted()
        .collect(Collectors.toList());
  }
}

```

```java
public class TemplateDemo {
  public static void main(String[] args) {
    final PerformanceTestTemplate test = new SortingPerformanceTest();
    test.run();
  }
}
```

