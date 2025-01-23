# Zadanie

Ograniczone możliwości czasowe, nie pozwoliły mi bardziej rozbudować projektu. 

Aplikacja korzysta z H2, więc powinna działać po pobraniu i natychmiastowym odpaleniu. 
Baza danych tworzona jest każdorazowo przy każdym uruchomieniu aplikacji.
W głównej klasie jest implementacja CommandLineRunner-a, żeby wstawić na sam początek Projekt i kilka tasków. 

Konsola jest dostepna pod http://localhost:8080/h2-console/

Rozbudowałem nieco obie encje, Project ma w sobie set-a Tasków. Korzystam z Seta ze względów wydajnościowych, co wymusza 
implementację metod equals i hashcode w oparciu o klucz biznesowy. Posłużyłem się datą i czasem tworzenia obiektu + 
nazwą i opisem taska. Zdaję sobie sprawę, że nie jest to idealne rozwiązanie, ponieważ pola name i description nie są finalne, co może
prowadzić do zerwania kontraktu hashcode, ale był to najlepszy sposób na implementację tego zadania w limicie czasowym i na potrzeby 
tej małej aplikacji jest wystarczający. 

Dziękuję za poświęcony czas. 