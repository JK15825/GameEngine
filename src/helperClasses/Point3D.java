package helperClasses; 

public class Point3D 
{
	private float x;
	private float y;
	private float z;
			
	public Point3D(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point3D GetPoint()
	{
		return new Point3D(this.x  , this.y  ,this.z ); 
	}
	
	public void SetPoint(float x ,float y ,float z )
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	
}
