package flight_set_hw;

//Flight(int fid, String name, String source, String destination, float ratings, double ticketPrice)

public class Flight implements Comparable<Flight> {
	
	private int fid;
	private String name;
	private String source;
	private String destination;
	private float ratings;
	private double ticketPrice;
	
	public Flight() {
		
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
	
	@Override
	public String toString() {
		return "Flight [fid=" + fid + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ ", ratings=" + ratings + ", ticketPrice=" + ticketPrice + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (fid != other.fid)
			return false;
		return true;
	}

	@Override
	public int compareTo(Flight o) {
		Integer i1=this.fid;
		Integer i2=o.fid;
		return i2.compareTo(i1);
	}

}