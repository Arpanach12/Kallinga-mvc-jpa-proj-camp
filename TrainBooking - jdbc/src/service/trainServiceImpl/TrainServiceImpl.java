package service.trainServiceImpl;

import java.util.ArrayList;
import java.util.List;

import dao.TrainDao;
import dao.daoImpl.TrainDaoImpl;
import entity.Train;
import entity.User;
import exceptions.DaoException;
import exceptions.ServiceException;
import service.TrainService;

public class TrainServiceImpl implements TrainService {

	static TrainDao dao = new TrainDaoImpl();
	@Override
	public List<Train> getAllTrainsBasedOnSourceDestination(String source, String destination) throws ServiceException {
		
		List<Train> trains = new ArrayList<>();
		try {
			trains = dao.getAllTrainsBasedOnSourceDestinationFromDB(source,destination);
		} catch (DaoException e) {
			throw new ServiceException("No such source exists");
		}
		return trains;
	}
	@Override
	public int getUserDetailsOnTrainUsedIds(int trainId, int userId) {
		
		int fare = dao.getUserDetailsOnTrainUsedIds(trainId,userId);
		return fare;
	}
	
}
