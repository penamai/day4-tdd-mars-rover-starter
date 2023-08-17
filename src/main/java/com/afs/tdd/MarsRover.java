package com.afs.tdd;

public class MarsRover {

    private Location location;

    public MarsRover(Location location) {
        this.location = location;
    }

    public void executeCommand(Command givenCommand) {
        if(givenCommand == Command.MOVE) {
            move();
        }
    }

    public void move(){
        if(location.getDirection() == Direction.NORTH){
            location.setY(location.getY() + 1);
        }else if(location.getDirection() == Direction.SOUTH){
            location.setY(location.getY() - 1);
        }else if(location.getDirection() == Direction.EAST){
            location.setX(location.getX() + 1);
        }
    }

    public Location getCurrentLocation() {
        return new Location(location.getX(), location.getY(), location.getDirection());
    }
}
