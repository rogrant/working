package homework_2.doppak;

public class Car implements Comparable<Car>{
    private String model;
    private String type;

    public Car(String m, String t) {
        model = m;
        type = t;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car o){
        if(this.getType().equals(o.getType()))
            return  0;
        else if(this.getType().hashCode() < o.getType().hashCode())
            return -1;
        else
            return 1;
    }
}