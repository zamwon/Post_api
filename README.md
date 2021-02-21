# Post_api
> Stwórz aplikację, która będzie pobierała cyklicznie (raz dziennie) oraz na żądanie (końcówka REST) dane
dotyczące postów z publicznego API – https://jsonplaceholder.typicode.com/posts.
Struktura postu:
{
userId : integer,
id : integer,
title: string,
body: string
}
Dane te powinny być zapisane do lokalnej bazy danych. Użytkownik aplikacji powinien mieć możliwość przy
pomocy API RESTowego:
- odczytania pobranej listy postów z możliowścią filtrowania po polu title oraz z pominięciem pola userId w
odpowiedzi
- usunięcia wybranego posta oraz edycji pól title i body.
Dodatkowe założenia:
- cykliczne pobieranie danych aktulizuje wpisy (wszystkie pola) na podstawie pola id z pominięciem
usuniętych oraz edytowanych przez użytkownika rekordów
- kod powinien zawierać testy (TDD)
- aplikacja powinna zawierać plik README z instrukcją uruchomienia

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Contact](#contact)

## General info
Zadanie rekrutacyjne

## Technologies
- JAVA + Spring Boot + Maven
- testy junit5
- baza danych MySql

## Setup
 Baza danych postawiona na remotemysql.com - dane umieszczone w resources.appplication.properties
Api posiada zaimplementowana obsluge swagger ui dla ułatwienia korzystania z aplikacji. 

http://localhost:8080/swagger-ui.html

## Code Examples
Show examples of usage:

GET
/posts getposts
DELETE
/posts/{id} deletePost
PATCH
/posts/{id} modifyPost
GET
/posts/{title} getPostsByTitle

To-do list:
* Testy

## Contact
Created by Błażej Karnecki
