package elamri.effyis.openbanking.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgenceRowMapper implements RowMapper<Agence> {
    @Override
    public Agence mapRow(ResultSet rs, int rowNum) throws SQLException {
        Agence item = new Agence();
        item.setId(rs.getInt("id"));
        item.setAdresse(rs.getString("adresse"));
       // item.setComptes(rs.getObject("comptes"));

        return item;
    }
}