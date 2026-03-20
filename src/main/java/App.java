import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presenters.MainPresenter;
import view.MainView;
import view.navigator.MainNavigator;
import view.references.Fxml;

public class App extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL mainUrl = getClass().getResource(Fxml.MAIN);
        FXMLLoader loader = new FXMLLoader(mainUrl);
        
        Scene scene = new Scene(loader.load(), 1200,720);
        scene.getStylesheets().add("/styles/style.css");
        scene.getStylesheets().add("/styles/fragment.css");
        Font.loadFont(getClass().getResourceAsStream("/fonts/JetBrainsMono.ttf"), 12);
        stage.setScene(scene);
        stage.getIcons().add(new Image("/img/logo.png"));
        stage.show();

        MainView view = loader.getController();
        MainNavigator nav = new MainNavigator(view);
        MainPresenter presenter = new MainPresenter(view, nav);
        view.setPresenter(presenter);
    }
    
}