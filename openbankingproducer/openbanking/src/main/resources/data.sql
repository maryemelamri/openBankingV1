-- Sample data for Agence table
INSERT INTO Agence (adresse) VALUES
                                 ('Address 1'),
                                 ('Address 2'),
                                 ('Address 3');

-- Sample data for Client table
INSERT INTO Client (nom, prenom) VALUES
                                     ('John', 'Doe'),
                                     ('Alice', 'Smith'),
                                     ('Bob', 'Johnson');

-- Sample data for Compte table
INSERT INTO Compte (numeroCompte, solde, agence_id, client_id) VALUES
                                                                   ('123456789', 1000.00, 1, 1),
                                                                   ('987654321', 500.00, 2, 2),
                                                                   ('456789123', 1500.00, 3, 3);

-- Sample data for Operation table
INSERT INTO Operation (code, compte_id, montant) VALUES
                                                     ('ABC123', 1, 100.00),
                                                     ('DEF456', 2, 50.00),
                                                     ('GHI789', 3, 200.00);
