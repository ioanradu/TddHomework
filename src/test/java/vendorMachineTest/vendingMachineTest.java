package vendorMachineTest;

import org.junit.Before;
import org.junit.Test;
import vendorMachine.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static vendorMachine.Item.*;

public class vendingMachineTest {

    private VendingMachineImpl vm;

    @Before
    public void init() {
        vm = new VendingMachineImpl();
    }

    @Test
    public void testIfAPriceForAnItemIsTheCorrectOneTheMethodReturnsThePrice() {
        assertEquals(25, MARS.getPrice());
        assertEquals(45, BOUNTY.getPrice());

    }

    @Test
    public void testIfTheCurrentBalanceDisplayTheCorrectValueAfterAddingVariousNumberOfCoins() {
        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.FIVE);
        vm.insertCoin(Coin.FIVE);
        vm.insertCoin(Coin.FIFTY);
        vm.insertCoin(Coin.FIFTY);
        vm.insertCoin(Coin.TWENTY);

        assertEquals(160, vm.getCurrentBalance());
    }

    @Test
    public void testIfTheTotalSalesDisplayTheCorrectValueIfVariousItemsAreBought() {
        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.TEN);

        try {
            vm.selectItemAndGetPrice(Item.MARS);
        } catch (SoldOutException e) {
            e.printStackTrace();
        }

        try {
            vm.collectItemAndGetChange();
        } catch (NotSufficientChangeException e) {
            e.printStackTrace();
        } catch (NotFullyPaidException e) {
            e.printStackTrace();
        }

        assertEquals(25, vm.getTotalSales());
    }

    private int getSumChange(List list) {
        int sum = 0;
        int value = 0;
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) == Coin.FIVE) {
                value = Coin.FIVE.getValue();
            }

            if (list.get(i) == Coin.TEN) {
                value = Coin.TEN.getValue();
            }

            if (list.get(i) == Coin.TWENTY) {
                value = Coin.TWENTY.getValue();
            }

            if (list.get(i) == Coin.FIFTY) {
                value = Coin.FIFTY.getValue();
            }

            sum += value;
        }
        return sum;
    }

    @Test
    public void testIfTheChangeIsReturnedCorrectlyAfterANumberOfCoinsIsAddedAndAnItemIsBought() {
        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.FIFTY);

        try {
            vm.selectItemAndGetPrice(Item.MARS);
        } catch (SoldOutException e) {
            e.printStackTrace();
        }

        try {
            PurchaseAndCoins<Item, List<Coin>> purchaseAndCoins = vm.collectItemAndGetChange() ;
            List<Coin> list = purchaseAndCoins.getCoins();

            assertEquals(35, getSumChange(list));

        } catch (NotSufficientChangeException e) {
            e.printStackTrace();
        } catch (NotFullyPaidException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NotSufficientChangeException.class)
    public void testIfIsNotEnoughChangeWhenAProductIsSelected() throws NotSufficientChangeException, NotFullyPaidException, SoldOutException {
        vm.insertCoin(Coin.FIFTY);
        vm.selectItemAndGetPrice(MARS);
        vm.collectItemAndGetChange();
    }

    @Test(expected = SoldOutException.class)
    public void testIfTheSelectedItemExistsInVendorMachine() throws SoldOutException {
        assertEquals(25, vm.selectItemAndGetPrice(MARS));
    }

   @Test(expected = NotFullyPaidException.class)
    public void testIfAProductIsSelectedAndThereAreEnoughCoinsIntroduced() throws SoldOutException, NotSufficientChangeException, NotFullyPaidException {
        vm.selectItemAndGetPrice(Item.MARS);
        vm.collectItemAndGetChange();
    }
}
