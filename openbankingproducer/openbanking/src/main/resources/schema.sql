DROP TABLE IF EXISTS Operation;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Agence;
CREATE TABLE Agence (
                        id SERIAL PRIMARY KEY,
                        adresse VARCHAR(255) NOT NULL
);
CREATE TABLE Client (
                        id SERIAL PRIMARY KEY,
                        nom VARCHAR(255) NOT NULL,
                        prenom VARCHAR(255) NOT NULL
);

CREATE TABLE Compte (
                        id SERIAL PRIMARY KEY,
                        numeroCompte VARCHAR(255) NOT NULL,
                        solde DOUBLE PRECISION NOT NULL,
                        agence_id INT,
                        client_id INT,
                        FOREIGN KEY (agence_id) REFERENCES Agence(id),
                        FOREIGN KEY (client_id) REFERENCES Client(id)
);
CREATE TABLE Operation (
                           id SERIAL PRIMARY KEY,
                           code VARCHAR(255),
                           compte_id INT,
                           montant DOUBLE PRECISION NOT NULL,
                           FOREIGN KEY (compte_id) REFERENCES Compte(id)
);
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
