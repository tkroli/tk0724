package main.java.com.rentalproject.rental.repository;

import main.java.com.rentalproject.rental.model.Tool;

public interface ToolRepository {
    Tool lookupToolByCode(String code);
    void addTool(Tool tool);
    void updateTool(Tool tool);
    void deleteTool(String code);
}
