
public interface Vector 
{
	public void setMagnitude(double magnitude);
	public double getMagnitude();
	
	public void setDirection(double direction);
	public double getDirection();
	
	public double dotProduct(Vector one, Vector two);
}
