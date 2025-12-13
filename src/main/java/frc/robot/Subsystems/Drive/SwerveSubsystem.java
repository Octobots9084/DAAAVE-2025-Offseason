package frc.robot.Subsystems.Drive;

import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.Constants;
import frc.robot.FieldConstants;



public class SwerveSubsystem extends SubsystemBase{
    public enum SystemState {
        MANUAL,
        IDLE,
        ROTATION_LOCK,
        REVERSE,
        ALIGN
    }
        SystemState wantedState;
        SystemState systemState;
        public SwerveIO io;
        public CommandJoystick driverLeft;
        public CommandJoystick driverRight;
        public double maxVelocity;
        public double maxAngularVelocity;

        final SwerveIOInputsAutoLogged swerveInputs = new SwerveIOInputsAutoLogged();

    public SwerveSubsystem(
        SwerveIO io, CommandJoystick driverLeft, CommandJoystick driverRight, double maxAngularVelocity, double maxVelocity
    ){
        this.io = io;
        this.driverLeft = driverLeft;
        this.driverRight = driverRight;
        this.maxAngularVelocity = maxAngularVelocity;
        this.maxVelocity = maxVelocity;

    }

    @Override
    public void periodic() {
        systemState = handleStateTransition();
        applyStates();
    }

    private SystemState handleStateTransition() {
        switch (wantedState){
            case MANUAL:
                return SystemState.MANUAL;
            case IDLE:
                return SystemState.IDLE;
            case ROTATION_LOCK:
                return SystemState.ROTATION_LOCK;
            case REVERSE:
                return SystemState.REVERSE;
            case ALIGN:
                return SystemState.ALIGN;
            default:
                return this.systemState;

        }
    }

    public void applyStates(){
        switch (systemState){
            case MANUAL:
                io.setSwerveState(new SwerveRequest.ApplyFieldSpeeds()
                    .withSpeeds(calculateSpeedsBasedOnJoystickInputs())
                    .withDriveRequestType(SwerveModule.DriveRequestType.OpenLoopVoltage));
                
                break;
            case IDLE:
                
                break;
            case ROTATION_LOCK:
                
                break;
            case REVERSE:
                
                break;
            case ALIGN:
                
                break;
            default:
                break;

        }
    }
    public void calculateSpeedsBasedOnJoystickInputs(){
        double yMagnitude = MathUtil.applyDeadband(driverLeft.getRawAxis(1), Constants.leftYDeadband);
        double xMagnitude = MathUtil.applyDeadband(driverLeft.getRawAxis(0), Constants.leftXDeadband);
        double angularMagnitude = MathUtil.applyDeadband(driverRight.getRawAxis(0), Constants.rightXDeadband);
        angularMagnitude = Math.copySign(angularMagnitude * angularMagnitude, angularMagnitude);
        double xVelocity = (FieldConstants.isBlueAlliance() ? -xMagnitude * maxVelocity : xMagnitude * maxVelocity)
                * Constants.maxTelopVelocity;
        double yVelocity = (FieldConstants.isBlueAlliance() ? -yMagnitude * maxVelocity : yMagnitude * maxVelocity)
                * Constants.maxTelopVelocity;

        double angularVelocity = angularMagnitude * maxAngularVelocity * Constants.maxTelopAngularVelocity;

        // could add a skew compensator
        // Rotation2d skewCompensationFactor = Rotation2d.fromRadians(swerveInputs.Speeds.omegaRadiansPerSecond * SKEW_COMPENSATION_SCALAR);

        return ChassisSpeeds.fromRobotRelativeSpeeds(
                ChassisSpeeds.fromFieldRelativeSpeeds(
                        new ChassisSpeeds(xVelocity, yVelocity, -angularVelocity), swerveInputs.Pose.getRotation()),
                swerveInputs.Pose.getRotation());//.plus(skewCompensationFactor));
    }
}
