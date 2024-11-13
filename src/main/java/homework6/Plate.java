package homework6;

//Реализуйте классы Тарелка (максимальное количество еды, текущее количество еды)
//При создании тарелки указывается ее объем и она полностью заполняется едой
//В тарелке должен быть метод, позволяющий добавить еду в тарелку. После добавления в тарелке не может оказаться еды больше максимума
//В тарелке должен быть boolean метод уменьшения количества еды, при этом после такого уменьшения, в тарелке не может оказаться отрицательное количество еды (если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды, то возвращаем true, в противном случае - false).

public class Plate {
    private int maxFood, currentFood;

    public Plate(int maxFood) {
        this.maxFood = maxFood;
        currentFood = maxFood;
    }

    public void addFood(int foodAmount) {
        currentFood += Math.max(foodAmount, maxFood);

    }

    public boolean consumeFood(int foodAmount) {
        if (currentFood <= foodAmount) return false;
        currentFood -= foodAmount;
        return true;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public int getCurrentFood() {
        return currentFood;
    }
}
