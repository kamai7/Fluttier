package contracts.workspace;

import presenters.workspace.SelectionPresenter;

public interface SelectionViewContract {

    public void setDimens(double w, double h);

    public void setPos(double x, double Y);

    public void setPresenter(SelectionPresenter presenter);
    
}
