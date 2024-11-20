INSERT INTO users (first_name, last_name, email, password, created_at, updated_at)
VALUES ('John', 'Doe', 'john.doe@example.com', 'azerty1234', NOW(), NOW());

INSERT INTO pokemons ("id", "name", "life", "damage", picture, created_at, updated_at, user_id) VALUES
                                                                            (1, 'Bulbizarre', 25, 5, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png', '2024-08-16T00:00:00Z', '2024-08-16T00:00:00Z', 1),
                                                                            (2, 'Salamèche', 28, 6, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/004.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (3, 'Carapuce', 21, 4, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/007.png', '2024-08-16T00:00:00Z', '2024-08-16T00:00:00Z',1),
                                                                            (4, 'Aspicot', 16, 2, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/013.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (5, 'Roucool', 30, 7, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/016.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (6, 'Rattata', 18, 6, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/019.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (7, 'Piafabec', 14, 5, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/021.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (8, 'Abo', 16, 4, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/023.png', '2024-08-16T00:00:00Z', '2024-08-16T00:00:00Z',1),
                                                                            (9, 'Pikachu', 21, 7, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/025.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (10, 'Sabelette', 19, 3, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/027.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (11, 'Mélofée', 25, 5, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/035.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (12, 'Groupix', 17, 8, 'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/037.png', '2024-08-16T00:00:00Z','2024-08-16T00:00:00Z', 1),
                                                                            (13, 'Lugia', 30, 10, 'https://img.pokemondb.net/artwork/large/lugia.jpg', '2024-10-23T21:29:22.026Z','2024-08-16T00:00:00Z', 1),
                                                                            (14, 'Dracofeu', 20, 9, 'https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/006.png', '2024-10-23T21:52:07.152Z', '2024-08-16T00:00:00Z',1);

-- Types corrigés pour chaque Pokémon
INSERT INTO pokemon_types (pokemon_id, type) VALUES
                                                 (1, 'GRASS'),
                                                 (1, 'POISON'),
                                                 (2, 'FIRE'),
                                                 (3, 'WATER'),
                                                 (4, 'BUG'),
                                                 (4, 'POISON'),
                                                 (5, 'NORMAL'),
                                                 (5, 'FLYING'),
                                                 (6, 'NORMAL'),
                                                 (7, 'NORMAL'),
                                                 (7, 'FLYING'),
                                                 (8, 'POISON'),
                                                 (9, 'ELECTRIC'),
                                                 (10, 'GROUND'),
                                                 (11, 'FAIRY'),
                                                 (12, 'FIRE'),
                                                 (13, 'PSYCHIC'),
                                                 (13, 'FLYING'),
                                                 (14, 'FIRE'),
                                                 (14, 'FLYING');
