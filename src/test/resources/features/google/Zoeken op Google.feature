#language: nl
@regression @google
Functionaliteit: navigatie en zoeken Google.nl

  - Acceptance criteria
  - AC 1: Moet Nederlandse versie van google openen
  - AC 2: Moet zoeken naar facebook en youtube en vinden
  - AC 2: Achtergrond moet 3 (2 x scen 1 en 1 x scen 2) keer zijn uitgevoerd


  Achtergrond:
    Gegeven we moeten iets in de achtergrond doen als setup, gebruik dit alleen als setUp

  Abstract Scenario: 1 Scenario: Navigeer naar Google
    Gegeven de url "https://www.google.nl" is geopend
    Als er wordt gezocht met "<zoek_criteria>"
    Dan wordt "<zoek_resultaat>" gevonden op eerste positie

  Voorbeelden:
    | zoek_criteria | zoek_resultaat               |
    | facebook      | https://nl-nl.facebook.com/  |
    | youtube       | www.youtube.com/?gl=NL&hl=nl |

  Scenario: 2 Scenario: Navigeer naar Google
    Gegeven de url "https://www.google.nl" is geopend
