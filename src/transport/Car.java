package transport;

import java.security.Key;
import java.time.LocalDate;

public class Car {
    private final String brand;
    private final String model;
    private double engineVolume; //обьём двигателя
    private String color; //цвет кузова
    private final int productionYear; //год производства
    private final String productionCountry; // страна сборки
    private String transmission;//коробка передач
    private final String bodyType;// тип кузова
    private String registrationNumber;//рег.номер
    private final int numberSeats;//кол-во мест
    private boolean winterRubber; // резина
    private Key key;
    private Insurance insurance;

    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               int productionYear,
               String productionCountry,
               String transmission,
               String bodyType,
               String registrationNumber,
               int numberSeats,
               boolean winterRubber,
               Key key,
               Insurance insurance) {
        if (brand == null || brand.isEmpty()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (color == null || color.isEmpty()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
        if (productionYear <= 0) {
            this.productionYear = 2000;
        } else {
            this.productionYear = productionYear;
        }
        if (productionCountry == null || productionCountry.isEmpty()) {
            this.productionCountry = "default";
        } else {
            this.productionCountry = productionCountry;
        }
        if (transmission == null) {
            this.transmission = "механика";
        } else {
            this.transmission = transmission;
        }
        if (bodyType == null) {
            this.bodyType = "седан";
        } else {
            this.bodyType = bodyType;
        }
        if (registrationNumber == null) {
            this.registrationNumber = "х000хх000";
        } else {
            this.registrationNumber = registrationNumber;
        }
        if ((key == null)) {
            this.key = new Key();
        } else {
            this.key = key;
        }
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
        this.numberSeats = numberSeats;
        this.winterRubber = winterRubber;

    }

    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               int productionYear,
               String productionCountry) {

        this(
                brand,
                model,
                engineVolume,
                color,
                productionYear,
                productionCountry,
                "механика",
                "седан",
                "х000хх000",
                7,
                true,
                new Key(),
                new Insurance()
        );
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {

        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public void setTransmission(String transmission) {
        if (transmission == null) {
            this.transmission = "механика";
        } else {
            this.transmission = transmission;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null) {
            this.registrationNumber = "х000хх000";
        } else {
            this.registrationNumber = registrationNumber;
        }
    }

    public boolean getWinterRubber() {
        return winterRubber;
    }

    public void setWinterRubber(boolean winterRubber) {
        this.winterRubber = winterRubber;
    }


    public boolean verifyWinterRubber() {// проверка
        return true;
    }

    public boolean writeRegistrationNumberValid() {
        if (registrationNumber.length() != 9) {
            return false;
        }
        char[] chars = registrationNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        if (!Character.isDigit(chars[1]) || !Character.isDigit(chars[2]) || !Character.isDigit(chars[3]) ||
                !Character.isDigit(chars[6]) || !Character.isDigit(chars[7]) || !Character.isDigit(chars[8])) {
            return false;
        }
        return true;
    }

    public static class Key {
        public final boolean remoteEngineStart;//удалённый
        public final boolean keylessEntry;//,безключевой

        public Key(boolean remoteEngineStart, boolean keylessEntry) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessEntry = keylessEntry;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessEntry() {
            return keylessEntry;
        }
    }

    public static class Insurance {
        private final LocalDate term; //срок
        private final double price;
        private final String number;

        public Insurance(LocalDate term, double price, String number) {
            if (term == null) {
                this.term = LocalDate.now().plusDays(365);
            } else {
                this.term = term;
            }
            this.price = price;
            if (number == null) {
                this.number = "123456789";
            } else {
                this.number = number;
            }
        }

        public Insurance() {
            this(null, 5000, null);
        }

        public LocalDate getTerm() {
            return term;
        }

        public double getPrice() {
            return price;
        }

        public String getNumber() {
            return number;
        }
        public void calculateTerm(){
            if (term.isBefore(LocalDate.now()) || term.isEqual(LocalDate.now()));{
                System.out.println("Необходимо срочно оформлять страховку!");
            }
        }
        public  void checkNumber(){
            if (number.length() != 9){
                System.out.println("Номер страховки некорректный!");
            }
        }

    }

}


