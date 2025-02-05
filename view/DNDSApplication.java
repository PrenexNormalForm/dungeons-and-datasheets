package view;
/*
Last updated 9/27/2019

java.application.Application child for javafx. Initializes and starts the GUI.

Contributors:
Jonathan Bacon
Eva Moniz
 */

import controller.JFXViewConnector;
import model.utilities.Resources;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The {@code Application} class that controls the view.
 *
 */
public class DNDSApplication extends Application {

    //The minimum bounds for the window
    private static final int MIN_WINDOW_HEIGHT = 400;
    private static final int MIN_WINDOW_WIDTH = 500;

    /**
     * The root node of the entire view
     */
    private Parent root;
    /**
     * The main application window
     */
    private Stage stage;
    /**
     * The title of the application
     */
    private final String title = "Dungeons & DataSheets";

    private static JFXViewConnector viewConnector;
    private static Stage primaryStage;

    /**
     * Starts the application, and the logic thread.
     *
     * @param _primaryStage the application window
     */
    @Override
    public void start(Stage _primaryStage) {
        DNDSApplication.primaryStage = _primaryStage;

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Resources.getFxmlUrl(Constants.START_WINDOW));
            this.root = loader.load();

            DNDSApplication.setViewConnector(new JFXViewConnector(loader.getController()));

            this.stage = _primaryStage;
            this.stage.setTitle(title);
            this.stage.setMinHeight(DNDSApplication.MIN_WINDOW_HEIGHT);
            this.stage.setMinWidth(DNDSApplication.MIN_WINDOW_WIDTH);

            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.setOnCloseRequest(e -> Platform.exit());
            this.stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static JFXViewConnector getViewConnector() {
        return DNDSApplication.viewConnector;
    }

    private static void setViewConnector(JFXViewConnector _viewConnector) {
        DNDSApplication.viewConnector = _viewConnector;
        controller.Controller.setViewConnector(_viewConnector);
    }

    protected static Stage getPrimaryStage() {
        return DNDSApplication.primaryStage;
    }
}
