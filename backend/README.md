# Helmes proovitöö
***

# BE Keskkonna seadistamine


## Andmebaasi loomine

+ Laadida alla [PostgreSQL](https://www.postgresql.org/download/), **v15.3**
+ Luua andmebaas nimega **helmes**
+ Kasutajanimi: **postgres**
+ Parool: **postgres** <br><br>

**Saab luua ühendus andmebaasiga:**
- Host: localhost:5432
- User: postgres
- Password: postgres

### Enne migratsioonide käivitamist kindlasti luua uus andmebaas **"helmes"**.<br><br>
```CREATE DATABASE helmes;```

## Java seadistamine

+ Kui pole olemas, siis laadida alla [Java versiooniga 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
+ Versiooni saab kontrollida käsuga:```java -version```
+ Sobib installeri kasutamine 
+ Kui jooksutamisega tekib probleeme või Intellij ei näita Java versiooni, siis veenduda, et **JAVA_HOME** ning **Path** on õigesti seadistatud.

## Maveni Seadistamine

+ Kui pole olemas, siis laadida alla [Maven Versiooniga 3.8](https://maven.apache.org/download.cgi), sobib 3.8.8
+ Alla laetud kaust lahti pakkida **Program Files** kausta.
+ Seadistada Environment Variables **MAVEN_HOME** ning **PATH**.

## Keskkonna jooksutamine
Jooksutada **HelmesApplication.java** ning BE hakkab tööle
***

## Autor:
### Ken Lilloja
