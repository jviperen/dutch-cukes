#language: nl
@rhd @userJourney @regression
Functionaliteit: User journey: navigeer naar rabobank hypotheek dossier en als starter geen NHG mogelijk

  - Acceptance criteria
  - AC 1: Moet naar RHD (Rabobank Hypotheek Dossier) navigeren
  - AC 2: Moet een dossier kunnen invullen met een dataTable
  - AC 3: Moet door de input values is NHG niet mogelijk

  Scenario: 1 Navigeer naar RHD
    Gegeven de url "http://www.rabobank.nl/particulieren/" is geopend
    Als de gebruiker navigeert naar het Rabobank HypotheekDossier
    En een uitgebreide berekening maakt met de volgende waarde als starter:
      | inkomen_per_maad | nieuw_huis | eigen_geld |
      | 7500             | 320000     | 200000     |
    # hier moet dan een mooie dataTable van worden gemaakt met input values
    Dan kan de gebruiker geen gebruik maken van NHG