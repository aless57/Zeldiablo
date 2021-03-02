package projet_zeldiablo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EcranDefaite extends JPanel {
	
	public EcranDefaite() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel titre = new JLabel("Game Over ");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 32));
		add(titre, BorderLayout.NORTH);
		
		JFrame frame = new JFrame("Fin de partie");
		frame.setContentPane(this);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblVousAvezReussi = new JLabel("Votre personnage est mort");
		lblVousAvezReussi.setHorizontalAlignment(SwingConstants.CENTER);
		lblVousAvezReussi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		panel.add(lblVousAvezReussi);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		panel_1.add(btnNewButton);
		frame.setSize(600,300);
		frame.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(1);
			}
			
		});
		
	}
}
