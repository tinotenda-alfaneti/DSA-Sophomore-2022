public class RecursionEnglishRuler {

    public static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);   // draw inch 0 line and label
        for(int j = 1; j<=nInches; j++) {
            drawInterval(majorLength - 1); // draw interior ticks for inch
            drawLine(majorLength, j);  // draw inch j line and label
        }
    }

    private static void drawInterval(int centralLength){
        if (centralLength >= 1) {
            drawInterval(centralLength - 1); // recursively draw top interval
            drawLine(centralLength);  // draw center tick line without label
            drawInterval(centralLength-1); // recursively draw bottom interval
        }
    }

    private static void drawLine(int tickLength, int tickLabel) {
        for (int i = 0; i < tickLength; i++) System.out.print("-");
        if (tickLabel >= 0) System.out.println(" " + tickLabel);
        System.out.print("\n");

    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }

    public static void main(String[] args) {
        drawRuler(10, 4);
    }
}