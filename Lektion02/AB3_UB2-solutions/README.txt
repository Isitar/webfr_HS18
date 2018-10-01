Webapp "flshcard-basic"
=======================

Beachten sie folgendes:
1. Dies ist ein Gradle Projekt.
    $ ./gradlew tasks

2. Das Gradle Plugin "war" ist konfiguriert.
    $ ./gradlew war
   das entsprechende war-File finden sie unter "build/libs".

3. Kopieren sie das war-File in ihre Tomcat-Instanz:
    $ cp build/libs/flshcard-basic.war $TOMCAT_HOME/webapps

4. Starten sie Tomcat.

5. Die URL für die Webapp ist:
    http://localhost:8080/flshcard-basic/app

   und für statische Ressourcen:
    http://localhost:8080/flshcard-basic/smiley.png

Informationen:
- Einträge im File "web.xml" ist auf das notwendigste reduziert. Wo möglich wurden Annotationen eingesetzt.
  (siehe @WebServlet, @WebFiler, @WebListener)
- Lösung zu AB3/Aufgabe 1 => Klasse BasicFilter
- Lösung zu AB3/Aufgabe 2 => Klasse BasicListener
- Lösung zu Übung 2 => Klassen ResponseWrapper und I18NFilter
  Beachten sie die Konfiguration in "web.xml"!
