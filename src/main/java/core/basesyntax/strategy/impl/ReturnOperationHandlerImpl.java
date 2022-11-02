package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void operationHandlerOfFruitTransaction(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitDao.get(fruitTransaction.getFruit());
        if (fruit != null) {
            fruit.setQuantity(fruit.getQuantity()
                    + fruitTransaction.getQuantity());
        }
    }
}