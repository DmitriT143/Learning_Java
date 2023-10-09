public class Point2D {
    private double xCoord;
    private double yCoord;
    public Point2D (double x, double y){
    xCoord = x;
    yCoord = y;
    }
    public Point2D(){
     this(0,0);
    }
    public double getX(){return xCoord;};
    public double getY(){return yCoord;};
    public void setX( double val ){xCoord = val;};
    public void setY( double val ){yCoord = val;};

}

class Point3D extends Point2D {
    private double zCoord;
    public Point3D (double x, double y, double z){
        super(x, y);
        zCoord = z;
    }
    public double getZ(){return zCoord;};
    public void setZ(double val){zCoord = val;};
}