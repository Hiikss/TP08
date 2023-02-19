package fr.eni.javaee.suividesrepas.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO {
	
	private static final String INSERT_REPAS = "INSERT INTO REPAS(date_repas, heure_repas) VALUES(?,?)";
	private static final String INSERT_ALIMENT = "INSERT INTO ALIMENTS(nom_aliment, id_repas) VALUES(?,?)";
	private static final String SELECT_REPAS = "SELECT r.id, r.date_repas, r.heure_repas, a.id, a.nom_aliment FROM REPAS r, ALIMENTS a WHERE r.id=a.id_repas ORDER BY r.date_repas DESC, r.heure_repas DESC";

	@Override
	public void insert(Repas repas) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Repas> select() throws BusinessException {
		List<Repas> listeRepas = new ArrayList<Repas>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_REPAS);
			ResultSet rs = stmt.executeQuery();
			Repas repas = new Repas();
			while(rs.next()) {
				listeRepas.add(repas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeRepas;
	}

}
