=========== Create new game, tournament and bots ===========
games.html --choose new game--> 
newGame.html --create new game--> 
tournaments.html --choose new tournament-->
newTournament.html --create new tournament-->
tournament.html --choose upload bot-->
uploadBot.html --choose new bot-->
newBot.html --upload new bot-->
tournament.html

=========== Add new tournament in an existing game ===========
games.html --choose one-->
tournaments.html --choose new tournament-->
newTournament.html --create new tournament-->
tournament.html

=========== Add an existing bot to any tournaments ===========
games.html --choose one-->
tournaments.html --choose a tournament-->
tournament.html --upload bot-->
uploadBot.html --choose a bot from bot list--> confirm -->
tournament.html
===============================================================

newGame(Form)
- Breadcrumb, game --> new game
- Name
- File upload

newTournament(Form)
- Breadcrumb, game --> new tournament
- Name
- Password

newBot.html(Form)
- Breadcrumb, game --> tournament --> new bot
- Name
- File upload

chooseBot.html(Do it later)
- Breadcrumb, game --> tournament --> choose bot
- Bot list table
  - bot name
  - tournament name
  - upload date

games.html
- Breadcrumb, game -->
- New game link
- Game list table

tournaments.html
- Breadcrumb, game --> list of tournaments
- New tournament
- Tournament list table

tournament.html
- Breadcrumb, game --> tournament name
- New bot link
- Choose bot link(choose existing bot from this game)
- leader board
  - Rank
  - Bot name
  - Win
  - Lose
  - Number of games played
- matches
