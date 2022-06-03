package hiber.model;

import javax.persistence.*;

@Entity
@Table (name = "car")
public class Car {
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private Long id;

    @Column (name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Car(){

    }

    public Car(String model, int series){
        this.model = model;
        this.series = series;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
