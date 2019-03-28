package CSVToJSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        AttributesParser attributesParser = new AttributesParser();
        OptionsParser optionsParser = new OptionsParser();

        ObjectMapper obj = new ObjectMapper();
        obj.writerWithDefaultPrettyPrinter().writeValue(new File("attributes.json"), attributesParser.attributesParser());
        obj.writerWithDefaultPrettyPrinter().writeValue(new File("options.json"),  optionsParser.optionsParser());

        Thread.sleep(5000);

        List<Attributes> attributesList = attributesParser.attributesParser();
        List<Options> optionsList = optionsParser.optionsParser();
        List<Attributes> completeList = new ArrayList<>();

        for (Attributes attributes : attributesList){
            String commonCode = attributes.getCode();
            for(Options options : optionsList){
                if (options.getAttribute().equals(commonCode)){
                    attributes.getOptions().add(options);
                }
            }
        }

        obj.writerWithDefaultPrettyPrinter().writeValue(new File("complete.json"), attributesList);

        System.out.println("Done!");
    }
}


