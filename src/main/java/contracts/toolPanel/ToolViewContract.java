package contracts.toolPanel;

import presenters.toolPanel.ToolPresenter;
import references.Icons;

public interface ToolViewContract {

    public void setPresenter(ToolPresenter presenter);

    public void setName(String name);

    public void setIcon(Icons icon);

    public void setSelected();

    public void setUnselected();
}
