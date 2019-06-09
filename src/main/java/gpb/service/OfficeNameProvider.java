package gpb.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OfficeNameProvider {
    private List<String> offices;
    private String officesFileName;

    public OfficeNameProvider(String officesFileName) {
        this.officesFileName = officesFileName;
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
        if (offices == null) {
            try {
                getOffices(officesFileName);
            } catch (FileNotFoundException e) {
                offices = null;
                System.out.println("Can't read officesFileName");
            }
        }
        if (offices == null) {
            return null;
        }
        Random r = new Random();
        return offices.get(r.ints(0, offices.size()).findFirst().getAsInt());
    }
}
