package Cards;

public enum Face {

    ACE(1,'A'),
    TWO(2,'2'),
    THREE(3,'3'),
    FOUR(4,'4'),
    FIVE(5,'5'),
    SIX(6,'6'),
    SEVEN(7,'7'),
    EIGHT(8,'8'),
    NINE(9,'9'),
    TEN(10,'T'),
    JACK(11,'J'),
    QUEEN(12,'Q'),
    KING(13,'K');

    private int primaryValue;
    private char secondaryValue;

    Face(int primaryValue, char secondaryValue) {
        this.primaryValue = primaryValue;
        this.secondaryValue = secondaryValue;
    }

    public int getPrimaryValue() {
        return primaryValue;
    }

    public int getSecondaryValue() {
        return secondaryValue;
    }

    public static Face getFaceByValue(char secondaryValue){
        Face[] faces = Face.values();
        for (Face face : faces)
            if (face.secondaryValue == secondaryValue)
                return face;
        return null;
    }
}
