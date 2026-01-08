package frc.robot.subsystems;


import static edu.wpi.first.units.Units.Volt;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;

public class ShooterIOHardware implements ShooterIO {

    private final SparkMax shooterMotor, angleMotor;
    
    private final RelativeEncoder shooterEncoder, angleEncoder;

    private final PIDController shooterController;


    public ShooterIOHardware() {
        this.shooterMotor = new SparkMax(0, MotorType.kBrushless);
        this.angleMotor = new SparkMax(1, MotorType.kBrushless);
        this.shooterEncoder = shooterMotor.getEncoder();
        this.angleEncoder = angleMotor.getEncoder();
        this.shooterController = new PIDController(0.1, 0, 0);
    }

    @Override
    public void setShooterSpeed(double voltage) {
        this.shooterMotor.setVoltage(Volt.of(voltage));
    }

    @Override
    public void setShooterAngle(double angle) {
        this.angleMotor.set(this.shooterController.calculate(angleEncoder.getPosition(), angle));
    }

    @Override
    public double getShooterSpeed() {
        return this.shooterEncoder.getVelocity();
    }

    @Override
    public double getShooterAngle() {
        return this.angleEncoder.getPosition();
    }
    
}
