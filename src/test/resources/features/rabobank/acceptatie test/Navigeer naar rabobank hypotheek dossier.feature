#language: nl
@regression @rhd @acceptance
Functionaliteit: Acceptatie test : Navigeer naar RHD

- Acceptance criteria
- AC 1: Moet naar RHD (Rabobank Hypotheek Dossier) navigeren
- AC 2: Knop uitgebreide berekening moet gevonden worden.

  Scenario: 1 Navigeer naar RHD
    Gegeven de url "http://www.rabobank.nl/particulieren/" is geopend
    Als de gebruiker navigeert naar het Rabobank HypotheekDossier
    Dan kan de gebruiker een uitgebreide berekening maken