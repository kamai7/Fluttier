package contracts;

import presenters.MainPresenter;

public interface MainViewContract {

    public void setPresenter(MainPresenter presenter);
    
    public void setStatusText(String text);

    public void setLogInfo(String message);

    public void setLogWarning(String message);

    public void setLogError(String message);
}
