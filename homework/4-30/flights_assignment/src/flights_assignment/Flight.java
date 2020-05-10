package flights_assignment;

public class Flight implements Comparable<Flight> {
	
	private int fid;
	private String name;
	private String source;
	private String destination;
	private float ratings;
	private double ticketPrice;
	
	public Flight() {
//		super();
	}

	public Flight(int fid, String name, String source, String destination, float ratings, double ticketPrice) {
		super();
		this.fid = fid;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.ratings = ratings;
		this.ticketPrice = ticketPrice;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

//	this sets toString specifically for my program, so that it is formatted with all my variables
@Override
public String toString() {
	return "Flight [fid=" + fid + ", name=" + name + ", source=" + source + ", destination=" + destination
			+ ", ratings=" + ratings + ", ticketPrice=" + ticketPrice + "]";
}

@Override
public int compareTo(Flight o) {
	// TODO Auto-generated method stub
	Integer i1=this.fid;
	Integer i2=o.fid;
	return i2.compareTo(i1);
}	
	

}


//  int fid, String name, String source, String destination, float ratings, double ticketPrice