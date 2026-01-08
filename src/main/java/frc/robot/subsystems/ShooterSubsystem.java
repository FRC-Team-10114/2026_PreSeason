package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    
    private final ShooterIO io;

    private final Mechanism2d shooterMechanism;

    private final MechanismRoot2d shooterRoot;

    private final MechanismLigament2d shooterAngle;

    private double targetSpeed = 0.0, targetAngle = 0.0;

    public ShooterSubsystem(ShooterIO io) {
        this.io = io;

        this.shooterMechanism = new Mechanism2d(1.0, 1.0);
        this.shooterRoot = shooterMechanism.getRoot("Wrist", 0.0, 0.0);
        this.shooterAngle = shooterRoot.append(
                new MechanismLigament2d("Wrist Angle", 1.0, 0.0));

        SmartDashboard.putNumber("Shooter/targetSpeed", targetSpeed);
        SmartDashboard.putNumber("shooter/targetAngle", targetAngle);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        Dashboard();

        io.setShooterSpeed(targetSpeed);
        io.setShooterAngle(targetAngle);
        
    }

    public void Dashboard() {
        SmartDashboard.getNumber("Shooter/targetAngle", 0.0);
        SmartDashboard.getNumber("Shooter/targetSpeed", 0.0);

        SmartDashboard.putNumber("Shooter/currentSpeed", this.io.getShooterSpeed());
        SmartDashboard.putNumber("Shooter/currentAngle", this.io.getShooterAngle());
        SmartDashboard.putData("Shooter/Wrist", shooterMechanism);  
    }

    public void setMechanism2d() {
        shooterAngle.setAngle(this.io.getShooterAngle());
    }

}
