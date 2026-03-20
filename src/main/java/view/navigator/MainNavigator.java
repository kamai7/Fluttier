package view.navigator;

import java.io.IOException;

import contracts.MainNavigatorContract;
import contracts.toolPanel.ToolPanelNavigatorContract;
import javafx.fxml.FXMLLoader;
import model.Workspace;
import presenters.toolPanel.ToolPanelPresenter;
import presenters.workspace.WorkspacePresenter;
import services.WorkspaceServices;
import services.tool.ToolSetServices;
import view.MainView;
import view.references.Fxml;
import view.toolPanel.ToolPanelView;
import view.toolPanel.navigator.ToolPanelNavigator;
import view.workspace.WorkspaceView;
import view.workspace.navigator.WorkspaceNavigator;

public class MainNavigator extends Navigator<MainView> implements MainNavigatorContract {

    protected Workspace worksapce;
    protected WorkspaceServices worksapceServices;
    protected ToolSetServices toolSetServices;

    public MainNavigator(MainView view){
        super(view);
        this.worksapce = new Workspace();
        this.worksapceServices = new WorkspaceServices(worksapce);
        this.toolSetServices = new ToolSetServices(worksapce);
    }

    @Override
    public void loadWorkspace(){
        try{
            FXMLLoader loader = getLoader(Fxml.WORKSPACE);
            view.setWorkspaceContent(loader.load());
            WorkspaceView newView = loader.getController();
            WorkspaceNavigator nav = new WorkspaceNavigator(newView);
            WorkspacePresenter presenter = new WorkspacePresenter(newView, nav, worksapceServices, toolSetServices);
            newView.setPresenter(presenter);
            newView.initKeyListeners();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadSidebar() {
        try{
            FXMLLoader loader = getLoader(Fxml.TOOLPANEL);
            view.setSidebarContent(loader.load());
            ToolPanelView newView = loader.getController();
            ToolPanelNavigatorContract navigator = new ToolPanelNavigator(newView);
            ToolPanelPresenter presenter = new ToolPanelPresenter(newView, navigator, toolSetServices);
            newView.setPresenter(presenter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
