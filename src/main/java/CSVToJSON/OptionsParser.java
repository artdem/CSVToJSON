package CSVToJSON;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    private static final String CSV_FILE_PATH = "options.csv";

    public List<Options> optionsParser() throws IOException {

        List<Options> options = new ArrayList<Options>();

        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withDelimiter(';')
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())

        ){
            for (CSVRecord csvRecord : csvParser) {
                Options optionsObject = new Options();
                List<Labels> labels = new ArrayList<>();
                Labels labelsObject = new Labels();
                String code = csvRecord.get("code");
                String label_it_IT = csvRecord.get("label-it_IT");
                String label_en_GB = csvRecord.get("label-en_GB");
                String label_en_IE = csvRecord.get("label-en_IE");
                String label_pl_PL = csvRecord.get("label-pl_PL");
                String label_nl_NL = csvRecord.get("label-nl_NL");
                String label_nl_BE = csvRecord.get("label-nl_BE");
                String label_nb_NO = csvRecord.get("label-nb_NO");
                String label_fi_FI = csvRecord.get("label-fi_FI");
                String label_en_US = csvRecord.get("label-en_US");
                String label_es_ES = csvRecord.get("label-es_ES");
                String label_de_DE = csvRecord.get("label-de_DE");
                String label_de_CH = csvRecord.get("label-de_CH");
                String label_de_AT = csvRecord.get("label-de_AT");
                String label_da_DK = csvRecord.get("label-da_DK");
                String label_fr_FR = csvRecord.get("label-fr_FR");
                String label_sv_SE = csvRecord.get("label-sv_SE");
                String label_cs_CZ = csvRecord.get("label-cs_CZ");
                String attribute = csvRecord.get("attribute");
                String sort_order = csvRecord.get("sort_order");

                optionsObject.setCode(code);
                labelsObject.setLabel_it_IT(label_it_IT);
                labelsObject.setLabel_en_GB(label_en_GB);
                labelsObject.setLabel_en_IE(label_en_IE);
                labelsObject.setLabel_pl_PL(label_pl_PL);
                labelsObject.setLabel_nl_NL(label_nl_NL);
                labelsObject.setLabel_nl_BE(label_nl_BE);
                labelsObject.setLabel_nb_NO(label_nb_NO);
                labelsObject.setLabel_fi_FI(label_fi_FI);
                labelsObject.setLabel_en_US(label_en_US);
                labelsObject.setLabel_es_ES(label_es_ES);
                labelsObject.setLabel_de_DE(label_de_DE);
                labelsObject.setLabel_de_CH(label_de_CH);
                labelsObject.setLabel_de_AT(label_de_AT);
                labelsObject.setLabel_da_DK(label_da_DK);
                labelsObject.setLabel_fr_FR(label_fr_FR);
                labelsObject.setLabel_sv_SE(label_sv_SE);
                labelsObject.setLabel_cs_CZ(label_cs_CZ);
                labels.add(labelsObject);
                optionsObject.setLabels(labels);
                optionsObject.setAttribute(attribute);
                optionsObject.setSort_order(Integer.parseInt(sort_order));
                options.add(optionsObject);
            }
        }
        return options;
    }
}
