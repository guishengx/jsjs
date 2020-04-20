import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JsonMappingException {
        String filePath = "C:\\Users\\neo\\Bot_log_01.txt";
        File file = new File(filePath);

        List <ErrorObject> errorObjects = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while((str = bufferedReader.readLine())!= null) {
            String line = str.trim();
            if (line.startsWith("******") && line.endsWith("******")) {
                System.out.println(">>"+str);

                String errorType = "";
                String errorTime = "";
                String errorTask = "";
                String lineNumber = "";
                String errorDesc = "";
                String moduleStatus = "";

                ErrorObject errObj = new ErrorObject();

                line = line.replace("******", "");
                String[] parts = line.split(";");

                for (String part: parts) {
                    System.out.println(" |:"+part);

                    if (part.contains("=")) {
                        String[] kv = part.split("=");
                        if (kv != null && kv.length > 1) {
                            String k = kv[0];
                            String v = kv[1];
                            if (!k.isEmpty() && !v.isEmpty()) {
                                if (k.equalsIgnoreCase("Error Type")) {
                                    errorType = v;
                                }
                                if (k.equalsIgnoreCase("Error Time")) {
                                    errorTime = v;
                                }
                                if (k.equalsIgnoreCase("Error Task")) {
                                    errorTask = v;
                                }
                                if (k.equalsIgnoreCase("Line Number")) {
                                    lineNumber = v;
                                }
                                if (k.equalsIgnoreCase("Error Description")) {
                                    errorDesc = v;
                                }
                                if (k.equalsIgnoreCase("Module Status")) {
                                    moduleStatus = v;
                                }
                            }
                        }
                    }
                }
                errObj.setType(errorType);
                errObj.setTime(errorTime);
                errObj.setTask(errorTask);
                errObj.setLine_number(lineNumber);
                errObj.setDescription(errorDesc);
                errObj.setModule_status(moduleStatus);
                errorObjects.add(errObj);
                System.out.println("Hello World!: " + errorObjects);
            } else {
                System.out.println(str);
            }

        }
        //最后不要忘记关流
//        try {
//            mapper.writeValueAsString(errorObjects);
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        }
        mapper.writeValue(new FileWriter("C:\\Users\\neo\\b.txt"), errorObjects);

        System.out.println("Hello World!");
    }
}
