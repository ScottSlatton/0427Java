package eg1;

public class Player {

	private int id;
	private String name;
	
	public Player() {
		
	}
//
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//right click > source>select getters/setters/constructores to create all above
  @Override
  public boolean equals(Object o) {
	  Player p2=(Player)o;
	  if(this.id==p2.id) {
		  return true;
	  } else {
		  return false;
	  }
  }

}

