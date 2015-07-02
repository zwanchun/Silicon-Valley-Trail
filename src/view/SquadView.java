package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Squad;

//show status of all players
public class SquadView extends JPanel{
	
	public SquadView(Squad squad){
		PersonView[] personView=new PersonView[squad.getNumPlayers()];// use array to store all personview
		setLayout(new GridLayout(0,1));//use grid layout
		for(int i=0;i<squad.getNumPlayers();i++){
			personView[i]=new PersonView(squad.getPlayer(i));
			add(personView[i]);//add to gridlayout
		}
		
	}
}
