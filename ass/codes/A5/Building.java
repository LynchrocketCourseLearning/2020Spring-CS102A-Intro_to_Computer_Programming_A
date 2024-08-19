import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Classroom> rooms;
    private Location location;
    private int id;


    public Building(Location location, int id) {
        this.location = location;
        this.id = id;
        rooms = new ArrayList<>();
    }

    public Building() {
        rooms = new ArrayList<>();
    }

    public List<Classroom> getRooms() {
        return rooms;
    }

    public void setRooms(List<Classroom> rooms) {
        this.rooms = rooms;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean addRoom(Classroom room) {
        boolean che = false;
        if (this.equals(room.getBuilding())) {
            if (rooms.size() == 0) {
                che = true;
            } else
                for (Classroom Room : rooms) {
                    if (room.getBuilding().equals(Room.getBuilding())) {
                        che = true;
                    }
                }
        }
        if (che) {
            this.rooms.add(room);
        }
        return che;
    }

    public boolean deleteRoom(Classroom room) {
        boolean che = false;
        if (this.equals(room.getBuilding())
                & this.getRooms().contains(room)
                & rooms.size() != 0) {
            for (Classroom Room : rooms) {
                if (room.getBuilding().equals(Room.getBuilding())) {
                    che = true;
                }
            }
        }
        if (che) {
            this.rooms.remove(room);
        }
        return che;
    }

    @Override
    public String toString() {
        return String.format("%s#%d", location.getName(), id);
    }
}

