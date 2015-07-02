package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import person.Person;
import model.Adventure;
import model.Squad;

public class AdventureView extends JPanel {

	private Adventure adventure;
	
	public AdventureView(Adventure adventure) {
		this.adventure = adventure;
		
		setLayout(new BorderLayout());
		
		
		Squad s = adventure.getSquad();

		SquadView squdView=new SquadView(s);
		add(squdView,BorderLayout.WEST);
		
		KnapsackView knapsackView=new KnapsackView(s);
		add(knapsackView,BorderLayout.EAST);
		 
		TravelStatusView travelStatusView=new TravelStatusView(adventure);
		StoreView storeView=new StoreView(adventure);
		TravelControlView tv=new TravelControlView(adventure);
		StatusView statusView=new StatusView(travelStatusView,tv,storeView);
		add(statusView,BorderLayout.SOUTH);
		
    

	}
}
