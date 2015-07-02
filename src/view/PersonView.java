package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.SwingUtilities;

import person.Person;

//show status of every player
public class PersonView extends JPanel implements Observer {

	private Person person;
	private JLabel status_label;
	
	public PersonView(Person p) {
		person = p;
		status_label = new JLabel(p.toString());
		
		add(status_label);
		person.addObserver(this);//add to observer
	}

	@Override
	public void update(Observable o, Object arg) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				status_label.setText(person.toString());//update person status
			}
		});
	}
}
