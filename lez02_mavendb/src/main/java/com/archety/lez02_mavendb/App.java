package com.archety.lez02_mavendb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
        	
        	//FindAll
//        	String query = "SELECT personaID, nome, cognome, cod_fis, email, telefono FROM persona;";
//        	PreparedStatement ps = conn.prepareStatement(query);
//        	
//        	ResultSet rs = ps.executeQuery();
//        	
//        	while(rs.next()) {
//        		Persona per = new Persona();
//        		per.setId( rs.getInt("personaID") );
//        		per.setNome( rs.getString("nome") );
//        		per.setCogn( rs.getString("cognome") );
//        		
//        		System.out.println(per);
//        	}
        	
        	//Vulnerabile
//        	Scanner scan = new Scanner(System.in);
//        	System.out.println("Inserisci il codice fiscale");
//        	String codFis = scan.nextLine();
//        	
//        	String query = "SELECT personaID, nome, cognome, cod_fis, email, telefono "
//        			+ "FROM persona "
//        			+ "WHERE cod_fis = '" + codFis + "'";
//        	
//        	System.out.println(query);
//        	
//        	PreparedStatement ps = conn.prepareStatement(query);
//        	
//        	ResultSet rs = ps.executeQuery();
//        	
//        	while(rs.next()) {
//        		Persona per = new Persona();
//        		per.setId( rs.getInt("personaID") );
//        		per.setNome( rs.getString("nome") );
//        		per.setCogn( rs.getString("cognome") );
//        		
//        		System.out.println(per);
//        	}
        	
        	//Versione non vulnerabile
//        	Scanner scan = new Scanner(System.in);
//        	System.out.println("Inserisci il codice fiscale");
//        	String codFis = scan.nextLine();
//        	
//        	String query = "SELECT personaID, nome, cognome, cod_fis, email, telefono "
//        			+ "FROM persona "
//        			+ "WHERE cod_fis = ?";
//        	
//        	System.out.println(query);
//        	
//        	PreparedStatement ps = conn.prepareStatement(query);
//        	ps.setString(1, codFis);
//        	
//        	ResultSet rs = ps.executeQuery();
//        	
//        	while(rs.next()) {
//        		Persona per = new Persona();
//        		per.setId( rs.getInt("personaID") );
//        		per.setNome( rs.getString("nome") );
//        		per.setCogn( rs.getString("cognome") );
//        		
//        		System.out.println(per);
//        	}
        	
        	//Insert
        	String codFis = "OPUIOY";
        	String nome = "Ciro";
        	String cognome = "Esposito";
        	String telefono = "123456";
        	
        	String query = "INSERT INTO Persona(nome, cognome, cod_fis, telefono) VALUES (?, ?, ?, ?)";
        	
        	PreparedStatement ps = conn.prepareStatement(query);
        	ps.setString(1, nome);
        	ps.setString(2, cognome);
        	ps.setString(3, codFis);
        	ps.setString(4, telefono);
        	
        	int affRows = ps.executeUpdate();
        	
        	if(affRows > 0)
        		System.out.println("STAPPOOOOOO");
        	else
        		System.out.println("Errore di inserimento");
        	
        	
        	
        	
        	
        	conn.close();
        	
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    }
}
