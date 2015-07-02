package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class StatusView extends JPanel{
	
	private TravelStatusView tsv;
	private TravelControlView tcv;
	private StoreView sv;
	
	public StatusView(TravelStatusView tsv, TravelControlView tcv, StoreView sv){
		this.tsv=tsv;
		this.tcv=tcv;
		this.sv=sv;
		
		setLayout(new GridLayout(3,0));
		
		add(tsv);
		add(tcv);
		add(sv);
		
	}

}
