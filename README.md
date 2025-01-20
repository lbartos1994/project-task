# Zadanie

Pracujesz nad aplikacją do zarządzania projektami, w której każdy projekt ma przypisane zadania.
Kod wykorzystuje REST API, Spring Data JPA oraz relację między encjami Project i Task. Twoim zadaniem jest:

## Poprawienie istniejących problemów:

- Wydajność: Zoptymalizuj operacje na bazie danych, szczególnie związane z relacją Project - Task. Upewnij się, że aplikacja unika problemów takich jak n+1 queries, niepotrzebne pobieranie dużych ilości danych, czy brak paginacji w zapytaniach.
- Błędy: Zidentyfikuj i popraw potencjalne błędy w kodzie, np. błędne mapowania encji, niespójności w danych, brak obsługi wyjątków.
- Czystość kodu: Uporządkuj kod, stosując dobre praktyki programistyczne, takie jak:
  - Rozdzielenie logiki na warstwy (kontroler, serwis, repozytorium),
  - Zastosowanie wzorców projektowych, np. Builder do konstruowania żłożonych obiektów czy DTO dla przesyłania danych między warstwami,
  - Dodanie odpowiedniej dokumentacji kodu i/lub komentarzy.

## Dodanie nowej funkcjonalności:

- Zaimplementuj brakujące operacje CRUD dla Project i Task (Create, Read, Update, Delete) wraz z odpowiednimi endpointami REST API.
- Stwórz możliwość filtrowania zadań (encja Task) przypisanych do projektu na podstawie różnych kryteriów, takich jak:
  - Status zadania (np. TODO, IN_PROGRESS, DONE),
  - Priorytet,
  - Termin realizacji (dueDate).

## Testowanie:

- Dodaj testy jednostkowe i integracyjne dla nowej funkcjonalności oraz poprawionych metod (przy użyciu JUnit lub innego narzędzia do testowania).
- Upewnij się, że aplikacja działa poprawnie w środowisku lokalnym, w tym integracja z bazą danych (np. H2 dla środowiska deweloperskiego).

## Przygotowanie środowiska:

Przygotuj aplikację do uruchomienia w lokalnym środowisku deweloperskim. Wymagania:
- Plik konfiguracyjny (np. application.properties lub application.yml) z ustawieniami dla lokalnej bazy danych,
- Instrukcja uruchomienia w pliku README.md.

## Publikacja kodu:

- Umieść kod w repozytorium Git (np. GitHub lub GitLab).
- Upewnij się, że repozytorium zawiera:
  - Cały kod źródłowy,
  - Pliki konfiguracyjne,
  - Plik README.md z instrukcją uruchomienia i opisem wprowadzonych zmian,
  - Plik .gitignore z odpowiednimi wykluczeniami (np. target/, *.log, *.class).

# Dodatkowe wskazówki:

- Upewnij się, że baza danych i encje Project oraz Task są poprawnie skonfigurowane w relacji (np. @OneToMany / @ManyToOne).
- W endpointach API zwracaj czytelne odpowiedzi, stosując wzorzec DTO, aby nie eksponować wewnętrznych szczegółów implementacji encji.
- Zadbaj o logowanie ważnych operacji w aplikacji.

Na koniec prześlij link do zdalnego repozytorium, aby umożliwić weryfikację Twojej pracy.