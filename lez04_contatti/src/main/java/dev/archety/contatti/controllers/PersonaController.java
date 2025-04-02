package dev.archety.contatti.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.jdbc.MysqlDataSource;

import dev.archety.contatti.models.Persona;

@RestController("/persona")
public class PersonaController {

	@GetMapping("/")
	private List<Persona> getAll(){
		List<Persona> elenco = new ArrayList();
		
		try {

        	MysqlDataSource ds = new MysqlDataSource();
        	ds.setServerName("localhost");
        	ds.setPortNumber(3306);
        	ds.setUser("root");
        	ds.setPassword("toor");
        	ds.setDatabaseName("its_32_02_primary");
        	ds.setUseSSL(false);
        	ds.setAllowPublicKeyRetrieval(true);
        	
        	Connection conn = ds.getConnection();
        	
        	String query = "SELECT personaID, nome, cognome, cod_fis, email, telefono FROM persona;";
        	PreparedStatement ps = conn.prepareStatement(query);
        	
        	ResultSet rs = ps.executeQuery();
        	
        	while(rs.next()) {
        		Persona per = new Persona();
        		per.setId( rs.getInt("personaID") );
        		per.setNome( rs.getString("nome") );
        		per.setCogn( rs.getString("cognome") );
        		
        		elenco.add(per);
        	}
        	
        	conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return elenco;
	}
	
}
