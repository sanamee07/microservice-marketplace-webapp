# Projektdokumentation in Web-basierte Anwendungssysteme 🚀

## 🌟 Einführung  
Willkommen in der Dokumentation unseres Projekts!  
Diese Markdown-Datei dient als zentrale Anlaufstelle für die Beschreibung und Nachverfolgung aller wichtigen Schritte und Ergebnisse unseres Projekts.  
Im Verlauf der verschiedenen Meilensteine werden hier Fortschritte und Ergebnisse dokumentiert, sodass ein klarer Überblick über den Projektverlauf gewährleistet ist. 

## 📝 Anmerkungen  
Diese Datei wird im Laufe des Projekts regelmäßig aktualisiert, um den Fortschritt festzuhalten. Rückmeldungen und Änderungen können über GitHub Issues oder Kommentare hinzugefügt werden.  

## 📖 Inhaltsverzeichnis  

[🌟 Einführung](#-einführung)  
[📝 Anmerkungen](#-anmerkungen) 

[Meilenstein 1 Projektplanung erstellt](#meilenstein-1-projektplanung-erstellt)

  - 📅 Zeitraum: Woche 1  
  - 🎯 Ziel  
  - ✅ Fortschritte
    - Bearbeitete Issues

[Meilenstein 2 Grundlegende Systemarchitektur und Design erstellt](#meilenstein-2-grundlegende-systemarchitektur-und-design-erstellt)

  - 📅 Zeitraum: Woche 2  
  - 🎯 Ziel  
  - ✅ Fortschritte
    - Bearbeitete Issues

[Meilenstein 3 Backend Entwicklung fertiggestellt](#meilenstein-3-backend-entwicklung-fertiggestellt)

  - 📅 Zeitraum: Woche 3  
  - 🎯 Ziel  
  - ✅ Fortschritte
    - Bearbeitete Issues

[Meilenstein 4 Frontend Entwicklung fertig erstellt](#meilenstein-4-frontend-entwicklung-fertig-erstellt)

  - 📅 Zeitraum: Woche 3  
  - 🎯 Ziel  
  - ✅ Fortschritte
    - Bearbeitete Issues

[Meilenstein 5 Integration und Testing vollendet](#meilenstein-5-integration-und-testing-vollendet)

  - 📅 Zeitraum: Woche 5 bzw 6  
  - 🎯 Ziel  
  - ✅ Fortschritte
    - Bearbeitete Issues

[Meilenstein 6 Dokumentation und Präsentation fertiggestellt](#meilenstein-6-dokumentation-und-präsentation-fertiggestellt)

  - 📅 Zeitraum: Woche 7  
  - 🎯 Ziel  
  - ✅ Fortschritte
    - Bearbeitete Issues

[Meilenstein 7 Projekt abgeschlossen und abgegeben](#meilenstein-5-projekt-abgeschlossen-und-abgegeben)

  - 📅 Zeitraum: Woche 7  
  - 🎯 Ziel  
  - ✅ Fortschritte
    - Bearbeitete Issues

---

## Meilenstein 1 Projektplanung erstellt  

### 📅 Zeitraum: Woche 1

### 🎯 Ziel  
Die Projektplanung umfasst alle grundlegenden Schritte, die notwendig sind, um den Projektverlauf zu strukturieren und die Grundlage für eine erfolgreiche Umsetzung zu schaffen. Dieser Meilenstein dient dazu, alle organisatorischen und strukturellen Anforderungen zu erfüllen.  

## ✅ Fortschritte  

### Roadmap in GitHub  
- Die Roadmap für das Projekt wurde in GitHub Projects erstellt.  
- Meilensteine und Arbeitspakete wurden angelegt (siehe Milestones und Issues); Jedes Teammitglied hat Meilensteine und Issues definiert, sodass wir insgesamt auf 7 Meilensteine und 30 Issues gekommen sind. Es wurde auf Übersichtlichkeit mit zeitlichen Zuordnungen und Fortschritten der Meilensteine und Arbeitspakete wertgelegt.

### Issues  
Die folgenden Issues wurden für den ersten Meilenstein angelegt:  
- [x] **Issue 1:** Kick-Off Projekt "MillionDollarProject".  
- [x] **Issue 2:** Github Roadmap anlegen.
- [x] **Issue 3:** Rollen/Teamaufteilung bilden.
- [x] **Issue 4:** **Milestones** für Projektlaufzeit erstellen.
- Die Meilensteine werden im Laufe dieser Dokumentation vorgestellt.   
- [x] **Issue 5:** **Issues** zu den jeweiligen Milestones erstellen.
- Die Issues werden mit jedem Meilenstein im Laufe dieser Dokumentation vorgestellt.
- [x] **Issue 6:** **Anwendung** festlegen.
- Das Projekt enthält mehrere Microservices, darunter:
	- GatewayService:
		- Enthält Klassen für die zentrale Steuerung der Kommunikation zwischen den anderen Services.
		- Enthält Modelle für User, Post und Advertisement.
		- Bietet Services für Benutzerverwaltung, Beiträge und Anzeigen.
		- Konfigurationsdateien und Build-Tools (Maven).
	- UserService:
		- Verwaltet Benutzer und deren Daten.
		- Enthält ein Repository zur Datenhaltung und Services zur Benutzerverarbeitung.
		- Controller zur Bereitstellung von Endpunkten für Benutzeroperationen.
	- AdvertisementService:
 		- Verwaltung von Werbeanzeigen mit Repository, Services und Controller.
   		- Enthält Konfigurationsdateien und statische Ressourcen.
	- PostService
		- Verwaltet Beiträge (Posts).
		- Verwendet GraphQL zur Abfrage von Posts.
		- Enthält Repositories, Services und Controller für GraphQL.
- Anforderungen an selbst-definiertes Anwendungssystem
  - Was soll das System tun?
    - Das System soll eine Plattform bereitstellen, auf der Benutzer Beiträge veröffentlichen und Werbeanzeigen geschaltet werden können.
    - Es bietet verschiedene Dienste zur Verwaltung von Benutzern, Beiträgen und Anzeigen.
  - Welche Aufgabe(n) soll das System lösen bzw. anbieten?
    - Benutzerverwaltung: Erstellen, Bearbeiten, Löschen und Authentifizieren von Benutzern.
    - Beitragserstellung: Hinzufügen und Abrufen von Posts über GraphQL-Schnittstellen.
    - Anzeigenmanagement: Erstellung und Anzeige von Werbeinhalten.
  - Beschreibung und Übersicht des Anwendungssystems
    - Das System besteht aus einem Microservice-Architekturansatz mit einzelnen Diensten für spezifische Aufgaben.
    - Ein API-Gateway fungiert als zentraler Zugriffspunkt für die verschiedenen Services.
    - Jeder Service hat eine spezifische Funktion, um die Trennung der Verantwortlichkeiten sicherzustellen.
    - Technologien wie Spring Boot und GraphQL werden zur Implementierung verwendet.
    - Daten werden in Repository-Klassen verarbeitet und über REST- oder GraphQL-APIs bereitgestellt.
- [x] **Issue 7:** **Ersten Architekturentwurf** erstellen.

Unsere Architektur ist folgendermaßen aufgebaut:
1. **Gateway-Service (API-Gateway):** Schnittstelle für alle Client-Anfragen.
2. **Microservices:**
	- UserService: Verwalten der Benutzerdaten.
	- AdvertisementService: Verwaltung und Bereitstellung von Anzeigen.
	- PostService: Verwaltung von Posts und GraphQL-Support.

Hier ist unser erster Architekturentwurf:  

![image](https://github.com/user-attachments/assets/b1e55cf3-f735-46fb-8d18-ad88e4839729)


Zudem haben wir noch einen Use Case Diagramm erstellt, der wie folgt aussieht:

![image](https://github.com/user-attachments/assets/27bc658f-3bc1-4dc7-9de1-3586c62889a7)


- [x] **Issue 8:** Markdown Datei updaten.

---

## Meilenstein 2 Grundlegende Systemarchitektur und Design erstellt  

### 📅 Zeitraum: Woche 2

### 🎯 Ziel  
Mit diesem Meilenstein haben wir das Ziel unsere Systemarchitektur zu definieren.  

## ✅ Fortschritte  

### Issues  
Die folgenden Issues wurden für den ersten Meilenstein angelegt:  
- [x] **Issue 9:** Systemarschitektur entwerfen.  
- [x] **Issue 10:** API Gateway und Services entwerfen.
  
  **API Gateway**
    
    Das API Gateway fungiert als zentraler Zugangspunkt für Clients und bietet folgende Funktionen:

     Leitet Anfragen zu Benutzer-, Anzeigen- und Postoperationen an die jeweiligen Services weiter.

     Verknüpft mehrere Services, um komplexe Abfragen zu bearbeiten (z. B. Posts eines Benutzers).
    
     Logging: Protokolliert alle eingehenden Anfragen und ausgehenden Antworten.

  - ***Endpoints***
    - /api/user
      - GET: Alle Benutzer abrufen.
      - POST : Neuen Benutzer ertsellen.
    - /api/users/{uderId}
      - GET: Benutzer abrufen.
      - PUT: Benutzer aktualisieren.
      - DELETE: Benutzer löschen.
    - /api/users/{uderId}/advertisements
      - GET: Anzeigen eines Benutzers abrufen.
      - POST: Anzeige erstellen
    - /api/users/{userId}/advertisements/{advertisementId}
      - GET: Einzelne Anzeige abrufen.
      - PUT: Anzeige aktualisieren
      - DELETE: Anzeige löschen.
    - /api/users/{userId}/advertisements/{advertisementId}/posts
      - GET: Posts einer Anzeige abrufen.
      - POST: Neuen Post zu eienr Anzeige erstellen.
    
  **User-Service**
    - ***Aufgaben:***
      - Verwaltung der Benutzer (CRUD).
      - HTTP-REST-Schnittstelle zur Kommunikation mit dem Gateway.
    - ***Endpoints:***
      - /users
        - GET: Liste aller Benutzer.
        - POST: Benutzer erstellen.
      - /users/{userId}
        - GET: Benutzer abrufen.
        - PUT: Benutzer aktualisieren.
        - DELETE: Benutzer löschen.

  **Advertisement-Service**
    - ***Aufgaben:***
      - Verwaltung von Anzeigen für Benutzer.
      - Operationen zur Anzeigeerstellung, -aktualisierung und -abfrage.
      - Exception-Handling für ungültige Benutzer- oder Anzeige-IDs.
    - ***Endpoints:***
      - /advertisements
        - GET: Liste aller Anzeigen eines Benutzers.
        - POST: Neue Anzeige erstellen.
      - /advertisements/{advertisementId}
        - GET: Einzelne Anzeige abrufen.
        - PUT: Anzeige aktualisieren.
        - DELETE: Anzeige löschen.
       
  **Post-Service**
  - ***Aufgaben:***
    - **Verwaltung der Posts**, die an Anzeigen angehängt sind.
    - **GraphQL-Schnittstelle** zur Erstellung und Abfrage von Posts.

  - ***GraphQL Queries:***
    - `query getPostsByAdvertisementId($userId: ID!, $advertisementId: ID!)`
      - Fragt Posts einer bestimmten Anzeige ab.
    - `mutation createPost($userId: ID!, $advertisementId: ID!, $platform: String!, $link: String!)`
      - Erstellt einen neuen Post für eine Anzeige.

  - Kommunikation zwischen den Services:
    - **Gateway → UserService:** HTTP-REST
    - **Gateway → AdvertisementService:** HTTP-REST
    - **Gateway → PostService:** GraphQL
- [x] **Issue 11:** Erstes Frontend-Design entwerfen.
- [x] **Issue 12:** Markdown Datei upgraden. 

---

## Meilenstein 3 Backend-Entwicklung fertiggestellt

### 📅 Zeitraum: Woche 3

Im Verlauf des dritten Meilensteins, der die Fertigstellung der Backend-Entwicklung zum Ziel hatte, stellten wir fest, dass unsere initiale Zeitplanung nicht optimal war und wir den erforderlichen Aufwand unterschätzt hatten; die Umsetzung des Backends dauerte länger als ursprünglich angenommen. Dies führte dazu, dass wir mehr Zeit benötigten als ursprünglich vorgesehen. Folglich sahen wir uns gezwungen, die Zeitpläne für die einzelnen Issues und Meilensteine entsprechend anzupassen.

Solche Anpassungen sind im Projektmanagement keine Seltenheit. In der Praxis kommt es häufig vor, dass ursprüngliche Zeitpläne aufgrund unerwarteter Herausforderungen (unerwartete technische Schwierigkeiten, veränderte Anforderungen uvm.) oder einer Fehleinschätzung des Arbeitsaufwands revidiert werden müssen. Flexibilität und die Fähigkeit zur dynamischen Anpassung sind daher essenziell für den Projekterfolg. Wie im Artikel "Projektzeitpläne im Projektmanagement" von Atlassian betont wird, ist es wichtig, die Dauer für die Bearbeitung von Aufgaben realistisch einzuschätzen und bei Bedarf Anpassungen vorzunehmen (QUELLE: https://www.atlassian.com/de/agile/project-management/project-schedule). 

Diese Erfahrung unterstreicht die Bedeutung einer kontinuierlichen Überwachung des Projektfortschritts und der Bereitschaft, Zeitpläne bei Bedarf zu überarbeiten. Ein agiler Ansatz und regelmäßige Kommunikation im Team sind dabei entscheidend, um auf Veränderungen reagieren und den Projekterfolg sicherstellen zu können.

### 🎯 Ziel  
Am Ende dieses Meilensteins möchten wir unser Backend fertig entwickelt haben. Daher stellt dieser Meilenstein auch unser Hauptfokus und Kern unserer Arbeit dar. Unsere drei beschriebenen Services (User-Service, Post-Service und Advertisement-Service) und unser Gateway sollten nach dem Meilenstein stehen.

## ✅ Fortschritte  

### Issues  
Die folgenden Issues wurden für den ersten Meilenstein angelegt:  
- [x] **Issue 13:** API Gateway in Spring Boot implementieren.
- [x] **Issue 14:** Services erstellen.

Diesen Service haben wir zunächst erstellt, ohne uns im Vorfeld endgültig auf unsere Services festgelegt zu haben. Nachdem klar war, welche Services wir implementieren möchten, haben wir gezielt weitere Issues erstellt und diesen dann aufgelöst. In diesem Zuge haben wir auch eine Aufgabenverteilung vorgenommen, die wir bereits zu Beginn des Projektes skizziert hatten – dabei wurde festgelegt, wer für welchen Service primär zuständig ist.

Allerdings verfolgen wir keine strikte Trennung der Verantwortlichkeiten. Stattdessen setzen wir auf ein kollaboratives Arbeitsmodell, bei dem jeder jederzeit Unterstützung bekommen kann. Unser Ziel ist es, Wissen und Verantwortung gemeinsam zu tragen, sodass niemand auf sich allein gestellt ist. Durch regelmäßige Abstimmungen und eine offene Kommunikation stellen wir sicher, dass jeder auf dem aktuellen Stand bleibt und Herausforderungen gemeinsam gemeistert werden. Dies fördert nicht nur die Effizienz, sondern auch den Teamgeist und die Qualität unserer Arbeit.

- [x] **Issue 15:** Advertisement-Service.
	- Zuständiger: Sana Meersaed
- [x] **Issue 16:** Post-Service erstellen.
	- Zuständiger: Kerem Celal Babacan
- [x] **Issue 17:** User-Service erstellen.
	- Zuständige: Gülay Solak
- [x] **Issue 18:** Markdown Datei upgraden.

---

## Meilenstein 4 Frontend-Entwicklung fertig erstellt

### 📅 Zeitraum: Woche 3

### 🎯 Ziel 
Ziel war es hier eine Frontend-Entwicklung zu entwickeln. Jedoch hat sich herausgestellt, dass dies kein Fokus in unserem Projekt hat. Somit haben wir dies nicht weiter verfolgt.

## ✅ Fortschritte  

### Issues  

---

## Meilenstein 5 Integration und Testing vollendet

### 📅 Zeitraum: Woche 5 bzw. 6

### 🎯 Ziel  
Unseren Fokus lag in diesem Meilenstein Unit-Tests durchzuführen und allgemein auf Fehler oder sonstiges aufmerksam zu werden.

## ✅ Fortschritte  

### Issues  
Die folgenden Issues wurden für den ersten Meilenstein angelegt:  
- [x] **Integration Backend und Frontend durchführen**
	- Dies wurde nicht weiter verfolgt.
- [x] **Unit-tests und Integrationstest durchführen**
- [x] **Fehlerbehebung und Optimierung durchführen**
- [x] **Markdown Datei updaten.**

---

## Meilenstein 6 Dokumentation und Präsentation fertiggestellt

### 📅 Zeitraum: Woche 7

### 🎯 Ziel  
Dieser Meilenstein diente nur dazu, dass wir die Präsentation erfolgreich aufgenommen haben und unsere Dokmentation abgeschlossen haben.

## ✅ Fortschritte  

### Issues  
Die folgenden Issues wurden für den ersten Meilenstein angelegt:  
- [x] **Verlinkung innerhalb der Projektdokumentation korrigieren**
- [x] **Präsentation und Videoaufzeichnung erstellen**
      - Die Präsentation wurde erfolgreich aufgenommen!
- [x] **Dokumentation finalisieren**
      - Die Dokumentation wurde finalisiert und im weiteren Verlauf bis zur Abgabe immer kleine Verfeinerungen gemacht.

---

## Meilenstein 7 Projekt abgeschlossen und abgegeben

### 📅 Zeitraum: Woche 8

### 🎯 Ziel  
Dieser Meilenstein ist die Kirche auf dem Sahnehäubchen! Hier geht es nurnoch darum, dass die Präsentation, die Dokumentation und der Code abgegeben. Also das große Finale!!

## ✅ Fortschritte  

### Issues  
Die folgenden Issues wurden für den ersten Meilenstein angelegt:  
- [x] **Finalisierung der Anwendung durchführen**
- [x] **Dokumentation und die des Codes abgeben**
- [x] **Präsentation abgeben**

Mit gutem Gewissen können wir auf eine erfolgreiche Projektarbeit zurückblicken, denn unsere Anwendung läuft ohne Probleme, die Dokumentation sitzt und die Präsentation wurde aufgenommen und alles wurde abgegeben.

Vielen Dank für diese lehrreiche Einheit! Wir sind uns alle einig, dass wir an dieser Arbeit sehr gewachsen sind: Von den ganzen Techniken für web-basierte Anwendungsysteme bis hin zu den scheinbar einfacheren Dingen wie eine Projektplanung zu erstellen.

Kerem Celal Babacan, Sana Meersaed und Gülay Solak.
