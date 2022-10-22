public class Main {
    public static void main(String[] args) {
        Car lada = new Car("", "", 0, "", 0, "");
        System.out.println(lada);
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, " черный", 2020, "Германии");
        System.out.println(audi);
        Car bmv = new Car("BMW", "Z8", 3.0, "черный", 2021, "Германии");
        System.out.println(bmv);
        Car kia = new Car("Kia", "Sportage 4-го поколения",  2.4, " красный", 2018, "Южной Корее");
        System.out.println(kia);
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южной Корее");
        System.out.println(hyundai);

    }
}