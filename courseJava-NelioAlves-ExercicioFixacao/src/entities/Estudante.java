package entities;

public class Estudante {
	private String name;
	private String email;
	private boolean reg;
	private int indexroom;
	
	private Estudante(String name, String email,int indexroom) {
		this.name = name;
		this.email = email;
		this.reg = true;
		this.indexroom = indexroom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Estudante [name=" + this.getName() +
				", email=" + this.getEmail() + 
				", Quarto: " + indexroom +"]";
	}
	
	
}
