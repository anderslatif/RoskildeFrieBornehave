import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Controller {

    public static ObservableList<Child> getObservableList(){
        List<Child> children = new ArrayList<>();
        ObservableList<Child> observableChildren = FXCollections.observableList(children);

        Child perJ = new Child(
                "Per Jensen", "Løvestuen", "1611121342", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child JanI = new Child(
                "Per Ibdensen", "Løvestuen", "1312741344", "Pia Ibdensen", 23453412, 97858745, "Mervej 254", "Povl Ibdensen", 12436434, 25455345, "Mervej 254");

        Child peterJ = new Child(
                "Peter Jensen", "Venteliste", "1904938843", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child annaI = new Child(
                "Anna Igor", "Bjørnestuen", "2308855839", "Ptra Igor", 34547365, 23436544, "Joevej 23", "Boris Igor", 64346576, 75452312, "Joevej 23");

        Child hansM = new Child(
                "Jonna Mortensen", "Venteliste", "1412934253", "Mille Mortensen", 65983469, 34696598, "Sersagade 1", "Hans Mortensen", 34653423, 00433781, "Sersagade 1");

        Child mikkelH = new Child(
                "Mikkel Hansen", "Bjørnestuen", "25 02 96 6345", "Anna Hansen", 57483940, 35251341, "Korkstræde 24", "Karl Hansen", 24548798, 24344343, "Korkstræde 24");

        Child frankK = new Child(
                "Frank Karendatter", "Løvestuen", "23 05 96 7623", "Signe Karendatter", 23432323, 87695345, "Nejevej 53", "Hanne Karendatter", 52546576, 24536587, "Nejevej 53");

        Child dohaW = new Child(
                "Doha Wakeem", "Tigerstuen", "16 08 96 2454", "Fatima Wakeem", 76568767, 47756565, "Adegade 166", "Achmed Wakeem", 24546576, 45567634, "Adegade 166");

        Child alonzoL = new Child(
                "Alonzo Leopas", "Venteliste", "35 05 96 6434", "Christina Leopas", 45454545, 76765656, "Fernvej 24333", "Vincent Leopas", 63636363, 54545445, "Fernvej 24333");

        Child mikhailB = new Child(
                "Mikhail Barstovski", "Tigerstuen", "07 04 96 2353", "Anna Barstovski", 11435476, 12345678, "Hovedvej 253", "Demitri Barstovski", 46768798, 24456587, "Hovedvej 253");

        Child karlL = new Child(
                "Karl Larsen", "Bjørnestuen", "03 07 96 6545", "Iben Larsen", 32432554, 14455667, "Densestræde 1", "Lars Larsen", 56474653, 42357586, "Densestræde 1");

        Child nikolinaB = new Child(
                "Nikolina Bendtsen", "Løvestuen", "15 08 96 1232", "Gerda Bendtsen", 12454323, 65413877, "Asseaway 2", "Nicklas Bendtsen", 14351455, 25256464, "Asseaway 2");

        Child ettaK = new Child(
                "Etta Karlsen", "Bjørnestuen", "26 06 96 9767", "Amanda Karlsen", 35455424, 54341323, "Gradevej 53", "Georg Karlsen", 85648568, 46254658, "Gradevej 53");

        Child hansH = new Child(
                "Hans Hansen", "Tigerstuen", "02 09 96 5887", "Linda Hansen", 25535445, 24343223, "Erkkevej 24", "Hans Hansen", 35535757, 53352424, "Erkkevej 24");

        Child patrickG = new Child(
                "Patrick Granhoff", "Venteliste", "15 12 96 7867", "Olga Granhoff", 98989898, 00000666, "Serssagade 345", "Per-Emil Granhoff", 46464646, 88888888,"Serssagade 345");

        Child franP = new Child(
                "Fran Potterdam", "Bjørnestuen", "12 11 96 4565", "Vera Potterdam", 45347676, 12425644, "Ereggade 234", "Damian Potterdam", 56565656, 34343412, "Ereggade 234");

        Child gertH = new Child(
                "Gert Hattian", "Løvestuen", "18 02 96 6556", "Gerd Hattian", 36243434, 65762433, "Petergade 52", "Jan Hattian", 09097878, 46565444, "Petergade 52");

        Child mieG = new Child(
                "Mie Greve", "Tigerstuen", "29 01 96 4323", "Naja Greve", 25535555, 34545445, "Fårkerdevej 666", "Joaqhim Greve", 56454534, 24422424, "Fårkerdevej 666");

        Child patriciaH = new Child(
                "Patricia Harkenberg", "Venteliste", "03 10 96 1265", "Stefan Harkenberg", 35353535, 65677634, "Gågade 111", "Mark Harkenberg", 75757575, 87778886, "Gågade 111");

        Child zimaD = new Child(
                "Zima Dormakun", "Venteliste", "31 12 96 1122", "Oka Dormakun", 63656778, 24356789, "Allegade 4", "Mokka Dormakun", 46976880, 68785765, "Allegade 4");



        children.add(perJ);
        children.add(janI);
        children.add(peterJ);
        children.add(annaI);
        children.add(hansM);
        children.add(mikkelH);
        children.add(frankK);
        children.add(dohaW);
        children.add(alonzoL);
        children.add(mikhailB);
        children.add(karlL);
        children.add(nikolinaB);
        children.add(ettaK);
        children.add(hansH);
        children.add(patrickG);
        children.add(franP);
        children.add(gertH);
        children.add(mieG);
        children.add(patriciaH);
        children.add(zimaD);

        return observableChildren;
    }
}