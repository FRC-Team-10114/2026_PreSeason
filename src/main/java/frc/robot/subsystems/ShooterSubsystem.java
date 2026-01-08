package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    
    private final ShooterIO io;

    private double targetSpeed = 0.0, targetAngle = 0.0;

    public ShooterSubsystem(ShooterIO io) {
        this.io = io;
        SmartDashboard.putNumber("Shooter/targetSpeed", targetSpeed);
        SmartDashboard.putNumber("shooter/targetAngle", targetAngle);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        DashboardControl();

        io.setShooterSpeed(targetSpeed);
        io.setShooterAngle(targetAngle);
        
    }

    public void DashboardControl() {
        SmartDashboard.getNumber("targetAngle", 0.0);
        SmartDashboard.getNumber("targetSpeed", 0.0);

    }

}
