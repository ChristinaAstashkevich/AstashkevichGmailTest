package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserTXT {

    public static ArrayList<String> txtParser() throws IOException {

        String txtAccount = ".\\src\\main\\resources\\accounts.txt";
        BufferedReader br = new BufferedReader(new FileReader(txtAccount));
        String line = null;
        ArrayList<String> arrayList = new ArrayList<String>();

        while ((line = br.readLine()) != null) {
            String[] str = line.split("/");
            arrayList.add(str[0]);
            arrayList.add(str[1]);
            str = null;
        }
        return arrayList;
    }
}


