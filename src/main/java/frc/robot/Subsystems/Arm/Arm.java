package frc.robot.Subsystems.Arm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Subsystems.Arm.ArmStates.ArmPositiones;
import frc.robot.Subsystems.Arm.ArmStates.ArmState;

public class Arm extends SubsystemBase{
    public ArmPositions desired_arm_position = ArmPositions.SAFE;
    public ArmState arm_state = ArmState.IDLE;
    public ArmPositions wanted_state = ArmPositions.SAFE;
    
    public Arm(){
        
    }

    @Override
    public void periodic() {
        //Logger.processInputs();

        switch(arm_state){
            case Armstates.IDLE:
                brea
        }
    }
    
    public void handleStateTransitions(ArmStates wantedState) {
        switch(wantedState){
            case L1:
                if(true){
                    
                }
                break;
            case L2:
                if(true){
                    
                }
                break;
            case L3:
                if(true){
                    
                }
                break;
            case L4:
                
        }
                   
        }
        

    public void getPosition() {
        if (arm_state == ArmState.MOVING || arm_state == ArmState.MANUAL) {
            return arm_state;
        }
        else if (arm_state == ArmState.IDLE)
    }
    //if moving return moving
    //if manual return manual
    //if idle return the enum
    //arm state= current wanted= want
    


    public boolean stateInTolerance (double tolerance) {
        //ArmState current_arm_state = getCurrent
        //ArmState 
        
        //double t1=0;
        //dob
        //if(tolerance=>t1 && tolerance=<t2){
        //if(tolerance=>t1 && tolerance=<t2){
            //return true//more code
            
        //} else{
        //return false;    
        //}
    }



    public void applyStates(){
        switch(currentState) {
        case MOVING:
            Arm.setPosition(desired_arm_position);
            bbreak;
        case IDLE:
            break;
        case MANUAL:
            break;
        }
        
    }
}