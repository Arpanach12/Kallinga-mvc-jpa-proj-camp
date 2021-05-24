package dao;

import java.util.List;

import entity.Train;
import exceptions.DaoException;

public interface TrainDao {

	List<Train> getAllTrainsBasedOnSourceDestinationFromDB(String source, String destination) throws DaoException;

	int getUserDetailsOnTrainUsedIds(int trainId, int userId);

}
