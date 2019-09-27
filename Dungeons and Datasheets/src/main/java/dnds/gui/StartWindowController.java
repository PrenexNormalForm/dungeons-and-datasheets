package dnds.gui;

import java.io.IOException;
import javafx.fxml.FXML;


public class StartWindowController extends Controller {
    @FXML
    private void serverLaunchHelper() throws IOException{
        super.load(Constants.SERVER_WINDOW);
    }
    @FXML
    private void localLaunchHelper() throws IOException{
        super.load(Constants.START_WINDOW);
    }
    @FXML
    private void openSettingsHelper() throws IOException{
        super.load(Constants.SETTINGS_WINDOW);
    }

    
}
