package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    @FXML
    Button bt_start;

    @FXML
    Button bt_stop;

    @FXML
    TextField tf_time;
    private int time;



   public void startTask(){
       String Text = tf_time.getText();
       try {
           time = Integer.valueOf(Text);
       } catch (NumberFormatException e) {
           e.printStackTrace();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("NickWinTool");
           alert.setHeaderText("不忘初心");
           alert.setContentText("类型错误! 只能输入数字!");
           alert.show();
       }


       shutdown(Integer.valueOf( tf_time.getText()));

       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("NickWinTool");
       alert.setHeaderText("不忘初心");
       alert.setContentText("任务已经开始!");
       alert.show();
   }

   public void stopTask(){
       cancel();
       Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
       alert1.setTitle("NickWinTool");
       alert1.setHeaderText("不忘初心");
       alert1.setContentText("任务已经停止!");
       alert1.show();
   }

   public void shutdown(int time) {
       Runtime rt = Runtime.getRuntime();

       try {
           rt.exec("shutdown.exe -s -t "+time*60);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void cancel(){
       Runtime rt = Runtime.getRuntime();

       try {
           rt.exec("shutdown.exe -a");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
