package utility;

import java.io.IOException;
import java.util.ArrayList;

public class DataProvider {

    public static ArrayList<String> getDataFromArrayList() throws IOException {
        return ParserTXT.txtParser();
    }

    @org.testng.annotations.DataProvider
    public static Object[][] accountsData() throws IOException {
        ArrayList<String> arrayList = getDataFromArrayList();
        return new Object[][]{
                {arrayList.get(0), arrayList.get(1)},
                {arrayList.get(2), arrayList.get(3)},
                {arrayList.get(4), arrayList.get(5)},
        };
    }
}
