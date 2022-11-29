package database;

public class Point {
    private float x;
    private float y;
    private float r;
    private boolean result;
    private String time;
    private long long_time;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getLong_time() {
        return long_time;
    }

    public void setLong_time(long long_time) {
        this.long_time = long_time;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result=" + result +
                ", time='" + time + '\'' +
                ", long_time=" + long_time +
                '}';
    }
}
