package com.example.demo;

import javafx.css.converter.ColorConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class HelloController {
    @FXML
    private TextArea txtinput;
    @FXML
    private TextArea txtoutput;
    ArrayList<Color> colors = new ArrayList<>();

    public HelloController()
    {
        Random rand = new Random();
        for (int i=0;i<20;i++)
        {
            Color C = Color.rgb(rand.nextInt(0,255),rand.nextInt(0,255),rand.nextInt(0,255));
            colors.add(C);
        }
    }

    int index =0;

    public void onGenerateClick(ActionEvent event)
    {
        String input = txtinput.getText();
       StringBuilder build = out(input);
       txtoutput.setText(build.toString());

//        if (i.endsWith("\u200f"))
//        {
//
//        }

    }

    private StringBuilder out(String input)
    {
        String[] split = input.trim().split("\\s+");

        StringBuilder build = new StringBuilder();
        try {


            for (int i = 0; i <= split.length; i++) {
                if (split[i].equals("<Text") && split[i + 1].startsWith("fx:id")) {
                    build.append("@FXML\nprivate Text "+split[i+1].substring(7,split[i+1].length()-1)+";\n");
                }
               else if (split[i].equals("<TextField") && split[i + 1].startsWith("fx:id")) {
                    build.append("@FXML\nprivate TextField "+split[i+1].substring(7,split[i+1].length()-1)+";\n");
                }
               else if (split[i].equals("<Button") && split[i + 1].startsWith("fx:id")) {
                    build.append("@FXML\nprivate Button "+split[i+1].substring(7,split[i+1].length()-1)+";\n");
                }
               else if (split[i].equals("<TableColumn")&& split[i + 1].startsWith("fx:id"))
               {
                   build.append("@FXML\n private TableColumn<scheduleRow,String> "+split[i+1].substring(7,split[i+1].length()-1)+";\n");

                }
                else if (split[i].equals("<TableView")&& split[i + 1].startsWith("fx:id"))
                {
                    build.append("@FXML\n private TableView<scheduleRow> "+split[i+1].substring(7,split[i+1].length()-1)+";\n");

                }
                else if (split[i].equals("<PasswordField")&& split[i + 1].startsWith("fx:id"))
                {
                    build.append("@FXML\n private PasswordField "+split[i+1].substring(7,split[i+1].length()-1)+";\n");

                }
                else if (split[i].equals("<ChoiceBox")&& split[i + 1].startsWith("fx:id"))
                {
                    build.append("@FXML\n private ChoiceBox "+split[i+1].substring(7,split[i+1].length()-1)+";\n");

                }
                else if (split[i].equals("<DatePicker")&& split[i + 1].startsWith("fx:id"))
                {
                    build.append("@FXML\n private DatePicker "+split[i+1].substring(7,split[i+1].length()-1)+";\n");

                }

            }
        }
        catch (RuntimeException e)
        {

        }
        try {
            for (int i=0;i<split.length;i++) {
                if (split[i].startsWith("onAction")) {
                    build.append("public void " + split[i].substring(11, split[i].length() - 1) + "(ActionEvent event){}\n");

                }
            }

        }
        catch (RuntimeException e)
        {

        }

        return build;
    }

    public void onRandomClick(ActionEvent event)
    {
            Random rand = new Random();

            txtinput.setStyle("-fx-background-color:" );
    }
}