package Exception;

public class QtdFlorException extends Exception{

    public QtdFlorException(){
        super("Não podemos vender um produto com menos que duas flores!");
    }

}
