package form.drama.moderna;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domen.Knizevnost;
import form.FormPocetna;
import form.OpstaEkranskaForma;
import koordinatorform.KoordinatorForm;

public class FromPol extends OpstaEkranskaForma{

	private JLabel lblPitanje;
	private JButton btnMuski;
	private JButton btnZenski;
	private JButton btnPocetna;
	
	
	public FromPol(){
		this.setLayout(null);
		kreirajKomponenteEkranskeForme();
		postaviLblPitanje();	
		postavibtnMuski();
		postavibtnZenski();
		postaviBtnPocetna();
		
	}

	private void kreirajKomponenteEkranskeForme() {

		lblPitanje = new JLabel();
		btnMuski = new JButton();
		btnZenski = new JButton();
		btnPocetna = new JButton();
		
	}
	
	void postaviLblPitanje()
	{  	
		lblPitanje.setText("Odabetite dominant pol u delu.");
		lblPitanje.setSize(lblPitanje.getPreferredSize());
		lblPitanje.setLocation(10, 10);
		add(lblPitanje);		
	}
	
	void postavibtnMuski(){
		btnMuski.setAction(new AbstractAction("Muški") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setPol("Muski");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });	
		btnMuski.setSize(btnMuski.getPreferredSize());
		btnMuski.setLocation(10, 40);
		add(btnMuski);
	}
	
	void postavibtnZenski(){
		btnZenski.setAction(new AbstractAction("Ženski") {
	        public void actionPerformed(ActionEvent e) {	        	
	        	Knizevnost k = KoordinatorForm.instance().getKnjizevnost();
	        	k.setPol("Zenski");
	            KoordinatorForm.instance().setKnjizevnost(k);
	            KoordinatorForm.instance().gtePdf();
	        }
	    });		
		btnZenski.setSize(btnZenski.getPreferredSize());
		btnZenski.setLocation(150, 40);
		add(btnZenski);
	}

	void postaviBtnPocetna(){
		btnPocetna.setAction(new AbstractAction() {			
			@Override
			public void actionPerformed(ActionEvent arg0) { 	
	        	KoordinatorForm.instance().resetujEkspertniSistem();
	            KoordinatorForm.instance().postaviFormu(new FormPocetna());
			}
		});

		btnPocetna.setText("Početna");
		btnPocetna.setVerticalTextPosition(SwingConstants.BOTTOM);		
		btnPocetna.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPocetna.setSize(btnPocetna.getPreferredSize());
		btnPocetna.setLocation(10, 300);
		add(btnPocetna);
	}

}
