package helperClasses;

public abstract class DefaultItem 
{
	public Vector3D MovmentVector ; 
	public Point3D Location ; 
	public float Mass ;
	public abstract void Update() ; 
	public abstract void Draw() ;
	
}
