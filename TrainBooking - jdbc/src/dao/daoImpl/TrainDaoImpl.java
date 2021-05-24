package dao.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dao.TrainDao;
import dbUtility.DBUtility;
import entity.Train;
import exceptions.DaoException;
import exceptions.NoSuchDestinationException;
import exceptions.NoSuchSourceException;

public class TrainDaoImpl implements TrainDao {

	static DBUtility db = new DBUtility();
	@Override
	public List<Train> getAllTrainsBasedOnSourceDestinationFromDB(String source, String destination) throws DaoException {
		List<Train> trains = new ArrayList<>();
		Connection con = db.getConnection();
		
		String query = "Select * from train ;";
		ResultSet sourceDestination = null;
		
		List<String> sources = new ArrayList<>();
		List<String> destinations= new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			sourceDestination = ps.executeQuery();
			while(sourceDestination.next())
			{
				String s = sourceDestination.getString(3);
				String d = sourceDestination.getString(4);
				sources.add(s);
				destinations.add(d);
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
//		System.out.println(sources);
//		System.out.println(destinations);
		
		String query1 = "Select * from train where source='"+source+"' and destination = '"+destination+"'";
		ResultSet rs  = null;
		try {
			PreparedStatement  prepareStmt = (PreparedStatement) con.prepareStatement(query1);
			rs=prepareStmt.executeQuery();
			if(!(sources.contains(source)))
				{
					
						throw new NoSuchSourceException("No such source exists");
					
				}
			 if(!(destination.contains(destination)))
			{
				
					throw new NoSuchDestinationException("No such destination exists");
				
			}
		} catch (SQLException|NoSuchSourceException|NoSuchDestinationException e) {
			throw new DaoException();
		}
		
		try {
			while(rs.next())
			{
				int trainID = rs.getInt(1);
				String trainName = rs.getString(2);
				String trainSource = rs.getString(3);
				String trainDestination = rs.getString(4);
				int distance = rs.getInt(5);
				int fare = rs.getInt(6);
				Train train = new Train(trainID, trainName, trainSource, trainDestination, distance, fare);
				trains.add(train);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trains;
		
	}
	@Override
	public int getUserDetailsOnTrainUsedIds(int trainId, int userId) {
		int fare=-1;
		Connection con = db.getConnection();
		
		String query2 = " select * from user inner join Train on user.train_id = Train.train_id where user_id='"+userId+"' and train.train_id='"+trainId+"'";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement prepareStmt = (PreparedStatement) con.prepareStatement(query2);
			rs=prepareStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				fare = rs.getInt(9);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fare;
	}
}
