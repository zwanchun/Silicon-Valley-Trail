package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import supplies.Supplies;
import model.Adventure;
import model.City;
import model.Knapsack;
import model.Squad;

//display kanpsack status
public class KnapsackView extends JPanel implements Observer{
	
	private JLabel label;
	private Squad squad;
	
	
	public KnapsackView(Squad squad){
		this.squad=squad;
		Knapsack knapsack=squad.getKnapsack();
		label=new JLabel();
		if(knapsack==null || knapsack.getSupplies().length==0){//if knapsack is empty
			label.setText("Knapsack is empty!");
		}
		else{//knapsack is not empty
			//using StringBuffer to store knapsack description
			StringBuffer text = new StringBuffer("<html><body>");
			for (Supplies supply : knapsack.getSupplies()) {
				text.append(supply.toString());
				text.append("<br>");//using html to format string
			}
			text.append("</body></html>");
			label.setText(text.toString());
		}
		
		add(label);
		knapsack.addObserver(this);
	}


	//update knapsack status
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Knapsack knapsack=squad.getKnapsack();
				if(knapsack==null || knapsack.getSupplies().length==0){
					label.setText("Knapsack is empty");
				}
				else{
					StringBuffer text = new StringBuffer("<html><body>");
					for (Supplies supply : knapsack.getSupplies()) {
						text.append(supply.toString());
						text.append("<br>");
					}
					text.append("<body><html>");
					label.setText(text.toString());
				}
				
			}
		});
	}

	


}
