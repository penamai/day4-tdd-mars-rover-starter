package com.afs.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MarsRoverTest {
    private MarsRover marsRover;
    private Location currentLocation;

    private void prepareAndExecute(Command command, Direction direction){
        prepare(direction);

        marsRover.executeCommand(command);
        currentLocation = marsRover.getCurrentLocation();
    }

    private void prepare(Direction direction) {
        Location initialLocation = new Location(0, 0, direction);
        marsRover = new MarsRover(initialLocation);
    }

    private void assertLocation(int expectedX, int expectedY, Direction expectedDirection){
        Assertions.assertEquals(expectedX , currentLocation.getX());
        Assertions.assertEquals(expectedY , currentLocation.getY());
        Assertions.assertEquals(expectedDirection , currentLocation.getDirection());
    }

    @Test
    void should_change_to_location_0_1_N_when_executeCommand_given_0_0_North_and_command_Move() {
        prepareAndExecute(Command.MOVE, Direction.NORTH);
        assertLocation(0,1,Direction.NORTH);
    }

    @Test
    void should_change_to_location_0_negative1_S_when_executeCommand_given_0_0_South_and_command_Move(){
        prepareAndExecute(Command.MOVE, Direction.SOUTH);
        assertLocation(0,-1,Direction.SOUTH);
    }

    @Test
    void should_change_to_location_1_0_E_when_executeCommand_given_0_0_East_and_command_Move(){
        prepareAndExecute(Command.MOVE, Direction.EAST);
        assertLocation(1,0,Direction.EAST);
    }

    @Test
    void should_change_to_location_negative_0_W_when_executeCommand_given_0_0_West_and_command_Move(){
        prepareAndExecute(Command.MOVE, Direction.WEST);
        assertLocation(-1,0,Direction.WEST);
    }

    @Test
    void should_change_to_location_0_0_W_when_executeCommand_given_0_0_N_and_command_TurnLeft(){
        prepareAndExecute(Command.TURN_LEFT, Direction.NORTH);
        assertLocation(0,0,Direction.WEST);
    }

    @Test
    void should_change_to_location_0_0_E_when_executeCommand_given_0_0_S_and_command_TurnLeft(){
        prepareAndExecute(Command.TURN_LEFT, Direction.SOUTH);
        assertLocation(0,0,Direction.EAST);
    }

    @Test
    void should_change_to_location_0_0_N_when_executeCommand_given_0_0_E_and_command_TurnLeft(){
        prepareAndExecute(Command.TURN_LEFT, Direction.EAST);
        assertLocation(0,0,Direction.NORTH);
    }

    @Test
    void should_change_to_location_0_0_S_when_executeCommand_given_0_0_W_and_command_TurnLeft(){
        prepareAndExecute(Command.TURN_LEFT, Direction.WEST);
        assertLocation(0,0,Direction.SOUTH);
    }

    @Test
    void should_change_to_location_0_0_E_when_executeCommand_given_0_0_N_and_command_TurnRight(){
        prepareAndExecute(Command.TURN_RIGHT, Direction.NORTH);
        assertLocation(0,0,Direction.EAST);
    }

    @Test
    void should_change_to_location_0_0_W_when_executeCommand_given_0_0_S_and_command_TurnRight(){
        prepareAndExecute(Command.TURN_RIGHT, Direction.SOUTH);
        assertLocation(0,0,Direction.WEST);
    }

    @Test
    void should_change_to_location_0_0_S_when_executeCommand_given_0_0_E_and_command_TurnRight(){
        prepareAndExecute(Command.TURN_RIGHT, Direction.EAST);
        assertLocation(0,0,Direction.SOUTH);
    }

    @Test
    void should_change_to_location_0_0_N_when_executeCommand_given_0_0_W_and_command_TurnRight(){
        prepareAndExecute(Command.TURN_RIGHT, Direction.WEST);
        assertLocation(0,0,Direction.NORTH);
    }

    @Test
    void should_change_to_location_negative1_1_N_when_executeBatchCommand_given_0_0_N_and_commands_MLMR(){
        prepare(Direction.NORTH);
        List<Command> givenCommands = Arrays.asList(Command.MOVE, Command.TURN_LEFT, Command.MOVE, Command.TURN_RIGHT);

        marsRover.executeBatchCommand(givenCommands);
        currentLocation = marsRover.getCurrentLocation();

        assertLocation(-1,1,Direction.NORTH);
    }
}
