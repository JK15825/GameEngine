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
	
	public void add(float x , float y , float z )
	{
		this.x += x; 
		this.y += y; 
		this.z += z ; 

	}
	public void add(Vector3D v )
	{
		this.x += v.x ; 
		this.y += v.y ; 
		this.z += v.z ; 
	}
	public void sub(float x , float y , float z )
	{
		this.x -= x; 
		this.y -= y; 
		this.z -= z ; 

	}
	public void sub(Vector3D v )
	{
		this.x -= v.x ; 
		this.y -= v.y ; 
		this.z -= v.z ; 
	}
	public void mult(float scalar)
	{
		this.x *= scalar; 
		this.y *= scalar; 
		this.z *= scalar ; 

	}
	public float magnitude()
	{
		return (float) Math.sqrt(Math.pow(this.x, 2) +Math.pow(this.y, 2) +Math.pow(this.z, 2));

	}
	public float dotProduct(Vector3D v )
	{
	 return this.x * v.x + this.y * v.y + this.z * v.z;
	}
	public Vector3D crossproduct(Vector3D v )
	{
	 return  new Vector3D(this.y * v.z - v.y * this.z  , this.z * v.x - v.x * this.z , this.x * v.y - v.y * this.x); 
	}
	
}
