package uz.b.application.config.logger;

import com.google.gson.Gson;

public class Logger {


    private static final Gson gson = new Gson();


    public static void error(Exception e) {
        System.out.println("ERROR ========== ".concat(e.getMessage()));
    }

    public static void req(Object objects) {
        try {
            System.out.println("REQ >>>>".concat(gson.toJson(objects)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void res(Object objects){
        try {
            System.out.println("RES <<<<".concat(gson.toJson(objects)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}