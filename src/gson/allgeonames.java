package gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Lars on 07.07.2015.
 */
public class allgeonames {

    public geonames[] geonames;

    public allgeonames(){
    }

    public void test(){
        for (gson.geonames geo : geonames){
            System.out.println(geo.name);
        }
    }

    public void sortDat(){

    }


    public static void main(String[] args) throws IOException {
        StringBuilder content = new StringBuilder();
        URL url =
                new URL("http://www.iai.kit.edu/~javavorlesung/dhbw/2013-14/cities.json");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openConnection(). getInputStream()));
        while (br.ready())
            content.append(br.readLine()). append(System.lineSeparator());
        br.close();
        Gson gson = new Gson();
        allgeonames results = gson.fromJson(content.toString(),allgeonames.class);
        System.out.println(content);
        results.test();
    }
}
