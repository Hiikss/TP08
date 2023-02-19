package fr.eni.javaee.suividesrepas.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bo.Aliment;
import fr.eni.javaee.suividesrepas.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO {
	
	private static final String INSERT_REPAS = "INSERT INTO REPAS(date_repas, heure_repas) VALUES(?,?)";
	private static final String INSERT_ALIMENT = "INSERT INTO ALIMENTS(nom_aliment, id_repas) VALUES(?,?)";
	private static final String SELECT_REPAS = "SELECT r.id id_repas, r.date_repas, r.heure_repas, a.id id_aliment, a.nom_aliment FROM REPAS r, ALIMENTS a WHERE r.id=a.id_repas ORDER BY r.date_repas DESC, r.heure_repas DESC";

	@Override
	public void insert(Repas repas) throws BusinessException {
		if(repas == null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw be;
		}
		
		try(Connection con = ConnectionProvider.getConnection()) {
			try {
				con.setAutoCommit(false);
				PreparedStatement stmt = con.prepareStatement(INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setDate(1, java.sql.Date.valueOf(repas.getDate()));
				stmt.setTime(2, java.sql.Time.valueOf(repas.getHeure()));
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next()) {
					repas.setId(rs.getInt(1));
				}
				rs.close();
				stmt.close();
				stmt = con.prepareStatement(INSERT_ALIMENT, PreparedStatement.RETURN_GENERATED_KEYS);
				for(Aliment aliment : repas.getAliments()) {
					stmt.setString(1, aliment.getNom());
					stmt.setInt(2, repas.getId());
					stmt.executeUpdate();
					rs = stmt.getGeneratedKeys();
					if(rs.next()) {
						aliment.setId(rs.getInt(1));
					}
					rs.close();
				}
				stmt.close();
				con.commit();
			}
			catch(Exception e) {
				e.printStackTrace();
				con.rollback();
				throw e;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw be;
		}
	}

	@Override
	public List<Repas> select() throws BusinessException {
		List<Repas> listeRepas = new ArrayList<Repas>();
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_REPAS);
			ResultSet rs = stmt.executeQuery();
			Repas repas = new Repas();
			while(rs.next()) {
				if(rs.getInt("id_repas") != repas.getId()) {
					repas = new Repas(rs.getInt("id_repas"), rs.getDate("date_repas").toLocalDate(), rs.getTime("heure_repas").toLocalTime());
					listeRepas.add(repas);
				}
				Aliment aliment = new Aliment(rs.getInt("id_aliment"), rs.getString("nom_aliment"));
				repas.getAliments().add(aliment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatDAL.LECTURE_REPAS_ECHEC);
			throw be;
		}
		return listeRepas;
	}

}
