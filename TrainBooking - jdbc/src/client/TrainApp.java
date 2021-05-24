package client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entity.Train;
import entity.User;
import exceptions.ServiceException;
import service.TrainService;
import service.trainServiceImpl.TrainServiceImpl;

public class TrainApp {

	static Scanner scanner = new Scanner(System.in);
	static TrainService service = new TrainServiceImpl();

	public static void main(String[] args) {

		char ch;
		do {
			displayMenu();
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter source : ");
				String source = scanner.next();
				System.out.println("Enter destination : ");
				String destination = scanner.next();
				List<Train> trains = new ArrayList<>();
				try {
					trains = service.getAllTrainsBasedOnSourceDestination(source, destination);
				} catch (ServiceException e) {
					System.out.println(e);
					// e.printStackTrace();
				}
				display(trains);
				System.out.println("Enter trainID : ");
				int trainId = scanner.nextInt();
				System.out.println("Enter userID : ");
				int userId = scanner.nextInt();
				int fare = service.getUserDetailsOnTrainUsedIds(trainId, userId);
				System.out.println("Booking successful and calculated fare is : " + fare);
				break;
			case 2:
//				List<User> usersWithFair = service.getUsersWithFair();

				break;
			case 3:
				break;
			case 4:
				System.out.println("Successfully Exited.");
				System.exit(0);
				break;
			default:
				System.out.println("Enter valid choice : ");
			}
			System.out.println("Do you want to continue ? Press y/Y to continue or any other key to discontinue");
			ch = scanner.next().charAt(0);
			if (!(ch == 'y' || ch == 'Y'))
				System.out.println("Thank you !!!");
		} while (ch == 'y' || ch == 'Y');
	}

	private static void display(List<Train> trains) {

		for (Train train : trains) {
			System.out.println(train.getTrainId() + "   " + train.getTrainName() + "   " + train.getSource() + "   "
					+ train.getDestination() + "   " + train.getDistance() + "   " + train.getFare());
		}

	}

	private static void displayMenu() {
		System.out.println("1. Book a Ticket for the user\n" + "Input- Source and Destination\n"
				+ "O/P: Print all trains based upon the above two parameters.\n" + "Input- train Id and user Id\n"
				+ "Output- “Booking Successful and calculated fare is ‘’’fare’”\n"
				+ "2. Show all the booking details(with user information) sorted in descending order of fare.\n"
				+ "3. Write all the booking details in a text file using file I/O.\n" + "4.Exit\n");
	}

}
