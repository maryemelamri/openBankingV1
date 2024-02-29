package elamri.effyis.openbanking.service;

import elamri.effyis.openbanking.entity.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ClientService {

    @Autowired
    JdbcTemplate temp;


    public Iterable<Client> findAllClients() {
        String sql = "select * from client";
        RowMapper<Client> mapper = new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                Client a = new Client();
                a.setId(rs.getInt(1)); // Supposons que l'ID est dans la première colonne
                a.setNom(rs.getString(2)); // Supposons que le nom est dans la deuxième colonne
                a.setPrenom(rs.getString(3)); // Supposons que la technologie est dans la troisième colonne
                return a;
            }
        };
        List<Client> cliens = temp.query(sql, mapper);
        return cliens;
    }



}
