# Askend proovitöö
***

# BE Keskkonna seadistamine


## Andmebaasi loomine

+ Laadida alla [PostgreSQL](https://www.postgresql.org/download/), **Tested with v15.3**
+ Luua andmebaas nimega **"askend"**
+ Kasutajanimi: **postgres**
+ Parool: **postgres** <br><br>

**Saab luua ühendus andmebaasiga (nt läbi IDE):**
- Host: localhost:5430
- User: postgres
- Password: postgres

### Enne migratsioonide käivitamist kindlasti luua uus andmebaas **"askend"**.<br><br>
```CREATE DATABASE askend;```

## Java seadistamine

+ Kui pole olemas, siis laadida alla [Java versiooniga 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)
+ Versiooni saab kontrollida käsuga:```java -version```
+ Sobib installeri kasutamine 
+ Kui jookstamisega tekib probleeme või Intellij ei näita Java versiooni, siis veenduda, et **JAVA_HOME** ning **Path** on õigesti seadistatud
+ Samuti seadistada projekt JDK 19 peale

## Maveni Seadistamine

+ Kui pole olemas, siis laadida alla [Maven Versiooniga 3.8](https://maven.apache.org/download.cgi), sobib 3.8.8
+ Alla laetud kaust lahti pakkida **Program Files** kausta.
+ Seadistada Environment Variables **MAVEN_HOME** ning **PATH**.

## Keskkonna jooksutamine
Jooksutada **AskendApplication.java** ning BE hakkab tööle
***

## Autor:
### Ken Lilloja
