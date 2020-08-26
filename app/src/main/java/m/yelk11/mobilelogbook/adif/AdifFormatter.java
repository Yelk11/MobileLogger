package m.yelk11.mobilelogbook.adif;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class AdifFormatter {

    private String outputString;

    public AdifFormatter(String string){

        tokenizer(string);

    }


    private void tokenizer(@NotNull String str){
        List<String> stringList = Arrays.asList(str.split("(?=<)"));



        formatter(stringList);
    }

    private void formatter(@NotNull List<String> stringList){
        String output = "";
        for(int x = 0;stringList.size() > x; x++){
            output = output.concat(stringList.get(x) + "\n");
        }

        outputString = output;
    }


    public String getFormattedString(){
        return outputString;
    }
}
