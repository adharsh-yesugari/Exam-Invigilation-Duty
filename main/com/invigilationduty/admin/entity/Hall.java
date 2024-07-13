package main.com.invigilationduty.admin.entity;

public class Hall {
    private String blockName;
    private String floorNumber;
    private String roomNumber;
    public Hall(){}

    public Hall(String blockName, String floorNumber, String roomNumber) {
        this.blockName = blockName;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
