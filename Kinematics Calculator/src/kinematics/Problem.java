package kinematics;

public class Problem {

	private double v0, v, a, t, d, type;
	
	public Problem(double velocity0, double velocity, double accel, double time, double displacement) {
		v0 = velocity0;
		v = velocity;
		a = accel;
		t = time;
		d = displacement;
	}
	
	public void solve() {
		if(v0 != -999 & v != -999 & a != -999) {
			t = Time.formula1(v0, v, a);
			d = Displacement.formula2(v0, v, a);
		}
		else if(v0 != -999 & v != -999 & t != -999) {
			a = Acceleration.formula1(v0, v, t);
			d = Displacement.formula3(v0, v, t);
		}
		else if(v0 != -999 & v != -999 & d != -999) {
			a = Acceleration.formula3(v0, v, d);
			t = Time.formula2(v0, v, d);
		}
		else if(v0 != -999 & a != -999 & t != -999) {
			d = Displacement.formula1(v0, a, t);
			v = Velocity.formula1(v0, a, t);
		}
		else if(v0 != -999 & a != -999 & d != -999) {
			v = Velocity.formula2(v0, a, d);
			t = Time.formula1(v0, v, a);
		}
		else if(v0 != -999 & t != -999 & d != -999) {
			v = Velocity.formula3(v0, t, d);
			a = Acceleration.formula2(v0, t, d);
		}
		else if(v != -999 & a != -999 & t != -999) {
			v0 = Velocity0.formula1(v, a, t);
			d = Displacement.formula1(v0, a, t);
		}
		else if(v != -999 & a != -999 & d != -999) {
			v0 = Velocity0.formula3(v, a, d);
			t = Time.formula1(v0, v, a);
		}
		else if(v != -999 & t != -999 & d != -999) {
			v0 = Velocity0.formula4(v, t, d);
			a = Acceleration.formula1(v0, v, t);
		}
		else if(a != -999 & t != -999 & d != -999) {
			v0 = Velocity0.formula2(a, t, d);
			v = Velocity.formula1(v0, a, t);
		}
	}
	
	public double getV0() {
		return v0;
	}
	
	public double getV() {
		return v;
	}
	
	public double getA() {
		return a;
	}
	
	public double getT() {
		return t;
	}
	
	public double getD() {
		return d;
	}
}
