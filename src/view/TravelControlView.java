package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Adventure;
import model.City;

//to control which city to travel
public class TravelControlView extends JPanel implements ActionListener{

	private Adventure adventure;
	private JComboBox citylist;
	
	public TravelControlView(Adventure adventure){
		this.adventure=adventure;
		
		JLabel label=new JLabel("Travel to: ");
		City[] cities=adventure.getCities();
		citylist=new JComboBox(cities);//use combobox to display choices
		citylist.addActionListener(this);
		add(label);
		add(citylist);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//travel to the city selected in the combobox
		adventure.travel((City)citylist.getSelectedItem());
		
	}

}
