package view;

import javax.swing.*;

import model.Adventure;
import model.City;
import model.InTransitException;
import model.TravelObserver;

//show travel status of the squad, which day, what city
public class TravelStatusView extends JPanel implements TravelObserver {

	private JLabel status_label;
	private Adventure adventure;

	public TravelStatusView(Adventure adventure) {

		this.adventure = adventure;
		adventure.addTravelObserver(this);

		status_label = new JLabel();
		try {
			String city = adventure.getCurrentCity().getName();
			status_label
					.setText("In " + city + " on day " + adventure.getDay());
		} catch (InTransitException e) {//still travelling
			// TODO Auto-generated catch block
			status_label.setText("I am traveling!");
		}
		add(status_label);
	}

	@Override
	public void travelUpdate(Adventure adventure, int distance_to_destination,
			City destination) {
		// TODO Auto-generated method stub
		if (distance_to_destination == 0) {//arrive destination
			status_label.setText("Arrived at " + destination.getName());
		} else {//display status
			status_label.setText("On day " + adventure.getDay() + " you are "
					+ distance_to_destination + " miles from "
					+ destination.getName());
		}
	}
}
