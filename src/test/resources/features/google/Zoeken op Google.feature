#language: nl
@regression @google @acceptance
Functionaliteit: Gebruiker zoekt via google en opent gezochte website

  - Acceptance criteria
  - AC 1: Moet Nederlandse versie van google openen
  - AC 2: Moet zoeken naar facebook en youtube en vinden
  - AC 2: Achtergrond moet 3 (2 x scen 1 en 1 x scen 2) keer zijn uitgevoerd


  Achtergrond:
    Gegeven we moeten iets in de achtergrond doen als setup, gebruik dit alleen als setUp

  Abstract Scenario: 1 Scenario: Navigeer naar Google
    Gegeven de url "https://www.google.nl" is geopend
    Als er wordt gezocht met "<zoek_criteria>"
    En zoek resultaat "<link>" wordt geopend
    Dan is de url van de pagina "<url>"

  Voorbeelden:
    | zoek_criteria | link                      | url                         |
    | raspberry     | Raspberry Pi              | http://www.raspberrypi.org/ |
    | cucumber      | Cucumber - Making BDD fun | http://cukes.info/          |

  Scenario: 2 Scenario: Navigeer naar Google zonder voorbeelden
    Gegeven de url "https://www.google.nl" is geopend
    Als er wordt gezocht met "aad"
    En zoek resultaat "American Academy of Dermatology" wordt geopend
    Dan is de url van de pagina "http://www.aad.org/"


