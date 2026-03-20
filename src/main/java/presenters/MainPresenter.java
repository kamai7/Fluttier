package presenters;

import contracts.MainNavigatorContract;
import contracts.MainViewContract;
import utils.Colors;

public class MainPresenter {

    private final MainViewContract view;

    private final MainNavigatorContract nav;

    public MainPresenter(MainViewContract view, MainNavigatorContract nav) {
        if (view == null) {
            throw new IllegalArgumentException(Colors.red("la view est null"));
        }
        if (nav == null) {
            throw new IllegalArgumentException(Colors.red("le navigateur est null"));
        }
        this.view = view;
        this.nav = nav;
        nav.loadWorkspace();
        nav.loadSidebar();
        view.setStatusText("ready");
    }
    
}
