
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorObject {
    private String type;
    private String time;
    private String task;
    private String line_number;
    private String module_status;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getLine_number() {
        return line_number;
    }

    public void setLine_number(String line_number) {
        this.line_number = line_number;
    }

    public String getModule_status() {
        return module_status;
    }

    public void setModule_status(String module_status) {
        this.module_status = module_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
