package frc.robot.subsystems;

public interface ShooterIO {

    public void setShooterSpeed(double voltage);

    public void setShooterAngle(double angle);

    public double getShooterSpeed();

    public double getShooterAngle();
}