package bus_reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bus {
     int busId;
     String busName;
     String busType;
     int totalSeats;

    // Getters and setters

    public static void addBus(Bus bus) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO buses (bus_name, bus_type, total_seats) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, bus.getBusName());
        stmt.setString(2, bus.getBusType());
        stmt.setInt(3, bus.getTotalSeats());
        stmt.executeUpdate();
    }

    int getTotalSeats() {
		// TODO Auto-generated method stub
		return 0;
	}

	String getBusType() {
		// TODO Auto-generated method stub
		return null;
	}

	String getBusName() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Bus> getAllBuses() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM buses";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        List<Bus> buses = new ArrayList<>();
        while (rs.next()) {
            Bus bus = new Bus();
            bus.setBusId(rs.getInt("bus_id"));
            bus.setBusName(rs.getString("bus_name"));
            bus.setBusType(rs.getString("bus_type"));
            bus.setTotalSeats(rs.getInt("total_seats"));
            buses.add(bus);
        }
        return buses;
    }

	void setTotalSeats(int int1) {
		// TODO Auto-generated method stub
		
	}

	void setBusType(String string) {
		// TODO Auto-generated method stub
		
	}

	void setBusName(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setBusId(int int1) {
		// TODO Auto-generated method stub
		
	}
}
