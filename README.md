# recruitingWorkflowApp
<b>Opis projektu</b>:
<br>Aplikacja webowa pełniąca funkcję systemu do przechowywania procesów rekrutacyjnych, zapisująca dane o realizowanych projektach w bazie danych.

<b>Zakres projektu</b>: <br>Aplikacja webowa, wykorzystująca funkcjonalności bootstrapa.

<b>Techniczny opis projektu</b>:
<br>Projekt został stworzony w Java 8 w Springu. Przy tworzeniu aplikacji wykorzystano narzędzie automatyzujące budowę oprogramowania na platformę Java - Maven. Sposób komunikowania się aplikacji z użytkownikiem jest oparty na formularzu HTML z użyciem silnika szablonów Thymeleaf. Wygląd strony i zdefiniowanie właściwości wyglądu jej elementów stworzono za pomocą CSS. Dane, które zostaną wprowadzone przez użytkownika, są pobierane i odczytywane później ze zintegrowanej z aplikacją bazy danych postgresql, dostarczanej przez platformę Heroku. Mapowanie obiektowo-relacyjne zrealizowane jest za pomocą Hibernate. Do wysyłania i odbierania wiadomości e-mail użyto JavaMail API. W celu zapisywania wprowadzonych i edytowanych danych do pliku Excel, pobieranego do wyznaczonego folderu na komputerze, wykorzystana została biblioteka Apache POI.

<b>Architektura</b>:
<br>Spring, Java 8, Postgresql, Tomcat

<b>Technologie</b>:
<br>Java 8, Maven, Spring, Hibernate, HTML, CSS, Thymeleaf

<b>Biblioteki</b>:
<br>Lombok, Apache POI
