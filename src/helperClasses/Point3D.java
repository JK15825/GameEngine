package helperClasses; 

public class Point3D 
{
	private double x;
	private double y;
	private double z;
	
	public Point3D()
	{
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Point3D(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() 
	{
		return x;
	}

	public void setX(double x) 
	{
		this.x = x;
	}

	public double getY() 
	{
		return y;
	}

	public void setY(double y) 
	{
		this.y = y;
	}

	public double getZ()
	{
		return z;
	}

	public void setZ(double z) 
	{
		this.z = z;
	}
	
	public Point3D GetPoint()
	{
		return new Point3D(this.x  , this.y  ,this.z ); 
	}
	
	
	
}
