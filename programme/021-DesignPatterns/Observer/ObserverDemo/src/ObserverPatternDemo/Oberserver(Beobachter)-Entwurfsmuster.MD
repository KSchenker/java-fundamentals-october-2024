# Entwurfsmuster - Verhaltensmuster - Beobachter => Flusssteuerungsmuster

## Was ist das Observer Pattern (Beobachter-Entwurfsmuster)?

Eine einheitliche Möglichkeit , eine Eins-zu-eins-Abhängigkeit zwischen zwei
oder mehreren Objekten zu definieren, um sämtliche Änderungen an einem bestimmten Objekt
auf möglichst unkomplizierte und schnelle Weise zu übermitteln. Zu diesem Zweck können
sich beliebige Objekte, die in diesem Fall als Observer bzw. Beobachter fungieren,
bei einem anderen Objekt registrieren. Letzteres Objekt, das man in diesem Fall
auch als Subjekt bezeichnet, informiert die registrierten Beobachter,
sobald es sich verändert bzw. angepasst wird.

### Zweck und Funktionsweise des Observer Patterns

Das Beobachter-Entwurfsmuster arbeitet mit zwei Typen von Akteuren:

- Auf der einen Seite steht das Subjekt, also das Objekt, dessen Status langfristig unter Beobachtung stehen soll.
- Auf der anderen Seite stehen die beobachtenden Objekte (Observer bzw. Beobachter), die über sämtliche Änderungen des Subjekts in Kenntnis gesetzt werden wollen.
- 1 Subjekt <=> X-Beobachter , aber auch 1 Subjekt <=> 1Beobachter möglich

Ohne den Einsatz des Beobachter-Patterns müssten die beobachtenden Objekte das Subjekt in regelmäßigen Intervallen um Status-Updates bitten –
jede einzelne Anfrage wäre mit entsprechender Rechenzeit inklusive der hierfür erforderlichen Hardware-Ressourcen verbunden.
Die grundlegende Idee des Observer Patterns ist es, die Aufgabe des Informierens im Subjekt zu zentralisieren.
Zu diesem Zweck führt es eine Liste, in die sich die Beobachter eintragen können. Bei einer Änderung informiert das Subjekt die registrierten Observer der Reihe nach,
ohne dass diese selbst aktiv werden müssen. Ist ein automatisches Status-Update nicht mehr für ein bestimmtes, beobachtendes Objekt gewünscht,
trägt man es einfach wieder aus der Liste aus.

Zur Information der einzelnen Beobachter sind zwei verschiedene Methoden möglich: Bei der Push-Methode übermittelt das Subjekt den geänderten Zustand bereits mit
der Benachrichtigung. Das kann jedoch zu Problemen führen, wenn Informationen übermittelt werden, die der Observer nicht verwerten kann. Dieses Problem besteht
bei der alternativen Pull-Methode nicht: Bei diesem Ansatz gibt das Subjekt lediglich die Information weiter, dass Änderungen vorgenommen wurden. Die Beobachter
müssen den geänderten Zustand anschließend per gesondertem Methodenaufruf erfragen.

### Schematische Darstellung

bash

```
___________________________________                     ________________________________________
|               SUBJECT           |                     |             Observer                 |
|---------------------------------|         Observer    |--------------------------------------|
| registrieren(b:Observer) : void |-------------------->|                                      |
| entfernen(b:Observer): void     |                     |        aktualisieren(): void         |
| benachrichtigen() : void        |                     |                                      |
|_________________________________|                     |______________________________________|
             ^                                                              ^
            / \                                                            / \
             |                                                              |
             |                                                              |
             |                                                              |
___________________________________                     ________________________________________
|         ConcreteSubject         |                     |            ConcteteObserver          |
|---------------------------------|    Subject          |--------------------------------------|
| erhaltenZustand()               |<--------------------|                                      |
| setzenZustand()                 |                     |          aktualisieren(): void       |
| subjektZustand                  |                     |            observerZustand           |
|_________________________________|                     |______________________________________|
```

#### Wo wird das Entwurfsmuter eingesetzt?

- Ist besonders gefragt in Anwendungen, die auf Komponenten basieren, deren Status

1.  Einerseits STARK von anderen Komponenten beobachtet wird
2.  Andererseits regelmäßigen Änderungen unterliegt

Typische Anwendungsfälle:

- GUI(Graphical User Interfaces)
- SWING/JavaFX in Java
- Programme, die Datensätze visualisieren (bspw: Datawrapper)
- Verwaltung der Newslettersubscription per Email

* eine einfach zu bedienende Schnittstelle für die Kommunikation mit der Software.
* sobald Sie Daten verändern, müssen diese in allen GUI-Komponenten aktualisiert werden
