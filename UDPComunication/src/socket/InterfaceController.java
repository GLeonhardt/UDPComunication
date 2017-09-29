package socket;




import java.io.IOException;
import java.net.SocketException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class InterfaceController {

    @FXML
    private Button serverButton;

    @FXML
    private TextArea mensagemTxtField;

    @FXML
    private Label endereco;

    @FXML
    private Label porta;

    @FXML
    private TextField enderecoText;

    @FXML
    private TextField portaText;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea logText;
    
    @FXML
    private Label serverLabel;
    
    @FXML
    void SendButtonAction(ActionEvent event) throws IOException {
        log("Sending message to "+enderecoText.getText()+" on "+portaText.getText());
        
        Sender sendMsg = new Sender();
        sendMsg.send(mensagemTxtField.getText(), enderecoText.getText(), portaText.getText());
        
        mensagemTxtField.setText("");
    }

    @FXML
    void serverButtonAction(ActionEvent event) throws SocketException {
      if(portaText.getText().length()==0){
           logText.appendText("Insert a valid UDPport \n");
        }else{
            serverButton.setDisable(true);
            serverLabel.setText("Server Online on port: "+ portaText.getText());
            serverLabel.setVisible(true);
            Server server = new Server(portaText.getText());
            server.start();
        }
    }

    public void log(String msg){
        Platform.runLater(new Runnable(){
            @Override public void run(){
                logText.appendText("[LOG] "+msg+"\n");
            }
        });
        
    }
}
