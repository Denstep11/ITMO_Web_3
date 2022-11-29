package beans;

import database.CollectionBD;
import database.PointsDB;
import hitChecker.HitCheck;
import database.Point;

import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "process", eager = true)
@SessionScoped
public class ProcessBean implements Serializable {

    PointsDB pointsDB = new PointsDB();

    @ManagedProperty(value = "#{coordinates}")
    private CoordinatesBean coordinatesBean;

   @ManagedProperty(value = "#{points}")
   private PointsBean pointsBean;


    private HitCheck  hitCheck = new HitCheck();
    public ProcessBean() {

    }

    public void createNewValue(){
        Date start_time = new Date();
        long start = System.nanoTime();
        Point point = new Point();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        point.setX(coordinatesBean.getCoordinateX());
        point.setY(coordinatesBean.getCoordinateY());
        point.setR(coordinatesBean.getRadius());
        point.setTime(format.format(start_time));
        point.setResult(hitCheck.result(coordinatesBean.getCoordinateX(),coordinatesBean.getCoordinateY(),coordinatesBean.getRadius()));
        System.out.println(point);
        point.setLong_time(System.nanoTime()-start);
        CollectionBD.collection.add(point);
        pointsBean.setPointsList(CollectionBD.collection);
        pointsDB.UpdateBD(point);
        System.out.println(pointsBean.getPointsList());
    }

    public void setPointsBean(PointsBean pointsBean) {
        this.pointsBean = pointsBean;
    }

    public PointsBean getPointsBean() {
        return pointsBean;
    }

    public void setCoordinatesBean(CoordinatesBean coordinatesBean) {
        this.coordinatesBean = coordinatesBean;
    }
}
