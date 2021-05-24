package service;

import java.util.List;

import entity.Train;
import entity.User;
import exceptions.ServiceException;

public interface TrainService {

	List<Train> getAllTrainsBasedOnSourceDestination(String source, String destination) throws ServiceException;

	int getUserDetailsOnTrainUsedIds(int trainId, int userId);



}
