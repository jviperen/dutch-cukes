#language: nl
@regression @rhd
Functionaliteit: Navigeer naar RHD

- Acceptance criteria
- AC 1: Moet naar RHD (Rabobank Hypotheek Dossier) navigeren
- LET OP: assertion in de Dan faalt! Dit is voor Red-Green-Refactor uitleg


  Scenario: 1 Navigeer naar RHD
    Gegeven de url "http://www.rabobank.nl/particulieren/" is geopend
    Als de gebruiker navigeert naar het Rabobank HypotheekDossier
    Dan kan de gebruiker een uitgebreide berekening maken