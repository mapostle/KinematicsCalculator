package kinematics;

import javax.swing.*;
import BreezySwing.*;
import java.text.DecimalFormat;

public class KinematicsGUI extends GBFrame {

	DecimalFormat df = new DecimalFormat("0.00");
	private JTextField v0, v, a, t, d;
	private JButton calculate;
	private JButton reset;
	private JButton quit;
	private double velocity0, velocity, accel, time, displacement;
	
	public KinematicsGUI() {
		velocity0 = velocity = accel = time = displacement = -999;
		
		addLabel("Please input 3 variables. The calculator will solve for the 2 unknowns.", 	1, 1, 1, 1);
		addLabel("Initial Velocity:",					2, 1, 1, 1);
		addLabel("Final Velocity:",						3, 1, 1, 1);
		addLabel("Acceleration:",						4, 1, 1, 1);
		addLabel("Time:",								5, 1, 1, 1);
		addLabel("Displacement:",						6, 1, 1, 1);
		v0 = addTextField("",							2, 2, 1, 1);
		v = addTextField("",							3, 2, 1, 1);
		a = addTextField("",							4, 2, 1, 1);
		t = addTextField("",							5, 2, 1, 1);
		d = addTextField("",							6, 2, 1, 1);
		calculate = addButton("Calculate",				7, 1, 1, 1);
		reset = addButton("Reset",						7, 2, 1, 1);
		quit = addButton("Quit",						7, 3, 1, 1);
		
		//Attach units to the end
		addLabel("m/s",									2, 3, 1, 1);
		addLabel("m/s",									3, 3, 1, 1);
		addLabel("m/s^2",								4, 3, 1, 1);
		addLabel("s",									5, 3, 1, 1);
		addLabel("m",									6, 3, 1, 1);
	}
	
	public void buttonClicked(JButton j) {
		if(j == calculate) {
			if(Error.checkUnknowns(v0.getText(), v.getText(), a.getText(), t.getText(), d.getText()) == true)
				messageBox("Please enter exactly 3 variables.");
			else {
				if(v0.getText().equals("") == false) { 
					velocity0 = Double.parseDouble(v0.getText());
					v0.setEnabled(false);
				}
				if(v.getText().equals("") == false) {
					velocity = Double.parseDouble(v.getText());
					v.setEnabled(false);
				}
				if(a.getText().equals("") == false) {
					accel = Double.parseDouble(a.getText());
					a.setEnabled(false);
				}
				if(t.getText().equals("") == false) {
					time = Double.parseDouble(t.getText());
					t.setEnabled(false);
				}
				if(d.getText().equals("") == false) {
					displacement = Double.parseDouble(d.getText());
					d.setEnabled(false);
				}
				
				Problem p = new Problem(velocity0, velocity, accel, time, displacement);
				p.solve();
				v0.setText(df.format(p.getV0()) + "");
				v.setText(df.format(p.getV()) + "");
				a.setText(df.format(p.getA()) + "");
				t.setText(df.format(p.getT()) + "");
				d.setText(df.format(p.getD()) + "");
				calculate.setEnabled(false);
				
				if(Error.checkNegTime(p.getT()) == true) {
					messageBox("Time cannot be negative; this scenario does not exist.");
				}
				else if(Error.checkZeroTime(p.getT()) == true) {
					messageBox("Time cannot be 0 (instantaneous travel); this scenario does not exist.");
				}
			}
			
		}
		else if(j == reset) {
			v0.setText("");
			v0.setEnabled(true);
			v.setText("");
			v.setEnabled(true);
			a.setText("");
			a.setEnabled(true);
			t.setText("");
			t.setEnabled(true);
			d.setText("");
			d.setEnabled(true);
			calculate.setEnabled(true);
		}
		else if(j == quit) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KinematicsGUI gui = new KinematicsGUI();
		gui.setSize(700, 500);
		gui.setTitle("Kinematics Calculator");
		gui.setVisible(true);
	}

}
