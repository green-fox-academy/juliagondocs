public class WarApp {
    public static void main(String[] args) {
        Armada myArmada = new Armada();
        Armada enemyArmada = new Armada();

        Ship myShip1 = new Ship();
        Ship myShip2 = new Ship();
        Ship myShip3 = new Ship();

        Ship enemyShip1 = new Ship();
        Ship enemyShip2 = new Ship();
        Ship enemyShip3 = new Ship();

        myShip1.fillShip();
        myShip2.fillShip();
        myShip3.fillShip();

        enemyShip1.fillShip();
        enemyShip2.fillShip();
        enemyShip3.fillShip();

        myArmada.addShipsToArmada(myShip1);
        myArmada.addShipsToArmada(myShip2);
        myArmada.addShipsToArmada(myShip3);

        enemyArmada.addShipsToArmada(enemyShip1);
        enemyArmada.addShipsToArmada(enemyShip2);
        enemyArmada.addShipsToArmada(enemyShip3);

        myArmada.war(enemyArmada);

    }
}
