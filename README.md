# Spring zadania

## zadanie 5

Tabela 'movies' reprezentowana przez klasę Movie posiada następujące pola
- id, typu Long, które jest automatycznie generowanym identyfikatorem,
- title, typu String, które reprezentuje tytuł filmu,
- lengthInMinutes, typu Integer, które reprezentuje długość filmu w minutach.

Dodaj odpowiednie adnotacje do klasy Movie aby klasa ta reprezetowała opisaną wyżej encję.

Stwórz implementację klasy MovieCrudService. Klasa ta powinna implementować interfejs MovieRepository i
umożliwiać tworzyć, pobierać, usuwać i aktualizować rekordy Movie w bazie danych wykorzystując bean EntityManager.
Projekt aktualnie działa z bazą H2 i żadna konfiguracja nie jest wymagana. 
Pamiętaj różnież, że warstwa repozytorium (lub tzw. DAO) nie jest odpowiedzialna za walidację.

Sprawdź swoją implementację uruchamiając testy w klasie MovieCrudRepositoryTest.
Rozwiązanie zadania znajduje się na branchu `zad5_rozw`.
