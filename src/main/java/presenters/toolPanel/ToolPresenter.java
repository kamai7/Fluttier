package presenters.toolPanel;

import contracts.toolPanel.ToolViewContract;
import model.tools.Tool;
import services.tool.ToolServices;
import services.tool.ToolSetServices;
import utils.listener.Observer;

public class ToolPresenter {

    private final ToolViewContract view;
    private final ToolServices services;
    private final ToolSetServices toolSetServices;

    public ToolPresenter(ToolViewContract view, ToolSetServices toolSetServices, ToolServices services){
        this.view = view;
        this.services = services;
        this.toolSetServices = toolSetServices;
        
        view.setName(services.getToolUseCase().getName());
        view.setIcon(services.getToolUseCase().getIcon());

        toolSetServices.addToolListener(new Observer<Tool<?>>() {

            @Override
            public void onChange(Tool<?> t) {
                if (t != services.getToolUseCase()){
                    view.setUnselected();
                } else {
                    view.setSelected();
                }
            }
        });
    }

    public void onMouseClicked(){
        toolSetServices.changeToolUseCase(services.getToolUseCase());
        view.setSelected();
    }
    
}
