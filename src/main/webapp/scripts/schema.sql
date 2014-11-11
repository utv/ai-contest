create table Bots(
	id serial primary key,
	creator_id integer,
	name text unique,
	language text
);

create table Games(
                    id serial PRIMARY KEY,
                    creator_id INTEGER,
                    name TEXT UNIQUE,
                    language TEXT,
                    instruction_location TEXT,
                    visualizer_location TEXT
                );

create table Tournaments(
                    id SERIAL PRIMARY KEY,
                    creator_id INTEGER,
                    game_id INTEGER,
                    name TEXT UNIQUE,
                    password TEXT,
                    start_date DATE,
                    end_date DATE,
                    last_active DATE
                );

create table Tourn_GameIndex(
                    id SERIAL PRIMARY KEY,
                    tourn_id INTEGER,
                    player TEXT,
                    gameid INTEGER
                );

create table Tourn_Games(
                    id SERIAL PRIMARY KEY,
                    tourn_id INTEGER,
                    players TEXT,
                    map TEXT,
                    datum DATE,
                    turns INTEGER DEFAULT 0,
                    draws INTEGER DEFAULT 0
                );

create table Tourn_Entries(
                    id SERIAL PRIMARY KEY,
                    tourn_id INTEGER,
                    bot_id INTEGER,
                    lastseen DATE,
                    rank INTEGER DEFAULT 1000,
                    skill real DEFAULT 0.0,
                    mu real DEFAULT 50.0,
                    sigma real DEFAULT 13.3,
                    ngames INTEGER DEFAULT 0,
                    status bool DEFAULT True
                );

create table Tourn_Replays(
                    id INTEGER,
                    tourn_id INTEGER,
                    json TEXT
                );