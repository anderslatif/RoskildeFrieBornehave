import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Controller {

    public static ObservableList<Child> getObservableList(){
        List<Child> children = new ArrayList<>();
        ObservableList<Child> observableChildren = FXCollections.observableList(children);

        Child child1 = new Child(
                "Per Jensen", "Bjørnestuen", "1203483034", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child child2 = new Child(
                "Anna Mortensen", "Bjørnestuen", "6247262333", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child child3 = new Child(
                "Craig Larman", "Løvestuen", "3445237238", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child child4 = new Child(
                "David Ema", "Tigerstuen", "2043845784", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child child5 = new Child(
                "Per Venter", "Venteliste", "6676798988", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child child6 = new Child(
                "Joaquin Greven", "Venteliste", "3465465465", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");


        children.add(child1);
        children.add(child2);
        children.add(child3);
        children.add(child4);
        children.add(child5);
        children.add(child6);

        Child perJ = new Child(
                "Per Jensen", "Løvestuen", "1611121342", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child janI = new Child(
                "Per Ibdensen", "Løvestuen", "1312741344", "Pia Ibdensen", 23453412, 97858745, "Mervej 254", "Povl Ibdensen", 12436434, 25455345, "Mervej 254");

        Child peterJ = new Child(
                "Peter Jensen", "Venteliste", "1904938843", "Anna Jensen", 45712893, 23872376, "Langgade 14", "Hans Jensen", 45872309, 56473748, "Langgade 14");

        Child annaI = new Child(
                "Anna Igor", "Bjørnestuen", "2308855839", "Ptra Igor", 34547365, 23436544, "Joevej 23", "Boris Igor", 64346576, 75452312, "Joevej 23");

        Child hansM = new Child(
                "Jonna Mortensen", "Venteliste", "1412934253", "Mille Mortensen", 65983469, 34696598, "Sersagade 1", "Hans Mortensen", 34653423, 34234332, "Sersagade 1");

        Child mikkelH = new Child(
                "Mikkel Hansen", "Bjørnestuen", "2502966345", "Anna Hansen", 57483940, 35251341, "Korkstræde 24", "Karl Hansen", 24548798, 24344343, "Korkstræde 24");

        Child frankK = new Child(
                "Frank Karendatter", "Løvestuen", "2305967623", "Signe Karendatter", 23432323, 87695345, "Nejevej 53", "Hanne Karendatter", 52546576, 24536587, "Nejevej 53");

        Child dohaW = new Child(
                "Doha Wakeem", "Tigerstuen", "1608962454", "Fatima Wakeem", 76568767, 47756565, "Adegade 166", "Achmed Wakeem", 24546576, 45567634, "Adegade 166");

        Child alonzoL = new Child(
                "Alonzo Leopas", "Venteliste", "3105966434", "Christina Leopas", 45454545, 76765656, "Fernvej 24333", "Vincent Leopas", 63636363, 54545445, "Fernvej 24333");

        Child mikhailB = new Child(
                "Mikhail Barstovski", "Tigerstuen", "0704962353", "Anna Barstovski", 11435476, 12345678, "Hovedvej 253", "Demitri Barstovski", 46768798, 24456587, "Hovedvej 253");

        Child karlL = new Child(
                "Karl Larsen", "Bjørnestuen", "0307966545", "Iben Larsen", 32432554, 14455667, "Densestræde 1", "Lars Larsen", 56474653, 42357586, "Densestræde 1");

        Child nikolinaB = new Child(
                "Nikolina Bendtsen", "Løvestuen", "1508961232", "Gerda Bendtsen", 12454323, 65413877, "Asseaway 2", "Nicklas Bendtsen", 14351455, 25256464, "Asseaway 2");

        Child ettaK = new Child(
                "Etta Karlsen", "Bjørnestuen", "2606969767", "Amanda Karlsen", 35455424, 54341323, "Gradevej 53", "Georg Karlsen", 85648568, 46254658, "Gradevej 53");

        Child hansH = new Child(
                "Hans Hansen", "Tigerstuen", "0209965887", "Linda Hansen", 25535445, 24343223, "Erkkevej 24", "Hans Hansen", 35535757, 53352424, "Erkkevej 24");

        Child patrickG = new Child(
                "Patrick Granhoff", "Venteliste", "1512967867", "Olga Granhoff", 98989898, 00000666, "Serssagade 345", "Per-Emil Granhoff", 46464646, 88888888,"Serssagade 345");

        Child franP = new Child(
                "Fran Potterdam", "Bjørnestuen", "1211964565", "Vera Potterdam", 45347676, 12425644, "Ereggade 234", "Damian Potterdam", 56565656, 34343412, "Ereggade 234");

        Child gertH = new Child(
                "Gert Hattian", "Løvestuen", "1802966556", "Gerd Hattian", 36243434, 65762433, "Petergade 52", "Jan Hattian", 39097878, 46565444, "Petergade 52");

        Child mieG = new Child(
                "Mie Greve", "Tigerstuen", "2901964323", "Naja Greve", 25535555, 34545445, "Fårkerdevej 666", "Joaqhim Greve", 56454534, 24422424, "Fårkerdevej 666");

        Child patriciaH = new Child(
                "Patricia Harkenberg", "Venteliste", "0310961265", "Stefan Harkenberg", 35353535, 65677634, "Gågade 111", "Mark Harkenberg", 75757575, 87778886, "Gågade 111");

        Child zimaD = new Child(
                "Zima Dormakun", "Venteliste", "3112961122", "Oka Dormakun", 63656778, 24356789, "Allegade 4", "Mokka Dormakun", 46976880, 68785765, "Allegade 4");



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