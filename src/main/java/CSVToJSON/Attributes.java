package CSVToJSON;

import java.util.ArrayList;
import java.util.List;

public class Attributes {

    private String code;
    private List<Labels> labels;
    private List<Options> options = new ArrayList<>();

    public List<Labels> getLabels() {
        return labels;
    }

    public void setLabels(List<Labels> labels) {
        this.labels = labels;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }
}
