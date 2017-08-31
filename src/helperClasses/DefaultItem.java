package helperClasses;

public abstract class DefaultItem 
{
	public Vector3D vector ; 
	public Point3D location ; 
	public float mass ;
	public abstract void Update() ; 
	public abstract void Draw() ;
	public float elasticity ; 
	public float CaculateMomentum()
	{
		return vector.magnitude() * mass;
	}
	public abstract void colide(Vector3D u); 

	
}
