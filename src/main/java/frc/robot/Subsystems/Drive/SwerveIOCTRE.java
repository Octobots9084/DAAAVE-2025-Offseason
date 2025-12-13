package frc.robot.Subsystems.Drive;

import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

public class SwerveIOCTRE implements SwerveIO{

    public void updateSwerveInputs(SwerveIOInputs inputs) {}

    // default void updateModuleInputs(ModuleIOInputs... inputs) {}

    public void registerTelemetryFunction(SwerveIOInputs inputs) {}

    public void setSwerveState(SwerveRequest request) {}

    public void resetRotation() {}

    public void resetToParamaterizedRotation(Rotation2d rotation2d) {}

    public void updateSimState() {}

    public void resetRobotTranslation(Translation2d translation2d) {}
    
}
