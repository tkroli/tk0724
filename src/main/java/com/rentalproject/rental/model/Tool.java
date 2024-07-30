package main.java.com.rentalproject.rental.model;

/**
 * Links the type of tool and its brand.
 */
public class Tool {
    /**
     * Must be unique.
     */
    private final String toolCode;
    private final ToolType toolType;
    private final String brand;

    public Tool(String toolCode, ToolType toolType, String brand) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
    }

    public String getToolCode() { return toolCode; }
    public ToolType getToolType() { return toolType; }
    public String getBrand() { return brand; }
}
