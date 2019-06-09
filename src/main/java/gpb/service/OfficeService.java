package gpb.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OfficeService {
    private List<String> offices;

    public OfficeService(String officesFileName) throws FileNotFoundException {
        getOffices(officesFileName);
    }
    private void getOffices(String officesFileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(officesFileName));
        offices = new ArrayList<>();
        while (s.hasNextLine()){
            offices.add(s.nextLine());
        }
        s.close();
    }

    public String getRandomOffice() {
        Random r = new Random();
        return offices.get(r.ints(0, offices.size()).findFirst().getAsInt());
    }
}
