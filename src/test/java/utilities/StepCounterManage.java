package utilities;

public class StepCounterManage {

    public static Integer stepCount(String counter) {
        return switch (counter.toUpperCase()) {
            case "FIRST", "1ST" -> 0;
            case "SECOND", "2ND" -> 1;
            case "THIRD", "3TH" -> 2;
            case "FOURTH", "4TH" -> 3;
            case "FIFTH", "5TH" -> 4;
            case "SIXTH", "6TH" -> 5;
            case "SEVENTH", "7TH" -> 6;
            case "EIGHTH", "8TH" -> 7;
            case "NINTH", "9TH" -> 8;
            case "TENTH", "10TH" -> 9;
            case "ELEVENTH", "11TH" -> 10;
            case "TWELFTH", "12TH" -> 11;
            case "THIRTEENTH", "13TH" -> 12;
            case "FOURTEENTH", "14TH" -> 13;
            case "FIFTEENTH", "15TH" -> 14;
            case "SIXTEENTH", "16TH" -> 15;
            case "SEVENTEENTH", "17TH" -> 16;
            case "EIGHTEENTH", "18TH" -> 17;
            case "NINETEENTH", "19TH" -> 18;
            case "TWENTIETH", "20TH" -> 19;
            case "TWENTY FIRST", "21ST" -> 20;
            case "TWENTY SECOND", "22ND" -> 21;
            case "TWENTY THIRD", "23TH" -> 22;
            case "TWENTY FOURTH", "24TH" -> 23;
            case "TWENTY FIFTH", "25TH" -> 24;
            case "TWENTY SIXTH", "26TH" -> 25;
            case "TWENTY SEVENTH", "27TH" -> 26;
            case "TWENTY EIGHTH", "28TH" -> 27;
            case "TWENTY NINTH", "29TH" -> 28;
            case "THIRTIETH", "30TH" -> 29;
            case "THIRTY FIRST", "31ST" -> 30;
            case "THIRTY SECOND", "32ND" -> 31;
            case "THIRTY THIRD", "33TH" -> 32;
            case "THIRTY FOURTH", "34TH" -> 33;
            case "THIRTY FIFTH", "35TH" -> 34;
            case "THIRTY SIXTH", "36TH" -> 35;
            case "THIRTY SEVENTH", "37TH" -> 36;
            case "THIRTY EIGHTH", "38TH" -> 37;
            case "THIRTY NINTH", "39TH" -> 38;
            case "FORTIETH", "40TH" -> 39;
            case "FORTY FIRST", "41ST" -> 40;
            case "FORTY SECOND", "42ND" -> 41;
            case "FORTY THIRD", "43TH" -> 42;
            case "FORTY FOURTH", "44TH" -> 43;
            case "FORTY FIFTH", "45TH" -> 44;
            case "FORTY SIXTH", "46TH" -> 45;
            case "FORTY SEVENTH", "47TH" -> 46;
            case "FORTY EIGHTH", "48TH" -> 47;
            case "FORTY NINTH", "49TH" -> 48;
            case "FIFTIETH", "50TH" -> 49;
            default -> throw new IllegalArgumentException("Illegal counter value: " + counter);
        };
    }
}
