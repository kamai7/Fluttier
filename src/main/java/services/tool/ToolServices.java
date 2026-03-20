package services.tool;

import model.tools.Tool;

public class ToolServices {
    
    private final Tool<?> tool;

    public ToolServices(Tool<?> model){
        this.tool = model;
    }

    public Tool<?> getToolUseCase(){
        return tool;
    }
}
