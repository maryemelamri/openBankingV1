package elamri.effyis.openbanking.repositoryPrefered.repository;

import elamri.effyis.openbanking.entity.Agence;
import elamri.effyis.openbanking.entity.AgenceRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgenceRepository  {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Agence> getAgenceByadresse(String adresse) {
        String sql = "select * from agence where adresse= ? ";
        return jdbcTemplate.query(sql, new AgenceRowMapper(), adresse);
    }
    public Agence findById(int id){
        String sql = "select * from agence where id= ? ";
        return jdbcTemplate.queryForObject(sql, new AgenceRowMapper(), id);
    }
}
