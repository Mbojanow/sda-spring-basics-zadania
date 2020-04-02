# Spring zadania

## zadanie 4

Stwórz serwis restowy (nie wykorzystując adnotacji @RestController) w klasie HelloWorldController. 
Klasa ta niech przechowuje obiekty typu Hello w liście (lista ta niech będzie polem klasy HelloWorldController).
Stwórz endpointy dla operacji CRUD. Niech bazowym adresem endpointów będzie "/api/hellos"

- niech endpoint pobierający wszystkie wiadomości zwraca wszystkie dostępne obiekty Hello opakowane w obiekt Hellos
- niech endpoint zwracający pojedynczy obiekt Hello, robi to po indeksie listy. Niech szukany indeks będzie częścią URLa,
 np. /api/hellos/1
- niech endpoint dodający obiekt Hello do listy, po dodaniu go do listy zwraca go ze statusem HTTP 201. 
 Obiekt Hello powinien przychodzić do requestu w body jako JSON
- niech endpoint aktualizujący obiekt Hello zwraca status 204. Indeks elementu do aktualizacji w liście powinien znajdować się w URLu,
 Obiekt Hello powinien przychodzić do requestu w body jako JSON
- niech endpoint usuwający obiekt Hello z listy zwraca status 204. Indeks usuwanego elementu powinien znajdować się z URLu

Podczas implementacji weź pod uwagę tylko tzw. happy flow. Zignoruj przypadki negatywne (tzn. nie implementuj żadnej walidacji).
Po skończeniu implementacji sprawdź swoją implementację uruchamiając testy w klasie HelloWorldController.
Rozwiązanie znajduje się na branchu zad4_rozw.




