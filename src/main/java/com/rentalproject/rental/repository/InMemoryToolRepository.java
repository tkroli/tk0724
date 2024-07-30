package main.java.com.rentalproject.rental.repository;

import main.java.com.rentalproject.rental.model.Tool;
import main.java.com.rentalproject.rental.model.ToolType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * In memory database class.  Added basic db operations just to have it somewhat fleshed out, some methods not required.
 */
public class InMemoryToolRepository implements ToolRepository {

    private final Map<String, Tool> toolRepo;

    public InMemoryToolRepository() {
        // These types would normally be included as a table, but not needed for the spec contents.
        Map<String, ToolType> toolTypes = new HashMap<>();
        // To keep things simple, made the DB ID just caps of the regular label.  Likely would be different if actual
        // DB was hooked into application.
        toolTypes.put("LADDER", new ToolType("Ladder", new BigDecimal("1.99"), true, true, false));
        toolTypes.put("CHAINSAW", new ToolType("Chainsaw", new BigDecimal("1.49"), true, false, true));
        toolTypes.put("JACKHAMMER", new ToolType("Jackhammer", new BigDecimal("2.99"),  true,false, false));

        this.toolRepo = new HashMap<>();
        addTool(new Tool("CHNS", toolTypes.get("CHAINSAW"), "Stihl"));
        addTool(new Tool("LADW", toolTypes.get("LADDER"), "Werner"));
        addTool(new Tool("JAKD", toolTypes.get("JACKHAMMER"), "DeWalt"));
        addTool(new Tool("JAKR", toolTypes.get("JACKHAMMER"), "Ridgid"));
    }

    @Override
    public Tool lookupToolByCode(String code) {
        return toolRepo.getOrDefault(code, null);
    }

    @Override
    public void addTool(Tool tool) {
        toolRepo.put(tool.getToolCode(), tool);
    }

    @Override
    public void updateTool(Tool tool) {
        if (toolRepo.containsKey(tool.getToolCode())) {
            toolRepo.put(tool.getToolCode(), tool);
        } else {
            throw new IllegalArgumentException("Tool not found for update: " + tool.getToolCode());
        }
    }

    @Override
    public void deleteTool(String code) {
        toolRepo.remove(code);
    }
}
