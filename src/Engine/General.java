package Engine;

public class General {
    private static int strzaly;
    private static int polaStatkow;

    public static void subStrzaly() {
        strzaly--;
    }

    public static int getStrzaly() {
        return strzaly;
    }

    public static void setStrzaly(String text) {
        if(!text.equals("Ile chcesz mieć prób?"))
            strzaly = Integer.parseInt(text);
        else
            strzaly = 40;
        polaStatkow = 20;
    }

    public static void subPolaStatkow() {
        polaStatkow--;
    }

    public static int getPolaStatkow() {
        return polaStatkow;
    }
}
