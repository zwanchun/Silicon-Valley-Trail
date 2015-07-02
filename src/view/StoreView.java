package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.InTransitException;
import model.ItemNotForSaleException;
import model.Store;

//display items sold in store and their price
public class StoreView extends JPanel implements ActionListener{
	
	private Adventure adventure;
	private JComboBox storelist;
	private JLabel warning_label;
	
	public StoreView(Adventure adventure){
		this.adventure=adventure;
		warning_label=new JLabel();
		add(warning_label);
		Store s;
		try {
			s = adventure.getCurrentCity().getStore();
			String[] item_names = s.getItemNames();
			String[] price_list=new String[item_names.length];
			for(int i=0;i<item_names.length;i++){//get current items and corresponding price
				price_list[i]=item_names[i] + " ($" + s.getPrice(item_names[i]) + ")";
			}
			storelist=new JComboBox(price_list);
			storelist.addActionListener(this);
			
		} catch (InTransitException e) {
			// TODO Auto-generated catch block
			warning_label.setText("No store while travelling.");
		} catch (ItemNotForSaleException e) {
		}
		add(storelist);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
