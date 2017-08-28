package helperClasses; 

public class Vector3D
{
	private float x ; 
	private float y ;
	private float z ;
	
	public Vector3D(float x , float y , float z )
	{
		this.x = x ; 
		this.y = y ; 
		this.z = z ; 
		
	}
	public Vector3D getVector() 
	{
			return new Vector3D(x , y , z );
	}

	
	public void setVector(float x , float y , float z )
	{
		this.x = x ; 
		this.y = y ; 
		this.z = z ; 
	}


	
}
