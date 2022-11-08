import java.io.*;

public class BMI{
    double height;
    double weight;
    double bmi;
    String status;

    public BMI(double height, double weight, double bmi, String status) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.status = status;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
