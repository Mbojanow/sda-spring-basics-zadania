# Spring zadania

## zadanie 7

Do klasy konfiguracyjnej SdaConfiguration dodaj pole `count`. Niech obiekt SdaConfiguration będzie walidowany na starcie
aplikacji i niech pola spełniają następujące warunki:
- pole `key` niech będzie miało długość conajmniej 3. Nie zmieniaj domyślnej wiadomości błędu.
- pole `value` niech będzie miało długość pomiędzy 1 a 25. Nie zmieniaj domyślnej wiadomości błędu.
- pole `count` niech będzie miało minimalną wartość 3. Nie zmieniaj domyślnej wiadomości błędu.
- pole `count` dodatkowo nie może mieć wartości `null`. Nadpisz domyślną wiadomość: `count cannot be null`.
