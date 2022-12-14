package lab11_exercise3;

/**
 * Enum type that represents the type of products (Same as Exercise 1)
 * 
 * @author Stella Kazamia
 * 
 */
public enum ProductType {
	ITALIAN("Italian"), CHINESE("Chinese"), INDIAN("Indian"), TRADITIONAL("Traditional");
	
	private String description;
	
	private ProductType(final String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
