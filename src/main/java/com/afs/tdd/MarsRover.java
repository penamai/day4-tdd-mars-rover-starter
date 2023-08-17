package com.afs.tdd;

public class MarsRover {

    private Location location;

    public MarsRover(Location location) {
        this.location = location;
    }

    public void executeCommand(Command givenCommand) {
        if(givenCommand == Command.MOVE) {
            move();
        }else if(givenCommand == Command.TURN_LEFT){
            turnLeft();
        }
    }

    public void move(){
        if(location.getDirection() == Direction.NORTH){
            location.setY(location.getY() + 1);
        }else if(location.getDirection() == Direction.SOUTH){
            location.setY(location.getY() - 1);
        }else if(location.getDirection() == Direction.EAST){
            location.setX(location.getX() + 1);
        }else{
            location.setX(location.getX() - 1);
        }
    }

    private void turnLeft() {
        if(location.getDirection() == Direction.NORTH){
            location.setDirection(Direction.WEST);
        }else if(location.getDirection() == Direction.SOUTH){
            location.setDirection(Direction.EAST);
        }else if(location.getDirection() == Direction.EAST){
            location.setDirection(Direction.NORTH);
        }
    }

    public Location getCurrentLocation() {
        return new Location(location.getX(), location.getY(), location.getDirection());
    }
}
