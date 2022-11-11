import transport.Car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car lada = new Car("Лада",
                "Гранта",
                1.7,
                "жёлтый",
                2015,
                "Россия");
        lada.setTransmission("автомат");
        lada.setRegistrationNumber("а333мм123");
        System.out.println(lada.writeRegistrationNumberValid());
        lada.setKey(new Car.Key(true, true));
        lada.setInsurance(new Car.Insurance(LocalDate.now(), 20000, "987654321"));
        lada.getInsurance().calculateTerm();
        lada.getInsurance().checkNumber();
        Car audi = new Car("Audi",
                "A8 50 L TDI quattro",
                3.0,
                " черный",
                2020,
                "Германии");


        Car bmv = new Car("BMW",
                "Z8",
                3.0,
                "черный",
                2021,
                "Германии");

        Car kia = new Car("Kia",
                "Sportage 4-го поколения",
                2.4,
                " красный",
                2018,
                "Южной Корее");

        Car hyundai = new Car("Hyundai",
                "Avante",
                1.6,
                "оранжевый",
                2016,
                "Южной Корее");

        printInfo(lada);
        printInfo(audi);
        printInfo(bmv);
        printInfo(kia);
        printInfo(hyundai);
    }
    private static void printInfo(Car car){
        System.out.println("Автомобиль " + car.getBrand()+ " "+car.getModel()+ ", " +
                "сборка - "+car.getProductionCountry()+" ," +
                " цвет — "+car.getColor()+"," +
                " объем двигателя - "+car.getEngineVolume()+" л," +
                " год выпуска — "+car.getProductionYear()+" ,"+
                "коробка передач- " +car.getTransmission()+" ,"+
                "тип кузова- " +car.getBodyType()+" ,"+
                "рег.номер- " +car.getRegistrationNumber()+" ,"+
                "кол-во мест- " +car.getNumberSeats()+" ,"
                 +(car.verifyWinterRubber() ? "зимняя " : "летняя ") + "резина ,"
                 +(car.getKey().isRemoteEngineStart() ? "безключевой " : "с ключём ") + "доступ ,"
                 +(car.getKey().isKeylessEntry() ? "удалённый " : "обычный ") + "запуск , "
                +"номер страховки: "+car.getInsurance().getNumber()+
                ", стоимость страховки: "+car.getInsurance().getPrice()+
                ", срок страховки: "+car.getInsurance().getTerm()
        );
    }


}