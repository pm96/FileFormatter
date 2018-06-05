import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileFormatter extends Application{


  public static void main(String args[]){
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Choose file to reformat");
    FileChooser fc = new FileChooser();
    fc.getExtensionFilters().addAll(
        new ExtensionFilter("Text Files", "*.txt", "*.odt", "*.rtf", "*.rtf", "*.tex", "*.doc", "*.docx")
    );
    File file = fc.showOpenDialog(primaryStage);
      if(file != null){
          file.getAbsolutePath();
          String line;
          BufferedWriter out;

          try {
              FileReader fr = new FileReader(file);
              BufferedReader br = new BufferedReader(fr);
              out = new BufferedWriter(new FileWriter("out.txt", true));

              while ((line = br.readLine()) != null) {
                out.append(line);
                System.out.print(line);
                System.out.print(", ");
                out.append(", ");
              }
          }catch (FileNotFoundException ex){
            System.out.println("Could not find the file: " + file);
          }catch(IOException e){
            System.out.println("error reading the file");
            e.printStackTrace();
          }
      }
    }
}

