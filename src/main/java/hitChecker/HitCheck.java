package hitChecker;

public class HitCheck {
    Float x;
    Float y;
    Float r;

    public HitCheck(){

    }

    public Boolean result(float x, float y, float r){
        this.x=x;
        this.y=y;
        this.r=r;
        return coordinateQuarterFourth()||coordinateQuarterSecond()||coordinateQuarterFirst();
    }

    private Boolean coordinateQuarterFourth(){
        return x>=0 && y<=0 && x*x+y*y<=r*r;
    }

    private Boolean coordinateQuarterSecond(){
        return x<=0 && y>=0 && y<=(2*x+r);
    }

    private Boolean coordinateQuarterFirst(){
        return x>=0 && y>=0 && x<=r && y<=r/2;
    }

    public boolean result(String coor_x, String coor_y, String value_r) {
        try {
            this.x= Float.valueOf(coor_x);
            this.y= Float.valueOf(coor_y);
            this.r= Float.valueOf(value_r);
            return coordinateQuarterFourth()||coordinateQuarterSecond()||coordinateQuarterFirst();
        }
        catch (Exception e){
            return false;
        }
    }
}
