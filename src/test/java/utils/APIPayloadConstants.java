package utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Shawn\",\n" +
                "  \"emp_lastname\": \"Beverly\",\n" +
                "  \"emp_middle_name\": \"S.\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1990-03-09\",\n" +
                "  \"emp_status\": \"active\",\n" +
                "  \"emp_job_title\": \"Lead\"\n" +
                "}";
        return createEmployeePayload;
    }

    public  static  String createEmployeePayloadJson(){

        JSONObject obj= new JSONObject();
        obj.put("emp_firstname","Shawn");
        obj.put("emp_lastname","Beverly");
        obj.put("emp_middle_name","S");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1990-03-09");
        obj.put("emp_status","active");
        obj.put("emp_job_title","Lead");

        return obj.toString();
    }


    public  static  String createEmployeePayloadJsonDynamic(String fname,String lname,String mname, String gender , String birthday, String status ,String jobTitle){

        JSONObject obj= new JSONObject();
        obj.put("emp_firstname",fname);
        obj.put("emp_lastname",lname);
        obj.put("emp_middle_name",mname);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",birthday);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);

        return obj.toString();
    }

}
