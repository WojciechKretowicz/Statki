package Engine;

public class General {
    private static int strzaly = 50;
    private static int polaStatkow;

    public static void subStrzaly() {
        strzaly--;
    }

    public static int getStrzaly() {
        return strzaly;
    }

    public static void setStrzaly(String text) {
        if(text != "Ile chcesz mieć prób?")
            strzaly = Integer.parseInt(text);
    }

    public static void subPolaStatkow() {
        polaStatkow--;
    }

    public static int getPolaStatkow() {
        return polaStatkow;
    }
}
