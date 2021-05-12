package example;

// example.Cover параметризированный тип, для него можно указать в качестве параметра другой тип
public class Cover<T> {
    private T phone;

    public void setPhone(T phone) {
        this.phone = phone;
    }

    public T getPhone() {
        return this.phone;
    }
}
