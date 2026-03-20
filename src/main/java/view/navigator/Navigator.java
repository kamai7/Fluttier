package view.navigator;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import utils.Colors;

public abstract class Navigator<View> {

    protected final View view;
    


    public Navigator(View view){
        if (view == null){
            throw new IllegalArgumentException(Colors.red("la view est null"));
        }
        this.view = view;
    }

    public FXMLLoader getLoader(String path){
        URL mainUrl = getClass().getResource(path);
        return new FXMLLoader(mainUrl);
    }
}
